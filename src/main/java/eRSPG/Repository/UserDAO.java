package eRSPG.Repository;

import java.util.List;

import eRSPG.model.User;

public interface UserDAO {

	List<User> findAllUser();

	User findUserById(int raid);

	User findUserByEmail(String email);

	List<User> findAllUserByFirstName(String fn);

	List<User> findAllUserByLastName(String ln);

	List<User> findAllUserByFullName(String fullName);

	int addUser(User ra);

	boolean updateUser(User ra);

	boolean deleteUser(User ra);

}