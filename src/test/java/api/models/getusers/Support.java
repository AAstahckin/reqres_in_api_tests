package api.models.getusers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Support{

	@JsonProperty("text")
	private String text;

	@JsonProperty("url")
	private String url;

	public String getText(){
		return text;
	}

	public String getUrl(){
		return url;
	}
}