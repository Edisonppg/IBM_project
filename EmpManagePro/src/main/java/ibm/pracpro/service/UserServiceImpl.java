package ibm.pracpro.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibm.pracpro.dao.UserDao;
import ibm.pracpro.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public int save(User u) {
		// TODO Auto-generated method stub
		u.setPassword(DigestUtils.md5Hex(u.getPassword()));
		return userDao.save(u)!=null?1:0;
	}

	@Override
	public int update(User u) {
		// TODO Auto-generated method stub
		u.setPassword(DigestUtils.md5Hex(u.getPassword()));
		return userDao.save(u)!=null?1:0;
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(userName);
	}

}
