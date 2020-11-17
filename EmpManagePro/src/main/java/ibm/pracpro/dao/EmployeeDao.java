package ibm.pracpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, String> {
	
//	@Query("select id,name,salary,age,empDate,did from Employee where name is like CONCAT('%',:name,'%')")
//	public List<Employee> selectEmpNameLike(@Param("name")String name);
	
	
}
