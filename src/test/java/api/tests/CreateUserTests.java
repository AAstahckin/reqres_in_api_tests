package api.tests;

import api.models.CreateUsersBodyModel;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static api.data.TestDataValues.parameterizedNegativeData;
import static api.responseassertions.AssertionsResponseCreateUserApi.assertPositiveCreateUserApi;
import static api.service.RequestCreateUser.sendCreateUser;

@Story("Создание юзера")
@DisplayName("Создание юзера API POST /users")
public class CreateUserTests extends TestBase {

    CreateUsersBodyModel body = new CreateUsersBodyModel();
    static Faker faker = new Faker();

    @Test
    @DisplayName("Проверка создания пользователя")
    @Description("Позитивный сценарий")
    @Tag("sanity")
    public void positiveCreateUserTest() {
        body.setName(faker.name().firstName()).setJob(faker.job().position());
        val response = sendCreateUser(body);
        assertPositiveCreateUserApi(response, body);

    }

    @DisplayName("Негативный сценарий создания пользователя")
    @Description("Негативный сценарий")
    @ParameterizedTest(name = "[user: {0}; pass:{1}]")
    @MethodSource("submitIncorrectParameters")
    public void negativeLoginTest(String name, String job) {
        body.setName(name).setJob(job);
        val response = sendCreateUser(body);
        assertPositiveCreateUserApi(response, body);
    }

    private static Stream<Arguments> submitIncorrectParameters() {
        return parameterizedNegativeData();
    }

}
