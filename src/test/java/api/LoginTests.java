package api;

import api.service.Requests;
import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static data.ErrorsTexts.*;
import static data.TestDataParams.LOGIN;
import static data.TestDataParams.TOKEN;
import static data.Urls.URL_LOGIN;
import static data.Urls.URL_USERS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTests extends TestBase {
    User user = new User();
    Faker faker = new Faker();

    @Test
    public void positiveLoginTest() {
        user.setEmail(LOGIN.getValue());
        user.setPassword(faker.artist().name());
        ValidatableResponse response = Requests.postRequest(user, URL_LOGIN.getUrl());
        response.statusCode(200);
        response.assertThat().body("token", equalTo(TOKEN.getValue()));


    }

    @Test
    public void userNotFoundTest() {
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.artist().name());
        ValidatableResponse response = Requests.postRequest(user, URL_LOGIN.getUrl());
        response.statusCode(400);
        response.assertThat().body("error", equalTo(USER_NOT_FOUND.getValue()));
    }

    @Test
    public void missingPasswordTest() {
        user.setEmail(faker.internet().emailAddress());
        ValidatableResponse response = Requests.postRequest(user, URL_LOGIN.getUrl());
        response.statusCode(400);
        response.assertThat().body("error", equalTo(MISSING_PASSWORD.getValue()));
    }

    @Test
    public void missingEmailOrUsernameTest4() {
        user.setPassword("cityslicka");
        ValidatableResponse response = Requests.postRequest(user, URL_LOGIN.getUrl());
        response.statusCode(400);
        response.assertThat().body("error", equalTo(MISSING_EMAIL_OR_USERNAME.getValue()));
    }

    @Test
    public void positiveCreateTest() {
        user.setName("morpheus");
        user.setJob("leader");
        ValidatableResponse response = Requests.postRequest(user, URL_USERS.getUrl());
        response.statusCode(201);
        response.assertThat().body("name", equalTo(user.getName()));
        response.assertThat().body("job", equalTo(user.getJob()));
        response.assertThat().body("id", notNullValue());
        response.assertThat().body("createdAt", notNullValue());
    }

}
