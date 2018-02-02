package com.edu.entity;

import java.sql.Date;

public class Bargain {

	private int id;//id
	private String barId;//合同编号
	private String barName;//合同名称
	private Date barDate;//合同时间
	private String barContext;//合同内容
	private String cusName;//合同甲方
	private String coName;//合同乙方
	
	/**
	 * 
	 */
	public Bargain() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarId() {
		return barId;
	}

	public void setBarId(String barId) {
		this.barId = barId;
	}

	public String getBarName() {
		return barName;
	}

	public void setBarName(String barName) {
		this.barName = barName;
	}

	public Date getBarDate() {
		return barDate;
	}

	public void setBarDate(Date barDate) {
		this.barDate = barDate;
	}

	public String getBarContext() {
		return barContext;
	}

	public void setBarContext(String barContext) {
		this.barContext = barContext;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	@Override
	public String toString() {
		return "Bargain [id=" + id + ", barId=" + barId + ", barName=" + barName + ", barDate=" + barDate
				+ ", barContext=" + barContext + ", cusName=" + cusName + ", coName=" + coName + "]";
	}

}
