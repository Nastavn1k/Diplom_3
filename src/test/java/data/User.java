package data;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

public class User {

    public User(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    private Faker fakeData = new Faker();
    private final String RANDOM_NAME = fakeData.name().firstName();
    private final String RANDOM_EMAIL = fakeData.name().firstName() + "." + System.currentTimeMillis() + "@yandex.ru";
    private final String RANDOM_PASSWORD = "1234" + System.currentTimeMillis();

    public String getRANDOM_NAME() {
        return RANDOM_NAME;
    }

    public String getRANDOM_EMAIL() {
        return RANDOM_EMAIL;
    }

    public String getRANDOM_PASSWORD() {
        return RANDOM_PASSWORD;
    }
}
