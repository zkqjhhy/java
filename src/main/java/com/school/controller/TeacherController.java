/**
 * 
 */
package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.model.ApiResponse;
import com.school.model.Teacher;
import com.school.service.TeacherService;

/**
 * @author KQ
 *
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
//	private static Log logger = (Log) LogFactory.getLog(TeacherController.class);
// 注册
	@Autowired
	private TeacherService teacherService;
	@RequestMapping("register")
	@ResponseBody
	public ApiResponse register(Teacher t) {
		ApiResponse response = new ApiResponse();
		try {
			teacherService.register(t);
			response.setCode(0);
			response.setMessage("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(1);
			response.setMessage("注册失败" + e.getMessage());
		}
		return response;

	}
	
//	登陆
	@RequestMapping("login")
	@ResponseBody
	public ApiResponse login(String tName,String password){

		ApiResponse response = new ApiResponse();
		try {
			teacherService.login(tName,password);
			response.setCode(0);
			response.setMessage("登陆成功");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(1);
			response.setMessage("登陆失败        " + e.getMessage());
		}
		return response;
	}
}
