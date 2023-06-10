package api.service;

import api.models.CreateUserResponseModel;
import api.models.LoginResponseModel;
import api.models.RegisterResponseModel;
import io.restassured.response.ValidatableResponse;
import static data.Urls.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Requests {
    public static LoginResponseModel postLoginRequest(Object body, int statusCode) {
        return  given()
                .contentType(JSON)
                .body(body)
                .when()
                .post(URL_LOGIN.getUrl())
                .then()
                .statusCode(statusCode)
                .extract().as(LoginResponseModel.class);
    }

    public static RegisterResponseModel postRegisterRequest(Object body, int statusCode) {
        return  given()
                .contentType(JSON)
                .body(body)
                .when()
                .post(URL_REGISTER.getUrl())
                .then()
                .statusCode(statusCode)
                .extract().as(RegisterResponseModel.class);
    }

    public static CreateUserResponseModel postCreateUserRequest(Object body, int statusCode) {
        return  given().log().uri()
                .log().body()
                .contentType(JSON)
                .body(body)
                .when()
                .post(URL_USERS.getUrl())
                .then()
                .statusCode(statusCode)
                .extract().as(CreateUserResponseModel.class);
    }

    public static ValidatableResponse getRequest(String url) {
        return  given()
                .when()
                .get(url)
                .then();
    }

}
