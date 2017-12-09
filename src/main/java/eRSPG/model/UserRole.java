package eRSPG.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="UserRole")
public class UserRole {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="userRoleID")
	private int userRoleId;
	
	@Column(name="userID")
	private int userId;
	
	@Column(name="roleTypeID")
	private int roleTypeId;
	
	@Column(name="revoked")
	private LocalDateTime revoked;
	
	@Column(name="updateAt")
	private LocalDateTime updatedAt;

	public UserRole(int userId, int roleTypeId, LocalDateTime revoked, LocalDateTime updatedAt) {
		this.userId = userId;
		this.roleTypeId = roleTypeId;
		this.revoked = revoked;
		this.updatedAt = updatedAt;
	}

	public UserRole(){
		
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public LocalDateTime getRevoked() {
		return revoked;
	}

	public void setRevoked(LocalDateTime revoked) {
		this.revoked = revoked;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
