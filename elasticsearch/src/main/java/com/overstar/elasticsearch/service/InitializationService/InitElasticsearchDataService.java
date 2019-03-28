package com.overstar.elasticsearch.service.InitializationService;

import com.overstar.elasticsearch.api.IInitElasticsearchDataService;
import com.overstar.elasticsearch.bean.ProductDocument;
import com.overstar.elasticsearch.mapper.common.ProductDocumentMapper;
import com.overstar.serviceproduct.bean.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 初始化es数据
 * @Author stanley.yu
 * @Date 2019/3/27 11:30
 */
@Service
public class InitElasticsearchDataService implements IInitElasticsearchDataService {

    @Autowired
    private ProductDocumentMapper productDocumentMapper;

    @Override
    public List<ProductDocument> iiiinitProData4Es(ProductQuery query) {
        List<ProductDocument> productDocuments = productDocumentMapper.loadGoodsResource(query);
        return productDocuments;
    }


    public List<ProductDocument> iiiinitProData4Esbak(ProductQuery query) {
//        List<ProductDocument> documents = new ArrayList<>();
//        // 分页查询销售员的所有订单ID
//        Page<ProductDocument> productDocuments =null;
//        int pageNo = 1;
//        do {
//            List<Integer> integers = new ArrayList<>();
//            integers.add(3000);
//            PageHelper.startPage(pageNo, 50);
//            ArrayList<Integer> integers2 = new ArrayList<>();
//            ProductQuery productQuery = new ProductQuery();
//            integers.add(1000);
//            productQuery.setProductStatus(integers);
//
//            List<ProductDocument> productDocuments1 = productDocumentMapper.loadGoodsResource(productQuery);
//            if (productDocuments.isEmpty()) {
//                break;
//            }
//            List<ProductDocument> list = productDocuments.toPageInfo().getList();
//            documents.addAll(list);
//            pageNo++;
//        } while (productDocuments.toPageInfo().isHasNextPage());
//
//        return documents;
        return null;
    }


}
