package Leroy;

import Logger.CustomLoggerNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;


@Story("Basket")
public class LeroyMerlinTest {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    BasketPage basketPage;
    OrderPage orderPage;

    final public static String URL_LOGIN = "https://leroymerlin.ru/login";
    final public static String LOGIN = "xowapi1@ineedsa.com";
    final public static String PASSWORD = "Aa123456";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_LOGIN);
        loginPage = new LoginPage(driver);
        loginPage
                .switchToLoginFrame()
                .fillLoginInput(LOGIN)
                .fillPasswordInput(PASSWORD)
                .clickSubmitLoginButton();
    }

    @Test
    @Feature("Корзина")
    @Description("Тест добавления товара в корзину")
    void addInBasket() throws InterruptedException {
        String category = "//span[.='Декор']";
//        String category = "//span[.='Хранение']";
//        String category = "//span[.='Плитка']";
        String item1 = "item1";
        String item2 = "item2";

        mainPage = new MainPage(driver);
        mainPage
                .clickCatalogue()
                .clickCategory(category)
                .clickItem(item1)
                .clickItem(item2);
        String item1PriceText = mainPage.getItemPriceText(item1);
        String item2PriceText = mainPage.getItemPriceText(item2);
        String item1NameText = mainPage.getItemNameText(item1);
        String item2NameText = mainPage.getItemNameText(item2);
        mainPage.clickBasket();

        basketPage = new BasketPage(driver);
        String basketPriceText = basketPage.getBasketPriceText();
        String NameBasketItem1 = basketPage.getNameBasketItem(item1);
        String NameBasketItem2 = basketPage.getNameBasketItem(item2);

        Double price1 = Double.parseDouble(item1PriceText);
        Double price2 = Double.parseDouble(item2PriceText);
        Double sumPrice = price1 + price2;
        Double basketPrice = Double.parseDouble(basketPriceText);
        Assertions.assertEquals(sumPrice, basketPrice);
        Assertions.assertEquals(item1NameText, NameBasketItem1);
        Assertions.assertEquals(item2NameText, NameBasketItem2);
    }

    @Test
    @Feature("Заказ")
    @Description("Тест невозможности заказа без заполнения полей")
    void notOrder() throws InterruptedException {
        String category = "//span[.='Освещение']";
        String item2 = "item2";
        mainPage = new MainPage(driver);
        mainPage
                .clickCatalogue()
                .clickCategory(category)
                .clickItem(item2)
                .clickBasket()
                .clickOrderButton()
                .clicksubmitOrder();

        orderPage = new OrderPage(driver);
        Assertions.assertTrue(orderPage.checkOrderAvailability());
    }

    @AfterEach
    void tearDown() {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logs.iterator();

        while ((iterator).hasNext()) {
            Allure.addAttachment("Ошибка в  логе браузера", iterator.next().getMessage());
        }
        driver.quit();
    }
}