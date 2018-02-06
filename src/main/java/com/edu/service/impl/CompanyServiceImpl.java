package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edu.base.BaseSevice;
import com.edu.dao.ICompanyDao;
import com.edu.entity.Company;
import com.edu.service.ICompanyService;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service
public class CompanyServiceImpl extends BaseSevice implements ICompanyService {

	@Autowired
	ICompanyDao companyDao;

	@Override
	public Result<Object> insCompany(Company insObj) {
		try {
			//获得最大maxCoIdC+(4)区号+（8）自增编号
			String coAddCode = StrUtil.strAddLeftZero(insObj.getCoAddCode(), 4);
			String maxCoId = companyDao.maxCoId(coAddCode);
			int maxId = 0;
			if(StrUtil.isBlank(maxCoId)){
				maxId = 0;
			}else{
//				StrUtil.cutStringRightRtnInteger(str, size, isFixed);
			}
			
			
			
			int insCompany = companyDao.insCompany(insObj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = {Exception.class})
	public Result<Object> uptCompany(String coId, String SimpleName) {
		//是否存在
		
		//更新操作
		//并且进行emp注册
		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//回手动滚

		return null;
	}

	@Override
	public Result<Object> delCompany(String coId) {
		//是否存在
		//删除操作
		return null;
	}

	@Override
	public List<Company> selCompany(String coId, String simpleName) {
		//查询
		return null;
	}

}
