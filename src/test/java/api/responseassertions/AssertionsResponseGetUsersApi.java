package api.responseassertions;

import api.models.getuser.UserResponseModel;
import api.models.getusers.UsersResponseModel;
import api.data.UsersDataValues;

import static api.constans.OtherTexts.TEXT_SUPPORT;
import static api.constans.OtherTexts.URL_SUPPORT;
import static api.helpers.CustomsTextsSteps.stepMatchingParameter;
import static api.helpers.CustomsTextsSteps.stepMatchingParameterId;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsResponseGetUsersApi {

    public static void assertGetRandomUser(UsersResponseModel response, UsersDataValues randomUserId) {
        step(stepMatchingParameterId(response.getData().get(randomUserId.ordinal()).getId()), () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getId(), randomUserId.getId()));
        step(stepMatchingParameter(response.getData().get(randomUserId.ordinal()).getEmail()), () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getEmail(), randomUserId.getEmail()));
        step(stepMatchingParameter(response.getData().get(randomUserId.ordinal()).getFirstName()), () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getFirstName(), randomUserId.getFirstName()));
        step(stepMatchingParameter(response.getData().get(randomUserId.ordinal()).getLastName()), () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getLastName(), randomUserId.getLastName()));
        step(stepMatchingParameter(response.getData().get(randomUserId.ordinal()).getAvatar()), () ->
                assertEquals(response.getData().get(randomUserId.ordinal()).getAvatar(), randomUserId.getAvatar()));

    }

    public static void assertGetUser(UserResponseModel response, UsersDataValues randomUserId) {
        step(stepMatchingParameterId(response.getDataUserResponseModel().getId()), () ->
                assertEquals(response.getDataUserResponseModel().getId(), randomUserId.getId()));
        step(stepMatchingParameter(response.getDataUserResponseModel().getEmail()), () ->
                assertEquals(response.getDataUserResponseModel().getEmail(), randomUserId.getEmail()));
        step(stepMatchingParameter(response.getDataUserResponseModel().getFirstName()), () ->
                assertEquals(response.getDataUserResponseModel().getFirstName(), randomUserId.getFirstName()));
        step(stepMatchingParameter(response.getDataUserResponseModel().getLastName()), () ->
                assertEquals(response.getDataUserResponseModel().getLastName(), randomUserId.getLastName()));
        step(stepMatchingParameter(response.getDataUserResponseModel().getAvatar()), () ->
                assertEquals(response.getDataUserResponseModel().getAvatar(), randomUserId.getAvatar()));
        step(stepMatchingParameter(response.getUserSupportResponseModel().getUrl()), () ->
                assertEquals(response.getUserSupportResponseModel().getUrl(), URL_SUPPORT.getValue()));
        step(stepMatchingParameter(response.getUserSupportResponseModel().getText()), () ->
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
