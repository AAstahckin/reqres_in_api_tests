package api;

import api.models.CreateUserResponseModel;
import api.models.CreateUsersBodyModel;
import api.service.Requests;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.specs.Specs.response201Spec;
import static api.utils.DateTimeCheck.timeDifferenceCreateForServ;
import static data.Urls.URL_USERS;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Создание юзера API /users")
public class CreateUserTests {

    CreateUsersBodyModel userBody = new CreateUsersBodyModel();
    Faker faker = new Faker();

    @Test
    @DisplayName("Проверка создания пользователя")
    @Description("Создание юзера")
    public void positiveCreateUserTest() {
        userBody.setName(faker.name().firstName()).setJob(faker.job().position());
        CreateUserResponseModel response = Requests.sendPostRequest(URL_USERS.getUrl(), userBody, CreateUserResponseModel.class, response201Spec);
        step("Проверяем что " + userBody.getName() + " присутствует в ответе ", () -> assertEquals(response.getName(), userBody.getName()));
        step("Проверяем что " + userBody.getJob() + " присутствует в ответе ", () -> assertEquals(response.getJob(), userBody.getJob()));
        step("Проверяем что " + response.getId() + " присутствует в ответе", () -> assertNotNull(response.getId()));
        timeDifferenceCreateForServ(response.getCreatedAt());
    }

}
