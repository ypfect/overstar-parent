package com.overstar.elasticsearch.utils;

import org.springframework.util.StringUtils;

/**
 * 简单数字处理
 * <li> 项目名称：product-search-service </li>
 * <li> 创建人：MacChen </li>
 * <li> 创建时间：2018年9月25日 </li>
 * <li> 联系邮箱：mac.chen@aoliday.com </li>
 * @version 0.0.1
 */
public final class NumberUtil {
	public static char[] ARABNUMBER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static char[] CHINESENUMBER = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };

	private NumberUtil() {
	}

	/**
	 * 将文本中的阿拉伯数字转换为中文数字，如输入：4天，返回四天，仅支持<10以下的单个数字转换
	 */
	public static String arab2Chinese(String string) {
		return arab2Chinese(string, true);
	}

	/**
	 * 将文本中的中文数字转换为阿拉伯数字，如输入：四天，返回4天，仅支持<10以下的单个数字转换
	 */
	public static String chinese2Arab(String string) {
		return arab2Chinese(string, false);
	}

	/**
	 * 判断指定source文本是否包含dest文本，支持中文与阿拉伯数字的转换，如：
	 * source：四天三晚套餐，dest：4天3晚，返回true.
	 */
	public static boolean contains(String source, String dest) {
		if (StringUtils.isEmpty(source) || StringUtils.isEmpty(dest)) {
			return false;
		}
		return source.contains(arab2Chinese(dest)) || source.contains(chinese2Arab(dest));
	}

	private static String arab2Chinese(String string, boolean toChinese) {
		if (!StringUtils.hasText(string)) {
			return new String();
		}
		StringBuilder result = new StringBuilder();
		for (char chr : string.toCharArray()) {
			result.append(convert(chr, toChinese ? ARABNUMBER : CHINESENUMBER, toChinese ? CHINESENUMBER : ARABNUMBER));
		}
		return result.toString();
	}

	private static char convert(char chr, char[] source, char[] dest) {
		for (int i = 0; i < source.length; i++) {
			if (source[i] == chr) {
				return dest[i];
			}
		}
		return chr;
	}

	public static void main(String[] args) {
		System.out.println(arab2Chinese("4天3晚"));
		System.out.println(chinese2Arab("四天三晚"));
		System.out.println(contains("四天三晚套餐", "四天三晚"));
		System.out.println(contains("四天三晚套餐", "4天三晚"));
		System.out.println(contains("四天三晚套餐", "4天3晚"));
		System.out.println(contains("4天3晚套餐", "四天三晚"));
	}

}
