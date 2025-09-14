package steps;

import data.RegistrationUserModel;
import data.TestData;
import data.User;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationPage;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationSteps {

    private static final String PATH_CREATE_USER = "/api/auth/register";
    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    TestData testData;

    public RegistrationSteps (WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        testData = new TestData(driver);
    }

    @Step("Клик по кнопке 'Зарегистрироваться' на странице 'login'")
    public void clickButtonRegistrationOnLoginPage() {
        driver.findElement(loginPage.getButtonRegistration()).click();
    }

    @Step("Заполнение полей пользователя для регистрации")
    public void fillingFieldsForRegistration(User user) {
        driver.findElement(registrationPage.getNameField()).sendKeys(user.getRANDOM_NAME());
        driver.findElement(registrationPage.getEmailField()).sendKeys(user.getRANDOM_EMAIL());
        driver.findElement(registrationPage.getPasswordField()).sendKeys(user.getRANDOM_PASSWORD());
    }

    @Step("Заполнение полей пользователя для регистрации с неверным паролем")
    public void fillingFieldsForRegistrationWithWrongPassword(User user) {
        driver.findElement(registrationPage.getNameField()).sendKeys(user.getRANDOM_NAME());
        driver.findElement(registrationPage.getEmailField()).sendKeys(user.getRANDOM_EMAIL());
        driver.findElement(registrationPage.getPasswordField()).sendKeys(String.valueOf(testData.getRANDOM_WRONG_PASSWORD()));
    }

    @Step("Клик по кнопке 'Зарегистрироваться' на странице 'registration', с дальнейшей проверкой отображения нужного Url")
    public void clickButtonRegistrationOnRegistrationPage() {
        driver.findElement(registrationPage.getButtonRegistration()).click();
    }

    @Step("Проверка отображения нужного Url после регистрации")
    public void checkUrlAfterRegister() {
        testData.waitVisibility(loginPage.getButtonRegistration());
        assertEquals("Url не совпали при сравнении после регистрации", testData.getURL_LOGIN_PAGE(), driver.getCurrentUrl());
    }

    @Step("Проверка отображения ошибки для некорректного пароля")
    public void checkErrorForWrongPassword() {
        assertTrue("Текст ошибки не отображается", driver.findElement(registrationPage.getIncorrectPassword()).isDisplayed());
    }

    @Step("Создание нового пользователя")
    public Response createNewUser(User user) {
        RegistrationUserModel registrationUserModel = new RegistrationUserModel()
        .setEmail(user.getRANDOM_EMAIL())
        .setPassword(user.getRANDOM_PASSWORD())
        .setName(user.getRANDOM_NAME());

        return given()
                .log().all()
                .baseUri("https://stellarburgers.nomoreparties.site")
                .contentType(ContentType.JSON)
                .body(registrationUserModel)
                .when()
                .post(PATH_CREATE_USER)
                .then()
                .extract().response();
    }
}
