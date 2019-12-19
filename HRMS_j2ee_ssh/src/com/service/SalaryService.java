package com.service;

import com.entity.PageBean;
import com.entity.Salary;

public interface SalaryService {

	PageBean<Salary> findByPage(Integer currPage);

	void save(Salary salary);

	void update(Salary salary);

	Salary findById(Integer eid);

	void delete(Salary salary);

}
