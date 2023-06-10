package api.models;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class CreateUserResponseModel {

    String name, job, id, createdAt;

}
