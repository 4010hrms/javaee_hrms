package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AleaveDao;
import com.entity.Aleave;
import com.entity.Employee;


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

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Aleave";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Aleave> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Aleave.class);
		List<Aleave> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public List<Aleave> search(Aleave aleave) {
		// TODO Auto-generated method stub
		List<Aleave> list = this.getHibernateTemplate().find("from Aleave b where b.aleaveid like'%"+aleave.getAleaveid()+"%'");
		System.out.println("eid----》"+aleave.getEid());
		System.out.println("模糊查询假条"+list.toString());

		return list;
	}

}
