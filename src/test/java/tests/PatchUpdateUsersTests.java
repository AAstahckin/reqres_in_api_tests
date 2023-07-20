package tests;

import models.CreateUsersBodyModel;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static data.TestDataValues.parameterizedNegativeData;
import static responseassertions.AssertionsResponseUpdateUsers.assertUpdateUserTestApi;
import static service.RequestUpdateUser.patchUpdateUser;

@Story("Изменение пользователя")
@DisplayName("Изменение пользователя API PUT /users/id")
@Owner("Aleksey_Astashkin")
public class PatchUpdateUsersTests extends TestBase {

    CreateUsersBodyModel body = new CreateUsersBodyModel();
    Faker faker = new Faker();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("sanity")
    @DisplayName("Изменение пользователя")
    @Description("ПозитивнВ сценарий")
    public void positiveUpdateUserTest() {
        body.setName(faker.name().firstName()).setJob(faker.artist().name());
        val response = patchUpdateUser(body, faker.random().nextInt(1, 100));
        assertUpdateUserTestApi(response, body);

    }

    @DisplayName("Негативный сценарий изменения пользователя ")
    @Description("Негативный сценарии")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest(name = "[Name = {0}, Job = {1}]")
    @MethodSource("checkOutputParamsForPage")
    public void negativeUpdateUserTests(String valueName, String valueJob) {
        body.setName(valueName).setJob(valueJob);
        val response = patchUpdateUser(body, faker.random().nextInt(1, 100));
        assertUpdateUserTestApi(response, body);
    }

    private static Stream<Arguments> checkOutputParamsForPage() {
        return parameterizedNegativeData();
    }

}
