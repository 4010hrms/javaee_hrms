package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskDao;
import com.entity.Task;
import com.entity.PageBean;
import com.service.TaskService;
/**
 * 锟斤拷锟脚癸拷锟斤拷锟揭碉拷锟斤拷实锟斤拷锟斤拷
 * @author hope
 */

@Transactional
public class TaskServiceImpl implements TaskService {

	private TaskDao taskDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}


	public PageBean<Task> findByPage(Integer currPage) {
		PageBean<Task> pageBean = new PageBean<Task>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = taskDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage;
		if(totalCount%pageSize == 0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1; 
		}
		pageBean.setTotalPage(totalPage);
		int begin= (currPage - 1)*pageSize;
		List<Task> list = taskDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	public void save(Task task) {
		// TODO Auto-generated method stub
		taskDao.save(task);
	}

	
	public Task findById(Integer tid) {
		// TODO Auto-generated method stub
		return taskDao.findById(tid);
	}

	
	public void update(Task task) {
		// TODO Auto-generated method stub
		taskDao.update(task);
	}

	
	public void delete(Task task) {
		// TODO Auto-generated method stub
		taskDao.delete(task);
	}

	
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskDao.findAll();
	}

	public List<Task> search(Task task) {
		return taskDao.search(task);
	}
}
