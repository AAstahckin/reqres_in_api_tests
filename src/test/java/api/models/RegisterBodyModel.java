package api.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RegisterBodyModel {

    private String email;
    private String password;


}
