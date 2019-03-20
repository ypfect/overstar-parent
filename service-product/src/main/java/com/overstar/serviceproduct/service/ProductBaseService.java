package com.overstar.serviceproduct.service;

import com.overstar.serviceproduct.api.IProductBaseService;
import com.overstar.serviceproduct.dto.ProductBase;
import com.overstar.serviceproduct.mapper.ProductBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/20 23:34
 */
@Service
public class ProductBaseService implements IProductBaseService {

    @Autowired
    private ProductBaseMapper productBaseMapper;

    @Override
    public List<ProductBase> getProductBaseAll() {
        return productBaseMapper.selectAll();
    }
}
