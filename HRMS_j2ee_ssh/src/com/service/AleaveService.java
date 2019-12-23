package com.service;

import java.util.List;

import com.entity.Aleave;
import com.entity.PageBean;

public interface AleaveService {
	
	PageBean<Aleave> findByPage(Integer currPage);
	
	void save(Aleave aleave);
	
	void update(Aleave aleave);
	
	void delete(Aleave aleave);
	
	List<Aleave> Findall();
	
	Aleave Findbyid(Integer aleaveid);
	
	List<Aleave> search(Aleave aleave);

}
