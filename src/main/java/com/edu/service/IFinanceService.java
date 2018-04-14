package com.edu.service;

public interface IFinanceService {
	//根据empInfo查询当天交易信息
	public int selFinanceCountByEmpInfo(String empInfo ,String empPer) throws Exception;
}
