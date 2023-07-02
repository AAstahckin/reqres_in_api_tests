package api.tests;

import config.AppConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());
    static String login = config.getLogin();
    static String password = config.getPassword();

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = config.getBaseUrl();
        RestAssured.basePath = config.getBasePath();
    }


}
