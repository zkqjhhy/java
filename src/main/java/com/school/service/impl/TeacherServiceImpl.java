/**
 * 
 */
package com.school.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.TeacherDao;
import com.school.model.Teacher;
import com.school.service.TeacherService;

/**
 * @author KQ
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void register(Teacher t) {

		int num = teacherDao.findTeacher(t.gettName());
		if (num == 0) {
			t.setCreateTime(new Date());
			teacherDao.saveTeacher(t);

		} else {
			throw new RuntimeException("用户已注册");
		}

	}
	@Override
	public void login(String tName,String password) {

		int state = teacherDao.findTeacher(tName);
		if (state == 0) {
			throw new RuntimeException("用户名不存在");

		} else {
		  String firstPwd=teacherDao.findTeacherPwd(tName);
        	if(firstPwd.equals(password)){ 		
        	}else{
        		throw new RuntimeException("密码不正确");
        	}
			
		}

	}

}
