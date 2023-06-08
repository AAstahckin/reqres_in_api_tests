package api;

import api.service.Requests;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static data.Urls.URL_USERS;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTests extends TesBase{

    @Test
    public void positiveGetUsersTest() {
        ValidatableResponse response = Requests.getRequest(URL_USERS.getUrl() + "/" + 2);
        response.statusCode(200);
        response.assertThat().body("data.id", equalTo(2));
        response.assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
        response.assertThat().body("data.first_name", equalTo("Janet"));
        response.assertThat().body("data.last_name", equalTo("Weaver"));
        response.assertThat().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
    }

    @Test
    public void negativeGetUsersTestInt() {
        ValidatableResponse response = Requests.getRequest(URL_USERS.getUrl() + "/" + 3332);
        response.statusCode(404);
    }

    @Test
    public void negativeGetUsersTestString() {
        ValidatableResponse response = Requests.getRequest(URL_USERS.getUrl() + "/test");
        response.statusCode(404);
    }

}
