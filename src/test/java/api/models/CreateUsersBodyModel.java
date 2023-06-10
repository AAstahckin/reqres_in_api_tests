package api.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CreateUsersBodyModel {

    private String name;
    private String job;

}
