package com.edu.entity;

public class FunEmpRela {
	private int id;
	private String empPermission;
	private String funId;

	/**
	 * 
	 */
	public FunEmpRela() {
	}

	/**
	 * @param id
	 * @param empPermission
	 * @param funId
	 */
	public FunEmpRela(int id, String empPermission, String funId) {
		this.id = id;
		this.empPermission = empPermission;
		this.funId = funId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpPermission() {
		return empPermission;
	}

	public void setEmpPermission(String empPermission) {
		this.empPermission = empPermission;
	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}

	@Override
	public String toString() {
		return "FunEmpRela [id=" + id + ", empPermission=" + empPermission + ", funId=" + funId + "]";
	}

}
