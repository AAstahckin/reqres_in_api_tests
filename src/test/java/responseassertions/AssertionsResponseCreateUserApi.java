package responseassertions;

import models.CreateUserResponseModel;
import models.CreateUsersBodyModel;

import static helpers.CustomsTextsSteps.matchingParameter;
import static utils.DateTimeCheck.timeDifferenceCreateForServ;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseCreateUserApi {

    public static void assertPositiveCreateUserApi(CreateUserResponseModel response, CreateUsersBodyModel userBody) {
        step(matchingParameter(userBody.getName()), () ->
                assertEquals(response.getName(), userBody.getName()));
        step(matchingParameter(userBody.getJob()), () ->
                assertEquals(response.getJob(), userBody.getJob()));
        step(matchingParameter(response.getId()), () ->
                assertNotNull(response.getId()));
        timeDifferenceCreateForServ(response.getCreatedAt());
    }

}
