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
import com.edu.dao.IIndentDao;
import com.edu.entity.Indent;
import com.edu.service.IBargainService;
import com.edu.service.IIndentService;
import com.edu.util.DateUtil;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service
public class IndentServiceImpl extends BaseSevice implements IIndentService {
	private static final Logger log = LoggerFactory.getLogger(IndentServiceImpl.class);
	@Autowired
	IIndentDao indentDao;

	@Autowired
	IBargainService bargainService;

	@Override
	public List<Indent> selIndent(String permiType, String indId, String empId, String coId) {
		List<Indent> selData = null;
		try {
			switch (permiType) {
			case "1":
				selData = indentDao.selIndentForEmp(empId, coId, indId);
				break;
			case "2":
				selData = indentDao.selIndentForAdmin(coId, indId);
				break;
			default:
				log.error("查询订单错误,错误的用户权限");
				break;
			}
		} catch (SQLException e) {
			log.error("查询订单异常,数据库异常." + e.getMessage());
		}
		return selData;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Result<Object> uptIndent(String indType, String indId, String coId) {
		int upNum = 0;
		boolean isInsBar = true;
		try {
			// 之前确认 订单是否存在
			// 检查 订单状态是否是已完成
			String upIndType = indentDao.selIndentType(indId, coId);
			if (StrUtil.isBlank(upIndType)) {
				return rtnFailResult("更新订单状态失败,订单不存在");
			} else if (!"审核中".equals(upIndType)) {
				return rtnFailResult("更新订单状态失败,订单状态不正确");
			}
			switch (indType) {
			case "enterInd":
				upNum = indentDao.uptIndentType(indId, "已完成");
				// 调用合同服务层生成合同；
				Result<Object> barResult = bargainService.insBargain(indId, coId);
				if (barResult.getStatus() != 0)
					isInsBar = false;
				break;
			case "cancelInd":
				upNum = indentDao.uptIndentType(indId, "已取消");
				break;
			default:
				return rtnFailResult("更新订单状态失败,未知的状态标识");
			}
		} catch (SQLException e) {
			log.error("订单状态更新异常,异常原因：" + e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回手动滚
			return rtnFailResult("订单状态更新异常");
		}
		if (upNum > 0 && isInsBar) {
			return rtnSuccessResult("订单更新成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回手动滚
			return rtnFailResult("订单更新失败,数据库操作失败");
		}
	}

	@Override
	public Result<Object> delIndent(String indId, String coId) {
		try {
			// 首先判断是否存在
			String delIndType = indentDao.selIndentType(indId, coId);
			if (StrUtil.isBlank(delIndType)) {
				return rtnFailResult("订单删除失败,找不到相关订单");
			} else {
				if ("审核中".equals(delIndType))
					return indentDao.delIndent(indId, coId) > 0 ? rtnSuccessResult("订单删除成功") : rtnFailResult("订单删除失败");
				return rtnFailResult("订单删除失败,订单状态不正确");
			}
		} catch (SQLException e) {
			log.error("订单删除异常,异常原因:" + e.getMessage());
			return rtnFailResult("订单删除异常");
		}
	}

	@Override
	public Result<Object> insIndent(Indent insObj) {
		if (null == insObj) {
			return rtnFailResult("订单添加失败，参数异常");
		}
		synchronized (this) {
			try {
				// I+yyyyMMdd+5位自增
				String maxId = indentDao.maxIndentId();
				int addMaxId = 0;
				if (StrUtil.isBlank(maxId)) {
					addMaxId = 0;
				} else {
					addMaxId = StrUtil.cutStringRightRtnInteger(maxId, 5, true);
				}
				String indId = Constant.INDENTTAG + DateUtil.curDateYMDForservice() + StrUtil.strAddLeftZero(
						(++addMaxId) + "", 5);

				// 添加订单编号
				insObj.setIndId(indId);
				// 添加时间
				insObj.setIndDate(DateUtil.curDateByStr());
				// 订单状态
				insObj.setIndType(Constant.TYPE[0]);
				if (indentDao.insIndent(insObj) > 0) {
					return rtnSuccessResult();
				} else {
					return rtnFailResult("订单添加失败");
				}
			} catch (SQLException e) {
				log.error("订单添加异常");
				return rtnFailResult("订单添加异常,异常原因:" + e.getMessage());
			}
		}
	}

	@Override
	public int selIndentCountByEmpInfo(String empInfo, String empPer) throws Exception {
		return indentDao.selIndentCountByEmpInfo(empInfo, empPer);
	}
}
