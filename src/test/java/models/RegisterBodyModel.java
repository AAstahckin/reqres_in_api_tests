package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterBodyModel {

    private String email;
    private String password;

    public RegisterBodyModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegisterBodyModel setPassword(String password) {
        this.password = password;
        return this;
    }

}
