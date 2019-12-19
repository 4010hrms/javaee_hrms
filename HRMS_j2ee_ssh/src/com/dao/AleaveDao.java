package com.dao;

import java.util.List;

import com.entity.Aleave;

public interface AleaveDao {
	
	void save(Aleave aleave);
	
	void update(Aleave aleave);
	
	void delete(Aleave aleave);
	
	List<Aleave> Findall();
	
	Aleave Findbyid(Integer aleaveid);
	

}
