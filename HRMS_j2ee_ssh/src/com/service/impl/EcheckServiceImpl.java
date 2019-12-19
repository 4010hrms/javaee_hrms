package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Echeck;
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

	
}









