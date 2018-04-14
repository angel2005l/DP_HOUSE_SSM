package com.edu.entity;

public class FunctionDIY {
	private int id;// id
	private String funId;// 功能编号
	private String funName;// 功能名称
	private String funUrl;// 功能url
	private String funIcon;// 功能图标

	/**
	 * 
	 */
	public FunctionDIY() {
	}

	/**
	 * @param id
	 * @param funId
	 * @param funName
	 * @param funUrl
	 */
	public FunctionDIY(int id, String funId, String funName, String funUrl, String funIcon) {
		this.id = id;
		this.funId = funId;
		this.funName = funName;
		this.funUrl = funUrl;
		this.funIcon = funIcon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public String getFunIcon() {
		return funIcon;
	}

	public void setFunIcon(String funIcon) {
		this.funIcon = funIcon;
	}

	@Override
	public String toString() {
		return "FunctionDIY [id=" + id + ", funId=" + funId + ", funName=" + funName + ", funUrl=" + funUrl
				+ ", funIcon=" + funIcon + "]";
	}

}
