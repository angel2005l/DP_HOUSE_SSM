package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.base.BaseSevice;
import com.edu.dao.IFunctionDIYDao;
import com.edu.entity.FunctionDIY;
import com.edu.service.IFunctionService;
import com.edu.util.Result;

@Service
public class FunctionServiceImpl extends BaseSevice implements IFunctionService {
	private final static Logger log = LoggerFactory.getLogger(FunctionServiceImpl.class);
	
	@Autowired
	IFunctionDIYDao funDao;
	
	@Override
	public Result<List<FunctionDIY>> functionForUser(String permission) {
		List<FunctionDIY> result;
		try {
			result = funDao.selFunction(permission);
			if(null != result && !result.isEmpty()){
				return rtnSuccessResultWithData("", result);
			}
			return rtnFailResult("该用户非法");
		} catch (SQLException e) {
			log.error("获取权限功能异常，异常原因："+e.getMessage());
			return rtnErrorResult("获取权限功能异常，请联系管理员");
		}
	}

}
