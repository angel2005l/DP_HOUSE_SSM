package com.edu.service;

import java.math.BigDecimal;
import java.util.List;

import com.edu.entity.Finance;

public interface IFinanceService {
	/**
	 * 
	 * @Title: selFinanceCountByEmpInfo   
	 * @Description: 根据empInfo查询当天交易信息 
	 * @param empInfo
	 * @param empPer
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int selFinanceCountByEmpInfo(String empInfo, String empPer) throws Exception;

	/**
	 * 
	 * @Title: selFinance   
	 * @Description: 查询财物记录
	 * @param empId
	 * @param coId
	 * @param pageNum
	 * @param userPer
	 * @param finId
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: List<Finance>
	 *
	 */
	public List<Finance> selFinance(String empId, String coId, String pageNum, String userPer, String finId)
			throws Exception;

	/**
	 * 
	 * @Title: insFinance   
	 * @Description: 生成收支记录
	 * @param coId
	 * @param indId
	 * @param finType
	 * @param finMoney
	 * @return
	 * @throws Exception
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int insFinance(String coId, String indId, String finType, BigDecimal finMoney) throws Exception;

}
