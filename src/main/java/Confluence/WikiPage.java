package Confluence;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiPage extends BaseView {
    public WikiPage(WebDriver driver) {
        super(driver);
    }

    private final static String wikiTitleXpath = "//textarea[@data-test-id=\"editor-title\"]";
    @FindBy(xpath = wikiTitleXpath)
    private WebElement wikiTitle;
    public WikiPage fillWikiTitle (String title) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wikiTitleXpath)));
        Thread.sleep(2000);
        wikiTitle.sendKeys(title);
        return this;
    }

    private final static String MAIN_CONTENT_AREA_XPATH = "//div[@aria-label=\"Main content area\"]";
    private final static String ADVANCED_OPTIONS_XPATH = "//span[@aria-label=\"Расширенные параметры форматирования\"]";
    private final static String ADVANCED_OPTIONS_INDEX_XPATH = "//span[.='Подстрочный']";
    private final static String ADVANCED_OPTIONS_EXPONENT_XPATH = "//span[.='Надстрочный']";


    @FindBy(xpath = MAIN_CONTENT_AREA_XPATH)
    private WebElement mainContentArea;
    @FindBy(xpath = ADVANCED_OPTIONS_XPATH)
    private WebElement advancedOptions;
    @FindBy(xpath = ADVANCED_OPTIONS_INDEX_XPATH)
    private WebElement advancedOptionsIndex;
    @FindBy(xpath = ADVANCED_OPTIONS_EXPONENT_XPATH)
    private WebElement advancedOptionsExponent;
    public WikiPage fillMainContentAreaByCommonText (String content) {
         mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByBoldText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "b"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByItalicsText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "i"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByUnderlinedText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "u"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByStrikethroughText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByCodeText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "m"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByIndexText (String content) {
        advancedOptions.click();
        advancedOptionsIndex.click();
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByExponentText (String content) {
        advancedOptions.click();
        advancedOptionsExponent.click();
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByBoldItalicsText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "bi"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByBoldUnderlinedText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "bu"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByBoldStrikethroughText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "b"));
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByBoldIndexText (String content) {
        advancedOptions.click();
        advancedOptionsIndex.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "b"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByBoldExponentText (String content) {
        advancedOptions.click();
        advancedOptionsExponent.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "b"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByItalicsUnderlinedText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "iu"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByItalicsStrikethroughText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "i"));
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByItalicsIndexText (String content) {
        advancedOptions.click();
        advancedOptionsIndex.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "i"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByItalicsExponentText (String content) {
        advancedOptions.click();
        advancedOptionsExponent.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "i"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByUnderlinedStrikethroughText (String content) {
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "u"));
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByUnderlinedIndexText (String content) {
        advancedOptions.click();
        advancedOptionsIndex.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "u"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByUnderlinedExponentText (String content) {
        advancedOptions.click();
        advancedOptionsExponent.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, "u"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByStrikethroughIndexText (String content) {
        advancedOptions.click();
        advancedOptionsIndex.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WikiPage fillMainContentAreaByStrikethroughExponentText (String content) {
        advancedOptions.click();
        advancedOptionsExponent.click();
        mainContentArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "s"));
        mainContentArea.sendKeys(content + "\n");
        return this;
    }

    public WebElement checkCommonText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkBoldText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/strong[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkItalicsText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/em[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkUnderlinedText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/u[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkStrikethroughText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/s[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkCodeText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/span[@class = 'code']"));
        return webElement;
    }

    public WebElement checkIndexText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/sub[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkExponentText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/sup[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkBoldItalicsText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/em/strong[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkBoldUnderlinedText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/strong/u[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkBoldStrikethroughText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/strong/s[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkBoldIndexText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/strong/sub[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkBoldExponentText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/strong/sup[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkItalicsUnderlinedText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/em/u[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkItalicsStrikethroughText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/em/s[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkItalicsIndexText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/em/sub[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkItalicsExponentText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/em/sup[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkStrikethroughUnderlineText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/s/u[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkUnderlinedIndexText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/sub/u[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkUnderlinedExponentText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/sup/u[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkStrikethroughIndexText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/s/sub[.='" + text + "']"));
        return webElement;
    }

    public WebElement checkStrikethroughExponentText (String text){
        WebElement webElement;
        webElement = driver.findElement(By.xpath(MAIN_CONTENT_AREA_XPATH + "/p[.='" + text + "']/s/sup[.='" + text + "']"));
        return webElement;
    }


}
