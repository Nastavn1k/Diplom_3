package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;

    public ForgotPasswordPage (WebDriver driver){
        this.driver = driver;
    }

    private By loginButton = By.className("Auth_link__1fOlj");

    @Step("Нажать кнопку Войти со страницы восстановления пароля")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
