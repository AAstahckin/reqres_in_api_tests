package api.specs;

import api.TestBase;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.helpers.CustomAllureListener.withCustomTemplates;
import static api.constans.HttpStatus.*;
import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class Specs extends TestBase {

    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON);

    public static ResponseSpecification response200Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(OK.getCode())
            .build();

    public static ResponseSpecification response201Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(CREATED.getCode())
            .build();

    public static ResponseSpecification response204Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(NO_CONTENT.getCode())
            .build();

    public static ResponseSpecification response400Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(BAD_REQUEST.getCode())
            .build();

    public static ResponseSpecification response404Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(NOT_FOUND.getCode())
            .build();

}
