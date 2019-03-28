package com.overstar.elasticsearch.service.InitializationService;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.common.collect.Sets;
import com.overstar.elasticsearch.dto.City;
import com.overstar.elasticsearch.mapper.product.CityMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 14:23
 */
@Service
public class CityService implements InitializingBean {

    @Autowired
    private CityMapper mapper;
    private Set<String > cityNameZh  = Sets.newHashSetWithExpectedSize(300);
    private Set<String > cityNameEn  = Sets.newHashSetWithExpectedSize(300);
    private Set<String > cityNamePinyin  = Sets.newHashSetWithExpectedSize(300);


    @Override
    public void afterPropertiesSet() throws Exception {
        List<City> cities = mapper.selectAll();
        for (City city : cities) {
            if (StringUtils.isEmpty(city.getCityNameZh())){
                continue;
            }
            cityNameZh.add(city.getCityNameZh());
            cityNameEn.add(city.getCityNameEn());
            cityNamePinyin.add(StringUtils.isEmpty(city.getCityNameSpelling())?Pinyin.toPinyin(city.getCityNameZh(),"").toLowerCase():city.getCityNameSpelling());
        }
    }

    public Set<String> getCities(){
        return cityNameEn;
    }
    /**
     * 完整匹配
     */
    public boolean matchZh(String text) {
        return safeMatch(cityNameZh, text);
    }

    public boolean matchEn(String text) {
        return safeMatch(cityNameEn, text);
    }

    public boolean matchPy(String text) {
        return safeMatch(cityNamePinyin, text);
    }

    /**
     * 包含，text 内容包含某个国家
     */
    public String containsZh(String text) {
        return safeContains(cityNameZh, text);
    }

    public String containsEn(String text) {
        return safeContains(cityNameEn, text);
    }

    public String containsPy(String text) {
        return safeContains(cityNamePinyin, text);
    }

    private boolean safeMatch(Set<String> set, String text) {
        if (set == null) {
            return false;
        }
        return set.contains(text);
    }

    /**
     * 查询是否以指定字符串开头或者结尾，不用包含的原因是有这种情况：罗特尼斯岛  这是个景点，但尼斯 是法国下的一个城市，会导致搜索不出结果
     */
    private String safeContains(Set<String> set, String text) {
        if (set == null || "".equals(text) || text == null) {
            return null;
        }
        //将搜索词拆分,如：Nautilus Aviation分为2个单词,然后分别全匹配
        String [] keyArray = text.split("\\s+");
        for (String tmp : set) {
            for(int i=0;i<keyArray.length;i++){
                if (keyArray[i].equals(tmp)) {
                    return tmp;
                }
            }
        }
        return null;
    }

}
