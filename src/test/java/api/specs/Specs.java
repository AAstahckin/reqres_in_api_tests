package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.helpers.CustomAllureListener.withCustomTemplates;
import static data.HttpStatus.*;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class Specs {

    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api");

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

    public static ResponseSpecification response400Spec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(BAD_REQUEST.getCode())
            .build();

}
