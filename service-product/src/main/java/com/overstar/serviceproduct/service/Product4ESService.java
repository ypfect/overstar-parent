package com.overstar.serviceproduct.service;

import com.overstar.serviceproduct.api.IProduct4ESService;
import com.overstar.serviceproduct.bean.ProductDocument;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/27 14:04
 */
@Service
public class Product4ESService implements IProduct4ESService {


    @Override
    public List<ProductDocument> searchResource() {
        return null;
    }
}
