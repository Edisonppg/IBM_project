<<<<<<< HEAD
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

//	@Query(value = "update Employee e set e.quitDate=?1 where e.id=?2")
//	public int delete(Date date,String id);
}
=======
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

//	@Query(value = "update Employee e set e.quitDate=?1 where e.id=?2")
//	public int delete(Date date,String id);
}
>>>>>>> 8b5f0c81db70df4e2aa3ed361213cb59ebe886a9
