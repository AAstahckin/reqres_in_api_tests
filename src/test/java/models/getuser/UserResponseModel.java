package models.getuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserResponseModel {

    @JsonProperty("data")
    private DataUserResponseModel dataUserResponseModel;

    @JsonProperty("support")
    private UserSupportResponseModel userSupportResponseModel;

}