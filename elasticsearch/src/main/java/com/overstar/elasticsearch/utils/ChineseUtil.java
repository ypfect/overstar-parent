package com.overstar.elasticsearch.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ChineseUtil {

	public static boolean isChinese(String str) {
		String regEx = "[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find()) {
			flg = true;
		}
		return flg;
	}

	public static void main(String[] args) {
		System.out.println(isChinese("dasdsad hhdsadas ~^^@!*@!*__"));
		System.out.println(isChinese("dasdsad hhdsadas ~^^@!*@!*__哈哈dsads a"));
		System.out.println(isChinese("全都是中文...&(&)%^^~!哈哈"));
	}

}
