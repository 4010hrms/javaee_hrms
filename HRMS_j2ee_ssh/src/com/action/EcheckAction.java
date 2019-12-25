package com.action;

import java.util.List;


import com.entity.Echeck;
import com.entity.Employee;
import com.entity.PageBean;
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
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public Echeck getEcheck() {
		return echeck;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public EcheckService getEcheckService() {
		return echeckService;
	}

	public void setEcheck(Echeck echeck) {
		this.echeck = echeck;
	}

	private EcheckService echeckService;
	
	@Override
	public Echeck getModel() {
		return echeck;
	}
	
	public void setEcheckService(EcheckService echeckService) {
		this.echeckService = echeckService;
	}
	
	public String findAll(){
		PageBean<Echeck> pageBean=echeckService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
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
	public String search(){
		if(echeck.getEcheckid()==null) {
			this.addActionError("请输入查询编号！");
			return "findAll";
		}
		List<Echeck> resultlist=echeckService.search(echeck);
		ActionContext.getContext().getSession().put("resultlist", resultlist);
		System.out.println("resultlist----->"+resultlist.toString());
		return "result";
	}
	
	public String personecheck() {
		Employee person =  (Employee) ActionContext.getContext().getSession().get("existEmployee");
		int id=person.getEid();
		List<Echeck> list=echeckService.Findall();
		for(int i=0;i<list.size();i++) {
			Echeck temp=list.get(i);
			System.out.println("temp的i："+temp.getEid());
			if(temp.getEid()!=id) {
				list.remove(temp);
				i--;
			}
			ActionContext.getContext().getSession().put("personlist", list);
		}
		return "personecheck";
		
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
