package data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class User {

    private Faker fakeData = new Faker();
    private final String RANDOM_NAME = fakeData.name().firstName();
    private final String RANDOM_EMAIL = fakeData.name().firstName() + "." + System.currentTimeMillis() + "@yandex.ru";
    private final String RANDOM_PASSWORD = "1234" + System.currentTimeMillis();

    @Step("Получить рандомное имя юзера")
    public String getRANDOM_NAME() {
        return RANDOM_NAME;
    }

    @Step("Получить рандомный email юзера")
    public String getRANDOM_EMAIL() {
        return RANDOM_EMAIL;
    }

    @Step("Получить рандомный пароль юзера")
    public String getRANDOM_PASSWORD() {
        return RANDOM_PASSWORD;
    }
}
