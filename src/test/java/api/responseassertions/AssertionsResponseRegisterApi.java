package api.responseassertions;

import api.models.RegisterResponseModel;
import io.restassured.response.Response;

import static api.constans.HttpStatus.BAD_REQUEST;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseRegisterApi {

    public static void assertPositiveRegisterApi(RegisterResponseModel response) {
        step("Проверяем что id соответствует: ", () -> assertEquals(response.getId(), 4));
        step("Проверяем что token присутствует  : ", () -> assertNotNull(response.getToken()));
    }

    public static void assertNegativeRegisterApi(Response response, String responseErrorText) {
        step("Проверяем код ответа", () ->
                assertEquals(response.statusCode(), BAD_REQUEST.getCode()));
        step("Проверяем что присутствует ошибка : " + responseErrorText, () ->
                assertEquals(response.as(RegisterResponseModel.class).getError(), responseErrorText));
    }

}
