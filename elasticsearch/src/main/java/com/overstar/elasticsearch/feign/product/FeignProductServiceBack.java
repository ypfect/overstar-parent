package com.overstar.elasticsearch.feign.product;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.serviceproduct.bean.ProductQuery;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:46
 */
@Service
public class FeignProductServiceBack implements FeignProductService{

    @Override
    public String feignHello() {
        return "this way is Terminated..";
    }

    @Override
    public String feignHystrixBack() {
        return "this way is Terminated..";
    }

    @Override
    public RetOverStar getAllProductBases(ProductQuery query) {
        return RetOverStar.failure(500,"query producy all by paging failure!");
    }
}
