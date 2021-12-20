package Confluence;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewSectionBlock extends BaseView {
    public NewSectionBlock(WebDriver driver) {
        super(driver);
    }

    private final static String DOCUMENT_SECTION_XPATH = "//div[text()[contains(.,'Раздел документации')]]";
    @FindBy(xpath = DOCUMENT_SECTION_XPATH)
    private WebElement documentSection;
    @Step("Нажать кнопку типа раздел")
    public NewSectionBlock clickDocumentSection () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DOCUMENT_SECTION_XPATH)));
        documentSection.click();
        return this;
    }

    private final static String NEXT_BUTTON_XPATH = "//button[text()[contains(.,'Далее')]]";
    @FindBy(xpath = NEXT_BUTTON_XPATH)
    private  WebElement nextButton;
    @Step("Нажать кнопку далее")
    public NewSectionBlock clickNextButton () {
        nextButton.click();
        return this;
    }

    private final static String NAME_SECTION_INPUT_XPATH = "//label[@for='name']/following-sibling::input";
    @FindBy(xpath = NAME_SECTION_INPUT_XPATH)
    private  WebElement nameSectionInput;
    @Step("Заполнить название раздела")
    public NewSectionBlock fillNameSection (String name) throws InterruptedException {
        nameSectionInput.sendKeys(name);
        Thread.sleep(1000);
        return this;
    }

    private final static String CREATE_SECTION_XPATH = "//button[text()[contains(.,'Создать')]]";
    @FindBy(xpath = CREATE_SECTION_XPATH)
    private  WebElement createSection;
    @Step("Нажать кнопку создания раздела")
    public SectionPage clickCreateSectionButton () {
        createSection.click();
        return new SectionPage(driver);
    }
}
