/**
 * 
 */
package com.jhhy.road.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhhy.road.dao.UserDao;
import com.jhhy.road.model.ZkqException;
import com.jhhy.road.service.UserService;

/**
 * @author KQ
 *
 *         2017年4月6日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	// 登陆
	@Override
	public void login(String userNumber, String userPwd) {
		int state = userDao.queryUser(userNumber);
		if (state == 0) {
			throw new ZkqException("用户不存在");
		} else {
			String password = userDao.findPwd(userNumber);
			if (password.equals(userPwd)) {

			} else {
				throw new ZkqException("密码不正确");
			}
		}
	}
}
