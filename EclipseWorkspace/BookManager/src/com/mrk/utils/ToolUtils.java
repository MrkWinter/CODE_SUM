package com.mrk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ͨ�ù�����
 * 
 * @author MrkWinter
 *
 */
public class ToolUtils {
	// �ж��Ƿ�Ϊ��ʽ��ȷ�ı��
	public static boolean isPositiveInteger(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("\\d+") && !str.startsWith("0");
	}

	// �ж��ַ����Ƿ�Ϊ����
	public static boolean isPositiveNumber(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("\\d+(\\.\\d+)?") && Double.parseDouble(str) > 0;
	}

	// �ж��Ƿ�Ϊ�ֻ���
	public static boolean isPhoneNumber(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("^1\\d{10}$");
	}

	// �ж��ַ���/�����Ƿ�Ϊ��
	public static Boolean isEmpty(Object ob) {
		if (ob instanceof String) {
			ob = ((String) ob).trim();
		}
		if (ob == null || "".equals(ob)) {
			return true;
		}
		return false;
	}

	// �жϲ�Ϊ��
	public static Boolean isNotEmpty(Object ob) {
		if (ob instanceof String) {
			ob = ((String) ob).trim();
		}
		if (ob == null || "".equals(ob)) {
			return false;
		}
		return true;
	}

	// �ж��ַ���/�����Ƿ���ͬ
	public static Boolean isSame(Object ob1, Object ob2) {
		if (ob1 == null && ob2 == null) {
			return true;
		}
		if (ob1 == null || ob2 == null) {
			return false;
		}
		return ob1.equals(ob2);
	}

	// �õ���ǰʱ�� ��Long���ͷ���
	public static Long getCurrentTime() {
		Long time = System.currentTimeMillis();
		return time;
	}

	// ��Long���͵�ʱ��ת���������ַ�����ʽ ע���������Բ���ȫ �����ڲ���
	public static String getFarmatTime(Long time) {
		if (time == null || time == 0) {
			// ���ݿ��л�ȡbigInt��nullΪ0������ -- ����ʹ����ResultSet ��getLong���� ���Ϊ�� ����0
			return "---";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTimeStr = format.format(new Date(time));
		return dateTimeStr;
	}
}
