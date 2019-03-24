package com.overstar.serviceproduct.api;

import com.overstar.serviceproduct.bean.ProductQuery;
import com.overstar.serviceproduct.dto.ProductBase;
import com.overstar.serviceproduct.utils.PageModel;

/**
 * @Description 产品基础服务
 * @Author stanley.yu
 * @Date 2019/3/20 23:32
 */
public interface IProductBaseService {

    PageModel<ProductBase> getProductBaseAll(ProductQuery query);
}
