package com.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SalaryDao;
import com.entity.PageBean;
import com.entity.Salary;
import com.service.SalaryService;
@Transactional
public class SalaryServiceImpl implements SalaryService {
    private SalaryDao salaryDao;
   
	public void setsalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}

	
	
	@Override
	public PageBean<Salary> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		  PageBean<Salary> pageBean = new PageBean<Salary>();
	     
	        pageBean.setCurrPage(currPage);
	        int pageSize = 5;
	        pageBean.setPageSize(pageSize);
	     
	        int totalCount = salaryDao.findCount();
	        pageBean.setTotalCount(totalCount);
	      
	        int totalPage;
	        if(totalCount%pageSize==0){
	        	totalPage = totalCount/pageSize;
	        }else{
	        	totalPage = totalCount/pageSize + 1; 
	        }
	        pageBean.setTotalPage(totalPage);
	        int begin= (currPage - 1)*pageSize;
	        List<Salary> list = salaryDao.findByPage(begin, pageSize);
	        pageBean.setList(list);
			return pageBean;
	}

	@Override
	
	public void save(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.save(salary);
		
	}

	@Override
	
	public Salary findById(Integer eid) {
		// TODO Auto-generated method stub
		return salaryDao.findById(eid);
	}
	
	@Override
	public void update(Salary salary ) {
		// TODO Auto-generated method stub
		salaryDao.update(salary);		
	}

	@Override
	public void delete(Salary salary ) {
		// TODO Auto-generated method stub
		salaryDao.delete(salary);
	}



}
