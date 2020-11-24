package ibm.pracpro;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ibm.pracpro.controller.DeptController;
import ibm.pracpro.model.Dept;
import ibm.pracpro.service.DeptService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppDeptTest {

	@Autowired
	private DeptController controller;
	
	@Autowired
	private DeptService service;

	@Test
	public void saveone() {// 新建
		Dept e = new Dept();
		e.setCreDate(new Date());
		e.setDeptName("aaa");
		e.setId("103");
		String result = controller.saveDept(e);
		System.out.println(result);
	}

	@Test
	public void getOne() {// 模糊查询
		String name = "研发";
		Dept dep = service.selectNameLike(name).get(0);
		System.out.println(controller.selectDept(dep));
	}

	@Test
	public void updateOne() {
		Dept dep = service.getDeptById("123456");
		System.out.println(dep);
		dep.setDeptName("管理部门");
		String e = controller.updatDept(dep);
		System.out.println(dep);
		System.out.println(e);
	}

	@Test
	public void deleteOne() {
		String result = controller.deleteDept("123456");
		System.out.println(result);
	}

}
