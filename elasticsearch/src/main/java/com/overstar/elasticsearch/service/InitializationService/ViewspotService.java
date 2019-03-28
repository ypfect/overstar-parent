package com.overstar.elasticsearch.service.InitializationService;

import com.github.promeg.pinyinhelper.Pinyin;
import com.overstar.elasticsearch.constant.ProductSearchConstant;
import com.overstar.elasticsearch.dto.Viewspot;
import com.overstar.elasticsearch.mapper.product.ViewspotMapper;
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
public class ViewspotService implements InitializingBean {

	public static final Logger logger = LoggerFactory.getLogger("run");
	private Set<String> nameZhs = new HashSet<>(), namePys = new HashSet<>();

	@Autowired
	private ViewspotMapper viewspotDao;
	@Autowired
	private CountryService countryService;
	@Autowired
	private CityService cityService;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Start to load viewspots...");
		try {
			List<Viewspot> viewspots = viewspotDao.loadAllViewspots(ProductSearchConstant.ONLINE_STATUS);
			for (Viewspot viewspot : viewspots) {
				if (!StringUtils.hasText(viewspot.getLocationNameZh())) {
					continue;
				}
				String nameZh = viewspot.getLocationNameZh().trim();
				// 去掉国家城市的标签，避免重复评分
				if (countryService.matchZh(nameZh) || cityService.matchZh(nameZh)) {
					continue;
				}
				nameZhs.add(nameZh);
				namePys.add(Pinyin.toPinyin(nameZh, "").toLowerCase());
			}
		} catch (Exception e) {
			logger.error("Load viewspots error.", e);
		}
		logger.info("Load viewspots success...");
	}


	public String matchNameZh(String text) {
		if (!StringUtils.hasText(text)) {
			return null;
		}
		for (String nameZh : nameZhs) {
			if (nameZh.equals(text)) {
				return nameZh;
			}
		}
		return null;
	}

	/**
	 * 根据输入字符查找里面的景点字符，如：输入“艾尔利滩飞机”，返回景点“艾尔利滩”
	 * 1、当有多个匹配项时，如输入：摩尔大堡礁  ，  可能会匹配：摩尔大堡礁  & 大堡礁    ，但只返回匹配度最高（字符长度最长）的那一个
	 * 2、当输入  三日 时，会匹配 三日 或者3日
	 * 没有匹配到则返回null，默认返回匹配到的第一个景点
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
	 * 根据输入字符查找里面的景点字符，如：输入“aierlitanfeiji”，返回景点“aierlitan”
	 * 没有匹配到则返回null，默认返回匹配到的第一个景点
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
