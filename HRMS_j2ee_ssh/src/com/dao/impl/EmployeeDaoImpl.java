package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.entity.Department;
import com.entity.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {


	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username=? and password=?";
		List<Employee> employeeList = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(employeeList.size()>0){
			System.out.println(employeeList.get(0).getEname()+"成功登录");
			return employeeList.get(0);
		}
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee em =this.getHibernateTemplate().get(Employee.class, eid);
		System.out.println("查找到数据"+em);
		return em;
	}
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("name: "+employee.getEname());
		System.out.println("sex: "+employee.getSex());
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}

	@Override
	public List<Employee> search(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("EmployeeDao:"+employee.getEname());
		List<Employee> list = this.getHibernateTemplate().find("from Employee b where b.ename like'%"+employee.getEname()+"%'");
		System.out.println("111111"+list.toString());

		return list;
	}
}
