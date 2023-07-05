package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.constans.HttpStatus.NOT_FOUND;
import static api.responseassertions.AssertionsResponseGetUsersApi.assertGetUser;
import static api.service.RequestGetUser.sendGetUser;
import static api.service.RequestGetUser.sendGetRaw;
import static api.utils.RandomUtils.getRandomUserForId;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("Получение пользователя")
@DisplayName("Получение пользователя API GET users/")
public class GetUserTests extends TestBase {

    @Test
    @Tag("sanity")
    @DisplayName("Получить рандомного пользователя по id")
    @Description("Позитивный сценарий")
    public void positiveTestGetUser() {
        val randomUserId = getRandomUserForId();
        val response = sendGetUser(randomUserId.getId());
        assertGetUser(response, randomUserId);

    }

    @DisplayName("Запрос с queryParam")
    @Description("Негативный сценарий")
    @ParameterizedTest(name = "[{0}]")
    @ValueSource(strings = {"100", "0", "-1", "-2147483648", "2147483647"})
    public void negativeTestGetUser(int value) {
        val response = sendGetRaw(value);
        assertEquals(response.statusCode(), NOT_FOUND.getCode());
    }

}
