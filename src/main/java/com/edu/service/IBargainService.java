package com.edu.service;

import com.edu.entity.Bargain;
import com.edu.util.Result;

public interface IBargainService {
	/**
	 * 
	 * @Title: selBargain   
	 * @Description: 合同查询
	 * @param barId
	 * @param coId
	 * @return 
	 * @author: MR.H
	 * @return: List<Bargain>      
	 *
	 */
	public Bargain selBargain(String barId, String coId);

	/**
	 * 
	 * @Title: insBargain   
	 * @Description: 合同添加
	 * @param coId
	 * @return 
	 * @author: MR.H
	 * @return: Result<Object>      
	 *
	 */
	public Result<Object> insBargain(String indId, String coId);
}
