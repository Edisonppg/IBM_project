package ibm.pracpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.pracpro.model.Dept;
import ibm.pracpro.service.DeptService;

@RestController
@RequestMapping("/dodept")
@CrossOrigin
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@RequestMapping("save")
	public String saveDept(Dept dept) {
		int result = 0;
		try {
			Dept d = service.getDeptById(dept.getId());
			if(d==null) {
				result = service.save(dept);
			}else {
				return "部门id已存在，请重新输入";
			}
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
	public String updatDept(Dept dept) {
		int result = 0;
		try {
			result = service.update(dept);
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
	public String selectDept(Dept example) {
		if(example.getId()!=null) {
			return service.getDeptById(example.getId()).toString();
		}else if (example.getDeptName()!=null) {
			return service.selectNameLike(example.getDeptName()).toString();
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("delete")
	public String deleteDept(String id) {
		
			service.delete(id);
			return "success";
	}
	
}

