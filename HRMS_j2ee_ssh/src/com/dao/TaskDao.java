package com.dao;

import java.util.List;


import com.entity.Task;

public interface TaskDao {

	int findCount();

	List<Task> findByPage(int begin, int pageSize);

	void save(Task task);

	void update(Task task);

	Task findById(Integer tid);

	void delete(Task task);

	List<Task> findAll();

	List<Task> search(Task task);

}
