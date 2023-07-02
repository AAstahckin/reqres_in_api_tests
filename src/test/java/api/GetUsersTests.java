package api;

import api.models.getusers.UsersResponseModel;
import api.service.Requests;
import data.UsersDataValues;
import io.qameta.allure.Description;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static api.responseassertions.AssertionsResponseGetUsersApi.*;
import static api.specs.Specs.response200Spec;
import static api.utils.RandomUtils.getRandomUserForId;
import static api.constans.Urls.URL_USERS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Список пользователей API /users?per_page= и /users?page=")
public class GetUsersTests {

    @DisplayName("Список пользователей API /users?per_page=")
    @Description("Список пользователей")
    @ParameterizedTest(name = "Проверка возвращения элементов по атрибуту per_page")
    @EnumSource(value = UsersDataValues.class)
    public void testsGetUsers(UsersDataValues usersDataValues) {
        val response = Requests.sendGetRequest(
                URL_USERS.getUrl(), "per_page", usersDataValues.getId(), UsersResponseModel.class, response200Spec);
        assertGetElementPerPage(response, usersDataValues);
    }

    @DisplayName("Список пользователей API /users?page=")
    @Description("Список пользователей")
    @ParameterizedTest(name = "Проверка возвращения элементов по атрибуту page")
    @MethodSource("checkOutputParamsForPage")
    public void testsGetUsers1(int page, int count) {
        val response = Requests.sendGetRequest(
                URL_USERS.getUrl(), "page", page, UsersResponseModel.class, response200Spec);
        assertGetElementPage(response, page, count);
    }

    private static Stream<Arguments> checkOutputParamsForPage() {
        return Stream.of(
                Arguments.of(1, 6),
                Arguments.of(2, 6));
    }

    @Test
    @DisplayName("Проверка возвращаемого пользователя")
    @Description("Проверка пользователя")
    void randomUserTests() {
        UsersDataValues randomUserId = getRandomUserForId();
        val response = Requests.sendGetRequest(
                URL_USERS.getUrl(), "per_page", UsersDataValues.values().length, UsersResponseModel.class, response200Spec);
        assertGetRandomUser(response, randomUserId);
    }

    @Test
    @DisplayName("Проверка возвращаемого пользователя API users/{int}")
    @Description("Проверка пользователя")
    void randomUserTests1() {
        UsersDataValues randomUserId = getRandomUserForId();
        val response = Requests.sendGetRequest(
                URL_USERS.getUrl(), "/", UsersDataValues.values().length, UsersResponseModel.class, response200Spec);
        assertGetRandomUser(response, randomUserId);
    }

}
