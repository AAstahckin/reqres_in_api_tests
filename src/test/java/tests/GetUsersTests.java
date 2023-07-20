package tests;

import data.UsersDataValues;
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

import static data.TestDataValues.getUsersOutputParamsForPage;
import static responseassertions.AssertionsResponseGetUsersApi.*;
import static service.RequestGetUsers.sendGetUsers;
import static utils.RandomUtils.getRandomUserForId;

@Story("Список пользователей")
@DisplayName("Список пользователей API GET /users?per_page= и /users?page=")
@Owner("Aleksey_Astashkin")
public class GetUsersTests extends TestBase {

    Map<String, Integer> queryParam = new HashMap<>();

    @DisplayName("Список пользователей")
    @Description("Позитивный сценарий")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest(name = " /users?per_page")
    @EnumSource(value = UsersDataValues.class)
    public void getUsersPerPageTest(UsersDataValues usersDataValues) {
        queryParam.put("per_page", usersDataValues.getId());
        val response = sendGetUsers(queryParam);
        assertGetElementPerPage(response, usersDataValues);
    }

    @DisplayName("Список пользователей")
    @Description("Позитивный сценарий")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest(name = " /users?page={0}")
    @MethodSource("checkOutputParamsForPage")
    public void getUsersPageTest(int page, int count) {
        queryParam.put("page", page);
        val response = sendGetUsers(queryParam);
        assertGetElementPage(response, page, count);
    }

    private static Stream<Arguments> checkOutputParamsForPage() {
        return getUsersOutputParamsForPage();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка рандомного пользователя из списка")
    @Description("Проверка рандомного пользователя")
    @Tag("sanity")
    void checkRandomUserTest() {
        val randomUserId = getRandomUserForId();
        queryParam.put("per_page", UsersDataValues.values().length);
        val response = sendGetUsers(queryParam);
        assertGetRandomUser(response, randomUserId);
    }

}
