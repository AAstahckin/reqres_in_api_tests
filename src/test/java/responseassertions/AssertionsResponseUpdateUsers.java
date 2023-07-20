package responseassertions;

import models.CreateUsersBodyModel;
import models.UpdateUserResponseModel;

import static helpers.CustomsTextsSteps.matchingParameter;
import static utils.DateTimeCheck.timeDifferenceCreateForServ;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsResponseUpdateUsers {

    public static void assertUpdateUserTestApi(UpdateUserResponseModel response, CreateUsersBodyModel body) {
        step(matchingParameter(body.getName()), () ->
                assertEquals(response.getName(), body.getName()));
        step(matchingParameter(body.getJob()), () ->
                assertEquals(response.getJob(), body.getJob()));
        timeDifferenceCreateForServ(response.getUpdatedAt());
    }

}
