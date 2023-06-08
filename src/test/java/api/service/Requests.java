package api.service;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Requests {

    public static ValidatableResponse postRequest(Object body, String url) {
        return  given()
                .contentType(JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .log().status()
                .log().body();
    }

    public static ValidatableResponse getRequest(String url) {
        return  given()
                .when()
                .get(url)
                .then();
    }

}
