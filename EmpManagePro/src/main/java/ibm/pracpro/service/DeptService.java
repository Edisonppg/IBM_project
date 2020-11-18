package ibm.pracpro.service;

import java.util.List;

import ibm.pracpro.model.Dept;

public interface DeptService {
	List<Dept> selectAll();

	int save(Dept e);

	int delete(String id);

	int update(Dept e);

	Dept getDeptById(String id);

	List<Dept> selectNameLike(String deptName);
}
