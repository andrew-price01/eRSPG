package eRSPG.Repository;

import java.util.List;

import eRSPG.model.UserRole;

public interface UserRoleDAO {

	List<UserRole> findAllUserRole();

	UserRole findUserRoleById(int raid);

	int addUserRole(UserRole ra);

	boolean updateUserRole(UserRole ra);

	boolean deleteUserRole(UserRole ra);

}