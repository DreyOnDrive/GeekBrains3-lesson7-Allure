package Confluence;

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
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Base Actions")
public class ConfluenceTest {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    WikiPage wikiPage;


    final public static String URL_LOGIN = "https://my-atlassian-site-441.atlassian.net/wiki/home/";
    final public static String LOGIN = "cegog77137@shirulo.com";
    final public static String PASSWORD = "cegog77137";

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
                .fillLogin(LOGIN)
                .clickSubmitLoginButton()
                .fillPassword(PASSWORD)
                .clickSubmitPasswordButton();
    }

    @Test
    @Feature("Новая страница")
    @Description("Тест создания новой страницы с различными стилями текста")
    void newWikiPage() throws InterruptedException {
        String testTitle = "Test title";
        String commonText = "Common text";
        String boldText = "Bold text";
        String italicsText = "Italics text";
        String underlinedText = "Underlined text";
        String strikethroughText = "Strikethrough text";
        String codeText = "Code text";
        String indexText = "Index text";
        String exponentText = "Exponent text";
        String boldItalicsText = "Bold Italics text";
        String boldUnderlinedText = "Bold Underlined text";
        String boldStrikethroughText = "Bold Strikethrough text";
        String boldIndexText = "Bold Index text";
        String boldExponentText = "Bold Exponent Text";
        String italicsUnderlinedText = "Italics Underlined text";
        String italicsStrikethroughText = "Italics Strikethrough text";
        String italicsIndexText = "Italics Strikethrough text";
        String italicsExponentText = "Italics Strikethrough text";
        String strikethroughUnderlinedText = "Strikethrough Underlined text";
        String underlinedIndexText = "Underlined Index text";
        String underlinedExponentText = "Underlined Exponent text";
        String strikethroughIndexText = "Strikethrough Index text";
        String strikethroughExponentText = "Strikethrough Exponent text";


        mainPage = new MainPage(driver);
        mainPage.clickCreateButton();

        wikiPage = new WikiPage(driver);
        wikiPage
                .fillWikiTitle(testTitle)
                .fillMainContentAreaByCommonText(commonText)
                .fillMainContentAreaByBoldText(boldText)
                .fillMainContentAreaByItalicsText(italicsText)
                .fillMainContentAreaByUnderlinedText(underlinedText)
                .fillMainContentAreaByStrikethroughText(strikethroughText)
                .fillMainContentAreaByCodeText(codeText)
                .fillMainContentAreaByIndexText(indexText)
                .fillMainContentAreaByExponentText(exponentText)
                .fillMainContentAreaByBoldItalicsText(boldItalicsText)
                .fillMainContentAreaByBoldUnderlinedText(boldUnderlinedText)
                .fillMainContentAreaByBoldStrikethroughText(boldStrikethroughText)
                .fillMainContentAreaByBoldIndexText(boldIndexText)
                .fillMainContentAreaByBoldExponentText(boldExponentText)
                .fillMainContentAreaByItalicsUnderlinedText(italicsUnderlinedText)
                .fillMainContentAreaByItalicsStrikethroughText(italicsStrikethroughText)
                .fillMainContentAreaByItalicsIndexText (italicsIndexText)
                .fillMainContentAreaByItalicsExponentText(italicsExponentText)
                .fillMainContentAreaByUnderlinedStrikethroughText(strikethroughUnderlinedText)
                .fillMainContentAreaByUnderlinedIndexText(underlinedIndexText)
                .fillMainContentAreaByUnderlinedExponentText(underlinedExponentText)
                .fillMainContentAreaByStrikethroughIndexText(strikethroughIndexText)
                .fillMainContentAreaByStrikethroughExponentText(strikethroughExponentText);

        assertThat(wikiPage.checkCommonText(commonText), isDisplayed());
        assertThat(wikiPage.checkBoldText(boldText), isDisplayed());
        assertThat(wikiPage.checkItalicsText(italicsText), isDisplayed());
        assertThat(wikiPage.checkUnderlinedText(underlinedText), isDisplayed());
        assertThat(wikiPage.checkStrikethroughText(strikethroughText), isDisplayed());
        assertThat(wikiPage.checkCodeText(codeText), isDisplayed());
        assertThat(wikiPage.checkIndexText(indexText), isDisplayed());
        assertThat(wikiPage.checkExponentText(exponentText), isDisplayed());
        assertThat(wikiPage.checkBoldItalicsText(boldItalicsText), isDisplayed());
        assertThat(wikiPage.checkBoldUnderlinedText(boldUnderlinedText), isDisplayed());
        assertThat(wikiPage.checkBoldStrikethroughText(boldStrikethroughText), isDisplayed());
        assertThat(wikiPage.checkBoldIndexText(boldIndexText), isDisplayed());
        assertThat(wikiPage.checkBoldExponentText(boldExponentText), isDisplayed());
        assertThat(wikiPage.checkBoldExponentText(boldExponentText), isDisplayed());
        assertThat(wikiPage.checkItalicsUnderlinedText(italicsUnderlinedText), isDisplayed());
        assertThat(wikiPage.checkItalicsStrikethroughText(italicsStrikethroughText), isDisplayed());
        assertThat(wikiPage.checkItalicsIndexText(italicsIndexText), isDisplayed());
        assertThat(wikiPage.checkItalicsExponentText(italicsExponentText), isDisplayed());
        assertThat(wikiPage.checkStrikethroughUnderlineText(strikethroughUnderlinedText), isDisplayed());
        assertThat(wikiPage.checkUnderlinedIndexText(underlinedIndexText), isDisplayed());
        assertThat(wikiPage.checkUnderlinedExponentText(underlinedExponentText), isDisplayed());
        assertThat(wikiPage.checkStrikethroughIndexText(strikethroughIndexText), isDisplayed());
        assertThat(wikiPage.checkStrikethroughExponentText(strikethroughExponentText), isDisplayed());
    }

    @Test
    @Feature("Новая раздел")
    @Description("Тест создания нового раздела")
    void newSection() throws InterruptedException {
        String sectionName = "Test Section";

        mainPage = new MainPage(driver);
        mainPage
                .clickSectionButton()
                .clickNewSectionButton()
                .clickDocumentSection()
                .clickNextButton()
                .fillNameSection(sectionName)
                .clickCreateSectionButton()
                .clickSectionSettings()
                .clickDrivingSection()
                .deleteSection()
                .clickAcceptDeleteSectionButton()
                .clickFinalDeleteSectionButton();

        SectionPage sectionPage = new SectionPage(driver);
        assertThat(sectionPage.checkDeleteProcess(), isDisplayed());
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