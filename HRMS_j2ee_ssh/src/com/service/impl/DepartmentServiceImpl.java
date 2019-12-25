package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.entity.Department;
import com.entity.PageBean;
import com.service.DepartmentService;


@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		int totalPage;
		if(totalCount%pageSize == 0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1; 
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin= (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}


	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}


	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}


	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}


	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}


	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

	public List<Department> search(Department department) {
		return departmentDao.search(department);
	}


}
