package com.dao;

import java.util.List;

import com.entity.Employee;
import com.entity.Salary;

public interface SalaryDao {

	

	int findCount();

	List<Salary> findByPage(int begin, int pageSize);

	void save(Salary salary);

	void update(Salary salary);

	Salary findById(Integer eid);

	void delete(Salary salary);
	
}
