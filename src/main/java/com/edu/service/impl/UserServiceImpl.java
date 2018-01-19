package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.IUserDao;
import com.edu.entity.User;
import com.edu.service.IUserService;
import com.edu.util.Result;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	public boolean login(User user) throws SQLException {
		User userObj = userDao.selectUserForLogin(user.getUserCode());
		if (userObj == null) {
			return false;
		} else {
			if (user.getUserPassword().equals(userObj.getUserPassword())) {
				return true;
			}
		}
		return false;
	}

	public Result<List<User>> selUser(int id) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

}
