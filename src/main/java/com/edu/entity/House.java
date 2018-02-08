package com.edu.entity;

import java.math.BigDecimal;

public class House {
	private int id;
	private String houId;
	private String houName;
	private String houStatus;
	private String houtype;
	private BigDecimal houFloor;
	private BigDecimal houBuild;
	private BigDecimal houMoney;
	private String houAdd;
	private String houImg;
	private Integer houBed;
	private int houBath;
	private int houLiving;
	private String empId;

	/**
	 * 
	 */
	public House() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouId() {
		return houId;
	}

	public void setHouId(String houId) {
		this.houId = houId;
	}

	public String getHouName() {
		return houName;
	}

	public void setHouName(String houName) {
		this.houName = houName;
	}

	public String getHouStatus() {
		return houStatus;
	}

	public void setHouStatus(String houStatus) {
		this.houStatus = houStatus;
	}

	public String getHoutype() {
		return houtype;
	}

	public void setHoutype(String houtype) {
		this.houtype = houtype;
	}

	public BigDecimal getHouFloor() {
		return houFloor;
	}

	public void setHouFloor(BigDecimal houFloor) {
		this.houFloor = houFloor;
	}

	public BigDecimal getHouBuild() {
		return houBuild;
	}

	public void setHouBuild(BigDecimal houBuild) {
		this.houBuild = houBuild;
	}

	public BigDecimal getHouMoney() {
		return houMoney;
	}

	public void setHouMoney(BigDecimal houMoney) {
		this.houMoney = houMoney;
	}

	public String getHouAdd() {
		return houAdd;
	}

	public void setHouAdd(String houAdd) {
		this.houAdd = houAdd;
	}

	public String getHouImg() {
		return houImg;
	}

	public void setHouImg(String houImg) {
		this.houImg = houImg;
	}

	public Integer getHouBed() {
		return houBed;
	}

	public void setHouBed(Integer houBed) {
		this.houBed = houBed;
	}

	public int getHouBath() {
		return houBath;
	}

	public void setHouBath(int houBath) {
		this.houBath = houBath;
	}

	public int getHouLiving() {
		return houLiving;
	}

	public void setHouLiving(int houLiving) {
		this.houLiving = houLiving;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", houId=" + houId + ", houName=" + houName + ", houStatus=" + houStatus
				+ ", houtype=" + houtype + ", houFloor=" + houFloor + ", houBuild=" + houBuild + ", houMoney="
				+ houMoney + ", houAdd=" + houAdd + ", houImg=" + houImg + ", houBed=" + houBed + ", houBath=" + houBath
				+ ", houLiving=" + houLiving + ", empId=" + empId + "]";
	}

}