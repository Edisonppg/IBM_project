package ibm.pracpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, String> {

}
