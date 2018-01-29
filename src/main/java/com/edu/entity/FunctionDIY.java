package com.edu.entity;

public class FunctionDIY {
	private int id;
	private String funId;
	private String funName;
	private String funUrl;

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
	public FunctionDIY(int id, String funId, String funName, String funUrl) {
		this.id = id;
		this.funId = funId;
		this.funName = funName;
		this.funUrl = funUrl;
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

	@Override
	public String toString() {
		return "FunctionDIY [id=" + id + ", funId=" + funId + ", funName=" + funName + ", funUrl=" + funUrl + "]";
	}

}
