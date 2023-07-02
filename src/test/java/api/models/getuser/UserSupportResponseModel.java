package api.models.getuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserSupportResponseModel {

	@JsonProperty("text")
	private String text;

	@JsonProperty("url")
	private String url;
}