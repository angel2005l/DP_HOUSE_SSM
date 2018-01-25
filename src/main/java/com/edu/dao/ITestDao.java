package com.edu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.entity.Test;

@Repository
public interface ITestDao {
	public List<Test> selInfoByCol(String userName);
}
