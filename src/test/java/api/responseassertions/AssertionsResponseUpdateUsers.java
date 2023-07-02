package api.responseassertions;

import api.models.CreateUsersBodyModel;
import api.models.RegisterResponseModel;
import api.models.UpdateUserResponseModel;

import static api.utils.DateTimeCheck.timeDifferenceCreateForServ;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsResponseUpdateUsers {

    public static void assertUpdateUserTestApi(UpdateUserResponseModel response, CreateUsersBodyModel bodyModel) {
        step("Проверяем что присутствует параметр " + response.getName() + " в ответе", () ->
                assertEquals(response.getName(), bodyModel.getName()));
        step("Проверяем что присутствует " + response.getJob() + " в ответе", () ->
                assertEquals(response.getJob(), bodyModel.getJob()));
        timeDifferenceCreateForServ(response.getUpdatedAt());
    }

}
