package ibm.pracpro.service;

import java.util.List;

import ibm.pracpro.model.Employee;

public interface EmployeeService {
	List<Employee> selectAll();
	
	int save(Employee e);
	
	int delete(String id);
	
	int update(Employee e);
	
	Employee getEmployee(String id);
}
