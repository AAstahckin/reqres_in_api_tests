package models.getuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DataUserResponseModel {

    @JsonProperty("last_name")
    private String lastName;

    private int id;

    private String avatar;

    @JsonProperty("first_name")
    private String firstName;

    private String email;

}
