package models.getusers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class UsersSupportResponseModel {

    private String text;

    private String url;

}