package models.getusers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponseModel {

    @JsonProperty("per_page")
    private int perPage;

    private int total;

    private List<DataUsersResponseModel> data;

    private int page;

    @JsonProperty("total_pages")
    private int totalPages;

    private UsersSupportResponseModel support;

}