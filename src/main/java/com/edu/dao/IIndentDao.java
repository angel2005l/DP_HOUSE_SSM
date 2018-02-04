package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.Indent;

@Repository
public interface IIndentDao {
	// 查询该用户所有订单
	public List<Indent> selIndentForEmp(@Param("empId") String empId, @Param("coId") String coId,
			@Param("indId") String indId) throws SQLException;

	// 管理者查询多有订单
	public List<Indent> selIndentForAdmin(@Param("coId") String coId,
			@Param("indId") String indId) throws SQLException;

	// 订单是否存在
	public int indentExist(@Param("indId") String indId, @Param("coId") String coId) throws SQLException;

	// 更新订单信息
	public int uptIndentType(@Param("indId") String indId, @Param("indType") String indType) throws SQLException;

	// 删除订单信息
	public int delIndent(@Param("indId") String indId, @Param("coId") String coId) throws SQLException;

	// 新增订单信息
	public int insIndent(Indent indObj) throws SQLException;

	// 获得当前该公司maxId
	public String maxIndentId(String coId) throws SQLException;

	// 获得订单的状态
	public String selIndentType(@Param("indId") String indId, @Param("coId") String coId) throws SQLException;
}
