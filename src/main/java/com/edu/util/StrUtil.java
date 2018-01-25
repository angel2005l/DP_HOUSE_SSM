package com.edu.util;

public class StrUtil {
	/**
	 * 
	 * @Title: isBlank   
	 * @Description: 校验字符串是否为空 当字符串为空时返回true
	 * @param: @param str
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isBlank(String str) {
		return !notBlank(str);
	}

	/**
	 * 
	 * @Title: notBlank   
	 * @Description: 校验字符串是否为空 当字符串不为空则返回true
	 * @param: @param str
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 * @throws
	 */
	public static boolean notBlank(String str) {
		return null != str && "".equals(str.trim());
	}
	/**
	 * 
	 * @Title: isPositiveInteger   
	 * @Description: 校验字符串是否是一个正整数  
	 * @param: @param str
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isPositiveInteger(String str){
		return str.matches("^[1-9]\\d*$");
	}
	/**
	 * 
	 * @Title: iPositiveNum   
	 * @Description: 是否是一个正数
	 * @param: @param str
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 * @throws
	 */
	public static boolean iPositiveNum(String str){
		return str.matches("^[1-9]\\d*\\.\\d*\\|0\\.\\d*[1-9]\\d*$");
	}
	
}
