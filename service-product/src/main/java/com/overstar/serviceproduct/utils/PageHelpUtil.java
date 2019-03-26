package com.overstar.serviceproduct.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/21 21:27
 */
public class PageHelpUtil {

    public static <T> PageModel<T> buildPageModel(List<T> data){
        if (CollectionUtils.isEmpty(data)){
            return new PageModel<T>();
        }
        //获取分页后的结果。
        PageInfo<T> pageInfo = new PageInfo<>(data);
        PageModel<T> model = new PageModel<>();
        model.setData(pageInfo.getList());
        model.setTotal((int)pageInfo.getTotal());
        return model;
    }
}
