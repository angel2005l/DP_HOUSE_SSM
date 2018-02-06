package com.edu.service;

import java.util.List;

import com.edu.entity.Company;
import com.edu.util.Result;

public interface ICompanyService {

	/**
	 * 
	 * @Title: insCompany   
	 * @Description: 新增公司
	 * @param insObj
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	public Result<Object> insCompany(Company insObj);

	/**
	 * 
	 * @Title: uptCompany   
	 * @Description: 更新公司
	 * @param coId
	 * @param SimpleName
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	public Result<Object> uptCompany(String coId, String simpleName);

	/**
	 * 
	 * @Title: delCompany   
	 * @Description: 删除公司
	 * @param coId
	 * @return
	 * @author: MR.H
	 * @return: Result<Object>
	 *
	 */
	public Result<Object> delCompany(String coId);

	/**
	 * 
	 * @Title: selCompany   
	 * @Description: 查询公司
	 * @param coId
	 * @param simpleName
	 * @return
	 * @author: MR.H
	 * @return: List<Company>
	 *
	 */
	public List<Company> selCompany(String coId, String simpleName);

}
