package com.jhhy.road.dao;

public interface UserDao {
	int queryUser(String userNumber);// 判断是否有这个用户

	String findPwd(String userNumber);// 登陆
}
