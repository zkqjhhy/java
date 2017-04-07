/**
 * 
 */
package com.jhhy.road.model;

import java.util.List;
import java.util.Map;

/**
 * @author zkq
 *
 */
public class ApiResponse {
	private int code;
	private String message;
	private List list;
	private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}



	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public void setAttribute(String string, List<Teacher> teacher) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

}
