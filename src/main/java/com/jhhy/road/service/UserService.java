/**
 * 
 */
package com.jhhy.road.service;

import org.springframework.stereotype.Service;

/**
 * @author KQ
 *
 *         2017年4月6日
 */
@Service
public interface UserService {
	public void login(String userNumber, String userPwd);
}
