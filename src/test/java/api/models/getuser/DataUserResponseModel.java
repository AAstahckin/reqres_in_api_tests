package api.models.getuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DataUserResponseModel {

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("id")
	private int id;

	@JsonProperty("avatar")
	private String avatar;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("email")
	private String email;
}