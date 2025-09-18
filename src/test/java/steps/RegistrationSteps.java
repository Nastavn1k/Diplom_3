package steps;

import api.UserApi;
import data.RegistrationUserModel;
import data.TestData;
import data.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private TestData testData;
    private UserApi userApi;

    public RegistrationSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.testData = new TestData(driver);
        this.userApi = new UserApi();
    }

    @Step("Клик по кнопке 'Зарегистрироваться' на странице 'login'")
    public void clickButtonRegistrationOnLoginPage() {
        loginPage.clickRegistrationButton();
    }

    @Step("Заполнение полей пользователя для регистрации")
    public void fillingFieldsForRegistration(User user) {
        registrationPage.enterName(user.getRANDOM_NAME());
        registrationPage.enterEmail(user.getRANDOM_EMAIL());
        registrationPage.enterPassword(user.getRANDOM_PASSWORD());
    }

    @Step("Заполнение полей пользователя для регистрации с неверным паролем")
    public void fillingFieldsForRegistrationWithWrongPassword(User user) {
        registrationPage.enterName(user.getRANDOM_NAME());
        registrationPage.enterEmail(user.getRANDOM_EMAIL());
        registrationPage.enterPassword(String.valueOf(testData.getRANDOM_WRONG_PASSWORD()));
    }

    @Step("Клик по кнопке 'Зарегистрироваться' на странице 'registration', с дальнейшей проверкой отображения нужного Url")
    public void clickButtonRegistrationOnRegistrationPage() {
        registrationPage.clickRegistrationButton();
    }

    @Step("Проверка отображения нужного Url после регистрации")
    public void checkUrlAfterRegister() {
        testData.waitVisibility(loginPage.getButtonRegistration());
        assertEquals("Url не совпали при сравнении после регистрации", testData.getURL_LOGIN_PAGE(), driver.getCurrentUrl());
    }

    @Step("Проверка отображения ошибки для некорректного пароля")
    public void checkErrorForWrongPassword() {
        assertTrue("Текст ошибки не отображается", registrationPage.isErrorDisplayed());
    }

    @Step("Создание нового пользователя")
    public Response createNewUser(User user) {
        RegistrationUserModel registrationUserModel = new RegistrationUserModel()
                .setEmail(user.getRANDOM_EMAIL())
                .setPassword(user.getRANDOM_PASSWORD())
                .setName(user.getRANDOM_NAME());

        return userApi.registerUser(registrationUserModel);
    }
}
