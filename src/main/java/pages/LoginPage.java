package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    private By buttonRegistration = By.xpath("//a[@href='/register']");
    private By buttonLogin = By.xpath("//button[contains(@class, 'button_button__33qZ0')]");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath("//input[@name = 'Пароль']");
    private By loginButton = By.xpath("//button[contains(text(), 'Войти')]");

    @Step("Получить локатор кнопки регистрации, на странице входа")
    public By getButtonRegistration() {
        return buttonRegistration;
    }

    @Step("Получить локатор кнопки войти на странице входа")
    public By getButtonLogin() {
        return buttonLogin;
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
