package tests;

import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.SectionTransitionsSteps;

import java.time.Duration;

@RunWith(Parameterized.class)
public class SectionTransitionsTest {

    @Parameterized.Parameter()
    public String browser;

    WebDriver driver;
    TestData testData;
    SectionTransitionsSteps sectionTransitionsSteps;

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"yandex"},
                {"chrome"}
        };
    }

    @Before
    public void setUp() {
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
    }

    @Test
    public void transitionsToSectionBun() {
        sectionTransitionsSteps.buttonToppingsClick();
        sectionTransitionsSteps.checkSectionToppings();
        sectionTransitionsSteps.buttonBunClick();
        sectionTransitionsSteps.checkSectionBun();
    }

    @Test
    public void transitionsToSectionSauces() {
        sectionTransitionsSteps.buttonToppingsClick();
        sectionTransitionsSteps.checkSectionToppings();
        sectionTransitionsSteps.buttonSaucesClick();
        sectionTransitionsSteps.checkSectionSauces();
    }

    @Test
    public void transitionsToSectionToppings() {
        sectionTransitionsSteps.buttonSaucesClick();
        sectionTransitionsSteps.checkSectionSauces();
        sectionTransitionsSteps.buttonToppingsClick();
        sectionTransitionsSteps.checkSectionToppings();
    }

    @After
    public void closeUp() {
        driver.quit();
    }
}
