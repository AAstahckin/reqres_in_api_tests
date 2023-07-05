package api.service;

import io.restassured.response.Response;
import static api.constans.Urls.URL_USER;
import static api.specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class RequestDeleteUser {

    public static String stepSendDeleteRequest(String value) {
        return String.format("Выполняется вызов метода DELETE, на %s", value);
    }

    public static String deleteUserUrl(int id) {
        return String.format(URL_USER.getUrl(), id);
    }

    public static Response sendDeleteUserRaw(int id) {
        return step(stepSendDeleteRequest(deleteUserUrl(id)), () ->
                given(requestSpec)
                        .when()
                        .delete(deleteUserUrl(id))
                        .then()
                        .spec(response204Spec)
                        .extract()
                        .response());
    }

}
