package com.mrk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用工具类
 * 
 * @author MrkWinter
 *
 */
public class ToolUtils {
	// 判断是否为格式正确的编号
	public static boolean isPositiveInteger(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("\\d+") && !str.startsWith("0");
	}

	// 判断字符串是否为正数
	public static boolean isPositiveNumber(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("\\d+(\\.\\d+)?") && Double.parseDouble(str) > 0;
	}

	// 判断是否为手机号
	public static boolean isPhoneNumber(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("^1\\d{10}$");
	}

	// 判断字符串/对象是否为空
	public static Boolean isEmpty(Object ob) {
		if (ob instanceof String) {
			ob = ((String) ob).trim();
		}
		if (ob == null || "".equals(ob)) {
			return true;
		}
		return false;
	}

	// 判断不为空
	public static Boolean isNotEmpty(Object ob) {
		if (ob instanceof String) {
			ob = ((String) ob).trim();
		}
		if (ob == null || "".equals(ob)) {
			return false;
		}
		return true;
	}

	// 判断字符串/对象是否相同
	public static Boolean isSame(Object ob1, Object ob2) {
		if (ob1 == null && ob2 == null) {
			return true;
		}
		if (ob1 == null || ob2 == null) {
			return false;
		}
		return ob1.equals(ob2);
	}

	// 得到当前时间 以Long类型返回
	public static Long getCurrentTime() {
		Long time = System.currentTimeMillis();
		return time;
	}

	// 将Long类型的时间转换成日期字符串格式 注意这里线性不安全 仅用于测试
	public static String getFarmatTime(Long time) {
		if (time == null || time == 0) {
			// 数据库中获取bigInt的null为0？？？ -- 过程使用了ResultSet 的getLong方法 如果为空 返回0
			return "---";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTimeStr = format.format(new Date(time));
		return dateTimeStr;
	}
}
