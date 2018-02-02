package com.edu.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Indent {

	private int id;// id
	private String indId;// 订单编号
	private Date indDate;// 订单时间
	private String indType;// 订单状态
	private String indInfo;// 订单信息
	private String houId;// 房屋编号
	private BigDecimal houMoney;// 房屋金额
	private BigDecimal indMoney;// 实际金额
	private BigDecimal indDiscount;// 折扣率
	private String barId;// 合同编号
	private String cusId;// 会员编号
	private String coId;// 单位编号

	/**
	 * 
	 */
	public Indent() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndId() {
		return indId;
	}

	public void setIndId(String indId) {
		this.indId = indId;
	}

	public Date getIndDate() {
		return indDate;
	}

	public void setIndDate(Date indDate) {
		this.indDate = indDate;
	}

	public String getIndType() {
		return indType;
	}

	public void setIndType(String indType) {
		this.indType = indType;
	}

	public String getIndInfo() {
		return indInfo;
	}

	public void setIndInfo(String indInfo) {
		this.indInfo = indInfo;
	}

	public String getHouId() {
		return houId;
	}

	public void setHouId(String houId) {
		this.houId = houId;
	}

	public BigDecimal getHouMoney() {
		return houMoney;
	}

	public void setHouMoney(BigDecimal houMoney) {
		this.houMoney = houMoney;
	}

	public BigDecimal getIndMoney() {
		return indMoney;
	}

	public void setIndMoney(BigDecimal indMoney) {
		this.indMoney = indMoney;
	}

	public BigDecimal getIndDiscount() {
		return indDiscount;
	}

	public void setIndDiscount(BigDecimal indDiscount) {
		this.indDiscount = indDiscount;
	}

	public String getBarId() {
		return barId;
	}

	public void setBarId(String barId) {
		this.barId = barId;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	@Override
	public String toString() {
		return "Indent [id=" + id + ", indId=" + indId + ", indDate=" + indDate + ", indType=" + indType + ", indInfo="
				+ indInfo + ", houId=" + houId + ", houMoney=" + houMoney + ", indMoney=" + indMoney + ", indDiscount="
				+ indDiscount + ", barId=" + barId + ", cusId=" + cusId + ", coId=" + coId + "]";
	}

}
