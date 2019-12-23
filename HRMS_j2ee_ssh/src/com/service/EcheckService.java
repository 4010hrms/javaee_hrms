package com.service;

import java.util.List;


import com.entity.Echeck;
import com.entity.PageBean;


public interface EcheckService {
	
	PageBean<Echeck> findByPage(Integer currPage);
	
	void save(Echeck echeck);
	
	void update(Echeck echeck);
	
	void delete(Echeck echeck);
	
	List<Echeck> Findall();
	
	Echeck Findbyid(Integer echeckid);
	
	List<Echeck> search(Echeck echeck);


}
