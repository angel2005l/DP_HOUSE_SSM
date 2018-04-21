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
import com.edu.dao.IEmployeeDao;
import com.edu.entity.Employee;
import com.edu.service.IEmployeeService;
import com.edu.util.MD5Util;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service
public class EmployeeServiceImpl extends BaseSevice implements IEmployeeService {
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	// private final int defaultIndex = 0;
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public Result<Employee> login(String empAccount, String userPass) {
		try {
			Employee employee = employeeDao.loginEmp(empAccount);
			if (null == employee) {
				return rtnFailResult("用户不存在");
			}
			return MD5Util.check(userPass, employee.getEmpSalt(), employee.getEmpPass()) ? rtnSuccessResultWithData(
					"登录成功", employee) : rtnFailResult("登陆失败,密码错误");
		} catch (SQLException e) {
			log.error("登录校验异常,异常原因:" + e.getMessage());
			return rtnErrorResult("登录校验异常");
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Result<Object> insEmployee(String coId, List<Employee> datas) throws Exception {
		if (datas == null || datas.isEmpty())
			return rtnFailResult("添加员工数据集为空,请检查文件");
		synchronized (this) {
			String maxEmpId = employeeDao.selMaxEmpId(coId);
			if (StrUtil.isBlank(maxEmpId))
				return rtnFailResult("未找到相关公司信息");
			Integer maxId = StrUtil.cutStringRightRtnInteger(maxEmpId, 5, false);
			String comSimpleCode = StrUtil.cutStringForLeftFixS(maxEmpId, 5);
			if (null == maxId || StrUtil.isBlank(comSimpleCode))
				return rtnFailResult("插入失败,无法获得当前最大值");
			// 进行加密和自增列添加
			for (Employee empObj : datas) {
				empObj.setEmpPermission("1");
				empObj.setEmpId(comSimpleCode + StrUtil.strAddLeftZero((++maxId) + "", 5));
				// 随机盐
				String salt = MD5Util.getRandomSalt();
				// 加密密码
				empObj.setEmpSalt(salt);
				empObj.setEmpPass(MD5Util.getMD5EncryptPass("123456", salt.getBytes()));
				empObj.setCoId(coId);
				System.err.println(empObj);
			}
			// 保存数据
			int insNum = employeeDao.insEmployees(datas);
			if (insNum == datas.size()) {
				return rtnSuccessResult("员工批量插入成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回手动滚
				return rtnFailResult("员工批量操作失败");
			}
			// } catch (SQLException e) {
			// log.error("员工批量插入异常,异常信息：" + e.getMessage());
			// throw e;
			// // return rtnFailResult("员工批量插入异常");
			// }
		}
	}

	@Override
	public Result<Employee> selEmployeeByFirst(String empId, String coId) {
		try {
			List<Employee> employees = employeeDao.selEmployee(empId, coId, 1);
			if (null == employees || employees.isEmpty())
				return rtnFailResultWithData("查找对象不存在,请检查查询条件", null);
			else
				return rtnSuccessResultWithData("", employees.get(0));
		} catch (SQLException e) {
			log.error("员工查询异常：异常信息：" + e.getMessage());
			return rtnFailResultWithData("员工查询异常", null);
		}
	}

	@Override
	public Result<List<Employee>> selEmployee(String empId, String coId, String pageNum) {
		try {
			List<Employee> employees = employeeDao.selEmployee(empId, coId, Integer.parseInt(pageNum));
			if (null == employees || employees.isEmpty())
				return rtnFailResultWithData("查找对象不存在,请检查查询条件", null);
			else
				return rtnSuccessResultWithData("", employees);
		} catch (SQLException e) {
			log.error("员工查询异常：异常信息：" + e.getMessage());
			return rtnFailResultWithData("员工查询异常", null);
		}
	}

	@Override
	public Result<Object> delEmployee(String empId, String coId) {
		try {
			if (employeeDao.employeeExist(empId, coId) > 0) {
				return employeeDao.delEmployee(empId, coId) > 0 ? rtnSuccessResult("员工【" + empId + "】删除成功")
						: rtnFailResult("员工【" + empId + "】删除失败");
			}
			return rtnFailResult("员工信息不存在,删除失败");
		} catch (SQLException e) {
			log.error("员工删除异常,异常信息：" + e.getMessage());
			return rtnFailResult("员工删除异常");
		}
	}

	@Override
	public Result<Object> uptEmployeePass(String oldPass, String newPass, String empId, String coId) {
		try {
			List<Employee> uptEmpObj = employeeDao.selEmployee(empId, coId, 1);
			if (null != uptEmpObj && !uptEmpObj.isEmpty()) {
				Employee employee = uptEmpObj.get(0);
				String salt = employee.getEmpSalt();
				if (MD5Util.check(oldPass, salt, employee.getEmpPass().trim())) {
					// String newPassCiphertext =
					// MD5Util.getMD5EncryptPass(newPass, salt.getBytes());
					int rtn = employeeDao.uptEmployeeByPass(MD5Util.getMD5EncryptPass(newPass, salt.getBytes()), empId,
							coId);
					return rtn > 0 ? rtnSuccessResult("员工【" + empId + "】密码修改成功")
							: rtnFailResult("员工【" + empId + "】密码修改失败");
				} else {
					return rtnFailResult("该员工原密码不正确");
				}
			} else {
				return rtnFailResult("员工信息不存在,请重试...");
			}
		} catch (SQLException e) {
			log.error("员工密码修改异常,异常信息：" + e.getMessage());
			return rtnFailResult("员工密码修改异常");
		}
	}
}
