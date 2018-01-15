package pages;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.EMPTY_DATA;
import static utils.Constants.REGISTRATION_PAGE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@rel='general']")
    private WebElement individualButton;

    @FindBy(xpath = "//a[@rel='legal']")
    private WebElement organizationButton;

    @FindBy(xpath = ".//*[@id='firstname']")
    private WebElement firstName;

    @FindBy(xpath = ".//*[@id='lastname']")
    private WebElement lastName;

    @FindBy(xpath = ".//*[@id='adv_phone']")
    private WebElement phone;

    @FindBy(xpath = ".//*[@id='email_address']")
    private WebElement email;

    @FindBy(xpath = ".//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = ".//*[@id='confirmation']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//label[@for='is_subscribed']")
    private WebElement subscription;

    @FindBy(xpath = "//label[@data-show='general']")
    private WebElement checkboxConfirm;

    @FindBy(xpath = "//label[@data-show='legal']")
    private WebElement checkboxConfirmLegal;

    @FindBy(xpath = ".//button[@title='Отправить']")
    private WebElement sendButton;

    @FindBy(css = ".layout__footer")
    private WebElement footer;

    @FindBy(css = ".layout__content")
    private WebElement layout;

    @FindBy(css = ".error-msg>ul>li>span>a")
    private WebElement forgotPassword;

    @FindBy(xpath = ".//*[@id='adv_full_name']")
    private WebElement organizationFullName;

    @FindBy(xpath = ".//*[@id='adv_inn']")
    private WebElement taxpayerId;

    @FindBy(xpath = ".//*[@id='adv_kpp']")
    private WebElement reasonCode;

    @FindBy(xpath = ".//*[@id='legal_address']")
    private WebElement legalAddress;

    @FindBy(xpath = ".//*[@id='company']")
    private WebElement company;

    @FindBy(xpath = ".//*[@id='street']")
    private WebElement address;

    @FindBy(xpath = ".//*[@id='comments']")
    private WebElement comments;

    @FindBy(xpath = "//span[contains(text(), \"г\")]/*[text()='Томск']")
    private WebElement cityForAddress;

    public void verifyLegalFormByDefault() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(individualButton.isEnabled());
    }

    public void verifyChoosingLegalForm() {
        getUrl(REGISTRATION_PAGE_URL);
        String linkTextAttribute = getValueOfAttributeByName(organizationButton, "href");
        elementFluentWaitVisibility(organizationButton, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to url with selected organization ",
                linkTextAttribute);
    }

    public void verifyForOrganizationsTextPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        textPresent("Внимание! Все заявки на регистрацию контрагентов - индивидуальных предпринимателей и " +
                "юридических лиц рассматриваются специалистами отдела продаж. Это может занять некоторое время. " +
                "До тех пор, пока контрагент не зарегистрирован, оформление заказов невозможно. Как правило, " +
                "рассмотрение заявки занимает не более одного рабочего дня.");
    }

    public void verifyFieldFirstNamePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(firstName.isDisplayed());
    }

    public void verifyInputInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(firstName, driver).click();
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(46));
        elementFluentWaitVisibility(layout, driver).click();
        String text = firstName.getAttribute("value");
        AssertCollector.assertEquals(text, " Current text is equal to ", text);
    }

    //test not pass(validation problems)
    public void verifyMaximumInputInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(46));
        AssertCollector.assertEquals(firstName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(45).length());
    }

    //test not pass(validation problems)
    public void verifyInputNumbersInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomNumeric(6));
        AssertCollector.assertTrue(firstName.getAttribute("value").isEmpty(), "required field is empty");
    }

    //test not pass(validation problems)
    public void verifyInputForbiddenSymbolsInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, "!@#$%^&*()+_/|{}[]?><.,");
        AssertCollector.assertTrue(firstName.getAttribute("value").isEmpty(), "required field is empty");
    }

    public void verifyInputSpecialSymbolsInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, "Анна-Мар'я");
        elementFluentWaitVisibility(layout, driver).click();
        String text = firstName.getAttribute("value");
        AssertCollector.assertEquals(text, " Current text is equal to ", text);
    }

    public void verifyFieldLastNamePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(lastName.isDisplayed());
    }

    public void verifyInputInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(46));
        elementFluentWaitVisibility(layout, driver).click();
        String text = lastName.getAttribute("value");
        AssertCollector.assertEquals(text, "  Current text is equal to  ", text);
    }

    //test not pass(validation problems)
    public void verifyMaximumInputInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(46));
        AssertCollector.assertEquals(lastName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(45).length());
    }

    //test not pass(validation problems)
    public void verifyInputNumbersInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, driver, RandomStringUtils.randomNumeric(6));
        AssertCollector.assertTrue(lastName.getAttribute("value").isEmpty(), "required field is empty");
    }

    //test not pass(validation problems)
    public void verifyInputForbiddenSymbolsInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(lastName, driver).click();
        fillInputField(lastName, driver, "!@#$%^&*()+_/|{}[]?><.,");
        AssertCollector.assertTrue(lastName.getAttribute("value").isEmpty(), "required field is empty");
    }

    public void verifyInputSpecialSymbolsInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(lastName, driver).click();
        fillInputField(lastName, driver, "Иванов-Петров'ъ");
        elementFluentWaitVisibility(layout, driver).click();
        String text = lastName.getAttribute("value");
        AssertCollector.assertEquals(text, "  Current text is equal to ", text);
    }

    public void verifyFieldPhonePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(phone.isDisplayed());
    }

    public void verifyMaskInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(phone.getAttribute("value").equals("+7__________"), "phone mask is correct");
    }

    public void verifyMaximumInputInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(15));
        AssertCollector.assertEquals(phone.getAttribute("value").length(), " The length of phone number equals ",
                RandomStringUtils.randomNumeric(12).length());
    }

    public void verifyInputForbiddenSymbolsInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, "!@#$%^&*()+_/|{}[]?><.,");
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty(), "Phone field is displayed");
    }

    public void verifyInputLettersInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, RandomStringUtils.randomAlphabetic(10));
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty(), "Phone field is displayed");
    }

    public void verifyInputSpacesInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, EMPTY_DATA);
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty(), "Phone field is displayed");
    }

    public void verifyInputLessThenTenNumbersInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(5));
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(email, driver, "test@test.ru");
        fillInputField(password, driver, "123456789");
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(footer);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX");
    }

    public void verifyFieldEmailPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(email.isDisplayed(), "Email field is displayed");
    }

    public void verifyEmailWithoutAtSymbol() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, driver, "a.shauloandersenlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Адрес электронной почты должен содержать символ \"@\". В адресе \"a.shauloandersenlab.com\" " +
                "отсутствует символ \"@\".");
    }

    public void verifyEmailWithoutDomainName() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, driver, "a.shaulo@andersenlabcom");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.");
    }

    public void verifyEmailWithMoreThanOneDot() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, driver, "a..shaulo@andersenlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). Например, ivanivanov@domain.com.");
    }

    public void verifyEmailWithSpacesBeforeAtSymbol() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, driver, "a.s ha ulo@andersenlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Часть адреса до символа \"@\" не должна содержать символ \" \".");
    }

    public void verifyEmailWithSpacesAfterAtSymbol() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, driver, "a.shaulo@anders enlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Часть адреса после символа \"@\" не должна содержать символ \" \".");
    }

    public void verifyFieldPasswordPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(password.isDisplayed());
    }

    public void verifyPasswordLengthLessThanSixSymbols() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, driver, "12345");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале.");
    }

    public void verifyPasswordWithOnlySpaces() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, driver, EMPTY_DATA);
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyPasswordWithSpacesAtStartAndEnd() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, driver, "   123456   ");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале.");
    }

    public void verifyFieldConfirmPasswordPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(confirmPassword.isDisplayed());
    }

    public void verifyInputNewPasswordWithoutConfirmation() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, driver, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyCoincidencePasswordAndConfirmation() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, driver, "1234567");
        fillInputField(confirmPassword, driver, "2233445");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Пожалуйста, убедитесь, что ваши пароли совпадают.");
    }

    public void verifySubscriptionCheckboxPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(subscription.isDisplayed());
        AssertCollector.assertFalse(subscription.isSelected());
    }

    public void verifyWorkOfCheckboxConfirm() {
        getUrl(REGISTRATION_PAGE_URL);
        scrollToNecessaryElement(checkboxConfirm);
        doubleClickOnElement(driver, checkboxConfirm);
        AssertCollector.assertFalse(checkboxConfirm.isSelected());
    }

    public void verifyCheckboxConfirmPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(checkboxConfirm.isDisplayed(), "Required check box is present");
        AssertCollector.assertFalse(checkboxConfirm.isSelected());
    }

    public void verifyPressSendButtonWithoutFillingFields() {
        getUrl(REGISTRATION_PAGE_URL);
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(11));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingEmailField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingPasswordField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingConfirmPasswordField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(12));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingCheckbox() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyDuplicateEmail() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, "123456789");
        fillInputField(confirmPassword, driver, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Учётная запись с таким адресом электронной почты уже существует. Если вы уверены, " +
                "что это ваш адрес, то нажмите сюда для получения пароля на email. С ним вы сможете получить доступ " +
                "к вашей учётной записи.");
    }

    public void verifyForgotPasswordButton() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "a.shaulo@andersenlab.com");
        fillInputField(password, driver, "123456789");
        fillInputField(confirmPassword, driver, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        String linkTextValue = getValueOfAttributeByName(forgotPassword, "href");
        elementFluentWaitVisibility(forgotPassword, driver).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of ",
                linkTextValue);
    }

    public void verifySuccessfulRegistration() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(12));
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(12));
        fillInputField(email, driver, "testuser@test.com");
        fillInputField(password, driver, "123456789");
        fillInputField(confirmPassword, driver, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Требуется подтверждение учётной записи. Ссылка для подтверждения была выслана на " +
                "указанный адрес электронной почты. Чтобы выслать ссылку повторно нажмите сюда.");
    }

    public void verifyLegalEntitySelected() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(organizationButton.isSelected());
    }

    public void verifyOrganizationFullNameFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(organizationFullName.isDisplayed());
    }

    //not pass
    public void verifyMaximumInputInFullName() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(organizationFullName, driver, RandomStringUtils.randomAlphabetic(256));
        AssertCollector.assertEquals(organizationFullName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(255).length());
    }

    public void verifyFieldForTaxpayerId() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(taxpayerId.isDisplayed());
    }

    public void verifyValidInputInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(taxpayerId, driver, "1234567891");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
    }

    public void verifyInputLettersInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(taxpayerId, driver, "абвы456781");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        AssertCollector.assertFalse(taxpayerId.getAttribute("value").matches("[A-Za-zа-яёА-ЯЁ]"));
    }

    // TODO: change regex expression
    public void verifyInputSymbolsInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(taxpayerId, driver, "%*&^@12121");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();

    }

    public void verifyInputLessThenTenDigitsInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(organizationFullName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(taxpayerId, driver, "7878");
        fillInputField(reasonCode, driver, RandomStringUtils.randomNumeric(9));
        fillInputField(legalAddress, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(company, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(address, driver, RandomStringUtils.randomAlphanumeric(10));
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(email, driver, "ashaulo@andersenlab.com");
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(10));
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(8));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirmLegal, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Значение \"ИНН\" должно содержать 10 символов.");
    }

    public void verifyReasonCodeFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(reasonCode.isDisplayed());
    }

    public void verifyValidInputInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(reasonCode, driver, RandomStringUtils.randomNumeric(9));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        AssertCollector.assertTrue(reasonCode.getAttribute("value").matches("\\d+"));
    }

    public void verifyInputLettersInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(reasonCode, driver, "абвы56781");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();
        AssertCollector.assertFalse(reasonCode.getAttribute("value").matches("[A-Za-zа-яёА-ЯЁ]"));
    }

    // TODO: change regex expression
    public void verifyInputSymbolsInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(reasonCode, driver, "%*&^@212121");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton, driver).click();

    }

    public void verifyInputLessThenNineDigitsInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(organizationFullName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(taxpayerId, driver, RandomStringUtils.randomNumeric(10));
        fillInputField(reasonCode, driver, "7878");
        fillInputField(legalAddress, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(company, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(address, driver, RandomStringUtils.randomAlphanumeric(10));
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(lastName, driver, RandomStringUtils.randomAlphabetic(10));
        fillInputField(email, driver, "ashaulo@andersenlab.com");
        fillInputField(phone, driver, RandomStringUtils.randomNumeric(10));
        fillInputField(password, driver, RandomStringUtils.randomAlphanumeric(8));
        fillInputField(confirmPassword, driver, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirmLegal, driver).click();
        elementFluentWaitVisibility(sendButton, driver).click();
        textPresent("Значение \"КПП\" должно содержать 9 символов.");
    }

    public void verifyLegalAddressFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(legalAddress.isDisplayed());
    }

    //not pass
    public void verifyMaximumInputInLegalAddress() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(legalAddress, driver, RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertEquals(legalAddress.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphanumeric(255).length());
    }
}
