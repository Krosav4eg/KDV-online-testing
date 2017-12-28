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

    @FindBy(xpath = ".//div[text()='Регистрация']")
    private WebElement registrationButton;

    @FindBy(xpath = ".//div[text()='Продолжить как гость']")
    private WebElement continueAsGuestButton;

    @FindBy(xpath = ".//div[text()='Для организаций']")
    private WebElement buttonForOrganizations;

    @FindBy(xpath = ".//*[@class='login__action-title login__action-title_red']")
    private WebElement forOrganizationsTitle;

    @FindBy(css = ".blank-layout__logo")
    private WebElement mainPageLogo;

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

    public void verifyEmailFieldWithoutAt() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "a.shauloandersenlab.com");
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). Например, " +
                "ivanivanov@domain.com.");
    }

    public void verifyEmailFieldWithoutDomainName() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "a.shaulo@andersenlabcom");
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). Например, " +
                "ivanivanov@domain.com.");
    }

    public void verifyEmailFieldWithMoreThanOneDot() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "a..shaulo@andersenlab.com");
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). Например, " +
                "ivanivanov@domain.com.");
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

    public void verifyPasswordContainsOnlySpaces() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "a.shaulo@andersenlab.com");
        fillInputFieldAndPressEnterButton(passwordField, EMPTY_DATA);
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyPasswordContainsSpacesAtStartAndEnd() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "a.shaulo@andersenlab.com" );
        fillInputFieldAndPressEnterButton(passwordField, " As06051993 ");
        textPresent("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале.");
    }

    public void verifyEnterWithUnconfirmedEmail() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "anastasiya.shaulo@gmail.com" );
        fillInputFieldAndPressEnterButton(passwordField, INCORRECT_PASSWORD);
        textPresent("Неверный адрес электронной почты (email) или пароль.");
    }

    public void verifyOpeningMainPage() {
        getUrl(AUTORIZATION_PAGE_URL);
        String link = getValueOfAttributeByName(mainPageLogo, "href");
        elementFluentWaitVisibility(mainPageLogo, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to main page ",
                link);
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

    public void verifyChangingColorsForTabs() {
        getUrl(AUTORIZATION_PAGE_URL);
        moveMouseTo(driver, registrationButton);
        String actualRegistrationButtonColor = "#ce0022";
        String expectedRegistrationButtonColor = getElementColor(registrationButton, "color");
        AssertCollector.assertEqualsJ(actualRegistrationButtonColor, expectedRegistrationButtonColor,
                " Verify elements color of registration button ");
        moveMouseTo(driver, continueAsGuestButton);
        String actualContinueButtonColor = "#ce0022";
        String expectedContinueButtonColor = getElementColor(continueAsGuestButton, "color");
        AssertCollector.assertEqualsJ(actualContinueButtonColor, expectedContinueButtonColor,
                " Verify elements color of continue as guest button ");
        moveMouseTo(driver, buttonForOrganizations);
        String actualForOrganizationsButtonColor = "#ce0022";
        String expectedForOrganizationsButtonColor = getElementColor(buttonForOrganizations, "color");
        AssertCollector.assertEqualsJ(actualForOrganizationsButtonColor, expectedForOrganizationsButtonColor,
                " Verify elements color of for organizations button ");
    }

    public void verifyCopyWrite() {
        getUrl(AUTORIZATION_PAGE_URL);
        textPresent("© 2017 ООО «КДВ Групп»");
    }

    public void verifyOfTextInRegistrationTab() {
        getUrl(AUTORIZATION_PAGE_URL);
        AssertCollector.assertTrue(registrationButton.isDisplayed());
        textPresent("Регистрация");
        textPresent("Регистрация позволит вам экономить время при оформлении заказов, даст возможность" +
                " отслеживать их состояние и повторять заказы из архива.");
    }

    public void verifyOfTextInContinueAsGuestTab() {
        getUrl(AUTORIZATION_PAGE_URL);
        AssertCollector.assertTrue(continueAsGuestButton.isDisplayed());
        textPresent("Продолжить как гость");
        textPresent("В нашем интернет-магазине вы можете выбрать товары и оформить заказ без регистрации.");
    }

    public void verifyTextInForOrganizationsTab() {
        getUrl(AUTORIZATION_PAGE_URL);
        AssertCollector.assertTrue(buttonForOrganizations.isDisplayed());
        textPresent("Для организаций");
        String actColor = "#ff1b41";
        String expColor = getElementColor(forOrganizationsTitle, "color");
        AssertCollector.assertEqualsJ(actColor, expColor,
                " Verify elements color of for organizations button ");
        textPresent("Зарегистрируйте вашу организацию и получайте полный комплект документов для юр. лиц. " +
                "Для организаций, уже работающих с KDV, цены и условия отгрузки сохраняются.");
    }
}
