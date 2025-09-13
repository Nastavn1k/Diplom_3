package pages;

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

    public By getNameField() {
        return nameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getButtonRegistration() {
        return buttonRegistration;
    }

    public By getIncorrectPassword() {
        return incorrectPassword;
    }

    public By getLoginButton() {
        return loginButton;
    }
}
