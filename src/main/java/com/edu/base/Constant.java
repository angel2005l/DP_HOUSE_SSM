package com.edu.base;

public final class Constant {
	/**
	 * 左边
	 */
	public static final String LEFT = "left";
	/**
	 *  中间
	 */
	public static final String CENTER = "center";
	/**
	 * 右边
	 */
	public static final String RIGHT = "right";
	/**
	 * 订单头标识
	 */
	public static final String INDENTTAG = "I";
	/**
	 * 通用状态
	 */
	public static final String[] TYPE = { "审核中", "已确认", "已取消", "已完成" };
	/**
	 * 订单状态 
	 */
	public static final String[] INDENTTYPE = { "defaultInd", "enterInd", "cancelInd" };
	/**
	 * 合同头标识
	 */
	public static final String BARGAINTAG = "B";
	/**
	 * 房屋头标识
	 */
	public static final String HOUSETAG = "H";
	/**
	 * 财物头标识
	 */
	public static final String FINANCETAG = "F";

	/**
	 * 公司头标识
	 */
	public static final String COMPANYTAG = "C";

	/**
	 * 员工头标识
	 */
	public static final String EMPLOYEETAG = "E";

	/**
	 * 虚拟顾客
	 */
	public static final String[] CUSNAME = { "顾客A", "顾客B", "顾客C", "顾客D" };

	/**
	 * 默认密码
	 */
	public static final String[] PASSWORDDEFAULT = { "qwer", "sa", "123456" };

	/**
	 * excel2007及以上文件MIME
	 */
	public static final String EXCELMIME = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	/**
	 * excel2003及以下文件MIME
	 */
	public static final String EXCELXLSMIME = "application/vnd.ms-excel";

	/**
	 * JPEG/JPG文件MIME
	 */
	public static final String JPEGMIME = "image/jpeg";

	/**
	 * PNG文件MIME
	 */
	public static final String PNGMIME = "image/png";

	/**
	 * 员工导入列对应字段
	 * （顺序不可随意改动）
	 */
	// public static final String[] EMPEXCELCOL = { "empAccount", "empName",
	// "empPhone", "empEmail", "empPass" };
	public static final String[] EMPEXCELCOL = { "empAccount", "empName", "empPhone", "empEmail" };

	/**
	 *	EXCEL2007及以上后缀名
	 */
	public static final String XLSXSUFFIX = ".xlsx";

	/**
	 * EXCEL2003及以下后缀名
	 */
	public static final String XLSSUFFIX = ".xls";

}
