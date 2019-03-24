package com.overstar.serviceproduct.service;

import com.github.pagehelper.PageHelper;
import com.overstar.serviceproduct.api.IProductBaseService;
import com.overstar.serviceproduct.bean.ProductQuery;
import com.overstar.serviceproduct.dto.ProductBase;
import com.overstar.serviceproduct.mapper.ProductBaseMapper;
import com.overstar.serviceproduct.utils.PageHelpUtil;
import com.overstar.serviceproduct.utils.PageModel;
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
    public PageModel<ProductBase> getProductBaseAll(ProductQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getSize());
        List<ProductBase> productBaseAll = productBaseMapper.selectAll();
        return PageHelpUtil.buildPageModel(productBaseAll);
    }
}
