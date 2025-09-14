package data;

import org.openqa.selenium.WebDriver;

public class AuthorizationUserModel {

    public AuthorizationUserModel(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public AuthorizationUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthorizationUserModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
