package com.edu.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Finance {
	private int id;// id
	private String finId;// 财务编号
	private String finType;// 财务类型
	private Date finDate;// 交易日期
	private BigDecimal finMoney;// 金额
	private String coId;// 单位编号
	private String indId;// 订单编号

	/**
	 * 
	 */
	public Finance() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFinId() {
		return finId;
	}

	public void setFinId(String finId) {
		this.finId = finId;
	}

	public String getFinType() {
		return finType;
	}

	public void setFinType(String finType) {
		this.finType = finType;
	}

	public Date getFinDate() {
		return finDate;
	}

	public void setFinDate(Date finDate) {
		this.finDate = finDate;
	}

	public BigDecimal getFinMoney() {
		return finMoney;
	}

	public void setFinMoney(BigDecimal finMoney) {
		this.finMoney = finMoney;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getIndId() {
		return indId;
	}

	public void setIndId(String indId) {
		this.indId = indId;
	}

	@Override
	public String toString() {
		return "Finance [id=" + id + ", finId=" + finId + ", finType=" + finType + ", finDate=" + finDate
				+ ", finMoney=" + finMoney + ", coId=" + coId + ", indId=" + indId + "]";
	}

}
