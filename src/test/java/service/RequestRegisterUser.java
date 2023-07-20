package service;

import models.RegisterResponseModel;
import io.restassured.response.Response;

import static constans.Urls.*;
import static helpers.CustomsTextsSteps.postRequest;
import static specs.Specs.requestSpec;
import static specs.Specs.response200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestRegisterUser {

    public static RegisterResponseModel sendRegisterUser(Object body) {
        return step(postRequest(URL_REGISTER.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .body(body)
                        .post(URL_REGISTER.getUrl())
                        .then()
                        .spec(response200Spec)
                        .extract()
                        .response()
                        .as(RegisterResponseModel.class));
    }

    public static Response sendRegisterUserRaw(Object body) {
        return step(postRequest(URL_REGISTER.getUrl()), () ->
                given(requestSpec)
                        .when()
                        .body(body)
                        .post(URL_REGISTER.getUrl())
                        .then().extract().response());
    }

}
