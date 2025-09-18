package data;

import io.qameta.allure.Step;

public class AuthorizationUserModel {

    private String email;
    private String password;

    @Step("Получить email для авторизации")
    public String getEmail() {
        return email;
    }

    @Step("Задать email для авторизации")
    public AuthorizationUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Step("Получить пароль для авторизации")
    public String getPassword() {
        return password;
    }

    @Step("Задать пароль для авторизации")
    public AuthorizationUserModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
