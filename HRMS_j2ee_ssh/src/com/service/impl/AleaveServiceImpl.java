package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.AleaveDao;
import com.entity.Aleave;
import com.entity.Echeck;
import com.entity.PageBean;
import com.service.AleaveService;

@Transactional
public class AleaveServiceImpl implements AleaveService {
	private AleaveDao aleaveDao;
	
	public void setAleaveDao(AleaveDao AleaveDao) {
		this.aleaveDao=AleaveDao;
	}

	@Override
	public void save(Aleave aleave) {
		// TODO Auto-generated method stub
		aleaveDao.save(aleave);
		
	}

	@Override
	public void update(Aleave aleave) {
		// TODO Auto-generated method stub
		aleaveDao.update(aleave);
		
	}

	@Override
	public void delete(Aleave aleave) {
		// TODO Auto-generated method stub
		aleaveDao.delete(aleave);
	}

	@Override
	public List<Aleave> Findall() {
		// TODO Auto-generated method stub
		return aleaveDao.Findall();
	}

	@Override
	public Aleave Findbyid(Integer aleaveid) {
		// TODO Auto-generated method stub
		return aleaveDao.Findbyid(aleaveid);
	}

	@Override
	public PageBean<Aleave> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		 PageBean<Aleave> pageBean = new PageBean<Aleave>();
	        // 封装当前页数
	        pageBean.setCurrPage(currPage);
	        // 封装每页记录数
	        int pageSize = 5;
	        pageBean.setPageSize(pageSize);
	        // 封装总记录数
	        int totalCount = aleaveDao.findCount();
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
	        List<Aleave> list = aleaveDao.findByPage(begin, pageSize);
	        pageBean.setList(list);	      
			return pageBean;
	}

}
