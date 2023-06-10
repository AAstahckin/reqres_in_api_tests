package api;

import api.models.CreateUserResponseModel;
import api.models.CreateUsersBodyModel;
import api.service.Requests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static api.helpers.DateTimeCheck.timeDifferenceCreateForServ;
import static org.junit.jupiter.api.Assertions.*;

public class CreateUserTests extends TestBase{

    CreateUsersBodyModel userBody = new CreateUsersBodyModel();
    Faker faker = new Faker();

    @Test
    public void positiveLoginTest() {
        userBody.setName(faker.name().firstName());
        userBody.setJob(faker.job().position());
        CreateUserResponseModel response = Requests.postCreateUserRequest(userBody, 201);
        assertEquals(response.getName(), userBody.getName());
        assertEquals(response.getJob(), userBody.getJob());
        assertNotNull(response.getId());
        timeDifferenceCreateForServ(response.getCreatedAt(), -3);
    }


}
