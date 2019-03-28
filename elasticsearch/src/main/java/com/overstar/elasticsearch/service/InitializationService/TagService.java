package com.overstar.elasticsearch.service.InitializationService;

import com.github.promeg.pinyinhelper.Pinyin;
import com.overstar.elasticsearch.constant.ProductSearchConstant;
import com.overstar.elasticsearch.dto.Tag;
import com.overstar.elasticsearch.mapper.product.TagMapper;
import com.overstar.elasticsearch.utils.ChineseUtil;
import com.overstar.elasticsearch.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagService implements InitializingBean {
	public static final Logger logger = LoggerFactory.getLogger("run");
	private Set<String> nameZhs = new HashSet<>(), namePys = new HashSet<>();

	@Autowired
	private TagMapper tagDao;
	@Autowired
	private CountryService countryService;
	@Autowired
	private CityService cityService;
	@Autowired
	private ViewspotService viewspotService;


	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Start to load tags...");
		try {
			List<Tag> tags = tagDao.loadAllTags(ProductSearchConstant.ONLINE_STATUS);
			for (Tag tag : tags) {
				if (!StringUtils.hasText(tag.getNameZh())) {
					continue;
				}
				String nameZh = tag.getNameZh().trim();
				// 去掉国家城市的标签，避免重复评分
				if (countryService.matchZh(nameZh) || cityService.matchZh(nameZh)) {
					continue;
				}
				// 跟景点去重，避免重复打分
				if (viewspotService.matchNameZh(nameZh) != null) {
					continue;
				}
				nameZhs.add(nameZh);
				namePys.add(Pinyin.toPinyin(nameZh, "").toLowerCase());
			}
		} catch (Exception e) {
			logger.error("Load tags error.", e);
		}
		logger.info("Load tags success...");
	}

	/**
	 * 根据输入字符查找里面的标签字符，如：输入“艾尔利滩飞机”，返回标签“艾尔利滩”
	 * 当有多个匹配项时，如输入：摩尔大堡礁  ，  可能会匹配：摩尔大堡礁  & 大堡礁    ，但只返回匹配度最高（字符长度最长）的那一个
	 * 没有匹配到则返回null，默认返回匹配到的第一个标签
	 */
	public String findNameZh(String text) {
		if (!StringUtils.hasText(text) || !ChineseUtil.isChinese(text)) {
			return null;
		}
		// 去掉所有空格
		String trim = text.trim().replaceAll(" ", "");
		int maxlength = 0;
		String result = null;
		for (String nameZh : nameZhs) {
			if (!NumberUtil.contains(trim, nameZh) || nameZh.length() <= maxlength) {
				continue;
			}
			result = nameZh;
			maxlength = nameZh.length();
		}
		return result;
	}

	/**
	 * 根据输入字符查找里面的标签字符，如：输入“aierlitanfeiji”，返回标签“aierlitan”
	 * 没有匹配到则返回null，默认返回匹配到的第一个标签
	 */
	public String findNamePy(String text) {
		if (!StringUtils.hasText(text) || ChineseUtil.isChinese(text)) {
			return null;
		}
		// 去掉所有空格
		String trim = text.trim().replaceAll(" ", "");
		int maxlength = 0;
		String result = null;
		for (String namePy : namePys) {
			if (!trim.contains(namePy) || namePy.length() <= maxlength) {
				continue;
			}
			result = namePy;
			maxlength = namePy.length();
		}
		return result;
	}


}
