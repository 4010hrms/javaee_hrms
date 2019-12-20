package com.action;

import java.util.List;


import com.entity.Echeck;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.EcheckService;

public class EcheckAction extends ActionSupport implements ModelDriven<Echeck> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Echeck echeck = new Echeck();
	
	private EcheckService echeckService;
	
	@Override
	public Echeck getModel() {
		return echeck;
	}
	
	public void setEcheckService(EcheckService echeckService) {
		this.echeckService = echeckService;
	}
	
	public String findAll(){
		
		List<Echeck> list = echeckService.Findall();
		
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAll";
	}
	
	public String goAddEcheck(){
		return "goAddEcheck";
	}
	
	public String saveecheck(){
	
		

		echeckService.save(echeck);
		return "addSuccess";
	}
	
	public String findByid(){
		echeck = echeckService.Findbyid(echeck.getEcheckid());
		return "goEditEcheck";
	}
	
	public String edit(){
		
		
		echeckService.update(echeck);
		return "editSuccess";
	}
	public String delete(){
		echeck = echeckService.Findbyid(echeck.getEcheckid());
		echeckService.delete(echeck);
		return "deleteSuccess";
	}

}
