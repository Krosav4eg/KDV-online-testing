package pages;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.EMPTY_DATA;
import static utils.Constants.REGISTRATION_PAGE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.elementIsClickable;


public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@rel='general']")
    private WebElement individualButton;

    @FindBy(xpath = "//a[@rel='legal']")
    private WebElement organizationButton;

    @FindBy(xpath = "//a[contains(text(),'Индивидуальный предприниматель')]")
    private WebElement individualEntrepreneurButton;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(id = "adv_phone")
    public WebElement phone;

    @FindBy(css = "#create-user-form > div.registration-layout__content.row > div:nth-child(3)")
    private WebElement contactData;

    @FindBy(id = "email_address")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "confirmation")
    public WebElement confirmPassword;

    @FindBy(css = "[for='is_subscribed']")
    private WebElement subscription;

    @FindBy(css = "[for='is_agree_legal']")
    private WebElement agreeLegal;

    @FindBy(css = ".j_login_section")
    private WebElement loginInformation;

    @FindBy(xpath = "//label[@data-show='general']")
    private WebElement checkboxConfirm;

    @FindBy(xpath = "//label[@data-show='legal']")
    private WebElement checkboxConfirmLegal;

    @FindBy(css = "h1")
    private WebElement getHeaderTxt;

    @FindBy(className = "text")
    private WebElement allertTxt;

    @FindBy(css = ".error-msg a")
    private WebElement forgotPasswordLink;

    @FindBy(css = ".login__title_forgotpassword")
    private WebElement forgotPasswordTxt;

    @FindBy(css = "button[title='Отправить']")
    private WebElement sendButton;

    @FindBy(css = ".layout__footer")
    private WebElement footer;

    @FindBy(css = ".layout__content")
    private WebElement layout;

    @FindBy(css = ".error-msg>ul>li>span>a")
    private WebElement forgotPassword;

    @FindBy(id = "adv_full_name")
    public WebElement organizationFullName;

    @FindBy(id = "adv_inn")
    public WebElement taxpayerId;

    @FindBy(id = "adv_kpp")
    private WebElement reasonCode;

    @FindBy(id = "legal_address")
    public WebElement legalAddress;

    @FindBy(css = "#create-user-form > div.registration-layout__content.row > div:nth-child(1)")
    private WebElement informationOrganization;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "street")
    public WebElement address;

    @FindBy(id = "comments")
    public WebElement comments;

    @FindBy(css = "#create-user-form > div.registration-layout__content.row > div:nth-child(2)")
    private WebElement addressDelivery;

    @FindBy(xpath = "//span[contains(text(), \"г\")]/*[text()='Томск']")
    private WebElement cityForAddress;

    @FindBy(css = "a[data-customer-type='3'].j_customer_type_link")
    private WebElement organizationCheckBox;

    @FindBy(css = "div.layout.container-static-top div > div > div > ul > li > ul > li > span")
    public WebElement getAlertTet;

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
        elementFluentWaitVisibility(phone, driver).click();
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty(), "phone mask is correct");
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

    /**
     * Validation JSON for tests
     *
     * @return JSONData
     */
    public JSONObject mainInfoRegistration() {
        JSONObject data = new JSONObject();
        String pass = RandomStringUtils.randomAlphabetic(10);
        data.put("email", RandomStringUtils.randomAlphabetic(10) + "@test.com");
        data.put("password", pass);
        data.put("confirmPassword", pass);
        data.put("organizationName", "ТЕСТ");
        data.put("taxId", RandomStringUtils.randomNumeric(10));
        data.put("reasonCode", RandomStringUtils.randomNumeric(9));
        data.put("legalAddress", RandomStringUtils.randomAlphabetic(20));
        data.put("company", "ТЕСТ");
        data.put("address", RandomStringUtils.randomAlphabetic(20));
        data.put("comments", RandomStringUtils.randomAlphabetic(20));
        data.put("firstName", RandomStringUtils.randomAlphabetic(20));
        data.put("lastName", RandomStringUtils.randomAlphabetic(20));
        data.put("phone", RandomStringUtils.randomNumeric(10));
        return data;
    }


    public String verifyAuthorizationFields(JSONObject data) {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationCheckBox, driver).click();
        String authorizationInformation = verifyAuthorizationInformation(data);
        String organizationInformation = organizationInformation(data);
        String addressDelivery = addressDelivery(data);
        String contactData = contactData(data);
        scrollToNecessaryElement(footer);
        elementIsClickable(subscription, driver).click();
        AssertCollector.assertTrue(subscription.isEnabled());
        elementIsClickable(agreeLegal, driver).click();
        AssertCollector.assertTrue(agreeLegal.isEnabled());
        elementIsClickable(sendButton, driver).click();
        return organizationInformation + addressDelivery + contactData + authorizationInformation;
    }

    //registration
    private String verifyAuthorizationInformation(JSONObject data) {
        moveToElementJS(driver, phone);
        elementFluentWaitVisibility(email, driver).click();
        elementFluentWaitVisibility(email, driver).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(password, driver).click();
        elementFluentWaitVisibility(password, driver).sendKeys(data.getString("password"));
        elementFluentWaitVisibility(confirmPassword, driver).click();
        elementFluentWaitVisibility(confirmPassword, driver).sendKeys(data.getString("confirmPassword"));
        return getText(loginInformation);
    }

    public String organizationInformation(JSONObject data) {
        moveMouseTo(driver, allertTxt);
        elementFluentWaitVisibility(organizationFullName, driver).click();
        elementFluentWaitVisibility(organizationFullName, driver).sendKeys(data.getString("organizationName"));
        elementFluentWaitVisibility(taxpayerId, driver).click();
        elementFluentWaitVisibility(taxpayerId, driver).sendKeys(data.getString("taxId"));
        elementFluentWaitVisibility(reasonCode, driver).click();
        elementFluentWaitVisibility(reasonCode, driver).sendKeys(data.getString("reasonCode"));
        elementFluentWaitVisibility(legalAddress, driver).click();
        elementFluentWaitVisibility(legalAddress, driver).sendKeys(data.getString("legalAddress"));
        return getText(informationOrganization);
    }

    String addressDelivery(JSONObject data) {
        elementFluentWaitVisibility(company, driver).click();
        elementFluentWaitVisibility(company, driver).sendKeys(data.getString("company"));
        elementFluentWaitVisibility(address, driver).click();
        elementFluentWaitVisibility(address, driver).sendKeys(data.getString("address"));
        elementFluentWaitVisibility(comments, driver).click();
        elementFluentWaitVisibility(comments, driver).sendKeys(data.getString("comments"));
        return getText(addressDelivery);
    }

    String contactData(JSONObject data) {
        elementFluentWaitVisibility(firstName, driver).click();
        elementFluentWaitVisibility(firstName, driver).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastName, driver).click();
        elementFluentWaitVisibility(lastName, driver).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(phone, driver).click();
        elementFluentWaitVisibility(phone, driver).sendKeys(data.getString("phone"));
        return getText(contactData);
    }

    /********************/
    public void verifyRegistrationWithEmptyFields() {
        getUrl(REGISTRATION_PAGE_URL);
        elementIsClickable(organizationCheckBox, driver).click();
        scrollToNecessaryElement(footer);
        elementIsClickable(subscription, driver).click();
        elementIsClickable(agreeLegal, driver).click();
        elementIsClickable(sendButton, driver).click();
        AssertCollector.assertTrue(getText(getHeaderTxt).contains("Регистрация"));
        AssertCollector.assertTrue(getText(loginInformation).contains("Это поле обязательно для заполнения."));
    }

    public void forgotPassword() {
        elementIsClickable(forgotPasswordLink, driver).click();
        AssertCollector.assertTrue(getText(forgotPasswordTxt).contains("Восстановление вашего пароля"));
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

    public void verifyCompanyFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(company.isDisplayed());
    }

    //not pass
    public void verifyMaximumInputInCompany() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(company, driver, RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertEquals(company.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphanumeric(255).length());
    }

    public void verifyAddressFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(address.isDisplayed());
    }

    public void verifyPromptsInAddressFieldAfterInput() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(address, driver, "Т");
        textPresent("Выберите адрес");
    }

    public void verifyPromptChoosingInAddressFieldAfterInput() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        scrollToNecessaryElement(company);
        elementFluentWaitVisibility(address, driver).click();
        fillInputField(address, driver, "Томск");
        elementFluentWaitVisibility(cityForAddress, driver).click();
        AssertCollector.assertTrue(address.getAttribute("value").contains("Томск"));
        textPresent("Внимание! Вы не указали номер квартиры, офиса.");
    }

    //not pass
    public void verifyFullAddressInputInAddressField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        scrollToNecessaryElement(company);
        fillInputField(address, driver, "Томск, пр. Мира 20, кв. 7");
    }

    //not pass
    public void verifyMaximumInputInAddressField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(address, driver, RandomStringUtils.randomAlphanumeric(256));
        AssertCollector.assertEquals(address.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphanumeric(255).length());
    }

    public void verifyCommentsFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        AssertCollector.assertTrue(comments.isDisplayed());
    }

    //not pass
    public void verifyMaximumInputInCommentsField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        fillInputField(comments, driver, RandomStringUtils.randomAlphanumeric(1001));
        AssertCollector.assertEquals(comments.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphanumeric(1000).length());
    }

    public void verifyIndividualEntrepreneurRadioButton() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        elementFluentWaitVisibility(individualEntrepreneurButton, driver).click();
        AssertCollector.assertTrue(organizationButton.isEnabled(), "Required radio button is selected");
    }
}
