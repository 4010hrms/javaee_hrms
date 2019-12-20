package com.entity;

import java.util.Date;

public class Echeck implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private  Integer echeckid;
	private  Integer eid;
	private  Date btime;
	private  Date etime;
	private  String state;
	
	
	

	@Override
	public String toString() {
		return "Echeck [echeckid=" + echeckid + ", eid=" + eid + ", btime=" + btime + ", etime=" + etime + ", state="
				+ state + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getEcheckid() {
		return echeckid;
	}
	public Integer getEid() {
		return eid;
	}
	public Date getBtime() {
		return btime;
	}
	public Date getEtime() {
		return etime;
	}
	public String getState() {
		return state;
	}
	public void setEcheckid(Integer echeckid) {
		this.echeckid = echeckid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public void setBtime(Date btime) {
		this.btime = btime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public void setState(String state) {
		this.state = state;
	}


	
}
