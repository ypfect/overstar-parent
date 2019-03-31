package com.overstar.elasticsearch.utils;

import org.springframework.util.StringUtils;

/**
 * 产品字符串相关工具类
 * <li> 项目名称：product-search-service </li>
 * <li> 创建人：MacChen </li>
 * <li> 创建时间：2018年8月10日 </li>
 * <li> 联系邮箱：mac.chen@aoliday.com </li>
 * @version 0.0.1
 */
public final class ESStringUtil {

	private ESStringUtil() {
	}

	/**
	 * 去掉单个字符串收尾空格
	 * @param text
	 * @return
	 */
	public static String safeTrim(String text) {
		if (!StringUtils.hasText(text)) {
			return text;
		}
		return text.trim();
	}

	/**
	 * 批量 去掉数组中 每个 字符串的收尾空格
	 * @param text
	 * @return
	 */
	public static String[] safeTrim(String[] text) {
		if (text == null || text.length == 0) {
			return text;
		}
		String[] array = new String[text.length];
		for (int i = 0; i < text.length; i++) {
			array[i] = safeTrim(text[i]);
		}
		return array;
	}

	public static String clearItripAolidayPromotion(String text) {
		return clearItripAoliday(clearPromotion(text));
	}

	/**
	 * 过滤掉字符串中的itrip、aoliday、澳乐、爱去自由
	 * @param str
	 * @return
	 */
	public static String clearItripAoliday(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("(?i)itrip|aoliday|澳乐|爱去自由", "");
	}

	/**
	 * 替换字符串中 itrip、aoliday、澳乐、爱去自由 为 指定字符串
	 * @param str
	 * @param rep
	 * @return
	 */
	public static String replaceItripAoliday(String str, String rep) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("(?i)itrip|aoliday|澳乐|爱去自由", rep);
	}

	/**
	 * 替换a标签的href
	 * @param str
	 * @return
	 */
	public static String clearHref(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("(?i)href\\s*=\\s*\"[^\"]*\"", "href=\"javascript:void(0);\"");
	}

	/**
	 * 过滤【】的内容，用途：如产品名称为：【818大促】xxxx，通过该方法会去掉【818大促】字样
	 * @param str
	 * @return
	 */
	public static String clearPromotion(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("(?i)【[^】]*】", "");
	}

	/**
	 * 替换<li *>【内容】</li> 为 <p>【内容】</p>
	 * @param str
	 * @return
	 */
	public static String li2P(String str) {
		if (null == str) {
			return null;
		}
		str = str.replaceAll("(?i)<ul.*?>", "");
		str = str.replaceAll("(?i)</ul>", "");
		str = str.replaceAll("(?i)<li.*?>", "<p>");
		return str.replaceAll("</li>", "</p>");
	}

	/**
	 * 过滤 图片
	 * @param str
	 * @return
	 */
	public static String cleanImg(String str) {
		if (!StringUtils.hasText(str)) {
			return str;
		}
		return str.replaceAll("(?i)<img[^>]*/>", "");
	}

}
