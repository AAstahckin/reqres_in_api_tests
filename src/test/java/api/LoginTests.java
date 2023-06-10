package api;

import api.models.LoginBodyModel;
import api.models.LoginResponseModel;
import api.service.Requests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static data.ErrorsTexts.*;
import static data.TestDataParams.LOGIN;
import static data.TestDataParams.TOKEN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends TestBase {
    LoginBodyModel loginBody = new LoginBodyModel();
    Faker faker = new Faker();

    @Test
    public void positiveLoginTest() {
        loginBody.setEmail(LOGIN.getValue());
        loginBody.setPassword(faker.artist().name());
        LoginResponseModel response = Requests.postLoginRequest(loginBody, 200);
        assertEquals(response.getToken(), TOKEN.getValue());
    }

    @ParameterizedTest(name = "Проверка негативных сценариев api/login с 400 кодом | [user: {0}; pass:{1}]")
    @MethodSource("submitIncorrectParameters")
    public void negativeTest(String user, String pass, String responseErrorText) {
        loginBody.setEmail(user);
        loginBody.setPassword(pass);
        LoginResponseModel response = Requests.postLoginRequest(loginBody, 400);
        assertEquals(response.getError(), responseErrorText);
    }

    private static Stream<Arguments> submitIncorrectParameters() {
        Faker fakerValue = new Faker();
        return Stream.of(
                Arguments.of(fakerValue.internet().emailAddress(), fakerValue.artist().name(), USER_NOT_FOUND.getValue()),
                Arguments.of(fakerValue.internet().emailAddress(), "", MISSING_PASSWORD.getValue()),
                Arguments.of("", fakerValue.artist().name(), MISSING_EMAIL_OR_USERNAME.getValue()));
    }

}
