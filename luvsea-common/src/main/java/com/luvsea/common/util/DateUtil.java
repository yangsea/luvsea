package com.luvsea.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建日期 2010-3-31 时间 上午10:46:13
 * 
 * @author gqp@shanxi 日期的工具类,包括日期转换为字符串，字符串转换为日期
 */
public class DateUtil {
    /**
     * 格式化日期
     */
    public static String format(Date date, String pattern) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    	return dateFormat.format(date);
    }
    /**
     * 格式化日期
     */
    public static Date format(String date, String pattern) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    	Date d = null;
    	try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return d;
    }
}
