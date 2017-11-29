package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RoleType")
public class RoleType {

	/*1 Faculty
	* 2 Committee
	* 3 Chairman*/

	/*--TODO: Insert Roles--*/

	@Id
	@Column(name="roleTypeID")
	private int roleTypeId;
	
	@Column(name="roleDesc")
	private String roleDesc;
	
	public RoleType(){
		
	}

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}