package com.entity;

import java.util.Date;

public class Aleave implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer aleaveid;
	private Integer eid;
	private  Date ktime;
	private  Date jtime;
	private  String reason;
	@Override
	public String toString() {
		return "Aleave [aleaveid=" + aleaveid + ", eid=" + eid + ", ktime=" + ktime + ", jtime=" + jtime + ", reason="
				+ reason + "]";
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getAleaveid() {
		return aleaveid;
	}
	public Integer getEid() {
		return eid;
	}
	public Date getKtime() {
		return ktime;
	}
	public Date getJtime() {
		return jtime;
	}
	public String getReason() {
		return reason;
	}
	public void setAleaveid(Integer aleaveid) {
		this.aleaveid = aleaveid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public void setKtime(Date ktime) {
		this.ktime = ktime;
	}
	public void setJtime(Date jtime) {
		this.jtime = jtime;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
