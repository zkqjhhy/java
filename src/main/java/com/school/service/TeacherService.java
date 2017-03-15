/**
 * 
 */
package com.school.service;

import org.springframework.stereotype.Service;

import com.school.model.Teacher;

/**
 * @author KQ
 *
 */
@Service
public interface TeacherService {
	public void register(Teacher t);
	
	public void login(String tName,String password);
	
}
