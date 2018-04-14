package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.IFinanceDao;
import com.edu.service.IFinanceService;

@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {

	@Autowired
	private IFinanceDao financeDao;

	@Override
	public int selFinanceCountByEmpInfo(String empInfo, String empPer) throws Exception {
		return financeDao.selFinanceCountByEmpInfo(empInfo, empPer);
	}

}
