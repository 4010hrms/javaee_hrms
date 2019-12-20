package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.entity.Department;
import com.entity.PageBean;
import com.service.DepartmentService;
/**
 * 锟斤拷锟脚癸拷锟斤拷锟揭碉拷锟斤拷实锟斤拷锟斤拷
 */

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	// 注锟斤拷serviceDao
    private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	/**
	 * 锟斤拷页锟斤拷询锟斤拷锟脚的凤拷锟斤拷
	 */
	public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        // 锟斤拷装锟斤拷前页锟斤拷
        pageBean.setCurrPage(currPage);
        // 锟斤拷装每页锟斤拷录锟斤拷
        int pageSize = 5;
        pageBean.setPageSize(pageSize);
        // 锟斤拷装锟杰硷拷录锟斤拷
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 锟斤拷装页锟斤拷
        int totalPage;
        if(totalCount%pageSize == 0){
        	totalPage = totalCount/pageSize;
        }else{
        	totalPage = totalCount/pageSize+1; 
        }
        pageBean.setTotalPage(totalPage);
        // 锟斤拷装锟斤拷前页锟斤拷录
        int begin= (currPage - 1)*pageSize;
        List<Department> list = departmentDao.findByPage(begin, pageSize);
        pageBean.setList(list);
		return pageBean;
	}

	@Override
	/**
	 * 锟斤拷硬锟斤拷诺锟揭碉拷锟斤拷实锟斤拷
	 */
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	/**
	 * 锟斤拷锟斤拷id锟斤拷询锟斤拷锟脚碉拷业锟斤拷锟绞碉拷锟�
	 */
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}
	
	@Override
	/**
	 * 锟斤拷锟铰诧拷锟脚碉拷业锟斤拷锟绞碉拷锟�
	 */
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	/**
	 * 删锟斤拷锟斤拷锟脚碉拷业锟斤拷锟绞碉拷锟�
	 */
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	@Override
	/**
	 * 业锟斤拷锟斤拷询锟斤拷锟叫诧拷锟斤拷
	 */
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
	public List<Department> search(Department department) {
		return departmentDao.search(department);
	}
	

}
