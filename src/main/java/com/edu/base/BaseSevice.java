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
		return new Result<>(Result.FAIL, msg);
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
		return new Result<T>(Result.FAIL, msg, data);
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
		return new Result<T>(Result.SUCCESS);
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
		return new Result<>(Result.SUCCESS, msg);
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
		return new Result<T>(Result.SUCCESS, msg, data);
	}

	/**
	 * 
	 * @Title: rtnErrorResult   
	 * @Description: 返回异常结果 并携带信息
	 * @param @param msg
	 * @param @return
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnErrorResult(String msg) {
		return new Result<T>(Result.ERROR, msg);
	}

	/**
	 * 
	 * @Title: rtnErrorResultWithData   
	 * @Description: 返回异常结果 并携带信息和数据
	 * @param: @param msg
	 * @param: @param data
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnErrorResultWithData(String msg, T data) {
		return new Result<T>(Result.ERROR, msg, data);
	}

	/**
	 * 
	 * @Title: rtnDefault   
	 * @Description: 返回默认状态
	 * @param: @param status
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnDefault(int status) {
		return new Result<T>(status);
	}

	/**
	 * 
	 * @Title: rtnDefaultMsg   
	 * @Description: 返回默认状态 并携带信息
	 * @param: @param status
	 * @param: @param msg
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnDefaultMsg(int status, String msg) {
		return new Result<>(status, msg);
	}

	/**
	 * 
	 * @Title: rtnDefaultMsgWithData   
	 * @Description: 返回默认状态 并携带信息和数据
	 * @param: @param status
	 * @param: @param msg
	 * @param: @param data
	 * @param: @return 
	 * @author: MR.H
	 * @return: Result<T>      
	 * @throws
	 */
	public <T> Result<T> rtnDefaultMsgWithData(int status, String msg, T data) {
		return new Result<T>(status, msg, data);
	}
}
