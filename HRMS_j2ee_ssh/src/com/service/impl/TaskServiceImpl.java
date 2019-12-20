package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.TaskDao;
import com.entity.Task;
import com.entity.Department;
import com.entity.PageBean;
import com.service.TaskService;
/**
 * 锟斤拷锟脚癸拷锟斤拷锟揭碉拷锟斤拷实锟斤拷锟斤拷
 * @author hope
 */

@Transactional
public class TaskServiceImpl implements TaskService {
	// 注锟斤拷serviceDao
    private TaskDao taskDao;

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	/**
	 * 锟斤拷页锟斤拷询锟斤拷锟脚的凤拷锟斤拷
	 */
	public PageBean<Task> findByPage(Integer currPage) {
        PageBean<Task> pageBean = new PageBean<Task>();
        // 锟斤拷装锟斤拷前页锟斤拷
        pageBean.setCurrPage(currPage);
        // 锟斤拷装每页锟斤拷录锟斤拷
        int pageSize = 5;
        pageBean.setPageSize(pageSize);
        // 锟斤拷装锟杰硷拷录锟斤拷
        int totalCount = taskDao.findCount();
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
        List<Task> list = taskDao.findByPage(begin, pageSize);
        pageBean.setList(list);
		return pageBean;
	}

	@Override
	/**
	 * 锟斤拷硬锟斤拷诺锟揭碉拷锟斤拷实锟斤拷
	 */
	public void save(Task task) {
		// TODO Auto-generated method stub
		taskDao.save(task);
	}

	@Override
	/**
	 * 锟斤拷锟斤拷id锟斤拷询锟斤拷锟脚碉拷业锟斤拷锟绞碉拷锟�
	 */
	public Task findById(Integer tid) {
		// TODO Auto-generated method stub
		return taskDao.findById(tid);
	}
	
	@Override
	/**
	 * 锟斤拷锟铰诧拷锟脚碉拷业锟斤拷锟绞碉拷锟�
	 */
	public void update(Task task) {
		// TODO Auto-generated method stub
		taskDao.update(task);
	}

	@Override
	/**
	 * 删锟斤拷锟斤拷锟脚碉拷业锟斤拷锟绞碉拷锟�
	 */
	public void delete(Task task) {
		// TODO Auto-generated method stub
		taskDao.delete(task);
	}

	@Override
	/**
	 * 业锟斤拷锟斤拷询锟斤拷锟叫诧拷锟斤拷
	 */
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskDao.findAll();
	}
	
	public List<Task> search(Task task) {
		return taskDao.search(task);
	}
}
