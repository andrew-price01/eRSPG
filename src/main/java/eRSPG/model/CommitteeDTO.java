package eRSPG.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CommitteeDTO implements Serializable {

    @JsonProperty(value = "id")
    private Integer userRoleId;

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "lastName")
    private String lastName;

    @JsonProperty(value = "email")
    private String email;


    public CommitteeDTO() { }

    public CommitteeDTO(UserRole userRole, User user) {
        this.userRoleId = userRole.getUserRoleId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
