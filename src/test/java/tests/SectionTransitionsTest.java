package tests;

import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import steps.SectionTransitionsSteps;

import java.time.Duration;

public class SectionTransitionsTest {

    WebDriver driver;
    TestData testData;
    SectionTransitionsSteps sectionTransitionsSteps;
    MainPage mainPage;

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
        sectionTransitionsSteps = new SectionTransitionsSteps(driver);
        testData = new TestData(driver);
        testData.openMainPage();
        mainPage = new MainPage(driver);
    }

    @Test
    public void transitionsToSectionBun() {
        sectionTransitionsSteps.buttonToppingsClick();
        sectionTransitionsSteps.checkSectionToppings();
        sectionTransitionsSteps.buttonBunClick();
        testData.waitVisibilityAttribute(mainPage.getButtonBuns());
        sectionTransitionsSteps.checkSectionBun();
    }

    @Test
    public void transitionsToSectionSauces() {
        sectionTransitionsSteps.buttonToppingsClick();
        sectionTransitionsSteps.checkSectionToppings();
        sectionTransitionsSteps.buttonSaucesClick();
        testData.waitVisibilityAttribute(mainPage.getButtonSauces());
        sectionTransitionsSteps.checkSectionSauces();
    }

    @Test
    public void transitionsToSectionToppings() {
        sectionTransitionsSteps.buttonSaucesClick();
        sectionTransitionsSteps.checkSectionSauces();
        sectionTransitionsSteps.buttonToppingsClick();
        testData.waitVisibilityAttribute(mainPage.getButtonToppings());
        sectionTransitionsSteps.checkSectionToppings();
    }

    @After
    public void closeUp() {
        driver.quit();
    }
}
