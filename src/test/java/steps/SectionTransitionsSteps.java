package steps;

import data.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SectionTransitionsSteps {

    WebDriver driver;
    MainPage mainPage;
    TestData testData;

    public SectionTransitionsSteps(WebDriver driver) {
        this.driver = driver;
        this.mainPage = new MainPage(driver);
        testData = new TestData(driver);
    }

    @Step("Клик по кнопке 'Булки'")
    public void buttonBunClick() {
        mainPage.clickBunsButton();
    }

    @Step("Клик по кнопке 'Соусы'")
    public void buttonSaucesClick() {
        mainPage.clickSaucesButton();
    }

    @Step("Клик по кнопке 'Начинки'")
    public void buttonToppingsClick() {
        mainPage.clickFillingsButton();
    }

    @Step("Проверка что раздел 'Булки' активен")
    public void checkSectionBun() {
        assertTrue("раздел 'Булки' неактивен", mainPage.isBunsSectionDisplayed());
    }

    @Step("Проверка что раздел 'Соусы' активен")
    public void checkSectionSauces() {
        assertTrue("раздел 'Соусы' неактивен", mainPage.isSaucesSectionDisplayed());
    }

    @Step("Проверка что раздел 'Начинки' активен")
    public void checkSectionToppings() {
        assertTrue("раздел 'Начинки' неактивен", mainPage.isToppingsSectionDisplayed());
    }
}
