package com.edu.util;

import com.edu.base.Constant;

public final class StrUtil {
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
	public static final boolean isBlank(String str) {
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
	public static final boolean notBlank(String str) {
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
	public static final boolean isPositiveInteger(String str) {
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
	public static final boolean iPositiveNum(String str) {
		return str.matches("^[1-9]\\d*\\.\\d*\\|0\\.\\d*[1-9]\\d*$");
	}

	/**
	 * 
	 * @Title: integerForIdAdd   
	 * @Description: 获取id后面的自增数值 并在前面补零 （端点）
	 * @param: @param str
	 * @param: @param size
	 * @param: @param type
	 * @param: @param isNeedFrontZero
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final Integer integerForIdAdd(String str, int size, String type) {
		String result = cutString(str, size, type);
		return isPositiveInteger(result) ? Integer.parseInt(result) : null;
	}

	/**
	 * 
	 * @Title: integerForIdAddForCenter   
	 * @Description: 获取id后面的自增数值并在前面补零（中间）
	 * @param: @param str
	 * @param: @param beginIndex
	 * @param: @param size
	 * @param: @param isNeedFrontZero
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final Integer integerForIdAddForCenter(String str, int beginIndex, int size) {
		String result = cutStringForCenter(str, beginIndex, size);
		return isPositiveInteger(result) ? Integer.parseInt(result) : null;
	}

	/**
	 * 
	 * @Title: cutString   
	 * @Description: 切割字符串 （端点）
	 * @param: @param str
	 * @param: @param size
	 * @param: @param type
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final String cutString(String str, int size, String type) {
		String result = null;
		int strSize = str.length();
		if (strSize == size) {
			return str;
		} else if (strSize < size) {
			return strAddSpace(str, strSize);
		}
		switch (type) {
		case Constant.RIGHT:
			result = str.substring(strSize - size);
			break;
		case Constant.LEFT:
			result = str.substring(0, size);
			break;
		default:
			result = str;
			break;
		}
		return result;
	}

	/**
	 * 
	 * @Title: cutStringForRight   
	 * @Description: 右边  
	 * @param: @param str
	 * @param: @param size
	 * @param: @param fixedHeight
	 * @param: @param isfixed
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final String cutStringForRight(String str, int size, int fixedHeight, boolean isfixed) {
		Result<String> checkResult = checkStrSize(str, size);
		if (1 == checkResult.getStatus()) {
			return checkResult.getData();
		}
		String result = null;
		if (isfixed) {
			result = str.substring(1);
		} else {

		}

	}

	/**
	 * 
	 * @Title: cutStringForCenter   
	 * @Description: 切割字符串（中间）
	 * @param: @param str
	 * @param: @param beginIndex
	 * @param: @param size
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final String cutStringForCenter(String str, int beginIndex, int size) {
		String result = null;
		int strLength = str.length();
		if (strLength < size) {
			result = strAddSpace(str, size);
		} else {
			int diffSize = strLength - beginIndex;
			if (diffSize < 0) {
				result = "";
			} else if (diffSize <= size) {
				result = strAddSpace(str.substring(beginIndex), size);
			} else {
				result = str.substring(beginIndex, beginIndex + size);
			}
		}
		return result;
	}

	/**
	 * 
	 * @Title: strAddSpace   
	 * @Description: 当切割长多大于字符串长度时 在尾部自增空格   
	 * @param: @param str
	 * @param: @param size
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	private static final String strAddSpace(String str, int size) {
		String result = str;
		for (int i = 0; i < size - str.length(); i++) {
			result += " ";
		}
		return result;
	}

	/**
	 * 
	 * @Title: strAddLeftZero   
	 * @Description: 在截取字段前补零
	 * @param: @param str
	 * @param: @param size
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final String strAddLeftZero(String str, int size) {
		String zeroStr = "";
		for (int i = 0; i < size - str.length(); i++) {
			zeroStr += "0";
		}
		return zeroStr + str;
	}

	private static final Result<String> checkStrSize(String str, int size) {
		int strSize = str.length();
		if (strSize == size) {
			return new Result<String>(1, "", str);
		} else if (strSize < size) {
			return new Result<String>(1, "", strAddSpace(str, size));
		}
		return new Result<>(0);

	}

	/**
	 * 
	 * @Title: cutStringForLeft   
	 * @Description: 左边  
	 * @param: @param str
	 * @param: @param size
	 * @param: @param fixedHeight
	 * @param: @param isfixed
	 * @param: @return 
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public static final String cutStringForLeftFixS(String str, int size, boolean isfixed) {
		Result<String> checkResult = checkStrSize(str, size);
		if (1 == checkResult.getStatus()) {
			return checkResult.getData();
		}
		String result = "";
		if (isfixed) {
			result = str.substring(0, size);
		} else {
			result = str.substring(0, str.length() - size);
		}
		return result;
	}
	
	public static final String cutStringForLeft(String str,int fixedHeight){
		return "";
	}
}
