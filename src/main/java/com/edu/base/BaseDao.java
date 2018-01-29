package com.edu.base;

public interface BaseDao {

	public <T> T select(Object... params);

	public int update(Object... params);

	public int delete(Object... params);

	public int insert(Object... params);
}
