package com.edu.service;

import java.util.List;

import com.edu.entity.Company;
import com.edu.util.Result;

public interface ICompanyService {

	// 新增公司
	public Result<Object> insCompany(Company insObj);

	// 更新公司
	public Result<Object> uptCompany(String coId ,String SimpleName);

	// 删除公司
	public Result<Object> delCompany(String coId);

	// 查询公司
	public List<Company> selCompany(String coId,String simpleName);

}
