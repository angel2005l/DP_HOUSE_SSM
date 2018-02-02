package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.ITestDao;
import com.edu.entity.Test;
import com.edu.service.ITestService;

@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	ITestDao testDao;

	@Override
	public Test selTestSer(String userName) {
		System.err.println(userName+"222");
		List<Test> selInfoByCol = testDao.selInfoByCol(userName);
		System.err.println(selInfoByCol);
		if (null != selInfoByCol && !selInfoByCol.isEmpty()) {
			return selInfoByCol.get(0);
		}
		return null;
	}

}
