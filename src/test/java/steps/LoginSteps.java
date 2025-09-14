package steps;

import data.AuthorizationUserModel;
import data.TestData;
import data.User;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static io.restassured.RestAssured.given;
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

    @Step("Авторизация с применением существующих данных пользователя")
    public Response authorizationUserStep(User user) {
        String PATH_LOGIN_USER = "/api/auth/login";

        AuthorizationUserModel authorizationUserModel = new AuthorizationUserModel(driver)
                .setEmail(user.getRANDOM_EMAIL())
                .setPassword(user.getRANDOM_PASSWORD());

        return given()
                .log().all()
                .baseUri("https://stellarburgers.nomoreparties.site")
                .contentType(ContentType.JSON)
                .body(authorizationUserModel)
                .when()
                .post(PATH_LOGIN_USER)
                .then()
                .extract().response();
    }
}
