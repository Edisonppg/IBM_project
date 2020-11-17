package ibm.pracpro;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ibm.pracpro.model.Employee;
import ibm.pracpro.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void saveone() {
		Employee e = new Employee("123456", "啊啊", 30.1, 15, new Date(), "101");
		int result = employeeService.save(e);
		System.out.println(result);
	}

}
