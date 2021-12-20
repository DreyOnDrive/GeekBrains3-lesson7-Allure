package Leroy;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseView {
    public MainPage(WebDriver driver ) {
        super(driver);
    }

    @Step("Нажатие кнопки каталога")
    public MainPage clickCatalogue(){
        webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"a[href^=" +
                "'/catalogue/']\").textContent == 'Каталог'"));
        ((JavascriptExecutor)driver).executeScript("document.querySelector(\"a[href^='/catalogue/']\").click()");
        return this;
    }

    @Step("Нажатие кнопки категории")
    public MainPage clickCategory(String categoryXpath) throws InterruptedException {
        if (categoryXpath.equals("//span[.='Хранение']")){
            ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,550)");
            Thread.sleep(1000);
        }
        if (categoryXpath.equals("//span[.='Плитка']")){
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,1100)");
        Thread.sleep(1000);
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryXpath)));
        driver.findElement(By.xpath(categoryXpath)).click();
        return this;
    }

    private String getItemStartXpath () {
        try {
            webDriverWaitSmall.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//*[@id=\"root\"]/main/div[2]/div[2]/div/section/div[4]/section/div[1]/div[1]")));
            return "//*[@id=\"root\"]/main/div[2]/div[2]/div/section/div[4]";
        } catch (TimeoutException e) {
            webDriverWaitSmall.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//*[@id=\"root\"]/main/div[2]/div[2]/div/section/div[3]/section/div[1]/div[1]")));
            return "//*[@id=\"root\"]/main/div[2]/div[2]/div/section/div[3]";
        }
    }

    private final String item1PriceTextXpath = "/section/div[1]/div[1]/div[2]/div/div[1]/p[1]";
    private final String item2PriceTextXpath = "/section/div[1]/div[2]/div[2]/div/div[1]/p[1]";

    @Step("Получение цены товара")
    public String getItemPriceText (String item) {
        WebElement itemPriceTextElement = null;
        if (item.equals("item1")){
            itemPriceTextElement = driver.findElement(By.xpath(getItemStartXpath() + item1PriceTextXpath));
        }
        if (item.equals("item2")){
            itemPriceTextElement = driver.findElement(By.xpath(getItemStartXpath() + item2PriceTextXpath));
        }
        String itemPriceText = itemPriceTextElement.getText().replaceAll("[^0-9/.]", "");
        return itemPriceText;
    }

    private final String item1NameTextXpath = "/section/div[1]/div[1]/div[1]/a/span/span";
    private final String item2NameTextXpath = "/section/div[1]/div[2]/div[1]/a/span/span";
    @Step("Получение названия товара")
    public String getItemNameText (String item) {
        WebElement itemNameTextElement = null;
        if (item.equals("item1")){
            itemNameTextElement = driver.findElement(By.xpath(getItemStartXpath() + item1NameTextXpath));
        }
        if (item.equals("item2")){
            itemNameTextElement = driver.findElement(By.xpath(getItemStartXpath() + item2NameTextXpath));
        }
        String itemNameText = itemNameTextElement.getText();
        return itemNameText;
    }

    private final String item1ClickXpath = "/section/div[1]/div[1]/div[2]/button";
    private final String item2ClickXpath = "/section/div[1]/div[2]/div[2]/button";

    @Step("Добавление товара в корзину")
    public MainPage clickItem (String item) {
        WebElement clickItemElement = null;
        if (item.equals("item1")){
            clickItemElement = driver.findElement(By.xpath(getItemStartXpath() + item1ClickXpath));
        }
        if (item.equals("item2")){
            clickItemElement = driver.findElement(By.xpath(getItemStartXpath() + item2ClickXpath));
        }
        clickItemElement.click();
        return this;
    }


    private final static String BASKET_XPATH = "//a[@href=\"/basket/\"]";
    @FindBy(xpath = BASKET_XPATH)
    private WebElement basket;
    @Step("Переход в корзину")
    public BasketPage clickBasket () {
        basket.click();
        return new BasketPage(driver);
    }

//Подскажите пожалуйста как можно и выполнить какое либо получение чего либо от элемента и вернуть страницу чтобы не терять цепочку действий через точку
//    public ArrayList <Object> getItemPriceText (String item) {
//        WebElement itemPriceTextElement = null;
//        if (item.equals("item1")) {
//            itemPriceTextElement = driver.findElement(By.xpath(item1PriceTextXpath));
//        }
//        if (item.equals("item2")) {
//            itemPriceTextElement = driver.findElement(By.xpath(item2PriceTextXpath));
//        }
//        String itemPriceText = itemPriceTextElement.getText().replaceAll("[^0-9/.]", "");
//        return new ArrayList<Object>(Arrays.asList(this, itemPriceText));
//    }
//        пытался через такое выражение - не получилось
//            mainPage
//                    .clickCatalogue()
//                    .clickCategory(category)
//                    .clickItem(item1).get(0).следующее действие

}
