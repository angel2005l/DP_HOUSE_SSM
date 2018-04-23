package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.edu.entity.Finance;

public interface IFinanceDao {
	// 根据empInfo查询交易数量
	public int selFinanceCountByEmpInfo(@Param("empInfo") String empInfo, @Param("empPer") String empPer)
			throws SQLException;

	public List<Finance> selFinance(@Param("coId") String coId,@Param("pageNum") int pageNum,@Param("finId") String finId) throws SQLException;

	public String maxFinId() throws SQLException;

	public int insFinace(Finance insObj) throws SQLException;

}
