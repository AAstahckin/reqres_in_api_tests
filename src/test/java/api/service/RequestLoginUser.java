package api.service;

import api.models.LoginResponseModel;
import io.restassured.response.Response;
import static api.constans.Urls.URL_LOGIN;
import static api.specs.Specs.requestSpec;
import static api.specs.Specs.response200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestLoginUser {

    public static String stepSendPostRequest(String value) {
        return String.format("Выполняется вызов метода POST, на %s", value);
    }

    public static LoginResponseModel sendLogin(Object body) {
        return step(stepSendPostRequest(URL_LOGIN.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .body(body)
                        .post(URL_LOGIN.getUrl())
                        .then()
                        .spec(response200Spec)
                        .extract()
                        .response()
                        .as(LoginResponseModel.class));
    }

    public static Response sendLoginRaw(Object body) {
        return step(stepSendPostRequest(URL_LOGIN.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .body(body)
                        .post(URL_LOGIN.getUrl())
                        .then().extract().response());
    }

}
