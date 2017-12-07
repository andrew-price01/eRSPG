package eRSPG.Repository;

import java.util.List;

import eRSPG.model.RoleType;

public interface RoleTypeDAO {

	List<RoleType> findAllRoleType();

	RoleType findRoleTypeById(int raid);

	RoleType findRoleTypeByUserId(int pid);

	RoleType findRoleTypeByRoleTypeId(int roleTypeId);

	void addNewOrUpdateRoleType(RoleType ra);

	void deleteRoleType(RoleType ra);

}