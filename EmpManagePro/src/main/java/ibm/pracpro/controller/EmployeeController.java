package ibm.pracpro.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.pracpro.model.Employee;
import ibm.pracpro.service.EmployeeService;

@RestController
@RequestMapping("/doemp")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("save")
	public String saveEmp(Employee emp) {//新增员工
		int result = 0;
		Employee em = service.getEmployeeById(emp.getId());
		if(em!=null) {//验证员工是否存在
			return "员工id已存在，请重新输入";
		}
		try {
			result = service.save(emp);//保存
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
	public String updateEmp(Employee emp) {//修改信息参数为修改后的新信息
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
	public String selectEmp(Employee example) {//查询
		if(example.getId()!=null&&example.getName()!=null) {
			return "只允许选择一种查询方式，id或者名字";
		}
		if(example.getId()!=null) {//id查询
			return JSONObject.valueToString(service.getEmployeeById(example.getId()));
		}else if (example.getName()!=null) {//名字模糊查询
			return service.selectNameLike(example.getName()).toString();
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("delete")
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
