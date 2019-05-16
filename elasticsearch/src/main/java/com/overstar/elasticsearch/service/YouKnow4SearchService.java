package com.overstar.elasticsearch.service;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.common.collect.Lists;
import com.overstar.elasticsearch.bean.ProductDocument;
import com.overstar.elasticsearch.constant.ProductSearchConstant;
import com.overstar.elasticsearch.mapper.common.ProductDocumentMapper;
import com.overstar.elasticsearch.mapper.product.ProductBaseMapper;
import com.overstar.elasticsearch.service.InitializationService.InitElasticsearchDataService;
import com.overstar.elasticsearch.utils.BeanUtils;
import com.overstar.elasticsearch.utils.ESStringUtil;
import com.overstar.elasticsearch.utils.ElasticsearchOpService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.index.IndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 23:26
 */
@Service
public class YouKnow4SearchService {

    public static final Logger logger = LoggerFactory.getLogger("es");

    @Value("${elasticsearch.conf.setting.overstar}")
    private String overstarConfig;
    @Value("${elasticsearch.conf.setting.ypfect}")
    private String ypfectConfig;

    @Autowired
    private ElasticsearchOpService opService;
    @Autowired
    private ProductBaseMapper productBaseMapper;
    @Autowired
    private ProductDocumentMapper documentMapper;
    @Autowired
    private InitElasticsearchDataService initElasticsearchDataService;

    /**
     * 索引数据
     * 查询数据，利用别名悄然更新数据
     * 里面bulkProcessor 进行批量的高效处理数据的插入
     * @return
     */
    public int initEsIndex(){
        BulkProcessor bulkProcessor = null;
        long time = System.currentTimeMillis();
        try {
            List<ProductDocument> productDocuments = initElasticsearchDataService.iiiinitProData4Es(null);
            logger.info("根据别名获取索引集合..");
            List<String> oldIndex = opService.getIndexesByAliases(ProductSearchConstant.INDEX_OVERSTAR);
            logger.info("old indexes {}",oldIndex.toString());
            String overstar = generateIndex(ProductSearchConstant.INDEX_OVERSTAR,overstarConfig);
            String ypfect = generateIndex(ProductSearchConstant.INDEX_YPFECT,ypfectConfig);
            logger.info("new index overstar name is {}",overstar);
            logger.info("new index ypfect name is {}",ypfect);
            //给新索引批量插入数据
            bulkProcessor = opService.createBulkProcessor();

            //分页查询文档数据进行处理
            prepareBaseProductInfo2ProductDocByPartition(overstar,ypfect,bulkProcessor);

//            for (ProductDocument document : productDocuments) {
//                bulkProcessor.add(new IndexRequest(overstar, ProductSearchConstant.TYPE, document.getProductId()).source(getJsonMap(document, false)));
//                bulkProcessor.add(new  IndexRequest(ypfect,ProductSearchConstant.TYPE,document.getProductId()).source(loadDocumentMap(document)));
//            }
            bulkProcessor.flush();
            if (!CollectionUtils.isEmpty(oldIndex)){
                String[] oldIndexes = oldIndex.toArray(new String[]{});
                logger.info("exchange oldIndex {} to del & insert new {} into ",oldIndexes,overstar);
                opService.insertNewDeleteOld(oldIndexes,overstar,ProductSearchConstant.INDEX_OVERSTAR);
                logger.info("delete old index ..{}",oldIndex);
                opService.deleteIndex(oldIndexes);
            }else {
                logger.info("there has no index named {},go ahead to insert {} to aliases",ProductSearchConstant.INDEX_OVERSTAR,overstar);
                opService.addIntoAliases(overstar,ProductSearchConstant.INDEX_OVERSTAR);
            }
            logger.info("reIndex[ {} ] success.", ProductSearchConstant.INDEX_OVERSTAR);
            logger.info("reIndex[ {} ] end, spend[{}]ms.", ProductSearchConstant.INDEX_OVERSTAR, (System.currentTimeMillis() - time));
            return productDocuments.size();
        }catch (Exception e){
            logger.info("init Aliases failure ..."+e);
            return 0;
        }finally {
            if (bulkProcessor != null){
                bulkProcessor.close();
            }
        }

    }

    /**
     * 分片查询,还是需要api的配合查询
     * @param bulkProcessor
     */
    public void prepareBaseProductInfo2ProductDocByPartition(String overstar,String ypfect,BulkProcessor bulkProcessor){
        List<Integer> allProductIds = productBaseMapper.getAllProductIds();
        List<List<Integer>> partition = Lists.partition(allProductIds, 200);//分割list
        partition.stream().forEach(par->{
            //根据list查询
            List<ProductDocument> productDocuments = documentMapper.loadGoodsResourceByProductIds(par);
            productDocuments.stream().forEach(doc->
                    bulkProcessor.add(new IndexRequest(overstar, ProductSearchConstant.TYPE,doc.getProductId()).source(getJsonMap(doc,false))));
            productDocuments.stream().forEach(doc->
                    bulkProcessor.add(new IndexRequest(ypfect, ProductSearchConstant.TYPE,doc.getProductId()).source(loadDocumentMap(doc))));
        });
    }


    /**
     * myself document init
     * @param document
     * @return
     */
    private Map<String ,Object> loadDocumentMap(ProductDocument document) {
        Map<String, Object> map = BeanUtils.bean2Map(document);
        //特殊字段的处理
        map.put("productNameZhPy",Pinyin.toPinyin(document.getProductNameZh(),""));//这种可以直接索引，然后在加一个字段索引小写的
        map.put("cityNamePy",Pinyin.toPinyin(document.getCityNameZh(),""));
        map.put("countryNamePy",Pinyin.toPinyin(document.getCityNameZh(),""));
        map.put("viewSportPy",Pinyin.toPinyin(document.getViewSpotsZh(),""));
        //处理搜索建议字段
        deal2CompletionField(map,document);
        return map;
    }

    /**
     * 处理搜索建议字段
     * 根据分词结果来搞，定制个性化的分词。达到edgeNgram  前缀搜索
     * @param map
     * @param document
     */
    private void deal2CompletionField(Map<String, Object> map, ProductDocument document) {
        map.forEach((k,v)->{
            dealWithSingleFieldAnalyze2SuggestMap(map,k,v);
        });
    }

    /**
     * 处理单个字段
     * 包括字段的各种分词结果和分数的配置
     * @param map
     * @param k
     * @param v
     */
    private void dealWithSingleFieldAnalyze2SuggestMap(Map<String, Object> map, String k, Object v) {
        AnalyzeRequest analyzeRequest = new AnalyzeRequest();
//        analyzeRequest. todo
    }


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        List<List<Integer>> partition = Lists.partition(integers, 2);
        System.out.println(partition);
    }


    /**
     * 生成索引，包括操作ES
     * @param alias
     * @return
     */
    private String generateIndex(String alias,String config) {
        String dateFormat = DateFormatUtils.format(new Date(), "yyyy-MM-dd[HH:mm:ss]");
        String indexName = new StringBuilder(alias).append(".").append(dateFormat).toString();
        opService.createIndex(indexName,config);
        return indexName;
    }

    /**
     * 生成字段和值的映射关系
     * @param source
     * @param filedName
     * @param map
     * @return
     */
    private String safeSource(String source, String filedName, Map<String, Object> map) {
        if (!StringUtils.hasText(source)) {
            return null;
        }
        String safe = ESStringUtil.safeTrim(source);
        map.put(filedName, safe);
        return safe;
    }

    private String[] safeArraySource(String source, String filedName, Map<String, Object> map) {
        if (!StringUtils.hasText(source)) {
            return null;
        }
        String[] array = ESStringUtil.safeTrim(source.split(","));
        map.put(filedName, array);
        return array;
    }

    private String[] safeArraySource(String[] sources, String filedName, Map<String, Object> map) {
        if (sources == null || sources.length == 0) {
            return null;
        }
        String[] array = ESStringUtil.safeTrim(sources);
        map.put(filedName, array);
        return array;
    }

    private String[] getPy(String zh) {
        if (!StringUtils.hasText(zh)) {
            return null;
        }
        return Pinyin.toPinyin(zh, "").toLowerCase().split(",");
    }
    private Map<String, Object> getSuggestMap(Object value, int weight) {
        Map<String, Object> map = new HashMap<>();
        map.put("input", value);
        map.put("weight", weight);
        return map;
    }

    private Map<String, Object> getJsonMap(ProductDocument document, boolean toB) {
        Map<String, Object> result = new HashMap<>();
        String productNameZh = safeSource(QueryParser.escape(toB ? ESStringUtil.clearItripAolidayPromotion(document.getProductNameZh()) : document.getProductNameZh()),
                "productNameZh", result);
        String productNameZhPy = safeSource(QueryParser.escape(toB ?
                        ESStringUtil.clearItripAolidayPromotion(Pinyin.toPinyin(document.getProductNameZh()," ").replace(" ",""))
                        : Pinyin.toPinyin(document.getProductNameZh()," ").replace(" ","")),
                "productNameZhPy", result);
        safeSource(toB ? ESStringUtil.clearItripAolidayPromotion(document.getProductNameEn()) : document.getProductNameEn(), "productNameEn", result);
        safeSource(toB ? ESStringUtil.clearItripAolidayPromotion(document.getProductNameEn()) : document.getProductNameEn(), "productNameEnNotAnalyzed",
                result);
        String[] tagNames = safeArraySource(document.getTagNamesZh(), "tagNamesZh", result);
        safeArraySource(getPy(document.getTagNamesZh()), "tagNamesPy", result);
        String[] countryNameZhs = safeArraySource(document.getCountryNameZh(), "countryNameZh", result);
        safeArraySource(getPy(document.getCountryNameZh()), "countryNamePy", result);
        safeArraySource(document.getCountryNameEn(), "countryNameEn", result);
        String[] cityNameZhs = safeArraySource(document.getCityNameZh(), "cityNameZh", result);
        safeArraySource(getPy(document.getCityNameZh()), "cityNamePy", result);
        safeArraySource(document.getCityNameEn(), "cityNameEn", result);
        String[] viewspots = safeArraySource(document.getViewSpotsZh(), "viewSpotsZh", result);
        safeArraySource(getPy(document.getViewSpotsZh()), "viewSpotsPy", result);
        safeArraySource(document.getSupplierName(), "supplierName", result);

        //搜索建议，不同字段配置不同的权重
        List<Map<String, Object>> suggest = new ArrayList<>();
        if (countryNameZhs != null) {
            suggest.add(getSuggestMap(countryNameZhs, 80));
        }
        if (productNameZhPy != null) {
            suggest.add(getSuggestMap(productNameZhPy, 60));
        }
        if (cityNameZhs != null) {
            suggest.add(getSuggestMap(cityNameZhs, 40));
        }
        if (tagNames != null) {
            suggest.add(getSuggestMap(tagNames, 20));
        }
        if (viewspots != null) {
            suggest.add(getSuggestMap(viewspots, 10));
        }
        if (productNameZh != null) {
            suggest.add(getSuggestMap(ESStringUtil.safeTrim(toB ?
                    ESStringUtil.clearItripAolidayPromotion(document.getProductNameZh()) : document.getProductNameZh()), 1));
        }
        result.put("suggestText", suggest);
        return result;
    }

}
