package Confluence;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseView {
    public MainPage(WebDriver driver ) {
        super(driver);
    }

    private final static String CREATE_BUTTON_XPATH = "//span[text()[contains(.,'Создать')]]";
    @FindBy(xpath = CREATE_BUTTON_XPATH)
    private  WebElement createButton;
    @Step("Нажать кнопку создания документа")
    public WikiPage clickCreateButton () throws InterruptedException {
        Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_BUTTON_XPATH)));
        createButton.click();
        return new WikiPage(driver);
    }

    private final static String SECTION_BUTTON_XPATH = "//span[.='Разделы']";
    @FindBy(xpath = SECTION_BUTTON_XPATH)
    private  WebElement sectionButton;
    @Step("Нажать кнопку разделы")
    public MainPage clickSectionButton () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SECTION_BUTTON_XPATH)));
        sectionButton.click();
        return this;
    }

    private final static String NEW_SECTION_BUTTON_XPATH = "//span[.='Создать раздел']";
    @FindBy(xpath = NEW_SECTION_BUTTON_XPATH)
    private  WebElement newSectionButton;
    @Step("Нажать кнопку создать раздел")
    public NewSectionBlock clickNewSectionButton () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEW_SECTION_BUTTON_XPATH)));
        newSectionButton.click();
        return new NewSectionBlock(driver);
    }
}
