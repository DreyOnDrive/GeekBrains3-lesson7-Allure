package Leroy;

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

    private final static String LOGIN_FRAME_LOCATOR_BY_ID = "oauth-iframe";
    @FindBy(id = LOGIN_FRAME_LOCATOR_BY_ID)
    private  WebElement loginFrame;
    @Step("Переключиться в логин фрейм")
    public LoginPage switchToLoginFrame() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_FRAME_LOCATOR_BY_ID)));
        driver.switchTo().frame(loginFrame);
        return this;
    }

    private final static String LOGIN_INPUT_BY_XPATH = "//input[@id=\"username\"]";
    @FindBy(xpath = LOGIN_INPUT_BY_XPATH)
    private WebElement loginInput;
    @Step("Заполнить логин")
    public LoginPage fillLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    private final static String PASSWORD_INPUT_BY_XPATH = "//input[@id=\"password\"]";
    @FindBy(xpath = PASSWORD_INPUT_BY_XPATH)
    private WebElement passwordInput;
    @Step("Заполнить пароль")
    public LoginPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    private final static String SUBMIT_LOGIN_BUTTON_BY_XPATH = "//input[@value=\"Войти\"]";
    @FindBy(xpath = SUBMIT_LOGIN_BUTTON_BY_XPATH)
    private WebElement submitLoginButton;
    @Step("Нажать кнопку входа")
    public void clickSubmitLoginButton () {
        submitLoginButton.click();
    }



}
