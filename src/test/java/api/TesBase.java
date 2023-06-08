package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TesBase {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }

}
