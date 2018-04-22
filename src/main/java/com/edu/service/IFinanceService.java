package com.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.edu.entity.Finance;

public interface IFinanceService {
	// 根据empInfo查询当天交易信息
	public int selFinanceCountByEmpInfo(String empInfo, String empPer) throws Exception;

	// 查询财物记录
	public List<Finance> selFinance(String empId, String coId, String pageNum, String userPer,String finId) throws Exception;

	// 生成收支记录
	public int insFinance(String coId, String indId, String finType,BigDecimal finMoney) throws Exception;

}
