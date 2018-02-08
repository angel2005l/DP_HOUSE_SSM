package com.edu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.base.BaseSevice;
import com.edu.base.Constant;
import com.edu.dao.IBargainDao;
import com.edu.dao.ICompanyDao;
import com.edu.dao.IIndentDao;
import com.edu.entity.Bargain;
import com.edu.entity.Indent;
import com.edu.service.IBargainService;
import com.edu.util.DateUtil;
import com.edu.util.Result;
import com.edu.util.StrUtil;

@Service
public class BargainServiceImpl extends BaseSevice implements IBargainService {
	private static final Logger log = LoggerFactory.getLogger(BargainServiceImpl.class);

	@Autowired
	IBargainDao bargainDao;
	@Autowired
	IIndentDao indentDao;
	@Autowired
	ICompanyDao companyDao;

	@Override
	public List<Bargain> selBargain(String barId, String coId) {
		try {
			// List<Bargain> selBarDatas = bargainDao.selBargain(barId, coId);
			return bargainDao.selBargain(barId, coId);
		} catch (SQLException e) {
			log.error("合同查询异常,异常原因:" + e.getMessage());
			return null;
		}
	}

	@Override
	public Result<Object> insBargain(String indId, String coId) {
		synchronized (this) {
			try {
				// 获得当天最大的max
				String maxBarId = bargainDao.maxBarId();
				Indent indent = null;
				// 获得订单信息
				List<Indent> indList = indentDao.selIndentForAdmin(coId, indId);
				if (null == indList || indList.isEmpty() || indList.size() > 1) {
					return rtnFailResult("合同更新失败");
				} else {
					indent = indList.get(0);
				}
				int maxAddId = 0;
				if (StrUtil.isBlank(maxBarId)) {
					maxAddId = 0;
				} else {
					maxAddId = StrUtil.cutStringRightRtnInteger(maxBarId, 5, true);
				}
				Bargain barObj = new Bargain();
				String barId = Constant.BARGAINTAG + DateUtil.curDateYMDForservice() + StrUtil.strAddLeftZero(
						(++maxAddId) + "", 5);
				// 合同编号
				barObj.setBarId(barId);
				// 合同名称
				barObj.setBarName("租房合同【" + StrUtil.cutStringForRight(barId, 1) + "】");
				// 合同时间
				barObj.setBarDate(DateUtil.curDateByStr());
				// 合同内容
				barObj.setBarContext("	日期：" + DateUtil.curDateYMD() + "房屋信息" + "共计：【" + indent.getIndMoney().toString()+"】元");
				// 合同租赁时间
				barObj.setBarEndDate(DateUtil.addDay(indent.getIndDay()));
				// 合同甲方
				barObj.setCoName(companyDao.selCompanyName(coId));
				// 合同乙方
				barObj.setCusName(Constant.CUSNAME[(int) (Math.random() * 3)]);
				// 订单编号
				barObj.setIndId(indId);

				return bargainDao.insBargain(barObj) > 0 ? rtnSuccessResult("合同添加成功") : rtnFailResult("合同生成失败");
			} catch (SQLException e) {
				log.error("合同添加异常,异常原因：" + e.getMessage());
				return rtnFailResult("合同添加异常");
			}
		}
	}
}
