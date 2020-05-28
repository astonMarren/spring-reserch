package com.enjoy.spring.dao;

import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

	@Insert("insert into user")
	public void insert();
}
