package api;

import api.service.Requests;
import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static data.ErrorsTexts.*;
import static data.TestDataParams.LOGIN;
import static data.TestDataParams.TOKEN;
import static data.Urls.URL_REGISTER;
import static org.hamcrest.Matchers.equalTo;

public class RegisterTests extends TesBase{
    User user = new User();
    Faker faker = new Faker();

    @Test
    public void negativeOnlyDefinedTest() {
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.artist().name());
        ValidatableResponse response = Requests.postRequest(user, URL_REGISTER.getUrl());
        response.statusCode(400);
        response.assertThat().body("error", equalTo(ONLY_DEFINED.getValue()));
    }

    @Test
    public void positiveRegisterTest() {
        user.setEmail(LOGIN.getValue());
        user.setPassword(faker.artist().name());
        ValidatableResponse response = Requests.postRequest(user, URL_REGISTER.getUrl());
        response.statusCode(200);
        response.assertThat().body("id", equalTo(4));
        response.assertThat().body("token", equalTo(TOKEN.getValue()));
    }

    @Test
    public void negativeMissingPasswordTest() {
        user.setEmail(LOGIN.getValue());
        ValidatableResponse response = Requests.postRequest(user, URL_REGISTER.getUrl());
        response.statusCode(400);
        response.assertThat().body("error", equalTo(MISSING_PASSWORD.getValue()));
    }

    @Test
    public void negativeMissingEmailOrUsernameTest8() {
        user.setPassword(faker.artist().name());
        ValidatableResponse response = Requests.postRequest(user, URL_REGISTER.getUrl());
        response.statusCode(400);
        response.assertThat().body("error", equalTo(MISSING_EMAIL_OR_USERNAME.getValue()));
    }

}
