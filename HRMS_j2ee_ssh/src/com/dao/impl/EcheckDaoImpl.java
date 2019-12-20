package com.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.dao.EcheckDao;
import com.entity.Echeck;
import com.entity.Employee;

public class EcheckDaoImpl extends HibernateDaoSupport implements EcheckDao {

	@Override
	public void save(Echeck echeck) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(echeck);
	}

	@Override
	public void update(Echeck echeck) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(echeck);
	}

	@Override
	public void delete(Echeck echeck) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(echeck);
	}

	@Override
	public List<Echeck> Findall() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Echeck");
	}

	@Override
	public Echeck Findbyid(Integer echeckid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Echeck.class, echeckid);
	}


}
