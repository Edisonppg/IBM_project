package ibm.pracpro.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.pracpro.model.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
	
	@Query(value = "select u from User u where u.userName=?1")
	public User findUserByName(String userName);
}
