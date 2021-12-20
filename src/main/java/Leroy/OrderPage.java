package Leroy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BaseView {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage clicksubmitOrder (){
        webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"#root > uc-app > uc-container >" +
                " main > uc-checkout\").shadowRoot.querySelector(\"layout-checkout > h2\").textContent == 'Оформление заказа'"));
        ((JavascriptExecutor) driver).executeScript("document.querySelector(\"#root > uc-app > uc-container > main > uc-checkout\")" +
                ".shadowRoot.querySelector(\"layout-checkout > checkout-totals > uc-button > button\").click()");
        return this;
    }

    public boolean checkOrderAvailability (){
       boolean checkOrderAvailability = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#root > uc-app >" +
                " uc-container > main > uc-checkout\").shadowRoot.querySelector(\"layout-checkout > checkout-totals > uc-button > button\").disabled");
       return checkOrderAvailability;
    }


}
