package eRSPG.Repository;

import java.util.List;

import eRSPG.model.UserRole;

public interface UserRoleDAO {

	List<UserRole> findAllUserRole();

	UserRole findUserRoleById(int raid);

	UserRole findUserRoleByUserId(int userId);

	void addNewOrUpdateUserRole(UserRole ra);

	void deleteUserRole(UserRole ra);

}