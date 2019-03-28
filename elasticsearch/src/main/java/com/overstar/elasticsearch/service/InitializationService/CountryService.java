package com.overstar.elasticsearch.service.InitializationService;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.common.collect.Sets;
import com.overstar.elasticsearch.constant.ProductSearchConstant;
import com.overstar.elasticsearch.dto.Country;
import com.overstar.elasticsearch.mapper.product.CountryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CountryService implements InitializingBean {
	public static final Logger logger = LoggerFactory.getLogger("run");

	// 一些同义词国家
	public static final Map<String, String> SYNONYM_ZHS = new HashMap<String, String>() {
		private static final long serialVersionUID = 2728710550114732067L;
		{
			put("澳洲", "澳大利亚");
			put("奥州", "澳大利亚");
		}
	};

	private Set<String> nameZhs = Sets.newHashSetWithExpectedSize(ProductSearchConstant.COUNTRIES_MAX), nameEns = Sets.newHashSetWithExpectedSize(ProductSearchConstant.COUNTRIES_MAX),
			namePys = Sets.newHashSetWithExpectedSize(ProductSearchConstant.COUNTRIES_MAX);

	@Autowired
	private CountryMapper countryDao;


	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Start to load country...");
		try {
			for (Country country : countryDao.loadAllCountries(ProductSearchConstant.ONLINE_STATUS)) {
				nameZhs.add(country.getCountryNameZh());
				nameEns.add(country.getCountryNameEn());
				namePys.add(StringUtils.hasText(country.getCountryNameSpelling()) ? country.getCountryNameSpelling() : Pinyin.toPinyin(country.getCountryNameZh(), "").toLowerCase());
			}
		} catch (Exception e) {
			logger.error("Load country error.", e);
		}
		logger.info("Load country success...");
	}

	/**
	 * 同义词匹配
	 * 返回同义词
	 */
	public String synonymMatchZh(String text) {
		return SYNONYM_ZHS.get(text);
	}

	/**
	 * 完整匹配
	 */
	public boolean matchZh(String text) {
		return safeMatch(nameZhs, text);
	}

	public boolean matchEn(String text) {
		return safeMatch(nameEns, text);
	}

	public boolean matchPy(String text) {
		return safeMatch(namePys, text);
	}

	/**
	 * 同义词包含
	 * 返回同义词
	 */
	public Map.Entry<String, String> synonymContainsZh(String text) {
		for (Map.Entry<String, String> entry : SYNONYM_ZHS.entrySet()) {
			if (text.contains(entry.getKey())) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * 包含，text 内容包含某个国家
	 */
	public String containsZh(String text) {
		return safeContains(nameZhs, text);
	}

	public String containsEn(String text) {
		return safeContains(nameEns, text);
	}

	public String containsPy(String text) {
		return safeContains(namePys, text);
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
		if (set == null) {
			return null;
		}
		for (String tmp : set) {
			if (text.contains(tmp)) {
				return tmp;
			}
		}
		return null;
	}


}
