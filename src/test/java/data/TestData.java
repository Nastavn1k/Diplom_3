package data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
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

    @Step("Открыть главную страницу")
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Step("Открыть страницу регистрации")
    public void openRegisterPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Step("Открыть страницу 'Восстановление пароля'")
    public void openForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }

    @Step("Явное ожидание видимости элемента")
    public void waitVisibility(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Явное ожидание отображения атрибута класса")
    public void waitVisibilityAttribute(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(locator, "class", "tab_tab_type_current__2BEPc"));
    }

    @Step("Получить адрес страницы входа")
    public String getURL_LOGIN_PAGE() {
        return URL_LOGIN_PAGE;
    }

    @Step("Получить неверный рандомный пароль")
    public int getRANDOM_WRONG_PASSWORD() {
        return RANDOM_WRONG_PASSWORD;
    }
}
