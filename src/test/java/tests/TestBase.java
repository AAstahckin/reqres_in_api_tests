package tests;

import config.ApiConfig;
import config.CredentialsConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
    static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    static String login = credentials.login();
    static String password = credentials.password();

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = config.baseUrl();
        RestAssured.basePath = config.basePath();
    }

}
