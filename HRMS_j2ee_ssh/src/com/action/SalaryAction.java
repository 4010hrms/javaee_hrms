package com.action;

import com.entity.PageBean;
import com.entity.Salary;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.SalaryService;

/**
 * 员工管理web层
 * 采用模型驱动
 * @author hope
 *
 */
public class SalaryAction extends ActionSupport implements ModelDriven<Salary>{

	// 模型驱动使用的对象，自动注入employee的数据 
	private Salary salary = new Salary();

	// 当前页数
	private Integer currPage = 1;

	// struts2整合spring,注入业务层
	private SalaryService salaryService;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}


	@Override
	public Salary getModel(){
		return salary;
	}

	/**
	 * 分页查询薪资
	 * @return
	 */
	public String findAll(){
		PageBean<Salary> pageBean = salaryService.findByPage(currPage);
		// 使用的是模型驱动，把部门信息放入值栈中，采可以使用OGNL表达是获取
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加薪资的方法
	 * @return
	 */
	public String goAddSalary(){
		return "goAddSalary";
	}
	/**
	 * web层添加薪资方法
	 */
	public String save(){
		
		if(salary.getEname().isEmpty()||salary.getEsex().isEmpty()) {
			this.addActionError("请完善信息再保存 ！");
			// 查询所有部门
			return "goAddSalary";
		}
		salaryService.save(salary);
		return "addSuccess";
	}

	/**
	 * 根据id查询员工
	 * @return
	 */
	public String findById(){
		salary = salaryService.findById(salary.getEid());
		return "goEditSalary";
	}
	public String findSalary(){
		salary = salaryService.findById(salary.getEid());
		return "gofindSalary";
	}
	/**
	 * web层编辑员工方法
	 */
	public String edit(){
		
//		if() {
//			this.addActionError("请完善信息再保存 ！");
//			// 查询所有部门
//			
//			return "goEditEmployee";
//		}
		salaryService.update(salary);
		return "editSuccess";
	}
	/**
	 * web层实现删除的方法
	 */
	public String delete(){
		salary = salaryService.findById(salary.getEid());
		salaryService.delete(salary);
		return "deleteSuccess";
	}
}
