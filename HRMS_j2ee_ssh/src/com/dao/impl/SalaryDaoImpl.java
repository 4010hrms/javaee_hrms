package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.SalaryDao;
import com.entity.Employee;
import com.entity.Salary;

public class SalaryDaoImpl extends HibernateDaoSupport implements SalaryDao{

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Salary";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;

	}

	@Override
	public List<Salary> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Salary.class);
		List<Salary> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public void save(Salary salary) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(salary);
	}

	@Override
	public void update(Salary salary) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(salary);
	}

	@Override
	public Salary findById(Integer eid) {
		// TODO Auto-generated method stub
		Salary em =this.getHibernateTemplate().get(Salary.class, eid);
		System.out.println("查找到数据"+em.getEname());
		return em;
	}

	@Override
	public void delete(Salary salary) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(salary);
	}

}
