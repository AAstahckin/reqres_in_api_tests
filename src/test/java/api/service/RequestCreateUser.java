package api.service;

import api.models.CreateUserResponseModel;
import static api.constans.Urls.URL_USER;
import static api.constans.Urls.URL_USERS;
import static api.specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestCreateUser {

    public static String stepSendPostRequest(String value) {
        return String.format("Выполняется вызов метода POST, на %s", value);
    }

    public static CreateUserResponseModel sendCreateUser(Object body) {
        return step(stepSendPostRequest(URL_USERS.getUrl()), () ->
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
