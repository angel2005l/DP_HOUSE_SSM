package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.entity.FunctionDIY;

@Repository
public interface IFunctionDIYDao {
	// 根据用户对应的权限类别 显示全部的功能
	public List<FunctionDIY> selFunction(String permission) throws SQLException;
}
