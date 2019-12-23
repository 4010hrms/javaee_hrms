package com.dao;

import java.util.List;

import com.entity.Aleave;


public interface AleaveDao {
	
	int findCount();
	
	List<Aleave> findByPage(int begin,int pageSize);
	
	void save(Aleave aleave);
	
	void update(Aleave aleave);
	
	void delete(Aleave aleave);
	
	List<Aleave> Findall();
	
	Aleave Findbyid(Integer aleaveid);
	
	List<Aleave> search(Aleave aleave);
	

}
