package api.responseassertions;

import api.models.CreateUserResponseModel;
import api.models.CreateUsersBodyModel;

import static api.helpers.CustomsTextsSteps.stepMatchingParameter;
import static api.utils.DateTimeCheck.timeDifferenceCreateForServ;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseCreateUserApi {

    public static void assertPositiveCreateUserApi(CreateUserResponseModel response, CreateUsersBodyModel userBody) {
        step(stepMatchingParameter(userBody.getName()), () ->
                assertEquals(response.getName(), userBody.getName()));
        step(stepMatchingParameter(userBody.getJob()), () ->
                assertEquals(response.getJob(), userBody.getJob()));
        step(stepMatchingParameter(response.getId()), () ->
                assertNotNull(response.getId()));
        timeDifferenceCreateForServ(response.getCreatedAt());
    }

}
