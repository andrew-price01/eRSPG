package eRSPG.Repository;

import java.util.List;

import eRSPG.model.RoleType;

public interface RoleTypeDAO {

	List<RoleType> findAllRoleType();

	RoleType findRoleTypeById(int raid);

	RoleType findRoleTypeByUserId(int pid);

	int addRoleType(RoleType ra);

	boolean updateRoleType(RoleType ra);

	boolean deleteRoleType(RoleType ra);

}