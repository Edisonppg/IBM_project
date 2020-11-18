package ibm.pracpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.pracpro.model.Employee;
import ibm.pracpro.service.EmployeeService;

@RestController
@RequestMapping("/doemp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("save")
	public String saveEmp(Employee emp) {
		int result = 0;
		try {
			result = service.save(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result==1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("update")
	public String updateEmp(Employee emp) {
		int result = 0;
		try {
			result = service.update(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result==1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("select")
	public String selectEmp(Employee example) {
		if(example.getId()!=null) {
			return service.getEmployeeById(example.getId()).toString();
		}else if (example.getName()!=null) {
			return service.selectNameLike(example.getName()).toString();
		}else {
			return "fail";
		}
	}
	
	
	public String deleteEmp(String id) {
		Employee emp = service.getEmployeeById(id);
		if(emp.getQuitDate() != null) {
			return "不能重复对离职人员进行删除操作";
		}else {
			service.delete(id);
			return "success";
		}
	}
	
}
