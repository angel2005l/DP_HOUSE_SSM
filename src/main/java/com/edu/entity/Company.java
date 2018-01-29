package com.edu.entity;

public class Company {
	private int id;
	private String coId;
	private String coSimpleName;
	private String coName;
	private String coAddCode;
	private String coType;
	private String coUniqueId;
	private String coAdd;

	/**
	 * 
	 */
	public Company() {
	}

	/**
	 * @param id
	 * @param coId
	 * @param coSimpleName
	 * @param coName
	 * @param coAddCode
	 * @param coType
	 * @param coUniqueId
	 * @param coAdd
	 */
	public Company(int id, String coId, String coSimpleName, String coName, String coAddCode, String coType,
			String coUniqueId, String coAdd) {
		this.id = id;
		this.coId = coId;
		this.coSimpleName = coSimpleName;
		this.coName = coName;
		this.coAddCode = coAddCode;
		this.coType = coType;
		this.coUniqueId = coUniqueId;
		this.coAdd = coAdd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getCoSimpleName() {
		return coSimpleName;
	}

	public void setCoSimpleName(String coSimpleName) {
		this.coSimpleName = coSimpleName;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public String getCoAddCode() {
		return coAddCode;
	}

	public void setCoAddCode(String coAddCode) {
		this.coAddCode = coAddCode;
	}

	public String getCoType() {
		return coType;
	}

	public void setCoType(String coType) {
		this.coType = coType;
	}

	public String getCoUniqueId() {
		return coUniqueId;
	}

	public void setCoUniqueId(String coUniqueId) {
		this.coUniqueId = coUniqueId;
	}

	public String getCoAdd() {
		return coAdd;
	}

	public void setCoAdd(String coAdd) {
		this.coAdd = coAdd;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", coId=" + coId + ", coSimpleName=" + coSimpleName + ", coName=" + coName
				+ ", coAddCode=" + coAddCode + ", coType=" + coType + ", coUniqueId=" + coUniqueId + ", coAdd=" + coAdd
				+ "]";
	}

}
