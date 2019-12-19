package com.service;

import java.util.List;

import com.entity.Aleave;

public interface AleaveService {
	
	void save(Aleave aleave);
	
	void update(Aleave aleave);
	
	void delete(Aleave aleave);
	
	List<Aleave> Findall();
	
	Aleave Findbyid(Integer aleaveid);

}
