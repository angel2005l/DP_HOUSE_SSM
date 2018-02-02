package com.edu.entity;

public class Test {
	private String userName;
	private String userPass;

	/**
	 * 
	 */
	public Test() {
	}

	/**
	 * @param userName
	 * @param userPass
	 */
	public Test(String userName, String userPass) {
		this.userName = userName;
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "Test [userName=" + userName + ", userPass=" + userPass + "]";
	}

}
