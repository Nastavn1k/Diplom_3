package steps;

import api.UserApi;
import data.AuthorizationUserModel;
import data.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ForgotPasswordPage forgotPasswordPage;
    private UserApi userApi;

    public LoginSteps (WebDriver driver){
        this.driver = driver;
        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
        this.userApi = new UserApi();
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной")
    public void clickButtonLoginInAccount() {
        mainPage.clickButtonLogin();
    }

    @Step("Клик по кнопке 'Личный Кабинет' на главной")
    public void clickButtonPersonalAccount() {
        mainPage.clickPersonalAccount();
    }

    @Step("Заполнение полей пользователя для входа")
    public void fillingFieldsForLogin(User user) {
        loginPage.enterEmail(user.getRANDOM_EMAIL());
        loginPage.enterPassword(user.getRANDOM_PASSWORD());
    }

    @Step("Клик по кнопке 'Войти' на loginPage")
    public void clickButtonLoginOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Step("Проверка факта входа в аккаунт")
    public void checkLoginUser() {
        assertTrue("Вход в аккаунт не выполнен", mainPage.isVisibleCreateOrder());
    }

    @Step("Клик по кнопке 'Войти' на registrationPage")
    public void clickButtonLoginOnRegistrationPage() {
        registrationPage.clickLoginButton();
    }

    @Step("Клик по кнопке 'Войти' в форме восстановления пароля")
    public void clickButtonLoginOnForgotPasswordPage() {
        forgotPasswordPage.clickLoginButton();
    }

    @Step("Авторизация с применением существующих данных пользователя")
    public Response authorizationUserStep(User user) {

        AuthorizationUserModel authorizationUserModel = new AuthorizationUserModel()
                .setEmail(user.getRANDOM_EMAIL())
                .setPassword(user.getRANDOM_PASSWORD());

        return userApi.loginUser(authorizationUserModel);
    }
}
