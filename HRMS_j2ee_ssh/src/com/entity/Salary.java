package com.entity;

public class Salary {
	private Integer eid;
	private String  ename;
	private String  esex;
	private int     eage;
	private double esalary;
	private int eno;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public Salary() {
		
	}
	
	public Salary(Integer eid, String ename, String esex, int eage, double esalary, int eno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esex = esex;
		this.eage = eage;
		this.esalary = esalary;
		this.eno = eno;
	}
	public Salary(Integer eid, String ename, String esex, int eage, double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esex = esex;
		this.eage = eage;
		this.esalary = esalary;
	}

	
	@Override
	public String toString() {
		return "Salary [eid=" + eid + ", ename=" + ename + ", esex=" + esex + ", eage=" + eage + ", esalary=" + esalary
				+ "]";
	}
	public Salary(double esalary) {
		super();
		this.esalary = esalary;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	
}
