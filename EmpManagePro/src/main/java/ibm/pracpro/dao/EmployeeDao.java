package ibm.pracpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, String> {

	@Query(value = "select e from Employee e where e.name like %?1%")
	public List<Employee> selectEmpNameLike(String name);

}
