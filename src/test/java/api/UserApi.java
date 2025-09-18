package api;

import data.AuthorizationUserModel;
import data.RegistrationUserModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String PATH_CREATE_USER = "/api/auth/register";
    public static final String PATH_DELETE_USER = "/api/auth/user";
    public static final String PATH_LOGIN_USER = "/api/auth/login";

    @Step("API: Зарегистрировать нового пользователя")
    public Response registerUser(RegistrationUserModel registrationUserModel) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(registrationUserModel)
                .when()
                .post(PATH_CREATE_USER)
                .then()
                .extract().response();
    }

    @Step("API: Авторизовать пользователя")
    public Response loginUser(AuthorizationUserModel authorizationUserModel) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(authorizationUserModel)
                .when()
                .post(PATH_LOGIN_USER)
                .then()
                .extract().response();
    }

    @Step("API: Удалить пользователя")
    public Response deleteUser(String accessToken) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .header("Authorization", accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(PATH_DELETE_USER)
                .then()
                .extract().response();
    }
}