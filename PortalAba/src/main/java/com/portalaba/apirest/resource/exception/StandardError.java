package com.portalaba.apirest.resource.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer staus;
	
	private String msg;
	
	private long timeSystem;

	public StandardError(Integer staus, String msg, long timeSystem) {
		super();
		this.staus = staus;
		this.msg = msg;
		this.timeSystem = timeSystem;
	}

	public Integer getStaus() {
		return staus;
	}

	public void setStaus(Integer staus) {
		this.staus = staus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimeSystem() {
		return timeSystem;
	}

	public void setTimeSystem(long timeSystem) {
		this.timeSystem = timeSystem;
	}
}
