package pages;

import basePage.BasePage;
import com.sun.jersey.server.wadl.WadlBuilder;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import javax.ws.rs.FormParam;

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

    @FindBy(xpath = "(.//*[@class='login__action'])[1]")
    private WebElement registrationButton;
    @FindBy(xpath = "(.//*[@class='login__action'])[2]")
    private WebElement continueAsGuestButton;

    @FindBy(xpath = "(.//*[@class='login__action'])[3]")
    private WebElement buttonForOrganizations;

    /*@FindBy(xpath = "(./*//*[@class='login__action-title'])[1]")
    private WebElement registrationButtonTitle;*/
    @FindBy(xpath = ".//*[@class='login__action-title login__action-title_red']")
    private WebElement forOrganizationsTitle;

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
        getValueOfInputField(passwordField, "value");
        textPresent("Неверный адрес электронной почты (email) или пароль");
    }

    public void typeCorrectLoginIncorrectPasswordInAuth() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, PHYSICAL_PERSON_EMAIL);
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        getValueOfInputField(passwordField, "value");
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
        fillInputFieldAndPressEnterButton(emailInputField, PHYSICAL_PERSON_EMAIL);
        fillInputFieldAndPressEnterButton(passwordField, EMPTY_DATA);
        textPresent("Это поле обязательно для заполнения.");
    }

    public void typePasswordWithoutLoginInAuth() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, EMPTY_DATA);
        fillInputFieldAndPressEnterButton(passwordField, PHYSICAL_PERSON_PASSWORD);
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyEmailFieldWithNumbersAndSymbols() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, RandomStringUtils.randomAlphanumeric(6) +
                PHYSICAL_PERSON_EMAIL);
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Неверный адрес электронной почты (email) или пароль.");
        getValueOfInputField(passwordField, "value");
    }

    public void verifyEmailWithSpaces() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, EMPTY_DATA + PHYSICAL_PERSON_EMAIL);
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email)");
    }

    public void verifyTypingPasswordLessSixSymbols() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, PHYSICAL_PERSON_EMAIL);
        fillInputFieldAndPressEnterButton(passwordField, RandomStringUtils.randomAlphanumeric(5));
        textPresent("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале.");
    }

    public void verifyOpeningRegistrationLink() {
        getUrl(AUTORIZATION_PAGE_URL);
        String linkTextAttribute = getValueOfAttributeByName(registrationButton, "href");
        elementFluentWaitVisibility(registrationButton, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to link of registration ",
                linkTextAttribute);
    }

    public void verifyOpeningContinueAsGuestLink() {
        getUrl(AUTORIZATION_PAGE_URL);
        String linkTextAttribute = getValueOfAttributeByName(continueAsGuestButton, "href");
        elementFluentWaitVisibility(continueAsGuestButton, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to main page link ",
                linkTextAttribute);
    }

    public void verifyOpeningForOrganizationsLink() {
        getUrl(AUTORIZATION_PAGE_URL);
        String linkTextAttribute = getValueOfAttributeByName(buttonForOrganizations, "href");
        elementFluentWaitVisibility(buttonForOrganizations, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to link for organizations ",
                linkTextAttribute);
    }
}
