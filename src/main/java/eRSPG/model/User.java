package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@Column(name="userID")
	private int userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="userFirstName")
	private String firstName;
	
	@Column(name="userLastName")
	private String lastName;

	@Column(name="username")
	private String username;
	
	public User(){
		
	}

	public User(int userId, String email, String firstName, String lastName) {
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String loginName) {
		this.username = loginName;
	}
}
