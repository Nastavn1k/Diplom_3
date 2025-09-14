package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserSteps {

    public static final String PATH_DELETE_USER = "/api/auth/user";

    @Step("Получить токен")
    public String findAccessToken(Response response) {
        return response.then()
                .extract().path("accessToken");
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken) {
        return given()
                .log().all()
                .baseUri("https://stellarburgers.nomoreparties.site")
                .header("Authorization", accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(PATH_DELETE_USER)
                .then()
                .extract().response();
    }

    @Step("Проверка успешного удаления пользователя")
    public void checkDeleteUser(Response response) {
        response.then()
                .statusCode(202)
                .body("success", equalTo(true));
    }
}
