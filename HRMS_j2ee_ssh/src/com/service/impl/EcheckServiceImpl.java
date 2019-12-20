package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Echeck;

import com.entity.PageBean;
import com.dao.EcheckDao;

import com.service.EcheckService;




@Transactional

public class EcheckServiceImpl implements EcheckService {
    private EcheckDao echeckDao;
   
	public void setEcheckDao(EcheckDao EcheckDao) {
		this.echeckDao = EcheckDao;
	}

	@Override
	public void save(Echeck echeck) {
		// TODO Auto-generated method stub
		echeckDao.save(echeck);
	}

	@Override
	public void update(Echeck echeck) {
		// TODO Auto-generated method stub
		echeckDao.update(echeck);
	}

	@Override
	public void delete(Echeck echeck) {
		// TODO Auto-generated method stub
		echeckDao.delete(echeck);
	}

	@Override
	public List<Echeck> Findall() {
		// TODO Auto-generated method stub
		return echeckDao.Findall();
	}

	@Override
	public Echeck Findbyid(Integer echeckid) {
		// TODO Auto-generated method stub
		return echeckDao.Findbyid(echeckid);
	}

	@Override
	public PageBean<Echeck> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		  PageBean<Echeck> pageBean = new PageBean<Echeck>();
	        // 封装当前页数
	        pageBean.setCurrPage(currPage);
	        // 封装每页记录数
	        int pageSize = 5;
	        pageBean.setPageSize(pageSize);
	        // 封装总记录数
	        int totalCount = echeckDao.findCount();
	        pageBean.setTotalCount(totalCount);
	        // 封装页数
	        int totalPage;
	        if(totalCount%pageSize==0){
	        	totalPage = totalCount/pageSize;
	        }else{
	        	totalPage = totalCount/pageSize + 1; 
	        }
	        pageBean.setTotalPage(totalPage);
	        // 封装当前页记录
	        int begin= (currPage - 1)*pageSize;
	        List<Echeck> list = echeckDao.findByPage(begin, pageSize);
	        pageBean.setList(list);	 
			return pageBean;
	}

	
}









