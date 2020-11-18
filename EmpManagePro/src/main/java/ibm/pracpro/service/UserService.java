package ibm.pracpro.service;

import ibm.pracpro.model.User;

public interface UserService {

	int save(User u);
	
	int update(User u);
	
	User getUserByName(String userName);
}
