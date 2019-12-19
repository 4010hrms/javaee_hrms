package com.service.impl;

import java.util.List;

import com.dao.AleaveDao;
import com.entity.Aleave;
import com.service.AleaveService;

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

}
