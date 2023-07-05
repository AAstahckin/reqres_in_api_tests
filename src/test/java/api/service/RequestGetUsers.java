package api.service;

import api.models.getusers.UsersResponseModel;

import java.util.Map;

import static api.constans.Urls.URL_USERS;
import static api.helpers.CustomsTextsSteps.getRequest;
import static api.specs.Specs.requestSpec;
import static api.specs.Specs.response200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestGetUsers {

    public static UsersResponseModel sendGetUsers(Map<String, Integer> queryParam) {
        return step(getRequest(URL_USERS.getUrl()), () ->
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

}
