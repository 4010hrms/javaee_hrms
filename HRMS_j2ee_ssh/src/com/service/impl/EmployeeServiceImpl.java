package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.entity.PageBean;
import com.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee eEmployee = employeeDao.findByUsernameAndPassword(employee);
		return eEmployee;
	}


	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);

		int totalPage;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize + 1; 
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin= (currPage - 1)*pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);

	}

	
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}

	
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);		
	}

	
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}

	@Override
	public List<Employee> search(Employee employee) {

		return employeeDao.search(employee);
	}
}
