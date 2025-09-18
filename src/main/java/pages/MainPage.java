package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    private By buttonLoginInAccount = By.className("button_button__33qZ0");
    private By buttonPersonalAccount = By.xpath("//p[contains(text(), 'Личный Кабинет')]");
    private By buttonBuns = By.xpath("//span[contains(text(), 'Булки')]/ancestor::div[contains(@class, 'tab_tab__1SPyG')]");
    private By buttonSauces = By.xpath("//span[contains(text(), 'Соусы')]/ancestor::div[contains(@class, 'tab_tab__1SPyG')]");
    private By buttonToppings = By.xpath("//span[contains(text(), 'Начинки')]/ancestor::div[contains(@class, 'tab_tab__1SPyG')]");
    private By buttonCreateOrder = By.xpath("//button[contains(text(), 'Оформить заказ')]");

    @Step("Получить локатор кнопки булки")
    public By getButtonBuns() {
        return buttonBuns;
    }

    @Step("Получить локатор кнопки соусы")
    public By getButtonSauces() {
        return buttonSauces;
    }

    @Step("Получить локатор кнопки начинки")
    public By getButtonToppings() {
        return buttonToppings;
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickButtonLogin() {
        driver.findElement(buttonLoginInAccount).click();
    }

    @Step("Клик по кнопке 'Личный Кабинет'")
    public void clickPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Проверка отображается ли кнопка Оформления заказа")
    public boolean isVisibleCreateOrder() {
       return driver.findElement(buttonCreateOrder).isDisplayed();
    }

    @Step("Нажать кнопку 'Булки'")
    public void clickBunsButton() {
        driver.findElement(buttonBuns).click();
    }

    @Step("Нажать кнопку 'Соусы'")
    public void clickSaucesButton() {
        driver.findElement(buttonSauces).click();
    }

    @Step("Нажать кнопку 'Начинки'")
    public void clickFillingsButton() {
        driver.findElement(buttonToppings).click();
    }

    @Step("Проверить, отображается ли раздел 'Булки'")
    public boolean isBunsSectionDisplayed() {
        return driver.findElement(buttonBuns).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    @Step("Проверить, отображается ли раздел 'Соусы'")
    public boolean isSaucesSectionDisplayed() {
        return driver.findElement(buttonSauces).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    @Step("Проверить, отображается ли раздел 'Начинки'")
    public boolean isToppingsSectionDisplayed() {
        return driver.findElement(buttonToppings).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
}
