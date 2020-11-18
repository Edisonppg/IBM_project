package ibm.pracpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.Dept;


@Repository
public interface DeptDao extends CrudRepository<Dept, String> {

	@Query(value = "select e from Dept e where e.deptName like %?1%")
	public List<Dept> selectDeptNameLike(String deptName);

//	@Query(value = "update Employee e set e.quitDate=?1 where e.id=?2")
//	public int delete(Date date,String id);
}