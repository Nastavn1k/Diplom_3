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

public class RegistrationTest {

    private WebDriver driver;
    private LoginSteps loginSteps;
    private RegistrationSteps registrationSteps;
    private TestData testData;
    private User user;
    private Response response;

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
    }

    @Test
    public void correctRegistrationTest() {
        loginSteps.clickButtonLoginInAccount();
        registrationSteps.clickButtonRegistrationOnLoginPage();
        registrationSteps.fillingFieldsForRegistration(user);
        registrationSteps.clickButtonRegistrationOnRegistrationPage();
        registrationSteps.checkUrlAfterRegister();
    }

    @Test
    public void registrationTestWithWrongPassword() {
        loginSteps.clickButtonLoginInAccount();
        registrationSteps.clickButtonRegistrationOnLoginPage();
        registrationSteps.fillingFieldsForRegistrationWithWrongPassword(user);
        registrationSteps.clickButtonRegistrationOnRegistrationPage();
        registrationSteps.checkErrorForWrongPassword();
    }

    @After
    public void closeUp() {
        String accessToken;
        DeleteUserSteps deleteUserSteps = new DeleteUserSteps();
        response =
                loginSteps.authorizationUserStep(user);
        accessToken =
                deleteUserSteps.findAccessToken(response);
        if (accessToken != null) {
            response =
                    deleteUserSteps.deleteUser(accessToken);
            deleteUserSteps.checkDeleteUser(response);
        }
        driver.quit();
    }
}