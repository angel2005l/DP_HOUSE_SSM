package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.Company;

@Repository
public interface ICompanyDao {

	/**
	 * 获得公司数据
	 */
	public List<Company> selCompany(@Param("id") int id, @Param("coId") String coId,
			@Param("coSimpleName") String coSimpleName, @Param("coName") String coName,
			@Param("coAddCode") String coAddCode, @Param("coType") String coType,
			@Param("coUniqueId") String coUniqueId) throws SQLException;

	/**
	 * 更新公司信息
	 * 允许更新的字段：
	 * 公司名称
	 * 公司地址
	 */
	public int uptCompany(Company companyUptObj) throws SQLException;

	/**
	 * 删除公司信息
	 */
	public int delCompany(@Param("id") int id, @Param("coId") String coId) throws SQLException;

	/**
	 * 添加公司信息
	 */
	public int insCompany(List<Company> companys) throws SQLException;
}
