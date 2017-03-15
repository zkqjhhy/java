/**
 * 
 */
package com.school.model;

import java.util.Date;

/**
 * @author KQ
 *
 */
public class Teacher {
		  private int id;        //主键
		  private int gender;//性别
		  private int tState;//状态
		  private String tName; //账号
		  private String tEmail;  //邮箱
		  private String password  ;//密码
		  private String  tPhone;   //手机
		  private Date createTime;   //注册时间
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getGender() {
			return gender;
		}
		public void setGender(int gender) {
			this.gender = gender;
		}
		public int gettState() {
			return tState;
		}
		public void settState(int tState) {
			this.tState = tState;
		}
		public String gettName() {
			return tName;
		}
		public void settName(String tName) {
			this.tName = tName;
		}
		public String gettEmail() {
			return tEmail;
		}
		public void settEmail(String tEmail) {
			this.tEmail = tEmail;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String gettPhone() {
			return tPhone;
		}
		public void settPhone(String tPhone) {
			this.tPhone = tPhone;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
//		public Teacher(int id, int gender, int tState, String tName, String tEmail, String password, String tPhone,
//				Date createTime) {
//			super();
//			this.id = id;
//			this.gender = gender;
//			this.tState = tState;
//			this.tName = tName;
//			this.tEmail = tEmail;
//			this.password = password;
//			this.tPhone = tPhone;
//			this.createTime = createTime;
//		}
//		public Teacher() {
//		}
}
