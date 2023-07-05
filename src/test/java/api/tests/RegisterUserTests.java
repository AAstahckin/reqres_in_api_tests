package api.tests;

import api.models.RegisterBodyModel;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static api.responseassertions.AssertionsResponseRegisterApi.*;
import static api.service.RequestRegisterUser.sendRegisterUser;
import static api.service.RequestRegisterUser.sendRegisterUserRaw;
import static api.constans.ErrorsTexts.*;

@Story("Регистрация пользователя")
@DisplayName("Регистрация пользователя API POST /register")
public class RegisterUserTests extends TestBase {

    RegisterBodyModel bodyModel = new RegisterBodyModel();

    @Test
    @Tag("sanity")
    @DisplayName("Регистрация пользователя")
    @Description("Позитивный сценарий")
    public void positiveRegisterTest() {
        bodyModel.setEmail(login).setPassword(password);
        val response = sendRegisterUser(bodyModel);
        assertPositiveRegisterApi(response);
    }

    @DisplayName("Регистрация пользователя с параметрами : ")
    @Description("Негативный сценарий")
    @ParameterizedTest(name = "[user: {0}; pass:{1}]")
    @MethodSource("submitIncorrectParameters")
    public void negativeRegisterTest(String user, String pass, String responseErrorText) {
        bodyModel.setEmail(user).setPassword(pass);
        val response = sendRegisterUserRaw(bodyModel);
        assertNegativeRegisterApi(response, responseErrorText);
    }

    private static Stream<Arguments> submitIncorrectParameters() {
        Faker fakerValue = new Faker();
        return Stream.of(
                Arguments.of(login, "", MISSING_PASSWORD.getValue()),
                Arguments.of("", fakerValue.artist().name(), MISSING_EMAIL_OR_USERNAME.getValue()),
                Arguments.of(fakerValue.internet().emailAddress(), fakerValue.artist().name(), ONLY_DEFINED.getValue()));
    }

}
