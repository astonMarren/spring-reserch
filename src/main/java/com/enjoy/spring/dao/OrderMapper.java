package com.enjoy.spring.dao;

import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {

	@Insert("insert into order")
	public void insert();
}
