package eRSPG.model.form;

import javax.validation.constraints.NotNull;

public class UserForm {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String userEmail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() { this.lastName = lastName; }

    public void setLastName(String lName) { this.lastName = lName; }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail() {
        this.userEmail = userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
}