package api;

import api.models.LoginBodyModel;
import api.models.LoginResponseModel;
import api.service.Requests;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static api.specs.Specs.response200Spec;
import static api.specs.Specs.response400Spec;
import static data.ErrorsTexts.*;
import static data.TestLoginDataParams.LOGIN;
import static data.TestLoginDataParams.TOKEN;
import static data.Urls.URL_LOGIN;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Авторизация API /login")
public class LoginTests {
    LoginBodyModel loginBody = new LoginBodyModel();
    Faker faker = new Faker();

    @Test
    @DisplayName("Проверка авторизации пользователя API /login")
    @Description("Авторизация")
    public void positiveLoginTest() {
        loginBody.setEmail(LOGIN.getValue()).setPassword(faker.artist().name());
        LoginResponseModel response = Requests.sendPostRequest(URL_LOGIN.getUrl(), loginBody, LoginResponseModel.class, response200Spec);
        step("Проверяем что присутствует token : " + TOKEN.getValue(), () -> assertEquals(response.getToken(), TOKEN.getValue()));
    }

    @DisplayName("Проверка негативных сценариев с 400 кодом API /login")
    @Description("Проверка негативных сценариев с 400")
    @ParameterizedTest(name = "[user: {0}; pass:{1}]")
    @MethodSource("submitIncorrectParameters")
    public void negativeTest(String user, String pass, String responseErrorText) {
        loginBody.setEmail(user).setPassword(pass);
        LoginResponseModel response = Requests.sendPostRequest(URL_LOGIN.getUrl(), loginBody, LoginResponseModel.class, response400Spec);
        step("Проверяем что присутствует ошибка : " + responseErrorText, () -> assertEquals(response.getError(), responseErrorText));
    }

    private static Stream<Arguments> submitIncorrectParameters() {
        Faker fakerValue = new Faker();
        return Stream.of(
                Arguments.of(fakerValue.internet().emailAddress(), fakerValue.artist().name(), USER_NOT_FOUND.getValue()),
                Arguments.of(fakerValue.internet().emailAddress(), "", MISSING_PASSWORD.getValue()),
                Arguments.of("", fakerValue.artist().name(), MISSING_EMAIL_OR_USERNAME.getValue()));
    }

}
