package api;

import api.models.RegisterBodyModel;
import api.models.RegisterResponseModel;
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

public class RegisterTests extends TestBase {
    RegisterBodyModel bodyModel = new RegisterBodyModel();
    Faker faker = new Faker();

    @Test
    public void positiveRegisterTest() {
        bodyModel.setEmail(LOGIN.getValue());
        bodyModel.setPassword(faker.artist().name());
        RegisterResponseModel response = Requests.postRegisterRequest(bodyModel, 200);
        assertEquals(response.getId(), 4);
        assertEquals(response.getToken(), TOKEN.getValue());
    }

    @ParameterizedTest(name = "Проверка негативных сценариев api/register с 400 кодом | [user: {0}; pass:{1}]")
    @MethodSource("submitIncorrectParameters")
    public void negativeTest(String user, String pass, String responseErrorText) {
        bodyModel.setEmail(user);
        bodyModel.setPassword(pass);
        RegisterResponseModel response = Requests.postRegisterRequest(bodyModel, 400);
        assertEquals(response.getError(), responseErrorText);
    }

    private static Stream<Arguments> submitIncorrectParameters() {
        Faker fakerValue = new Faker();
        return Stream.of(
                Arguments.of(LOGIN.getValue(), "", MISSING_PASSWORD.getValue()),
                Arguments.of("", fakerValue.artist().name(), MISSING_EMAIL_OR_USERNAME.getValue()),
                Arguments.of(fakerValue.internet().emailAddress(), fakerValue.artist().name(), ONLY_DEFINED.getValue()));
    }

}
