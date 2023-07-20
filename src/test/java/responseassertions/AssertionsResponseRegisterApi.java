package responseassertions;

import models.RegisterResponseModel;
import io.restassured.response.Response;

import static constans.HttpStatus.BAD_REQUEST;
import static helpers.CustomsTextsSteps.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseRegisterApi {

    public static void assertPositiveRegisterApi(RegisterResponseModel response, int id) {
        step(matchingParameterId(id), () -> assertEquals(response.getId(), id));
        step(presentParameter("token"), () -> assertNotNull(response.getToken()));
    }

    public static void assertNegativeRegisterApi(Response response, String responseErrorText) {
        step(statusCodeResponse(BAD_REQUEST.getCode()), () ->
                assertEquals(response.statusCode(), BAD_REQUEST.getCode()));
        step(errorText(responseErrorText), () ->
                assertEquals(response.as(RegisterResponseModel.class).getError(), responseErrorText));
    }

}
