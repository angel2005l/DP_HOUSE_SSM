package com.edu.dao;

import org.springframework.stereotype.Repository;

import com.edu.entity.User;

@Repository
public interface IUserDao {
	User selectUserForLogin(String userCode);
}