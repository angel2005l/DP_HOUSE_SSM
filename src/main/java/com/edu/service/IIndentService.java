package com.edu.service;

import java.sql.SQLException;
import java.util.List;

import com.edu.entity.Indent;
import com.edu.util.Result;

public interface IIndentService {
	/**
	 * 
	 * @Title: selIndent   
	 * @Description: 查询订单信息 
	 * @param permiType
	 * @param indId
	 * @param empId
	 * @param coId
	 * @return
	 * @author: MR.H
	 * @return: List<Indent>      
	 * @throws
	 */
	public List<Indent> selIndent(String permiType, String indId, String empId, String coId);

	/**
	 * 
	 * @Title: uptIndent   
	 * @Description: 更新订单
	 * @param indType
	 * @param indId
	 * @param coId
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> uptIndent(String indType, String indId, String coId);

	/**
	 * 
	 * @Title: delIndent   
	 * @Description: 删除订单 只能删除(审核中)的单子
	 * @param indId
	 * @param coId
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> delIndent(String indId, String coId);

	/**
	 * 
	 * @Title: insIndent   
	 * @Description: 添加订单
	 * @param insObj
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>      
	 * @throws
	 */
	public Result<Object> insIndent(Indent insObj);

	/**
	 * 
	 * @Title: selIndentCountByEmpId   
	 * @Description: 根据empInfo获得未处理订单信息  
	 * @param empId
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int
	 *
	 */
	public int selIndentCountByEmpInfo(String empInfo, String empPer) throws Exception;
}
