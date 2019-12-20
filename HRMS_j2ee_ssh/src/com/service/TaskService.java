package com.service;

import java.util.List;

import com.entity.Task;
import com.entity.PageBean;

public interface TaskService {
	
	PageBean<Task> findByPage(Integer currPage);

	void save(Task task);

	void update(Task task);

	Task findById(Integer tid);

	void delete(Task task);

	List<Task> findAll();

	List<Task> search(Task task);
}
