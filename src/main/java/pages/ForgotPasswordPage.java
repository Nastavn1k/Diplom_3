package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;

    public ForgotPasswordPage (WebDriver driver){
        this.driver = driver;
    }

    private By loginButton = By.className("Auth_link__1fOlj");

    public By getLoginButton() {
        return loginButton;
    }
}
