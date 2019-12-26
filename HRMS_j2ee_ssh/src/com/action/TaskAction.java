package com.action;

import java.util.List;

import com.entity.Task;
import com.entity.Employee;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TaskService;

public class TaskAction extends ActionSupport implements ModelDriven<Task>{
	
	private Task task = new Task();

	private TaskService taskService;
	@Override
	public Task getModel() {
		return task;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String search(){
		System.out.println(task.toString());
		List<Task> resultlist =  taskService.search(task);
		ActionContext.getContext().getSession().put("resultlist", resultlist);
		System.out.println(resultlist.toString());
		
		return "result";
	}

	public String findAll(){
		PageBean<Task> pageBean = taskService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		System.out.println(pageBean.toString());
		return "findAll";
	}

	public String goAddTask(){
		return "goAddTask";
	}


	public String saveTask(){
		String str=task.getEid().toString();
		if(str.isEmpty()) {
			this.addActionError("员工编号不能为空！");
			return "goAddTask";
		}
		if (task.getTno().isEmpty()) {
			this.addActionError("任务编号不能为空！");
			return "goAddTask";
		}
		if (task.getTname().isEmpty()) {
			this.addActionError("执行员工不能为空！");
			return "goAddTask";
		}
		
		if (task.getTaskname().isEmpty()) {
			this.addActionError("任务名称不能为空！");
			return "goAddTask";
		}
		if (task.getTcontent().isEmpty()) {
			this.addActionError("任务内容不能为空！");
			return "goAddTask";
		}
		taskService.save(task);
		return "addSuccess";
	}

	public String findById(){
		task = taskService.findById(task.getTid());
		return "goEditTask";
	}

	public String update(){
		String str=task.getEid().toString();
		if(str.isEmpty()) {
			this.addActionError("员工编号不能为空！");
			return "goEditTask";
		}
		if (task.getTno().isEmpty()) {
			this.addActionError("任务编号不能为空！");
			return "goEditTask";
		}
		if (task.getTname().isEmpty()) {
			this.addActionError("执行员工不能为空！");
			return "goEditTask";
		}
		
		if (task.getTaskname().isEmpty()) {
			this.addActionError("任务名称不能为空！");
			return "goEditTask";
		}
		if (task.getTcontent().isEmpty()) {
			this.addActionError("任务内容不能为空！");
			return "goEditTask";
		}
		taskService.update(task);
		return "updateSuccess";
	}

	public String delete(){
		task = taskService.findById(task.getTid());
		taskService.delete(task);
		return "deleteSuccess";
	}
	public String persontask() {
		Employee person =  (Employee) ActionContext.getContext().getSession().get("existEmployee");
		int id=person.getEid();
		List<Task> list=taskService.findAll();
		for(int i=0;i<list.size();i++) {
			Task temp=list.get(i);
			System.out.println("temp的i："+temp.getEid());
			if(temp.getEid()!=id) {
				list.remove(temp);
				i--;
			}
			ActionContext.getContext().getSession().put("personlist", list);
		}
		return "persontask";		
	}
}
