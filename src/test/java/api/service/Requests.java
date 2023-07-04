package api.service;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import lombok.val;

import static api.specs.Specs.requestSpec;
import static api.specs.Specs.response204Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Requests {

    public static <T> T sendGetRequestGetUser(String endpoint, Class<T> responseClass, ResponseSpecification responseSpecification) {
        val response = step("Выполняется вызов метода GET, на " + endpoint, () -> given(requestSpec)
                .when().get(endpoint).then().spec(responseSpecification).extract().response());
        return response.as(responseClass);
    }

    public static <T> T sendGetRequest(String endpoint, String queryParam, int queryParamValue, Class<T> responseClass, ResponseSpecification responseSpecification) {
        val response = step("Выполняется вызов метода GET, на " + endpoint, () -> given(requestSpec)
                .queryParam(queryParam, queryParamValue)
                .when().get(endpoint).then().spec(responseSpecification).extract().response());
        return response.as(responseClass);
    }


    public static <T> T sendPostRequest(String endpoint, Object body, Class<T> responseClass, ResponseSpecification responseSpecification) {
        val response = step("Выполняется вызов метода POST, на " + endpoint, () -> given(requestSpec)
                .body(body)
                .when().post(endpoint).then().spec(responseSpecification).extract().response());
        return response.as(responseClass);
    }

    public static <T> T sendPutRequest(String endpoint, Object body, Class<T> responseClass, ResponseSpecification responseSpecification) {
        val response = step("Выполняется вызов метода PUT, на " + endpoint, () -> given(requestSpec)
                .body(body)
                .when().put(endpoint).then().spec(responseSpecification).extract().response());
        return response.as(responseClass);
    }

    public static ValidatableResponse sendDeleteUserRequest(String endpoint, String userId, ResponseSpecification responseSpecification) {
        return step("Выполняется вызов метода DELETE, на " + endpoint + userId, () -> given(requestSpec)
                .when().delete(endpoint + userId).then().spec(responseSpecification));
    }

}
