package ibm.pracpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.pracpro.dao.EmployeeDao;
import ibm.pracpro.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeDao.findAll();
		return list;
	}

	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		
		return employeeDao.save(e)!=null?1:0;
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDao.getOne(id);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			employeeDao.deleteById(id);
			flag = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
            flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Employee e) {
		// TODO Auto-generated method stub
		return employeeDao.save(e)!=null?1:0;
	}

}
