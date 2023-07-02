package api.responseassertions;

import api.models.RegisterResponseModel;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseRegisterApi {

    public static void assertPositiveRegisterApi(RegisterResponseModel response) {
        step("Проверяем что присутствует id : ", () -> assertEquals(response.getId(), 4));
        step("Проверяем что присутствует token : ", () -> assertNotNull(response.getToken()));
    }

    public static void assertNegativeRegisterApi(RegisterResponseModel response, String responseErrorText) {
        step("Проверяем что присутствует ошибка : " + responseErrorText, () ->
                assertEquals(response.getError(), responseErrorText));
    }

}
