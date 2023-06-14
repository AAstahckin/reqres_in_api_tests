package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterBodyModel {

    private String email;
    private String password;


    public RegisterBodyModel setEmail(String email) {
        RegisterBodyModel.this.email = email;
        return this;
    }

    public RegisterBodyModel setPassword(String password) {
        RegisterBodyModel.this.password = password;
        return this;
    }



}
