package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.*;
import static utils.WaitingUtility.elementFluentWaitVisibility;

/**
 * @author Sergey Potapov
 */
public class AuthorizationPage extends BasePage {
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    //========================AUTHORIZATION PAGE=============================================
    @FindBy(css = "#email")
    private WebElement emailInputField;

    @FindBy(css = "#pass")
    private WebElement passwordField;

    @FindBy(css = "#send2")
    private WebElement authorizationButton;

    public void authAsPhysicalPerson() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, PHYSICAL_PERSON_EMAIL);
        fillInputField(passwordField, driver, PHYSICAL_PERSON_PASSWORD);
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertTrue(getCurrentUrl().contains("http://kemerovo.demo.dev.magonline.ru/customer/account/"));
    }

    public void typeIncorrectPasswordInAuth() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, INCORRECT_EMAIL);
        fillInputField(passwordField, driver, PHYSICAL_PERSON_PASSWORD);
        elementFluentWaitVisibility(authorizationButton, driver).click();
        textPresent("Неверный адрес электронной почты (email) или пароль");
    }

    public void typeCorrectLoginIncorrectPasswordInAuth() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, PHYSICAL_PERSON_EMAIL);
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Неверный адрес электронной почты (email) или пароль");
    }

    public void typeEmptyDataInAuth() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, EMPTY_DATA);
        fillInputFieldAndPressEnterButton(passwordField, EMPTY_DATA);
        textPresent("Это поле обязательно для заполнения.");
    }
    public void typeLoginWithoutPasswordInAuth() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputFieldAndPressEnterButton(emailInputField, EMPTY_DATA);
        textPresent("Это поле обязательно для заполнения.");
    }
}
