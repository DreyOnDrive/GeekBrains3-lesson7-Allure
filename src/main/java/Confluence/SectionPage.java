package Confluence;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SectionPage extends BaseView{
    public SectionPage(WebDriver driver) {
        super(driver);
    }

    private final static String SETTINGS_SECTION_XPATH = "//span[.='Настройки раздела']";
    @FindBy(xpath = SETTINGS_SECTION_XPATH)
    private WebElement settingsSection;
    @Step("Нажать кнопку настроек раздела")
    public SectionPage clickSectionSettings() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SETTINGS_SECTION_XPATH)));
        settingsSection.click();
        return this;
    }

    private final static String DRIVING_SECTION_XPATH = "//span[.='Управление разделом']";
    @FindBy(xpath = DRIVING_SECTION_XPATH)
    private WebElement drivingSection;
    @Step("Нажать кнопку управление разделом")
    public SectionPage clickDrivingSection() {
        drivingSection.click();
        return this;
    }

    private final static String DELETE_SECTION_WAIT_JS = "return document.querySelector(\"#space-settings-v2-navigation-portal-container >" +
            " div > div.css-9jay18.e1678cd51 > div.css-1hycfov.e1678cd52\").textContent == 'Управление разделом'";
    private final static String DELETE_SECTION_JS = "document.querySelectorAll(\"#space-settings-inner-nav-tabs-0\").item(3).click()";
    @Step("Нажать кнопку удаление раздела")
    public SectionPage deleteSection() {
        webDriverWait.until(ExpectedConditions.jsReturnsValue(DELETE_SECTION_WAIT_JS));
        ((JavascriptExecutor)driver).executeScript(DELETE_SECTION_JS);
        return this;
    }

    private final static String ACCEPT_DELETE_SECTION_XPATH = "//span[.='Удалить этот раздел']";
    @FindBy(xpath = ACCEPT_DELETE_SECTION_XPATH)
    private WebElement acceptDeleteSectionButton;
    @Step("Нажать кнопку подтверждения удаление раздела")
    public SectionPage clickAcceptDeleteSectionButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACCEPT_DELETE_SECTION_XPATH)));
        acceptDeleteSectionButton.click();
        return this;
    }

    private final static String FINAL_DELETE_SECTION_XPATH = "//button[@data-testid=\"delete-space-button\"]";
    @FindBy(xpath = FINAL_DELETE_SECTION_XPATH)
    private WebElement finalDeleteSectionButton;
    @Step("Нажать кнопку окончательного удаление раздела")
    public SectionPage clickFinalDeleteSectionButton() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FINAL_DELETE_SECTION_XPATH)));
        finalDeleteSectionButton.click();
        Thread.sleep(5000);
        return this;
    }

    private final static String DELETE_PROCESS_XPATH = "//span[.='100']";
    @FindBy(xpath = DELETE_PROCESS_XPATH)
    private WebElement deleteProcess;
    @Step("Проверка удаления раздела")
    public WebElement checkDeleteProcess() {
        WebElement webElement = driver.findElement(By.xpath(DELETE_PROCESS_XPATH));
        return webElement;
    }
}
