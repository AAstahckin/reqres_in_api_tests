package api.responseassertions;

import api.models.CreateUsersBodyModel;
import api.models.UpdateUserResponseModel;

import static api.utils.DateTimeCheck.timeDifferenceCreateForServ;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsResponseUpdateUsers {

    public static void assertUpdateUserTestApi(UpdateUserResponseModel response, CreateUsersBodyModel bodyModel) {
        step("Проверяем что Name соответствует", () ->
                assertEquals(response.getName(), bodyModel.getName()));
        step("Проверяем что Job соответствует", () ->
                assertEquals(response.getJob(), bodyModel.getJob()));
        timeDifferenceCreateForServ(response.getUpdatedAt());
    }

}
