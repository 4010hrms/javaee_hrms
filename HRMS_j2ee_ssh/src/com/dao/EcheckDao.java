package com.dao;

import java.util.List;


import com.entity.Echeck;

public interface EcheckDao {

	int findCount();
	
	List<Echeck> findByPage(int begin,int pageSize);
	
	void save(Echeck echeck);
	
	void update(Echeck echeck);
	
	void delete(Echeck echeck);
	
	List<Echeck> Findall();
	
	Echeck Findbyid(Integer echeckid);
}
