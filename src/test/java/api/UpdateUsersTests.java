package api;

import api.models.*;
import api.service.Requests;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static api.constans.Urls.URL_USER;
import static api.specs.Specs.response200Spec;
import static api.utils.DateTimeCheck.timeDifferenceCreateForServ;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Изменения пользователя API /users/")
public class UpdateUsersTests {
    static CreateUsersBodyModel bodyModel = new CreateUsersBodyModel();
    static Faker faker = new Faker();

    @Test
    @DisplayName("Проверка изменения пользователя API /users/")
    @Description("Регистрация")
    public void positiveUpdateUserTest() {
        bodyModel.setName(faker.name().firstName()).setJob(faker.artist().name());
        val response = Requests.sendPutRequest(
                URL_USER.getUrl() + faker.random().nextInt(1,100), bodyModel, UpdateUserResponseModel.class, response200Spec);
        assertEquals(response.getName(), bodyModel.getName());
        assertEquals(response.getJob(), bodyModel.getJob());
        timeDifferenceCreateForServ(response.getUpdatedAt());

    }


    @DisplayName("Проверка негативных сценариев с изменением пользователя API /users/")
    @Description("Негативные сценарии")
    @ParameterizedTest(name = "Запрос с параметрами [Name = {0}, Job = {1}]")
    @MethodSource("checkOutputParamsForPage")
    public void negativeUpdateUserTests(String valueName,String valueJob) {
        bodyModel.setName(valueName).setJob(valueJob);
        val response = Requests.sendPutRequest(
                URL_USER.getUrl() + faker.random().nextInt(1,100), bodyModel, UpdateUserResponseModel.class, response200Spec);
        assertEquals(response.getName(), bodyModel.getName());
        assertEquals(response.getJob(), bodyModel.getJob());
        timeDifferenceCreateForServ(response.getUpdatedAt());
    }

    private static Stream<Arguments> checkOutputParamsForPage() {
        return Stream.of(
                Arguments.of("!@%&^%*(!@(&*", "()*^*&%&*^@)"),
                Arguments.of("КУАГУРУСУПЕР", "КУАГУРУСУПЕР"),
                Arguments.of("qa.guru super", "qa.guru super"),
                Arguments.of(" ", " "),
                Arguments.of("4124123", "41251253"));
    }

    @DisplayName("Проверка негативных сценариев с изменением пользователя API /users/")
    @Description("Негативные сценарии")
    @ParameterizedTest(name = "Запрос с параметрами [Name = {0}, Job = {1}]")
    @MethodSource("checkOutputParamsForPage1")
    public void negativeUpdateUserTests1(String valueName,String valueJob) {
        bodyModel.setName(valueName).setJob(valueJob);
        val response = Requests.sendPutRequest(
                URL_USER.getUrl() + faker.random().nextInt(1,100), bodyModel, UpdateUserResponseModel.class, response200Spec);
    }

    private static Stream<Arguments> checkOutputParamsForPage1() {
        return Stream.of(
                Arguments.of(null,faker.job().position()),
                Arguments.of(faker.job().position(), null),
                Arguments.of());
    }


}
