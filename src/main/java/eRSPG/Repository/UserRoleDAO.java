package eRSPG.Repository;

import java.util.List;

import eRSPG.model.UserRole;

public interface UserRoleDAO {

	List<UserRole> findAllUserRole();

	UserRole findUserRoleById(int raid);

	void addNewOrUpdateUserRole(UserRole ra);

	void deleteUserRole(UserRole ra);

}