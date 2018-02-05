package com.edu.util;

import java.io.Serializable;

public class Result<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int ERROR = 500;
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	private int status;
	private String msg;
	private T data;

	public Result() {
	}

	public Result(int status) {
		this.status = status;
	}

	public Result(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public Result(int status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
