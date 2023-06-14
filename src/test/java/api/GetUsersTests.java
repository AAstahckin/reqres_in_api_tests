package api;

import api.models.getusers.UsersResponseModel;
import api.service.Requests;
import data.UsersDataValues;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static api.specs.Specs.response200Spec;
import static api.utils.RandomUtils.getRandomUserForId;
import static api.constans.OtherTexts.TEXT_SUPPORT;
import static api.constans.OtherTexts.URL_SUPPORT;
import static api.constans.Urls.URL_USERS;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Список пользователей API /users?per_page= и /users?page=")
public class GetUsersTests {

    @DisplayName("Список пользователей API /users?per_page=")
    @Description("Список пользователей")
    @ParameterizedTest(name = "Проверка возвращения элементов по атрибуту per_page")
    @EnumSource(value = UsersDataValues.class)
    public void testsGetUsers(UsersDataValues usersDataValues) {
        UsersResponseModel response = Requests.sendGetRequest(URL_USERS.getUrl() + "?per_page=" + usersDataValues.getId(), UsersResponseModel.class, response200Spec);
        step("Проверяем колличество возвращаемых элементов", () -> assertEquals(response.getData().size(), usersDataValues.getId()));
        step("Проверяем что в ответе изменилось значение ключа per_page", () -> assertEquals(response.getPerPage(), usersDataValues.getId()));
        Allure.step("Проверяем объект support");
        assertEquals(response.getSupport().getUrl(), URL_SUPPORT.getValue());
        assertEquals(response.getSupport().getText(), TEXT_SUPPORT.getValue());
    }

    @DisplayName("Список пользователей API /users?page=")
    @Description("Список пользователей")
    @ParameterizedTest(name = "Проверка возвращения элементов по атрибуту page")
    @MethodSource("checkOutputParamsForPage")
    public void testsGetUsers1(int page, int count) {
        UsersResponseModel response = Requests.sendGetRequest(URL_USERS.getUrl() + "?page=" + page, UsersResponseModel.class, response200Spec);
        step("Проверяем колличество возвращаемых элементов" + count, () -> assertEquals(response.getData().size(), count));
        step("Проверяем что меняется page при запросе ?page=" + page, () -> assertEquals(response.getPage(), page));
    }

    private static Stream<Arguments> checkOutputParamsForPage() {
        return Stream.of(
                Arguments.of(1, 6),
                Arguments.of(2, 6));
    }

    @Test
    @DisplayName("Проверка возвращаемого пользователя")
    @Description("Проверка пользователя")
    void getUsersTests() {
        UsersDataValues randomUserId = getRandomUserForId();
        UsersResponseModel response = Requests.sendGetRequest(URL_USERS.getUrl() + "?per_page=" + UsersDataValues.values().length, UsersResponseModel.class, response200Spec);
        Allure.step("Проверяем рандомного пользователя с id : " + randomUserId.getId());
        assertEquals(response.getData().get(randomUserId.ordinal()).getId(), randomUserId.getId());
        assertEquals(response.getData().get(randomUserId.ordinal()).getEmail(), randomUserId.getEmail());
        assertEquals(response.getData().get(randomUserId.ordinal()).getFirstName(), randomUserId.getFirstName());
        assertEquals(response.getData().get(randomUserId.ordinal()).getLastName(), randomUserId.getLastName());
        assertEquals(response.getData().get(randomUserId.ordinal()).getAvatar(), randomUserId.getAvatar());
    }

}
