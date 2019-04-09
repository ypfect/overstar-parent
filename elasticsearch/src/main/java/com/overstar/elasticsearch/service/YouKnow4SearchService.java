package com.overstar.elasticsearch.service;

import com.github.promeg.pinyinhelper.Pinyin;
import com.overstar.elasticsearch.bean.ProductDocument;
import com.overstar.elasticsearch.constant.ProductSearchConstant;
import com.overstar.elasticsearch.service.InitializationService.InitElasticsearchDataService;
import com.overstar.elasticsearch.utils.ESStringUtil;
import com.overstar.elasticsearch.utils.ElasticsearchOpService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.index.IndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 23:26
 */
@Service
public class YouKnow4SearchService {

    public static final Logger logger = LoggerFactory.getLogger("es");

    @Autowired
    private ElasticsearchOpService opService;
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
            String indexNameNew = generateIndex(ProductSearchConstant.INDEX_OVERSTAR);
            logger.info("new index name is {}",indexNameNew);
            //给新索引批量插入数据
            bulkProcessor = opService.createBulkProcessor();
            for (ProductDocument document : productDocuments) {
                bulkProcessor.add(new IndexRequest(indexNameNew, ProductSearchConstant.TYPE, document.getProductId()).source(getJsonMap(document, false)));
            }
            bulkProcessor.flush();
            if (!CollectionUtils.isEmpty(oldIndex)){
                String[] oldIndexes = oldIndex.toArray(new String[]{});
                logger.info("exchange oldIndex {} to del & insert new {} into ",oldIndexes,indexNameNew);
                opService.insertNewDeleteOld(oldIndexes,indexNameNew,ProductSearchConstant.INDEX_OVERSTAR);
                logger.info("delete old index ..{}",oldIndex);
                opService.deleteIndex(oldIndexes);
            }else {
                logger.info("there has no index named {},go ahead to insert {} to aliases",ProductSearchConstant.INDEX_OVERSTAR,indexNameNew);
                opService.addIntoAliases(indexNameNew,ProductSearchConstant.INDEX_OVERSTAR);
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

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>();
        ss.add("asdas");
        ss.add("eeee");
        ss.add("fsdsfa");
        String[] strings = ss.toArray(new String[]{});
    }


    /**
     * 生成索引，包括操作ES
     * @param alias
     * @return
     */
    private String generateIndex(String alias) {
        String dateFormat = DateFormatUtils.format(new Date(), "yyyy-MM-dd[HH:mm:ss]");
        String indexName = new StringBuilder(alias).append(".").append(dateFormat).toString();
        opService.createIndex(indexName);
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
