package com.edu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateUtil {

	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
	// 基本类型
	public static final String YM = "yyyy-MM";
	public static final String YMD = "yyyy-MM-dd";
	public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

	// 业务格式 （连续）
	private static final String JOINT_YMD = "yyyyMMdd";
	private static final String JOINT_YMDHM = "yyyyMMddHHmm";

	// 格式转换工具
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat();

	/**
	 * 
	 * @Title: isValidDate   
	 * @Description: 校验 日期字符串是否正确
	 * @param: @param date
	 * @param: @param pattern
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 *
	 */
	public static boolean isValidDate(String date, String pattern) {
		if (StrUtil.isBlank(date) || StrUtil.isBlank(pattern)) {
			return false;
		}
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			// 设置lenient为false.
			// 严格的解析,输入必须匹配这个对象的格式。
			format.setLenient(false);
			format.parse(date);
		} catch (ParseException e) {
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 
	 * @Title: curDateYM   
	 * @Description: 获得当前时间（yyyy-MM）
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 *
	 */
	public static String curDateYM() {
		dateFormat.applyPattern(YM);
		return dateFormat.format(System.currentTimeMillis());
	}

	/**
	 * 
	 * @Title: curTimeYMD   
	 * @Description: 获得当前日期 （yyyy-MM-dd）   
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 *
	 */
	public static String curDateYMD() {
		dateFormat.applyPattern(YMD);
		return dateFormat.format(System.currentTimeMillis());
	}

	/**
	 * 
	 * @Title: curTime   
	 * @Description: 获得当前时间（yyyy-MM-dd HH:mm:ss）
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 *
	 */
	public static String curDateYMDHMS() {
		dateFormat.applyPattern(YMDHMS);
		return dateFormat.format(System.currentTimeMillis());
	}

	/*
	 * 业务获得ID的日期识别码
	 */

	/**
	 * 
	 * @Title: curDateYMDForservice   
	 * @Description: 获得当前业务ID识别码 （yyyyMMdd）
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 *
	 */
	public static String curDateYMDForservice() {
		dateFormat.applyPattern(JOINT_YMD);
		return dateFormat.format(System.currentTimeMillis());
	}

	/**
	 * 
	 * @Title: curDateYMDHMForService   
	 * @Description: 获得当前业务ID识别码 （yyyyMMddHHmm）
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 *
	 */
	public static String curDateYMDHMForService() {
		dateFormat.applyPattern(JOINT_YMDHM);
		return dateFormat.format(System.currentTimeMillis());
	}

	/*
	 * 字符串转换Date
	 */

	/**
	 * 
	 * @Title: curDateByStr   
	 * @Description: 获得当前时间  （yyyy-MM-dd HH:mm:ss）
	 * @param: @return 
	 * @author: MR.H
	 * @return: Date      
	 *
	 */
	public static Date curDateByStr() {
		dateFormat.applyPattern(YMDHMS);
		try {
			return dateFormat.parse(curDateYMDHMS());
		} catch (ParseException e) {
			log.error("时间工具类【curDateByStr】方法异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @Title: curDateByStr   
	 * @Description: 根据日期格式,转换传入的日期字符串 
	 * @param: @param date
	 * @param: @param pattern
	 * @param: @return 
	 * @author: MR.H
	 * @return: Date      
	 *
	 */
	public static Date curDateByStr(String date, String pattern) {
		if (!isValidDate(date, pattern)) {
			return null;
		}
		dateFormat.applyPattern(StrUtil.isBlank(pattern) ? YMDHMS : pattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			log.error("时间工具类【curDateByStr】[string,string]方法异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	/*
	 * 拓展方法
	 */

	/**
	 * 
	 * @Title: addDay   
	 * @Description: 几天后
	 * @param day
	 * @return
	 * @author: MR.H
	 * @return: String
	 *
	 */
	public static Date addDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curDateByStr(curDateYMDHMS(),DateUtil.YMDHMS));
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}

	// /**
	// *
	// * @Title: addMonth
	// * @Description: 几月后
	// * @param: @return
	// * @author: MR.H
	// * @return: String
	// *
	// */
	// public static String addMonth() {
	//
	// return "";
	// }
	//
	// /**
	// *
	// * @Title: addYear
	// * @Description: 几年后
	// * @param: @return
	// * @author: MR.H
	// * @return: String
	// *
	// */
	// public static String addYear() {
	// return "";
	// }
}
