package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage (WebDriver driver){
        this.driver = driver;
    }

    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath("//input[@name = 'Пароль']");
    private By buttonRegistration = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private By incorrectPassword = By.xpath("//p[contains(text(), 'Некорректный пароль')]");
    private By loginButton = By.className("Auth_link__1fOlj");

    @Step("Получить локатор поля Email, на странице регистрации")
    public By getEmailField() {
        return emailField;
    }

    @Step("Получить локатор Пароль, на странице регистрации")
    public By getPasswordField() {
        return passwordField;
    }

    @Step("Ответ типа boolean, отображается ли текст ошибки")
    public boolean isErrorDisplayed() {
        return driver.findElement(incorrectPassword).isDisplayed();
    }

    @Step("Получить локатор кнопки войти, на странице регистрации")
    public By getLoginButton() {
        return loginButton;
    }

    @Step("Ввести имя для регистрации")
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email для регистрации")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль для регистрации")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Нажать кнопку Войти со страницы регистрации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
