package api.tests;

import api.data.UsersDataValues;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static api.responseassertions.AssertionsResponseGetUsersApi.*;
import static api.service.RequestGetUsers.sendGetUsers;
import static api.utils.RandomUtils.getRandomUserForId;

@Story("Список пользователей")
@DisplayName("Список пользователей API GET /users?per_page= и /users?page=")
@Owner("Aleksey_Astashkin")
public class GetUsersTests extends TestBase {

    Map<String, Integer> queryParam = new HashMap<>();
    Faker faker = new Faker();

    @DisplayName("Список пользователей")
    @Description("Позитивный сценарий")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest(name = " /users?per_page")
    @EnumSource(value = UsersDataValues.class)
    public void testsGetUsersPerPage(UsersDataValues usersDataValues) {
        queryParam.put("per_page", usersDataValues.getId());
        val response = sendGetUsers(queryParam);
        assertGetElementPerPage(response, usersDataValues);
    }

    @DisplayName("Список пользователей")
    @Description("Позитивный сценарий")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest(name = " /users?page={0}")
    @MethodSource("checkOutputParamsForPage")
    public void testsGetUsersPage(int page, int count) {
        queryParam.put("page", page);
        val response = sendGetUsers(queryParam);
        assertGetElementPage(response, page, count);
    }

    private static Stream<Arguments> checkOutputParamsForPage() {
        return Stream.of(
                Arguments.of(1, 6),
                Arguments.of(2, 6));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка рандомного пользователя из списка")
    @Description("Проверка рандомного пользователя")
    @Tag("sanity")
    void randomUserTests() {
        val randomUserId = getRandomUserForId();
        queryParam.put("per_page", UsersDataValues.values().length);
        val response = sendGetUsers(queryParam);
        assertGetRandomUser(response, randomUserId);
    }

}
