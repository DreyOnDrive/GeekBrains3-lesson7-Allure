package Logger;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class CustomLoggerNew implements WebDriverListener {
    public void beforeFindElement(WebDriver driver, By locator) {
        Allure.addAttachment("Скриншот страницы ",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}


