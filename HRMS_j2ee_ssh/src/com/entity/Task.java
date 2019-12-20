package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Task implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String tno;
	private String tname;
	private String taskname;
	private String tcontent;
	
	//员工集合
	private Set<Employee> employees = new HashSet<Employee>();

	// Constructors

	/** default constructor */
	public Task() {
	}
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", tno=" + tno + ", tname=" + tname + ", taskname=" + taskname + ", tcontent=" + tcontent + ", employees=" + employees
				+ "]";
	}
	/** full constructor */
	public Task(String tno, String tname,String taskname, String tcontent,Set employees) {
		this.tno = tno;
		this.tname = tname;
		this.taskname = taskname;
		this.tcontent = tcontent;
		this.employees = employees;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return this.tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String getTaskname() {
		return this.taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	public String getTcontent() {
		return this.tcontent;
	}	
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	
	public Set getEmployees() {
		return this.employees;
	}
	public void setEmployees(Set employees) {
		this.employees = employees;
	}

	

}
