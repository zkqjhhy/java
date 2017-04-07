/**
 * 
 */
package com.jhhy.road.model;

import java.util.Date;

/**
 * @author KQ
 *
 * 2017年4月7日
 */
public class AdminRequest {
  private String carName,//车段名
  userName,//车段超级管理员
  userNumber,//车段超级管理员账号
  userPwd,//车段超级管理员密码
  userPhone,//车段超级管理员电话
  userBorth,//车段超级管理员生日
  userDepartment,//user部门
  userPosition;//user职位
  
  private int id,//用户id
  cardId, //车段id
  departmentId,//部门id
  positionId,//职位id
  userPower,//用户权限
  sex;//性别
  
  public String getCarName() {
	return carName;
}

public void setCarName(String carName) {
	this.carName = carName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserNumber() {
	return userNumber;
}

public void setUserNumber(String userNumber) {
	this.userNumber = userNumber;
}

public String getUserPwd() {
	return userPwd;
}

public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}

public String getUserPhone() {
	return userPhone;
}

public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}

public String getUserBorth() {
	return userBorth;
}

public void setUserBorth(String userBorth) {
	this.userBorth = userBorth;
}

public String getUserDepartment() {
	return userDepartment;
}

public void setUserDepartment(String userDepartment) {
	this.userDepartment = userDepartment;
}

public String getUserPosition() {
	return userPosition;
}

public void setUserPosition(String userPosition) {
	this.userPosition = userPosition;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getCardId() {
	return cardId;
}

public void setCardId(int cardId) {
	this.cardId = cardId;
}

public int getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}

public int getPositionId() {
	return positionId;
}

public void setPositionId(int positionId) {
	this.positionId = positionId;
}

public int getUserPower() {
	return userPower;
}

public void setUserPower(int userPower) {
	this.userPower = userPower;
}

public int getSex() {
	return sex;
}

public void setSex(int sex) {
	this.sex = sex;
}

public Date getCreatTime() {
	return creatTime;
}

public void setCreatTime(Date creatTime) {
	this.creatTime = creatTime;
}

private Date creatTime;
  
}
