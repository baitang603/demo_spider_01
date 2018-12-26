package cn.tledu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static String match(String input, String regex) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			sb.append(m.group());
		}
		return sb.toString();
	}
	
	public static List<String> matchList(String input, String regex) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			list.add(m.group());
		}
		return list;
	}
	
	public static String match(String input, String regex, int grpNum) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			sb.append(m.group(grpNum));
		}
		return sb.toString();
	}
}
