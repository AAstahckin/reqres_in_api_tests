package api.models.getusers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponseModel {

	@JsonProperty("per_page")
	private int perPage;

	@JsonProperty("total")
	private int total;

	@JsonProperty("data")
	private List<DataUsersResponseModel> data;

	@JsonProperty("page")
	private int page;

	@JsonProperty("total_pages")
	private int totalPages;

	@JsonProperty("support")
	private UsersSupportResponseModel support;
}