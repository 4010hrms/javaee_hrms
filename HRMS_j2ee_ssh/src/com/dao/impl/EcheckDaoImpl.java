package com.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.dao.EcheckDao;
import com.entity.Aleave;
import com.entity.Echeck;


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

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Echeck";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Echeck> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Echeck.class);
		List<Echeck> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public List<Echeck> search(Echeck echeck) {
		// TODO Auto-generated method stub
		List<Echeck> list = this.getHibernateTemplate().find("from Echeck b where b.echeckid like'%"+echeck.getEcheckid()+"%'");
		
		System.out.println("模糊查询假条"+list.toString());
		
		return list;
	}


}
