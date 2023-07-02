package api.responseassertions;

import api.models.LoginResponseModel;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseLoginApi {

    public static void assertPositiveLoginApi(LoginResponseModel response) {
        step("Проверяем что присутствует token : ", () -> assertNotNull(response.getToken()));
    }

    public static void assertNegativeLoginApi(LoginResponseModel response, String value) {
        step("Проверяем что присутствует ошибка : " + value, () -> assertEquals(response.getError(), value));
    }

}
