package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.TaskDao;
import com.entity.Department;
import com.entity.Task;

public class TaskDaoImpl extends HibernateDaoSupport implements TaskDao {

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Task";
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Task> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Task.class);
		List<Task> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(task);
	}

	@Override
	public Task findById(Integer tid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Task.class, tid);
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(task);
	}

	@Override
	public void delete(Task task) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(task);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Task");
	}
	@Override
	public List<Task> search(Task task){
		// TODO Auto-generated method stub
		System.out.println("TaskDao:"+task.getTname());
		List<Task> list = this.getHibernateTemplate().find("from Task b where b.tname like'%"+task.getTname()+"%'");
		System.out.println("111111"+list.toString());

		return list;
	}
}
