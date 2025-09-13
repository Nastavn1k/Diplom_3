package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SectionTransitionsSteps {

    WebDriver driver;
    MainPage mainPage;

    public SectionTransitionsSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    @Step("Клик по кнопке 'Булки'")
    public void buttonBunClick() {
        driver.findElement(mainPage.getButtonBuns()).click();
    }

    @Step("Клик по кнопке 'Соусы'")
    public void buttonSaucesClick() {
        driver.findElement(mainPage.getButtonSauces()).click();
    }

    @Step("Клик по кнопке 'Начинки'")
    public void buttonToppingsClick() {
        driver.findElement(mainPage.getButtonToppings()).click();
    }

    @Step("Проверка что раздел 'Булки' активен")
    public void checkSectionBun() {
        assertTrue("раздел 'Булки' неактивен", driver.findElement(mainPage.getButtonBuns()).getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @Step("Проверка что раздел 'Соусы' активен")
    public void checkSectionSauces() {
        assertTrue("раздел 'Соусы' неактивен", driver.findElement(mainPage.getButtonSauces()).getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @Step("Проверка что раздел 'Начинки' активен")
    public void checkSectionToppings() {
        assertTrue("раздел 'Начинки' неактивен", driver.findElement(mainPage.getButtonToppings()).getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }
}
