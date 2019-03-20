package com.overstar.serviceproduct.api;

import com.overstar.serviceproduct.dto.ProductBase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 产品基础服务
 * @Author stanley.yu
 * @Date 2019/3/20 23:32
 */
public interface IProductBaseService {

    List<ProductBase> getProductBaseAll();
}
