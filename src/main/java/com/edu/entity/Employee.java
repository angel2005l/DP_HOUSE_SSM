package com.edu.entity;

public class Employee {

	private int id;
	private String empId;
	private String empAccount;
	private String empName;
	private String empPhone;
	private String empEmail;
	private String empPass;
	private String empSalt;
	private String empPermission;
	private String coId;

	/**
	 * 
	 */
	public Employee() {
	}

	/**
	 * @param id
	 * @param empId
	 * @param empAccount
	 * @param empName
	 * @param empPhone
	 * @param empEmail
	 * @param empPass
	 * @param empSalt
	 * @param empPermission
	 * @param coId
	 */
	public Employee(int id, String empId, String empAccount, String empName, String empPhone, String empEmail,
			String empPass, String empSalt, String empPermission, String coId) {
		this.id = id;
		this.empId = empId;
		this.empAccount = empAccount;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.empPass = empPass;
		this.empSalt = empSalt;
		this.empPermission = empPermission;
		this.coId = coId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpAccount() {
		return empAccount;
	}

	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpSalt() {
		return empSalt;
	}

	public void setEmpSalt(String empSalt) {
		this.empSalt = empSalt;
	}

	public String getEmpPermission() {
		return empPermission;
	}

	public void setEmpPermission(String empPermission) {
		this.empPermission = empPermission;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", empAccount=" + empAccount + ", empName=" + empName
				+ ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", empPass=" + empPass + ", empSalt=" + empSalt
				+ ", empPermission=" + empPermission + ", coId=" + coId + "]";
	}

}
