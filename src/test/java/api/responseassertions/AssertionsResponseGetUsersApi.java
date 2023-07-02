package api.responseassertions;

import api.models.getuser.UserResponseModel;
import api.models.getusers.UsersResponseModel;
import data.UsersDataValues;
import io.qameta.allure.Allure;

import static api.constans.OtherTexts.TEXT_SUPPORT;
import static api.constans.OtherTexts.URL_SUPPORT;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsResponseGetUsersApi {

    public static void assertGetRandomUser(UsersResponseModel response, UsersDataValues randomUserId) {
        Allure.step("Проверяем пользователя с " + randomUserId.getId() + " id" );
        step("Проверяем что id соответствует ", () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getId(), randomUserId.getId()));
        step("Проверяем что email соответствует ", () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getEmail(), randomUserId.getEmail()));
        step("Проверяем что firstName соответствует ", () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getFirstName(), randomUserId.getFirstName()));
        step("Проверяем что lastName соответствует ", () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getLastName(), randomUserId.getLastName()));
        step("Проверяем что avatar соответствует ", () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getAvatar(), randomUserId.getAvatar()));

    }

    public static void assertGetUser(UserResponseModel response, UsersDataValues randomUserId) {
        Allure.step("Проверяем пользователя с " + randomUserId.getId() + " id" );
        step("Проверяем что id соответствует ", () ->
                assertEquals(response.getDataUserResponseModel().getId(), randomUserId.getId()));
        step("Проверяем что email соответствует ", () ->
                assertEquals(response.getDataUserResponseModel().getEmail(), randomUserId.getEmail()));
        step("Проверяем что firstName соответствует ", () ->
                assertEquals(response.getDataUserResponseModel().getFirstName(), randomUserId.getFirstName()));
        step("Проверяем что lastName соответствует ", () ->
                assertEquals(response.getDataUserResponseModel().getLastName(), randomUserId.getLastName()));
        step("Проверяем что avatar соответствует ", () ->
                assertEquals(response.getDataUserResponseModel().getAvatar(), randomUserId.getAvatar()));
        step("Проверяем что avatar соответствует ", () ->
                assertEquals(response.getUserSupportResponseModel().getUrl(), URL_SUPPORT.getValue()));
        step("Проверяем что avatar соответствует ", () ->
                assertEquals(response.getUserSupportResponseModel().getText(), TEXT_SUPPORT.getValue()));
    }

    public static void assertGetElementPage(UsersResponseModel response, int page, int count) {
        step("Проверяем колличество возвращаемых элементов" + count, () ->
                assertEquals(response.getData().size(), count));
        step("Проверяем что меняется page при запросе ?page=" + page, () ->
                assertEquals(response.getPage(), page));
    }

    public static void assertGetElementPerPage(UsersResponseModel response, UsersDataValues usersDataValues) {
        step("Проверяем колличество возвращаемых элементов", () ->
                assertEquals(response.getData().size(), usersDataValues.getId()));
        step("Проверяем что в ответе изменилось значение ключа per_page", () ->
                assertEquals(response.getPerPage(), usersDataValues.getId()));
        step("Проверяем что объекте support присутствует url : ", () ->
                assertEquals(response.getSupport().getUrl(), URL_SUPPORT.getValue()));
        step("Проверяем что объекте support присутствует text : ", () ->
                assertEquals(response.getSupport().getText(), TEXT_SUPPORT.getValue()));
    }

}
