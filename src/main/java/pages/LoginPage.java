package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    private By buttonRegistration = By.xpath("//a[@href='/register']");
    private By logoBurger = By.className("AppHeader_header__logo__2D0X2");
    private By buttonLogin = By.xpath("//button[contains(@class, 'button_button__33qZ0')]");

    public By getButtonRegistration() {
        return buttonRegistration;
    }

    public By getLogoBurger() {
        return logoBurger;
    }

    public By getButtonLogin() {
        return buttonLogin;
    }
}
