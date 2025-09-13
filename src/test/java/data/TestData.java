package data;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestData {

    public TestData(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    private Faker fakeData = new Faker();
    private final String URL_LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    private final int RANDOM_WRONG_PASSWORD = fakeData.number().numberBetween(10000, 99999);

    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    public void openRegisterPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    public void openForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }

    public void waitVisibility(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getURL_LOGIN_PAGE() {
        return URL_LOGIN_PAGE;
    }

    public int getRANDOM_WRONG_PASSWORD() {
        return RANDOM_WRONG_PASSWORD;
    }
}
