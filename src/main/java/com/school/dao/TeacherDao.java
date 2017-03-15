/**
 * 
 */
package com.school.dao;

import org.springframework.stereotype.Component;

import com.school.model.Teacher;

/**
 * @author KQ
 *
 */
@Component
public interface TeacherDao {
	 void saveTeacher(Teacher teacher) ;//教师注册
	 
	 int findTeacher(String tName);//略去同用户名的注册
	 
	 String findTeacherPwd(String tName);//登陆
}
