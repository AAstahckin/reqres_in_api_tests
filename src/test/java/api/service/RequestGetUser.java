package api.service;

import api.models.getuser.UserResponseModel;
import io.restassured.response.Response;
import static api.constans.Urls.URL_USER;
import static api.specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestGetUser {

    public static String stepSendGetRequest(String value) {
        return String.format("Выполняется вызов метода GET, на %s", value);
    }

    public static String getUserUrl(int id) {
        return String.format(URL_USER.getUrl(), id);
    }

    public static UserResponseModel sendGetUser(int id) {
        return step(stepSendGetRequest(getUserUrl(id)), () ->
                given(requestSpec)
                        .when()
                        .get(getUserUrl(id))
                        .then()
                        .spec(response200Spec)
                        .extract()
                        .response()
                        .as(UserResponseModel.class));
    }

    public static Response sendGetRaw(int id) {
        return step(stepSendGetRequest(getUserUrl(id)), () ->
                given(requestSpec)
                        .when()
                        .get(getUserUrl(id))
                        .then().extract().response());
    }

}
