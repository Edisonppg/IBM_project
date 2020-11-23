package ibm.pracpro.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		List<Employee> list = (List<Employee>) employeeDao.findAll();
		return list;
	}

	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		return employeeDao.save(e) != null ? 1 : 0;
	}

	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeDao.findById(id);
		if(result!=null&&result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			Employee emp = employeeDao.findById(id).get();
			emp.setQuitDate(new Date());
			flag = employeeDao.save(emp)!=null?1:0;
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
		return employeeDao.save(e) != null ? 1 : 0;
	}

	@Override
	public List<Employee> selectNameLike(String name) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmpNameLike(name);
	}

	@Override
	public List<Employee> initSelect(int pageNum) {
		// TODO Auto-generated method stub
		int index = (pageNum-1)*20;
		return employeeDao.initSelect(index);
	}

	
}
