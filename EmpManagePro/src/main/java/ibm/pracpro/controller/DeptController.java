package ibm.pracpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

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
				return "0";//部门id已存在
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
	public String selectDept(@RequestBody Dept example) {
		if(example.getId()!=null) {
			List<Dept> list = new ArrayList<Dept>();
			Dept d = service.getDeptById(example.getId());
			if(d!=null) {
				list.add(d);
				return JSON.toJSONString(list);
			}else {
				return JSON.toJSONString(null);
			}
		}else if (example.getDeptName()!=null) {
			return JSON.toJSONString(service.selectNameLike(example.getDeptName()));
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("delete")
	public String deleteDept(String id) {
		service.delete(id);
		return "1";
	}
	
	@RequestMapping("initSelect")
	public String iselect() {
		return JSON.toJSONString(service.selectAll());
	}
	
}

