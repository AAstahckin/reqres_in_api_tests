package api;

import api.models.getuser.UserResponseModel;
import api.models.getusers.UsersResponseModel;
import api.service.Requests;
import data.UsersDataValues;
import io.qameta.allure.Description;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.constans.Urls.URL_USER;
import static api.responseassertions.AssertionsResponseGetUsersApi.assertGetUser;
import static api.specs.Specs.response200Spec;
import static api.specs.Specs.response404Spec;
import static api.utils.RandomUtils.getRandomUserForId;

@DisplayName("Получение пользователя API GET users/")
public class GetUserTests extends TestBase {

    @Test
    @DisplayName("Получить рандомного пользователя по id")
    @Description("Позитивный сценарий")
    public void positiveTestGetUser() {
        UsersDataValues randomUserId = getRandomUserForId();
        val response = Requests.sendGetRequestGetUser(
                URL_USER.getUrl() + randomUserId.getId(), UserResponseModel.class, response200Spec);
        assertGetUser(response, randomUserId);

    }

    @DisplayName("Запрос с queryParam")
    @Description("Негативный сценарий")
    @ParameterizedTest(name = "[{0}]")
    @ValueSource(strings = {"100", "0", "test", "%"})
    public void negativeTestGetUser(String value) {
        Requests.sendGetRequestGetUser(URL_USER.getUrl() + value, UsersResponseModel.class, response404Spec);
    }

}
