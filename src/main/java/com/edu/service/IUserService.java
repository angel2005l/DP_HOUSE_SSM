package com.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.edu.entity.User;
import com.edu.util.Result;

public interface IUserService {
	//登录验证
	public boolean login(User user) throws SQLException;
	//查询用户信息
	public Result<List<User>> selUser(int id) throws SQLException;
}
