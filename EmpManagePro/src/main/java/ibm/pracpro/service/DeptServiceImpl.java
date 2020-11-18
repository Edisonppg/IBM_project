package ibm.pracpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.pracpro.dao.DeptDao;
import ibm.pracpro.model.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao DeptDao;

	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		List<Dept> list = (List<Dept>) DeptDao.findAll();
		return list;
	}

	@Override
	public int save(Dept e) {
		// TODO Auto-generated method stub

		return DeptDao.save(e) != null ? 1 : 0;
	}

	@Override
	public Dept getDeptById(String id) {
		// TODO Auto-generated method stub
		return DeptDao.findById(id).get();
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			DeptDao.deleteById(id);
			flag = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}

	@Override
	public int update(Dept e) {
		// TODO Auto-generated method stub
		return DeptDao.save(e) != null ? 1 : 0;
	}

	@Override
	public List<Dept> selectNameLike(String deptName) {
		// TODO Auto-generated method stub
		return DeptDao.selectDeptNameLike(deptName);
	}

	
}

