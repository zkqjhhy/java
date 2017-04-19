/**
 * 
 */
package com.jhhy.road.model;

/**
 * @author zkq
 *
 */
public class ApiResponse {
	private boolean success;// 操作成功是否
	private String msg;// 错误成功信息
	private Object object;// 返回值

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public ApiResponse(boolean success, String msg, Object object) {
		this.success = success;
		this.msg = msg;
		this.object = object;
	}

	public ApiResponse() {
	}
}
