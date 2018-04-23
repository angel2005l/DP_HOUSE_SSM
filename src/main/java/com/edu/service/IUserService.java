package com.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.edu.entity.User;
import com.edu.util.Result;

public interface IUserService {
	/**
	 * 
	 * @Title: login   
	 * @Description: 登录验证
	 * @param user
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: boolean
	 *
	 */
	public boolean login(User user) throws SQLException;

	/**
	 * 
	 * @Title: selUser   
	 * @Description: 查询用户信息  
	 * @param id
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: Result<List<User>>
	 *
	 */
	public Result<List<User>> selUser(int id) throws SQLException;
}
