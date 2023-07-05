package api.service;

import api.models.UpdateUserResponseModel;
import static api.constans.Urls.URL_USER;
import static api.specs.Specs.requestSpec;
import static api.specs.Specs.response200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestUpdateUser {

    public static String stepSendPutRequest(String value) {
        return String.format("Выполняется вызов метода PUT, на %s", value);
    }

    public static String getUserUrl(int id) {
        return String.format(URL_USER.getUrl(), id);
    }

    public static UpdateUserResponseModel sendUpdateUser(Object body, int userId) {
        return step(stepSendPutRequest(getUserUrl(userId)), () ->
                given(requestSpec)
                        .when()
                        .body(body)
                        .put(getUserUrl(userId))
                        .then()
                        .spec(response200Spec)
                        .extract()
                        .response()
                        .as(UpdateUserResponseModel.class));
    }

}
