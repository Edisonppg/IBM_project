<<<<<<< HEAD
package ibm.pracpro;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ibm.pracpro.controller.EmployeeController;
import ibm.pracpro.model.Employee;
import ibm.pracpro.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	private EmployeeController controller;
	
	@Autowired
	private EmployeeService service;

	@Test
	public void saveone() {// 新建
		Employee e = new Employee("123456", "啊啊", 30.1, 15, new Date(), "101");
		String result = controller.saveEmp(e);
		System.out.println(result);
	}

	@Test
	public void getOne() {// 模糊查询
		String name = "啊";
		Employee emp = service.selectNameLike(name).get(0);
		System.out.println(controller.selectEmp(emp));
	}

	@Test
	public void updateOne() {
		Employee emp = service.getEmployeeById("123456");
		System.out.println(emp);
		emp.setAge(22);
		String e = controller.updateEmp(emp);
		System.out.println(emp);
		System.out.println(e);
	}

	@Test
	public void deleteOne() {
		String result = controller.deleteEmp("123456");
		System.out.println(result);
	}

}
=======
package ibm.pracpro;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ibm.pracpro.controller.EmployeeController;
import ibm.pracpro.model.Employee;
import ibm.pracpro.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	private EmployeeController controller;
	
	@Autowired
	private EmployeeService service;

	@Test
	public void saveone() {// 新建
		Employee e = new Employee("123456", "啊啊", 30.1, 15, new Date(), "101");
		String result = controller.saveEmp(e);
		System.out.println(result);
	}

	@Test
	public void getOne() {// 模糊查询
		String name = "啊";
		Employee emp = service.selectNameLike(name).get(0);
		System.out.println(controller.selectEmp(emp));
	}

	@Test
	public void updateOne() {
		Employee emp = service.getEmployeeById("123456");
		System.out.println(emp);
		emp.setAge(22);
		String e = controller.updateEmp(emp);
		System.out.println(emp);
		System.out.println(e);
	}

	@Test
	public void deleteOne() {
		String result = controller.deleteEmp("123456");
		System.out.println(result);
	}

}
>>>>>>> 8b5f0c81db70df4e2aa3ed361213cb59ebe886a9
