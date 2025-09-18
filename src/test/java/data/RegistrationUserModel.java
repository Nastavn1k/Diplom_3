package data;

import io.qameta.allure.Step;

public class RegistrationUserModel {

    private String email;
    private String password;
    private String name;

    @Step("Получить email для регистрации")
    public String getEmail() {
        return email;
    }

    @Step("Задать email для регистрации")
    public RegistrationUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Step("Получить пароль для регистрации")
    public String getPassword() {
        return password;
    }

    @Step("Задать пароль для регистрации")
    public RegistrationUserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Step("Получить имя для регистрации")
    public String getName() {
        return name;
    }

    @Step("Задать имя для регистрации")
    public RegistrationUserModel setName(String name) {
        this.name = name;
        return this;
    }
}
