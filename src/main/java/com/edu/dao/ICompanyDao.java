package com.edu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.entity.Company;

@Repository
public interface ICompanyDao {

	/**
	 * 
	 * @Title: selCompany   
	 * @Description: 查询公司信息
	 * @param id
	 * @param coId
	 * @param coSimpleName
	 * @param coName
	 * @param coAddCode
	 * @param coType
	 * @param coUniqueId
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: List<Company>      
	 * @throws
	 */
	public List<Company> selCompany(@Param("id") int id, @Param("coId") String coId,
			@Param("coSimpleName") String coSimpleName, @Param("coName") String coName,
			@Param("coAddCode") String coAddCode, @Param("coType") String coType,
			@Param("coUniqueId") String coUniqueId) throws SQLException;

	/**
	 * 
	 * @Title: uptCompany   
	 * @Description: 更新公司信息
	 * 				  允许更新的字段：
	 * 					公司名称
	 * 					公司地址
	 * @param companyUptObj
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int      
	 * @throws
	 */
	public int uptCompany(Company companyUptObj) throws SQLException;

	/**
	 * 
	 * @Title: delCompany   
	 * @Description: 删除公司信息
	 * @param id
	 * @param coId
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int      
	 * @throws
	 */
	public int delCompany(@Param("id") int id, @Param("coId") String coId) throws SQLException;

	/**
	 * 
	 * @Title: insCompany   
	 * @Description: 添加公司信息
	 * @param companys
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int      
	 * @throws
	 */
	public int insCompany(List<Company> companys) throws SQLException;

	/**
	 * 
	 * @Title: maxCoId   
	 * @Description: 获得最大公司ID
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public String maxCoId() throws SQLException;

	/**
	 * 
	 * @Title: selCompanyName   
	 * @Description: 获得公司名
	 * @param coId
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: String      
	 * @throws
	 */
	public String selCompanyName(String coId) throws SQLException;

	/**
	 * 
	 * @Title: isCompanyExist   
	 * @Description: 根据公司编号判断公司是否存在
	 * @param coId
	 * @return
	 * @throws SQLException
	 * @author: MR.H
	 * @return: int      
	 * @throws
	 */
	public int isCompanyExist(String coId) throws SQLException;

}
