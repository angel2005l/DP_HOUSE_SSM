package com.edu.base;

import com.edu.util.Result;

public class BaseSevice {

	/**
	 * 返回结果集合
	 */
	/**
	 * 
	 * @Title: rtnFailResult   
	 * @Description: 返回失败结果 并携带信息  
	 * @param: @param msg
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnFailResult(String msg) {
		return new Result<>(1, msg);
	}

	/**
	 * 
	 * @Title: rtnFailResultWithData   
	 * @Description: 返回失败结果 并携带信息和数据
	 * @param: @param msg
	 * @param: @param data
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnFailResultWithData(String msg, T data) {
		return new Result<T>(1, msg, data);
	}

	/**
	 * 
	 * @Title: rtnSuccessResult   
	 * @Description: 返回成功结果
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnSuccessResult() {
		return new Result<T>(0);
	}

	/**
	 * 
	 * @Title: rtnSuccessResult   
	 * @Description: 返回成功结果 并携带信息   
	 * @param: @param msg
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnSuccessResult(String msg) {
		return new Result<>(0, msg);
	}

	/**
	 * 
	 * @Title: rtnSuccessResultWithData   
	 * @Description: 返回成功结果 并携带信息和数据
	 * @param: @param msg
	 * @param: @param data
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnSuccessResultWithData(String msg, T data) {
		return new Result<T>(0, msg, data);
	}
}
