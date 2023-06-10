package api.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RegisterResponseModel {

    private int id;
    private String token;
    private String error;


}
