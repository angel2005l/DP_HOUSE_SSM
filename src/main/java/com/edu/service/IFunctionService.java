package com.edu.service;

import java.util.List;

import com.edu.entity.FunctionDIY;
import com.edu.util.Result;

public interface IFunctionService {

	/**
	 * 
	 * @Title: functionForUser   
	 * @Description: 根据用户对应的权限类别 显示全部的功能
	 * @param permission
	 * @return
	 * @author: MR.H
	 * @return: Result<List<FunctionDIY>>
	 *
	 */
	public Result<List<FunctionDIY>> functionForUser(String permission);

}
