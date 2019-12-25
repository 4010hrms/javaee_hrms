package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;
import com.entity.Salary;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.service.SalaryService;
/**
 * 员工管理web层
 * 采用模型驱动
 * @author hope
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	// 模型驱动使用的对象，自动注入employee的数据 
	private Employee employee = new Employee();
	private Salary salary =new Salary();

	// 当前页数
	private Integer currPage = 1;

	// struts2整合spring,注入业务层
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private SalaryService salaryService;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Employee getModel(){
		return employee;
	}

	/**
	 * 员工登陆
	 * @return
	 */
	public String plogin(){
		System.out.println("action.login方法执行");
		// 调用业务层方法
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee==null){
			// 登陆失败
			this.addActionError("用户名或密码错误！");
			System.out.println("action查找失败");
			return "pINPUT";
		}else{
			// 登录成功
			System.out.println("Action查找成功");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return "pSUCCESS";
		}
	}

	/**
	 * 管理员登陆
	 * @return
	 */
	public String login(){
		System.out.println("action.login方法执行");
		// 调用业务层方法
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee==null){
			// 登陆失败
			this.addActionError("用户名或密码错误！");
			System.out.println("action查找失败");
			return "INPUT";
		}else if(Integer.parseInt(existEmployee.getEno())<=10){
			// 登录成功
			System.out.println("Action查找成功");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return "SUCCESS";
		}else {
			this.addActionError("该账户没有权限！");
			System.out.println("action查找失败");
			return "INPUT";
		}
	}


	/**
	 * 退出登陆
	 * @return
	 */
	public String outlog(){
		System.out.println("action.outlog方法执行");
		// 登录成功
		System.out.println("Action查找成功");
		ActionContext.getContext().getSession().clear();
		return "INPUT";
	}

	public String search(){
		System.out.println(employee.toString());
		List<Employee> resultlist =  employeeService.search(employee);
		ActionContext.getContext().getSession().put("resultlist", resultlist);
		System.out.println(resultlist.toString());
		return "result";
	}

	/**
	 * 分页查询员工
	 * @return
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 使用的是模型驱动，把部门信息放入值栈中，采可以使用OGNL表达是获取
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加员工的方法
	 * @return
	 */
	public String goAddEmployee(){
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		return "goAddEmployee";
	}
	/**
	 * web层添加员工方法
	 */
	public String save(){
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		//		if (employee.getEno().isEmpty() || employee.getEno().equals(null) || employee.getEno()=="" 
		//			||employee.getEname().isEmpty()|| employee.getEname().equals(null) || employee.getEname()=="" 
		//			||employee.getUsername().isEmpty()|| employee.getUsername().equals(null) || employee.getUsername()=="" 
		//			||employee.getPassword().isEmpty() || employee.getUsername().equals(null) || employee.getUsername()=="" 
		//			||employee.getDepartment().equals(null)|| employee.getUsername().equals(null) || employee.getUsername()=="" ) {
		//			this.addActionError("请完善信息！");
		//			return "goEditEmployee";
		//		}

		if(employee.getEno().isEmpty()||employee.getEname().isEmpty()||employee.getUsername().isEmpty()||employee.getPassword().isEmpty()) {
			this.addActionError("请完善信息再保存 ！");
			// 查询所有部门

			return "goAddEmployee";
		}

		employeeService.save(employee);
		return "addSuccess";
	}

	/**
	 * 根据id查询员工
	 * @return
	 */
	public String findById(){
		employee = employeeService.findById(employee.getEid());
		System.out.print("名称："+employee.getEname());
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		System.out.print("所有部门："+list.size());
		ActionContext.getContext().getValueStack().set("list", list);	
		return "goEditEmployee";
	}

	/**
	 * web层编辑员工方法
	 */
	public String edit(){
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		System.out.print("所有部门："+list.size());
		ActionContext.getContext().getValueStack().set("list", list);	
		if(employee.getEno().isEmpty()||employee.getEname().isEmpty()||employee.getUsername().isEmpty()||employee.getPassword().isEmpty()) {
			this.addActionError("请完善信息再保存 ！");
			// 查询所有部门

			return "goEditEmployee";
		}
		employeeService.update(employee);
		return "editSuccess";
	}
	/**
	 * web层实现删除的方法
	 */
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

	public String personinfo(){
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		System.out.print("所有部门："+list.size());
		ActionContext.getContext().getValueStack().set("list", list);	
		Employee person =  (Employee) ActionContext.getContext().getSession().get("existEmployee");
		ActionContext.getContext().getSession().put("theperson", person);
		salary =salaryService.findById(person.getEid());
		ActionContext.getContext().getSession().put("salary", salary);
		return "personinfo";
	}

	public String personpassword(){
		Employee person =  (Employee) ActionContext.getContext().getSession().get("existEmployee");
		ActionContext.getContext().getSession().put("theperson", person);

		return "personpass";
	}

	public String editpassword(){
		if(employee.getPassword().isEmpty()) {
			this.addActionError("请完善信息再保存 ");
			return "personpassdone";
		}
		System.out.println("action"+employee.getPassword());
		employeeService.update(employee);
		this.addActionError("密码修改完成 ！");
		Employee existEmployee = employeeService.findById(employee.getEid());
		ActionContext.getContext().getSession().put("theperson", existEmployee);
		return "personpassdone";
	}

}
