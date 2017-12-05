package eRSPG.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

// Committee Email
public class EmailDTO implements Serializable {

    @JsonProperty(value="email")
    private String email;

    public EmailDTO() { }

    public EmailDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
