package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static api.constans.Urls.URL_USER;
import static api.service.Requests.sendDeleteUserRequest;
import static api.specs.Specs.response204Spec;

@Story("Удаление пользователя")
@DisplayName("Удаление пользователя API DELETE users/")
public class DeleteUserTests extends TestBase {

    @Tag("sanity")
    @DisplayName("Удаление пользователя с id")
    @Description("Позитивный сценарий")
    @ParameterizedTest(name = " = {0}]")
    @ValueSource(strings = {"1", "1000", "10000", "test"})
    public void deleteUsersTests(String userId) {
        sendDeleteUserRequest(URL_USER.getUrl(), userId, response204Spec);
    }
}
