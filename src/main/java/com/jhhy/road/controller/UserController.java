/**
 * 
 */
package com.jhhy.road.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhhy.road.model.ApiResponse;
import com.jhhy.road.service.UserService;
import com.jhhy.road.model.ZkqException;

/**
 * @author KQ
 *
 *         2017年4月6日
 */
@Controller
// @RequestMapping("user")
public class UserController {
	private static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse login(String userNumber, String userPwd) {
		if (userNumber == null || userPwd == null) {
			return new ApiResponse(false, "信息不规范", null);
		} else {
			try {
				userService.login(userNumber, userPwd);
				return new ApiResponse(true, "登陆成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				if (e instanceof ZkqException) {
					return new ApiResponse(false, e.getMessage(), null);
				} else {
					return new ApiResponse(false, "登陆失败，系统错误", null);
				}
			}

		}
	};

}
