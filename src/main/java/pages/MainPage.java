package pages;

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

    public By getButtonLoginInAccount() {
        return buttonLoginInAccount;
    }

    public By getButtonPersonalAccount() {
        return buttonPersonalAccount;
    }

    public By getButtonBuns() {
        return buttonBuns;
    }

    public By getButtonSauces() {
        return buttonSauces;
    }

    public By getButtonToppings() {
        return buttonToppings;
    }

    public By getButtonCreateOrder() {
        return buttonCreateOrder;
    }
}
