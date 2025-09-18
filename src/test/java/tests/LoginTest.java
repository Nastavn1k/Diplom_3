package tests;

import data.TestData;
import data.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.DeleteUserSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginSteps loginSteps;
    TestData testData;
    RegistrationSteps registrationSteps;
    User user;
    Response response;

    @Before
    public void setUp() {

        String browser = System.getProperty("browser", "chrome");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\yandexdriver.exe");
            options.setBinary("C:\\Users\\user\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        }
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new User();
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        testData = new TestData(driver);
        testData.openMainPage();
        response =
                registrationSteps.createNewUser(user);
    }

    @Test
    public void loginUsingButtonMainPageTest() {
        loginSteps.clickButtonLoginInAccount();
        loginSteps.fillingFieldsForLogin(user);
        loginSteps.clickButtonLoginOnLoginPage();
        loginSteps.checkLoginUser();
    }

    @Test
    public void loginUsingButtonPersonalAccountOnMainPageTest() {
        loginSteps.clickButtonPersonalAccount();
        loginSteps.fillingFieldsForLogin(user);
        loginSteps.clickButtonLoginOnLoginPage();
        loginSteps.checkLoginUser();
    }

    @Test
    public void loginUsingButtonOnRegistrationPageTest() {
        testData.openRegisterPage();
        loginSteps.clickButtonLoginOnRegistrationPage();
        loginSteps.fillingFieldsForLogin(user);
        loginSteps.clickButtonLoginOnLoginPage();
        loginSteps.checkLoginUser();
    }

    @Test
    public void loginUsingButtonOnForgotPasswordPageTest() {
        testData.openForgotPasswordPage();
        loginSteps.clickButtonLoginOnForgotPasswordPage();
        loginSteps.fillingFieldsForLogin(user);
        loginSteps.clickButtonLoginOnLoginPage();
        loginSteps.checkLoginUser();
    }

    @After
    public void closeUp() {
        DeleteUserSteps deleteUserSteps = new DeleteUserSteps();
        String accessToken = deleteUserSteps.findAccessToken(response);
        if (accessToken != null) {
            response =
                    deleteUserSteps.deleteUser(accessToken);
            deleteUserSteps.checkDeleteUser(response);
        }
        driver.quit();
    }
}