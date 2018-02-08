package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.edu.base.BaseSevice;
import com.edu.base.Constant;
import com.edu.dao.ICompanyDao;
import com.edu.dao.IEmployeeDao;
import com.edu.entity.Company;
import com.edu.entity.Employee;
import com.edu.service.ICompanyService;
import com.edu.util.MD5Util;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service
public class CompanyServiceImpl extends BaseSevice implements ICompanyService {
	private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	private ICompanyDao companyDao;
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public Result<Object> insCompany(Company insObj) {
		try {
			String coAddCode = StrUtil.strAddLeftZero(insObj.getCoAddCode(), 4);
			String maxCoId = companyDao.maxCoId(coAddCode);
			int maxId = 0;
			if (StrUtil.isBlank(maxCoId)) {
				maxId = 0;
			} else {
				maxId = StrUtil.cutStringLeftRtnInteger(maxCoId, 8, true);
			}
			insObj.setCoAddCode(coAddCode);
			insObj.setCoId(Constant.COMPANYTAG + coAddCode + StrUtil.strAddLeftZero((++maxId) + "", 8));

			if (companyDao.insCompany(insObj) > 0) {
				return rtnSuccessResult("公司添加成功，等待审核...");
			} else {
				return rtnFailResult("公司添加失败");
			}
		} catch (SQLException e) {
			log.error("公司添加异常,异常原因:" + e.getMessage());
			return rtnErrorResult("公司添加异常。");
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Result<Object> uptCompany(String coId, String simpleName) {
		// 是否存在
		try {
			simpleName = StrUtil.strToUpper(simpleName);
			// 是否存在
			// 按照coId来获得公司信息
			List<Company> companyList = null;
			if (companyDao.isCompanyExist("", simpleName) > 0) {
				return rtnFailResult("已存在使用该公司简称的公司信息");
			} else {
				companyList = companyDao.selCompany(coId, "");
				if (null != companyList && !companyList.isEmpty()) {
					if (companyList.size() > 1) {
						return rtnFailResult("公司查询错误，请检查查询条件");
					}
				} else {
					return rtnFailResult("公司信息不存在");
				}
			}

			Company comObj = companyList.get(0);
			// 添加员工
			Employee insEmp = new Employee();
			// E+单位别名+自增5位
			// 密码处理
			String salt = MD5Util.getRandomSalt();
			insEmp.setEmpId(Constant.EMPLOYEETAG + simpleName + "00001");
			insEmp.setEmpAccount(StrUtil.strToLower(simpleName));
			insEmp.setEmpName(comObj.getCoName());
			insEmp.setEmpPhone("");
			insEmp.setEmpEmail("");
			insEmp.setEmpPass(MD5Util.getMD5EncryptPass(Constant.PASSWORDDEFAULT[(int) (Math.random() * 3)], salt
					.getBytes()));
			insEmp.setEmpSalt(salt);
			insEmp.setEmpPermission("个人".equals(comObj.getCoType()) ? "1" : "2");
			insEmp.setCoId(coId);
			if (companyDao.uptCompany(coId, simpleName) > 0 && employeeDao.insEmployee(insEmp) > 0) {
				return rtnSuccessResult("公司审核成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回手动滚
				return rtnFailResult("公司审核失败");
			}
		} catch (SQLException e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回手动滚
			log.error("公司审核异常,异常原因:" + e.getMessage());
			return rtnErrorResult("公司审异常");
		}
	}

	@Override
	public Result<Object> delCompany(String coId) {
		try {
			if (companyDao.isCompanyExist(coId, "") > 0) {
				if (employeeDao.selEmpNum(coId) > 0) {
					return rtnFailResult("公司状态不正确");
				} else {
					return companyDao.delCompany(coId) > 0 ? rtnSuccessResult("删除公司成功") : rtnFailResult("删除合同失败");
				}
			} else {
				return rtnFailResult("无此公司信息");
			}
		} catch (SQLException e) {
			log.error("公司查询异常");
			return rtnErrorResult("公司删除失败");
		}
	}

	@Override
	public List<Company> selCompany(String coId, String simpleName) {
		try {
			return companyDao.selCompany(coId, simpleName);
		} catch (SQLException e) {
			log.error("公司查询异常");
			return null;
		}
	}
}
