package api.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginBodyModel {

    private String email;
    private String password;

}
