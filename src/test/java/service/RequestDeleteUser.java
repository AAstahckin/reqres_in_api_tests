package service;

import io.restassured.response.Response;

import static constans.Urls.URL_USER;
import static helpers.CustomsTextsSteps.deleteRequest;
import static specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestDeleteUser {

    public static String deleteUserUrl(int id) {
        return String.format(URL_USER.getUrl(), id);
    }

    public static Response sendDeleteUserRaw(int id) {
        return step(deleteRequest(deleteUserUrl(id)), () ->
                given(requestSpec)
                        .when()
                        .delete(deleteUserUrl(id))
                        .then()
                        .spec(response204Spec)
                        .extract()
                        .response());
    }

}
