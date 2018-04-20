package com.edu.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

public interface IFinanceDao {
	//根据empInfo查询交易数量
	public int selFinanceCountByEmpInfo(@Param("empInfo") String empInfo,@Param("empPer") String empPer) throws SQLException;
	
	
}
