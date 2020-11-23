package ibm.pracpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.Dept;


@Repository
public interface DeptDao extends CrudRepository<Dept, String> {

	@Query(value = "select d from Dept d where d.deptName like %?1%")
	public List<Dept> selectDeptNameLike(String deptName);

	@Query(value = "select d.id from Dept d")
	public List<String> selectAllOnlyId();
}