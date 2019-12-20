package com.action;

import java.util.List;

import com.entity.Department;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private Department department = new Department();

	private DepartmentService departmentService;
	@Override
	public Department getModel() {
		return department;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String search(){
		System.out.println(department.toString());
		List<Department> resultlist =  departmentService.search(department);
		ActionContext.getContext().getSession().put("resultlist", resultlist);
		System.out.println(resultlist.toString());
		
		return "result";
	}
	
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		System.out.println(pageBean.toString());
		return "findAll";
	}

	public String goAddDepartment(){
		return "goAddDepartment";
	}


	public String saveDepartment(){
		if (department.getDname().isEmpty()) {
			this.addActionError("部门名称不能为空！");
			return "goAddDepartment";
		}
		if (department.getDdesc().isEmpty()) {
			this.addActionError("部门简介不能为空！");
			return "goAddDepartment";
		}
		departmentService.save(department);
		return "addSuccess";
	}

	public String findById(){
		department = departmentService.findById(department.getDid());
		return "goEditDepartment";
	}

	public String update(){
		if (department.getDname().isEmpty()) {
			this.addActionError("部门名称不能为空！");
			return "goEditDepartment";
		}
		if (department.getDdesc().isEmpty()) {
			this.addActionError("部门简介不能为空！");
			return "goEditDepartment";
		}
		departmentService.update(department);
		return "updateSuccess";
	}

	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
	
	
	
}
