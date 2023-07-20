package tests;

import io.qameta.allure.*;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static constans.HttpStatus.NO_CONTENT;
import static service.RequestDeleteUser.sendDeleteUserRaw;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Story("Удаление пользователя")
@DisplayName("Удаление пользователя API DELETE users/")
@Owner("Aleksey_Astashkin")
public class DeleteUserTests extends TestBase {

    @Tag("sanity")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление пользователя с id")
    @Description("Позитивный сценарий")
    @ParameterizedTest(name = " = [{0}]")
    @ValueSource(strings = {"100", "0", "-1", "-2147483648", "2147483647"})
    public void deleteUserTest(int userId) {
        val response = sendDeleteUserRaw(userId);
        assertEquals(response.statusCode(), NO_CONTENT.getCode());
    }

}
