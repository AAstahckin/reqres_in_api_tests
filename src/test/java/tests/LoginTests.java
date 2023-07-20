package tests;

import models.LoginBodyModel;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static data.TestDataValues.loginSubmitIncorrectParameters;
import static responseassertions.AssertionsResponseLoginApi.*;
import static service.RequestLoginUser.sendLogin;
import static service.RequestLoginUser.sendLoginRaw;
import static constans.ErrorsTexts.*;

@Story("Авторизация")
@DisplayName("Авторизация API POST /login")
@Owner("Aleksey_Astashkin")
public class LoginTests extends TestBase {

    LoginBodyModel body = new LoginBodyModel();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("sanity")
    @DisplayName("Проверка авторизации пользователя")
    @Description("Авторизация")
    public void positiveLoginTest() {
        body.setEmail(login).setPassword(password);
        val response = sendLogin(body);
        assertPositiveLoginApi(response);
    }

    @DisplayName("Негативный сценарий авторизации ")
    @Description("Проверка негативных сценариев с 400")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest(name = "[user: {0}; pass:{1}]")
    @MethodSource("submitIncorrectParameters")
    public void negativeLoginTest(String user, String pass, String responseErrorText) {
        body.setEmail(user).setPassword(pass);
        val response = sendLoginRaw(body);
        assertNegativeLoginApi(response, responseErrorText);
    }

    public static Stream<Arguments> submitIncorrectParameters() {
        return loginSubmitIncorrectParameters();
    }



}
