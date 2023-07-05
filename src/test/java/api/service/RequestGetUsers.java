package api.service;

import api.models.getusers.UsersResponseModel;
import io.restassured.response.Response;
import java.util.Map;
import static api.constans.Urls.URL_USERS;
import static api.specs.Specs.requestSpec;
import static api.specs.Specs.response200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestGetUsers {

    public static String stepSendGetRequest(String value) {
        return String.format("Выполняется вызов метода GET, на %s", value);
    }

    public static UsersResponseModel sendGetUsers(Map<String, Integer> queryParam) {
        return step(stepSendGetRequest(URL_USERS.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .queryParams(queryParam)
                        .get(URL_USERS.getUrl())
                        .then()
                        .spec(response200Spec)
                        .extract()
                        .response()
                        .as(UsersResponseModel.class));
    }

    public static Response sendGetUsersRaw(Map<String, Integer> queryParam) {
        return step(stepSendGetRequest(URL_USERS.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .queryParams(queryParam)
                        .get(URL_USERS.getUrl())
                        .then().extract().response());
    }


}
