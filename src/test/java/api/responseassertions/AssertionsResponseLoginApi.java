package api.responseassertions;

import api.models.LoginResponseModel;
import io.restassured.response.Response;

import static api.constans.HttpStatus.BAD_REQUEST;
import static api.helpers.CustomsTextsSteps.statusCodeResponse;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseLoginApi {

    public static void assertPositiveLoginApi(LoginResponseModel response) {
        step("Проверяем что присутствует token : ", () ->
                assertNotNull(response.getToken()));
    }

    public static void assertNegativeLoginApi(Response response, String value) {
        step(statusCodeResponse(BAD_REQUEST.getCode()), () ->
                assertEquals(response.statusCode(), BAD_REQUEST.getCode()));
        step("Проверяем что присутствует ошибка : " + value, () ->
                assertEquals(response.as(LoginResponseModel.class).getError(), value));
    }

}
