package com.action;

import java.util.List;

import com.entity.Aleave;

import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AleaveService;

public class AleaveAction extends ActionSupport implements ModelDriven<Aleave> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Aleave aleave=new Aleave();
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	private AleaveService aleaveService;
	
	

	public AleaveService getAleaveService() {
		return aleaveService;
	}

	public void setAleaveService(AleaveService aleaveService) {
		this.aleaveService = aleaveService;
	}

	@Override
	public Aleave getModel() {
		// TODO Auto-generated method stub
		return aleave;
	}

	public String findAll(){
		
		PageBean<Aleave> pageBean=aleaveService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	
	}
	
	public String goAddAleave(){
		return "goAddAleave";
	}
	
	public String savealeave(){
	
		

		aleaveService.save(aleave);
		return "addSuccess";
	}
	
	public String findByid(){
		aleave = aleaveService.Findbyid(aleave.getAleaveid());
		return "goEditAleave";
	}
	
	public String edit(){
		
		aleaveService.update(aleave);
		return "editSuccess";
	}
	public String delete(){
		aleave = aleaveService.Findbyid(aleave.getAleaveid());
		aleaveService.delete(aleave);
		return "deleteSuccess";
	}

	
	
	
	
	
}
