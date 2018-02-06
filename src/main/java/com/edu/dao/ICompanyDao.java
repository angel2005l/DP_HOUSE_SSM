package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.Company;

@Repository
public interface ICompanyDao {

	// 查询公司信息
	public List<Company> selCompany(@Param("coId") String coId, @Param("simpleName") String simpleName)
			throws SQLException;

	// 更新公司
	public int uptCompany(@Param("coId") String coId, @Param("simpleName") String simpleName) throws SQLException;

	// 删除公司信息
	public int delCompany(String coId) throws SQLException;

	// 添加公司信息
	public int insCompany(Company insObj) throws SQLException;

	// 获得最大公司ID
	public String maxCoId(String addCode) throws SQLException;

	// 获得公司名
	public String selCompanyName(String coId) throws SQLException;

	// 根据公司编号/别名判断公司是否存在
	public int isCompanyExist(@Param("coId") String coId, @Param("simpleName") String simpleName) throws SQLException;

}
