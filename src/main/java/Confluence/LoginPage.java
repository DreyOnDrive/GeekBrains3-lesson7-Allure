package Confluence;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN_INPUT_XPATH = "//input[@name='username']";
    @FindBy(xpath = LOGIN_INPUT_XPATH)
    private  WebElement loginInput;
    @Step("Заполнение логина")
    public LoginPage fillLogin (String login) {
        loginInput.sendKeys(login);
        return this;
    }

    private final static String SUBMIT_LOGIN_BUTTON_XPATH = "//span[text()[contains(.,'Продолжить')]]";
    @FindBy(xpath = SUBMIT_LOGIN_BUTTON_XPATH)
    private  WebElement submitLoginButton;
    @Step("Подтверждение логина")
    public LoginPage clickSubmitLoginButton () {
        submitLoginButton.click();
        return this;
    }

    private final static String PASSWORD_INPUT_XPATH = "//input[@name='password']";
    @FindBy(xpath = PASSWORD_INPUT_XPATH)
    private  WebElement passwordInput;
    @Step("Заполнение пароля")
    public LoginPage fillPassword (String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_INPUT_XPATH)));
        passwordInput.sendKeys(password);
        return this;
    }

    private final static String SUBMIT_PASSWORD_BUTTON_XPATH = "//span[text()[contains(.,'Войти')]]";
    @FindBy(xpath = SUBMIT_PASSWORD_BUTTON_XPATH)
    private  WebElement submitPasswordButton;
    @Step("Подтверждение пароля")
    public MainPage clickSubmitPasswordButton () {
        submitPasswordButton.click();
        return new MainPage(driver);
    }

}
