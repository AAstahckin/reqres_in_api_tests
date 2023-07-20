package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginBodyModel {

    private String email;
    private String password;

    public LoginBodyModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LoginBodyModel setPassword(String password) {
        this.password = password;
        return this;
    }

}
