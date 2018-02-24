package com.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.edu.entity.FunctionDIY;

public interface IFunctionService {

	//根据用户对应的权限类别  显示全部的功能
	public List<FunctionDIY> selFunction(String permission) throws SQLException;
	
}
