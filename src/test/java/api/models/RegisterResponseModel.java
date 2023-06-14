package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterResponseModel {

    private int id;
    private String token;
    private String error;


}
