package ibm.pracpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import ibm.pracpro.model.Employee;
import ibm.pracpro.service.EmployeeService;

@RestController
@RequestMapping("/doemp")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("save")
	public String saveEmp(@RequestBody Employee emp) {//新增员工
		int result = 0;
		Employee em = service.getEmployeeById(emp.getId());
		if(em!=null) {//验证员工是否存在
			return "0";//员工id已存在
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
	public String updateEmp(@RequestBody Employee emp) {//修改信息参数为修改后的新信息
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
	public String selectEmp(@RequestBody Employee example) {//查询
		if (example.getId() != null) {//id查询
			List<Employee> list = new ArrayList<Employee>();
			Employee e = service.getEmployeeById(example.getId());
			if(e!=null) {
				list.add(e);
				return JSON.toJSONString(list);
			}else {
				return JSON.toJSONString(null);
			}
		} else if (example.getName() != null) {//名字模糊查询
			return JSON.toJSONString(service.selectNameLike(example.getName()));
		} else {
			return JSON.toJSONString(service.initSelect(1));
		} 
		
	}
	
	@RequestMapping("delete")
	public String deleteEmp(String id) {
		System.out.println(id);
		Employee emp = service.getEmployeeById(id);
		if(emp.getQuitDate() != null) {
			return "0";//重复删除离职
		}else {
			service.delete(id);
			return "1";
		}
	}
	
	@RequestMapping("initSelect")
	public String iselect() {
		return JSON.toJSONString(service.initSelect(1));
	}
}
