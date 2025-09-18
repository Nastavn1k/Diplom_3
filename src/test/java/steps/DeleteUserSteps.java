package steps;

import api.UserApi;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUserSteps {

    private UserApi userApi = new UserApi();

    @Step("Получить токен")
    public String findAccessToken(Response response) {
        return response.then()
                .extract().path("accessToken");
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken) {
        return userApi.deleteUser(accessToken);
    }

    @Step("Проверка успешного удаления пользователя")
    public void checkDeleteUser(Response response) {
        response.then()
                .statusCode(202)
                .body("success", equalTo(true));
    }
}
