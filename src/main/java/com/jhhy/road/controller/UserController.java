/**
 * 
 */
package com.jhhy.road.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jhhy.road.model.ApiResponse;
import com.jhhy.road.service.UserService;
import com.jhhy.road.util.MD5Utils;
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
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse login(String userNumber, String userPwd,@RequestParam("files") MultipartFile file,HttpServletRequest request) {
//		  userPwd = MD5Utils.MD5(userPwd);
//		  System.out.println(userPwd+"  MD5");
//		 String encodeToUrlSafeString = Base64Utils.encodeToUrlSafeString(userPwd.getBytes());
//		 System.out.println(encodeToUrlSafeString+"  Base64After");
//		 byte[] a=Base64Utils.decode(encodeToUrlSafeString.getBytes());
//		 System.out.println(new String(a));
		System.out.println(userNumber+"  111");
		System.out.println(userPwd+"  123");
		if (userNumber == null || userPwd == null) {	
			return new ApiResponse(false, "信息不规范", null);
		} else {
			try {
			    String path = request.getSession().getServletContext().getRealPath("upload");  
		        String fileName = file.getOriginalFilename(); 
		        System.out.println(fileName);
		        File dir = new File(path,fileName);          
		        if(!dir.exists()){  
		            dir.mkdirs();  
		        }  
		        //MultipartFile自带的解析方法  
		        file.transferTo(dir); 
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
