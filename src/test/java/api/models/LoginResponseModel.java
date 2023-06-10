package api.models;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class LoginResponseModel {

    String token, error;

}
