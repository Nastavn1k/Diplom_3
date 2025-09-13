package steps;

import data.TestData;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    TestData testData;

    public LoginSteps (WebDriver driver){
        this.driver = driver;
        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.testData = new TestData(driver);
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной")
    public void clickButtonLoginInAccount() {
        driver.findElement(mainPage.getButtonLoginInAccount()).click();
    }

    @Step("Клик по кнопке 'Личный Кабинет' на главной")
    public void clickButtonPersonalAccount() {
        driver.findElement(mainPage.getButtonPersonalAccount()).click();
    }

    @Step("Клик по логотипу бургера")
    public void clickLogoBurger() {
        driver.findElement(loginPage.getLogoBurger());
    }

    @Step("Заполнение полей пользователя для входа")
    public void fillingFieldsForLogin(User user) {
        driver.findElement(registrationPage.getEmailField()).sendKeys(user.getRANDOM_EMAIL());
        driver.findElement(registrationPage.getPasswordField()).sendKeys(user.getRANDOM_PASSWORD());
    }

    @Step("Клик по кнопке 'Войти' на loginPage")
    public void clickButtonLoginOnLoginPage() {
        driver.findElement(loginPage.getButtonLogin()).click();
    }

    @Step("Проверка факта входа в аккаунт")
    public void checkLoginUser() {
        assertTrue("Вход в аккаунт не выполнен", driver.findElement(mainPage.getButtonCreateOrder()).isDisplayed());
    }

    @Step("Клик по кнопке 'Войти' на registrationPage")
    public void clickButtonLoginOnRegistrationPage() {
        driver.findElement(registrationPage.getLoginButton()).click();
    }

    @Step("Клик по кнопке 'Войти' в форме восстановления пароля")
    public void clickButtonLoginOnForgotPasswordPage() {
        driver.findElement(
                new ForgotPasswordPage(driver)
                        .getLoginButton()).click();
    }
}
