package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUsersBodyModel {

    private String name;
    private String job;

    public CreateUsersBodyModel setName(String name) {
        this.name = name;
        return this;
    }

    public CreateUsersBodyModel setJob(String job) {
        this.job = job;
        return this;
    }

}
