package com.service;

import java.util.List;

import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);
	
	List<Employee> search (Employee employee);

	void save(Employee employee);

	void update(Employee employee);

	Employee findById(Integer eid);

	void delete(Employee employee);

}
