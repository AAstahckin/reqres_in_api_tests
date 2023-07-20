package service;

import models.CreateUserResponseModel;

import static constans.Urls.URL_USER;
import static constans.Urls.URL_USERS;
import static helpers.CustomsTextsSteps.postRequest;
import static specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestCreateUser {

    public static CreateUserResponseModel sendCreateUser(Object body) {
        return step(postRequest(URL_USERS.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .body(body)
                        .post(URL_USER.getUrl())
                        .then()
                        .spec(response201Spec)
                        .extract()
                        .response()
                        .as(CreateUserResponseModel.class));
    }

}
