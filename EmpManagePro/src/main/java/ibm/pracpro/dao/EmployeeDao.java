package ibm.pracpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, String> {
	//自定义模糊查询
	@Query(value = "select e from Employee e where e.name like %?1%")
	public List<Employee> selectEmpNameLike(String name);

	@Query(value = "select * from employee limit ?1,20",nativeQuery = true)
	public List<Employee> initSelect(int index);
}
