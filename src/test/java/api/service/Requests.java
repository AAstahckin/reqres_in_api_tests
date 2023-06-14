package api.service;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static api.specs.Specs.requestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Requests {
    public static <T> T sendGetRequest(String endpoint, Class<T> responseClass, ResponseSpecification responseSpecification) {
        Response response = step("Выполняется вызов метода GET, на " + endpoint, () -> given(requestSpec)
                .when().get(endpoint).then().spec(responseSpecification).extract().response());
        return response.as(responseClass);
    }


    public static <T> T sendPostRequest(String endpoint, Object body, Class<T> responseClass, ResponseSpecification responseSpecification) {
        Response response = step("Выполняется вызов метода POST, на " + endpoint, () -> given(requestSpec)
                .body(body)
                .when().post(endpoint).then().spec(responseSpecification).extract().response());
        return response.as(responseClass);
    }

}
