package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AleaveDao;
import com.entity.Aleave;

public class AleaveDaoImpl extends HibernateDaoSupport implements AleaveDao {

	@Override
	public void save(Aleave aleave) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(aleave);
	}

	@Override
	public void update(Aleave aleave) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(aleave);
		
	}

	@Override
	public void delete(Aleave aleave) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(aleave);
		
	}

	@Override
	public List<Aleave> Findall() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Aleave");
	}

	@Override
	public Aleave Findbyid(Integer aleaveid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Aleave.class, aleaveid);
	}

}
