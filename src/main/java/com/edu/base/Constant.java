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
	 * 订单状态
	 */
	public static final String[] INDENTTYPE = { "审核中", "已取消", "已完成" };
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
	 * excel文件MIME
	 */
	public static final String EXCELMIME = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

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
	public static final String[] empExcelCol = { "empAccount", "empName", "empPhone", "empEmail", "empPass" };

}
