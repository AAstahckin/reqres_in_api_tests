package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseModel {

    String token, error;

}
