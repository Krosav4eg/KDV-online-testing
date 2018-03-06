package KDV_business_logic.pages;

import Core.basePage.BasePage;
import KDV_business_logic.pages.PersonalAreaPage.PersonalCabinetPage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Core.utils.AssertCollector;
import org.testng.Assert;

import static Core.utils.Constants.EMPTY_DATA;
import static Core.utils.Constants.REGISTRATION_PAGE_URL;
import static Core.utils.WaitingUtility.elementFluentWaitVisibility;
import static Core.utils.WaitingUtility.elementIsClickable;
import static Core.utils.WaitingUtility.elementIsDisplayed;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".registration-layout__content")
    public WebElement allContainerText;

    @FindBy(xpath = "//a[@rel='general']")
    private WebElement individualButton;

    @FindBy(id = "customer_type_legal")
    private WebElement legalBtn;

    @FindBy(xpath = "//a[@rel='legal']")
    private WebElement organizationButton;

    @FindBy(xpath = "//li[@class=\"notice-msg\"]")
    private WebElement noticeMessage;

    @FindBy(xpath = "//a[contains(text(),'Индивидуальный предприниматель')]")
    private WebElement individualEntrepreneurButton;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

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

    @FindBy(css = "a[rel='individual']")
    public WebElement getIndividualButton;

    @FindBy(xpath = "(//a[@class=\"radio__label j_organization_type_link\"])[1]")
    public WebElement getLegalButton;

    @FindBy(css = "[for='is_agree_legal']")
    private WebElement agreeLegal;

    @FindBy(css = ".j_login_section")
    private WebElement loginInformation;

    @FindBy(xpath = "//label[@data-show='general']")
    private WebElement checkboxConfirm;

    @FindBy(id = "form-validate")
    private WebElement formValidate;

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

    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    public void verifyLegalFormByDefault() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(individualButton.isEnabled());
    }

    public void verifyChoosingLegalForm() {
        getUrl(REGISTRATION_PAGE_URL);
        String linkTextAttribute = getValueOfAttributeByName(organizationButton, "href");
        elementFluentWaitVisibility(organizationButton).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to url with selected organization ",
                linkTextAttribute);
    }

    public void verifyForOrganizationsTextPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        Assert.assertTrue(noticeMessage.getText().contains("Внимание! Все заявки на регистрацию контрагентов"));
    }

    public void verifyFieldFirstNamePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(firstName));
    }

    public void verifyInputInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(firstName).click();
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(46));
        elementFluentWaitVisibility(layout).click();
        String text = firstName.getAttribute("value");
        AssertCollector.assertEquals(text, " Current text is equal to ", text);
    }

    //test not pass(validation problems)
    public void verifyMaximumInputInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(46));
        AssertCollector.assertEquals(firstName.getAttribute("value").length(),
                " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(45).length());
    }

    //test not pass(validation problems)
    public void verifyInputNumbersInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomNumeric(6));
        AssertCollector.assertTrue(firstName.getAttribute("value").isEmpty(), "required field is empty");
    }

    //test not pass(validation problems)
    public void verifyInputForbiddenSymbolsInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, "!@#$%^&*()+_/|{}[]?><.,");
        AssertCollector.assertTrue(firstName.getAttribute("value").isEmpty(), "required field is empty");
    }

    public void verifyInputSpecialSymbolsInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, "Анна-Мар'я");
        elementFluentWaitVisibility(layout).click();
        String text = firstName.getAttribute("value");
        AssertCollector.assertEquals(text, " Current text is equal to ", text);
    }

    public void verifyFieldLastNamePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(lastName));
    }

    public void verifyInputInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(46));
        elementFluentWaitVisibility(layout).click();
        String text = lastName.getAttribute("value");
        AssertCollector.assertEquals(text, "  Current text is equal to  ", text);
    }


    public void verifyMaximumInputInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(46));
        AssertCollector.assertEquals(lastName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(45).length());
    }

    //test not pass(validation problems)
    public void verifyInputNumbersInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, RandomStringUtils.randomNumeric(6));
        AssertCollector.assertTrue(lastName.getAttribute("value").isEmpty(), "required field is empty");
    }

    //test not pass(validation problems)
    public void verifyInputForbiddenSymbolsInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(lastName).click();
        fillInputField(lastName, "!@#$%^&*()+_/|{}[]?><.,");
        AssertCollector.assertTrue(lastName.getAttribute("value").isEmpty(), "required field is empty");
    }

    public void verifyInputSpecialSymbolsInLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(lastName).click();
        fillInputField(lastName, "Иванов-Петров'ъ");
        elementFluentWaitVisibility(layout).click();
        String text = lastName.getAttribute("value");
        AssertCollector.assertEquals(text, "  Current text is equal to ", text);
    }

    public void verifyFieldPhonePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(PersonalCabinetPage.phoneInEditPage));
    }

    public void verifyMaskInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(PersonalCabinetPage.phoneInEditPage).click();
        AssertCollector.assertTrue(PersonalCabinetPage.phoneInEditPage.getAttribute("value").isEmpty(),
                "phone mask is correct");
    }

    public void verifyMaximumInputInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(15));
        AssertCollector.assertEquals(PersonalCabinetPage.phoneInEditPage.getAttribute("value").length(),
                " The length of phone number equals ",
                RandomStringUtils.randomNumeric(12).length());
    }

    public void verifyInputForbiddenSymbolsInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(PersonalCabinetPage.phoneInEditPage, "!@#$%^&*()+_/|{}[]?><.,");
        AssertCollector.assertTrue(PersonalCabinetPage.phoneInEditPage.getAttribute("value").isEmpty(),
                "Phone field is displayed");
    }

    public void verifyInputLettersInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomAlphabetic(10));
        AssertCollector.assertTrue(PersonalCabinetPage.phoneInEditPage.getAttribute("value").isEmpty(),
                "Phone field is displayed");
    }

    public void verifyInputSpacesInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(PersonalCabinetPage.phoneInEditPage, EMPTY_DATA);
        AssertCollector.assertTrue(PersonalCabinetPage.phoneInEditPage.getAttribute("value").isEmpty(),
                "Phone field is displayed");
    }

    public void verifyInputLessThenTenNumbersInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(5));
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(10));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(10));
        fillInputField(email, "test@test.ru");
        fillInputField(password, "123456789");
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(footer);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Значение \"Телефон\" должно соответствовать формату: +7XXXXXXXXXX");
    }

    public void verifyFieldEmailPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(email), "Email field is displayed");
    }

    //Пропало сообщение "Часть адреса после символа \"@\" не должна содержать символ \" \"." на
    public void verifyEmailWithoutAtSymbol() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, "a.shauloandersenlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Адрес электронной почты должен содержать символ \"@\". В адресе \"a.shauloandersenlab.com\" " +
                "отсутствует символ \"@\".");
    }

    public void verifyEmailWithoutDomainName() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, "a.shaulo@andersenlabcom");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). " +
                "Например, ivanivanov@domain.com.");
    }

    public void verifyEmailWithMoreThanOneDot() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, "a..shaulo@andersenlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Пожалуйста, введите правильный адрес электронной почты (email). " +
                "Например, ivanivanov@domain.com.");
    }

    //Пропало сообщение "Часть адреса после символа \"@\" не должна содержать символ \" \"." на
    public void verifyEmailWithSpacesBeforeAtSymbol() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, "a.s ha ulo@andersenlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Часть адреса до символа \"@\" не должна содержать символ \" \".");
    }

    //Пропало сообщение "Часть адреса после символа \"@\" не должна содержать символ \" \"." на
    public void verifyEmailWithSpacesAfterAtSymbol() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(email, "a.shaulo@anders enlab.com");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Часть адреса после символа \"@\" не должна содержать символ \" \".");
    }

    public void verifyFieldPasswordPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(password));
    }

    public void verifyPasswordLengthLessThanSixSymbols() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, "12345");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале.");
    }

    public void verifyPasswordWithOnlySpaces() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, EMPTY_DATA);
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyPasswordWithSpacesAtStartAndEnd() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, "   123456   ");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Пожалуйста, введите не менее 6 символов без пробелов в конце и в начале.");
    }

    public void verifyFieldConfirmPasswordPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(confirmPassword));
    }

    public void verifyInputNewPasswordWithoutConfirmation() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(password, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
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
        data.put("taxId", RandomStringUtils.randomNumeric(12));
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

    public String verifyMandatory() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationCheckBox).click();
        elementFluentWaitVisibility(getIndividualButton).click();
        scrollToNecessaryElement(footer);
        elementIsClickable(subscription).click();
        AssertCollector.assertTrue(subscription.isEnabled());
        elementIsClickable(agreeLegal).click();
        AssertCollector.assertTrue(agreeLegal.isEnabled());
        elementIsClickable(sendButton).click();
        return getText(loginInformation);
    }

    //метод scrollToNecessaryElement(footer) не срабатывал. Заменил на del.scrollByCoordinate();
    public String verifyAuthorizationFields(JSONObject data) {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationCheckBox).click();
        verifyAuthorizationInformation(data);
        organizationInformation(data);
        addressDelivery(data);
        contactData(data);
        del.scrollByCoordinate();
        elementIsClickable(subscription).click();
        AssertCollector.assertTrue(subscription.isEnabled());
        elementIsClickable(agreeLegal).click();
        AssertCollector.assertTrue(agreeLegal.isEnabled());
        elementIsClickable(sendButton).click();
        sleepWait();
        System.out.println(getText(layout));
        return getText(layout);
    }

    public String selectExistEmail() {
        elementFluentWaitVisibility(forgotPasswordLink).click();
        return getCurrentUrl();
    }

    public String verifyUnselectCheckoBoxIndividual(JSONObject data) {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationCheckBox).click();
        elementFluentWaitVisibility(getIndividualButton).click();
        verifyAuthorizationInformation(data);
        organizationInformationIndividual(data);
        addressDelivery(data);
        contactData(data);
        scrollToNecessaryElement(footer);
        elementIsClickable(sendButton).click();
        return getText(layout);
    }

    public String verifyAuthorizationFieldsIndividual(JSONObject data) {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationCheckBox).click();
        elementFluentWaitVisibility(getIndividualButton).click();
        scrollToNecessaryElement(footer);
        elementIsClickable(sendButton).click();
        elementIsClickable(agreeLegal).click();
        scrollToNecessaryElement(getHeaderTxt);
        verifyAuthorizationInformation(data);
        organizationInformationIndividual(data);
        addressDelivery(data);
        contactData(data);
        del.scrollByCoordinate();
        elementIsClickable(subscription).click();
        AssertCollector.assertTrue(subscription.isEnabled());
        AssertCollector.assertTrue(agreeLegal.isEnabled());
        elementIsClickable(sendButton).click();
        return getText(layout);
    }

    //registration
    private String verifyAuthorizationInformation(JSONObject data) {
        moveToElementJS(driver, PersonalCabinetPage.phoneInEditPage);
        elementFluentWaitVisibility(email).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(password).sendKeys(data.getString("password"));
        elementFluentWaitVisibility(confirmPassword).sendKeys(data.getString("confirmPassword"));
        return getText(loginInformation);
    }

    public String organizationInformation(JSONObject data) {
        moveMouseTo(driver, allertTxt);
        elementFluentWaitVisibility(organizationFullName).click();
        elementFluentWaitVisibility(organizationFullName).sendKeys(data.getString("organizationName"));
        elementFluentWaitVisibility(taxpayerId).click();
        elementFluentWaitVisibility(taxpayerId).sendKeys(data.getString("taxId"));
        elementFluentWaitVisibility(reasonCode).click();
        elementFluentWaitVisibility(reasonCode).sendKeys(data.getString("reasonCode"));
        elementFluentWaitVisibility(legalAddress).click();
        elementFluentWaitVisibility(legalAddress).sendKeys(data.getString("legalAddress"));
        return getText(informationOrganization);
    }

    private String organizationInformationIndividual(JSONObject data) {
        moveMouseTo(driver, allertTxt);
        elementFluentWaitVisibility(organizationFullName).click();
        elementFluentWaitVisibility(organizationFullName).sendKeys(data.getString("organizationName"));
        elementFluentWaitVisibility(taxpayerId).click();
        elementFluentWaitVisibility(taxpayerId).sendKeys(data.getString("taxId"));
        elementFluentWaitVisibility(legalAddress).click();
        elementFluentWaitVisibility(legalAddress).sendKeys(data.getString("legalAddress"));
        return getText(informationOrganization);
    }

    String addressDelivery(JSONObject data) {
        elementFluentWaitVisibility(company).sendKeys(data.getString("company"));
        elementFluentWaitVisibility(address).sendKeys(data.getString("address"));
        elementFluentWaitVisibility(comments).sendKeys(data.getString("comments"));
        return getText(addressDelivery);
    }

    public String contactData(JSONObject data) {
        elementFluentWaitVisibility(firstName).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastName).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(PersonalCabinetPage.phoneInEditPage).click();
        elementFluentWaitVisibility(PersonalCabinetPage.phoneInEditPage).sendKeys(data.getString("phone"));
        return getText(contactData);
    }

    /********************/
    public void verifyRegistrationWithEmptyFields() {
        getUrl(REGISTRATION_PAGE_URL);
        elementIsClickable(organizationCheckBox).click();
        scrollToNecessaryElement(footer);
        elementIsClickable(subscription).click();
        elementIsClickable(agreeLegal).click();
        elementIsClickable(sendButton).click();
        AssertCollector.assertTrue(getText(getHeaderTxt).contains("Регистрация"));
        AssertCollector.assertTrue(getText(loginInformation).contains("Это поле обязательно для заполнения."));
    }

    public void forgotPassword() {
        elementIsClickable(forgotPasswordLink).click();
        AssertCollector.assertTrue(getText(forgotPasswordTxt).contains("Восстановление вашего пароля"));
    }

    public void verifySubscriptionCheckboxPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(elementIsDisplayed(subscription));
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
        AssertCollector.assertTrue(elementIsDisplayed(checkboxConfirm), "Required check box is present");
        AssertCollector.assertFalse(checkboxConfirm.isSelected());
    }

    public void verifyPressSendButtonWithoutFillingFields() {
        getUrl(REGISTRATION_PAGE_URL);
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingLastNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(11));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingEmailField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(password, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingPasswordField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingConfirmPasswordField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, RandomStringUtils.randomAlphanumeric(12));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifySendingWithoutFillingCheckbox() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, RandomStringUtils.randomAlphanumeric(12));
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Это поле обязательно для заполнения.");
    }

    public void verifyDuplicateEmail() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, "123456789");
        fillInputField(confirmPassword, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Учётная запись с таким адресом электронной почты уже существует.");
    }

    public void verifyForgotPasswordButton() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, "a.shaulo@andersenlab.com");
        fillInputField(password, "123456789");
        fillInputField(confirmPassword, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        String linkTextValue = getValueOfAttributeByName(forgotPassword, "href");
        elementFluentWaitVisibility(forgotPassword).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of ",
                linkTextValue);
    }

    public void verifySuccessfulRegistration() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(12));
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(12));
        fillInputField(email, RandomStringUtils.randomAlphabetic(7) + "@test.com");
        fillInputField(password, "123456789");
        fillInputField(confirmPassword, "123456789");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirm).click();
        elementFluentWaitVisibility(sendButton).click();
        Assert.assertTrue(formValidate.getText().contains("Требуется подтверждение учётной записи."));
    }

    public void verifyLegalEntitySelected() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        System.out.println(legalBtn.isSelected());
        AssertCollector.assertTrue(legalBtn.isSelected());
    }

    public void verifyOrganizationFullNameFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        AssertCollector.assertTrue(elementIsDisplayed(organizationFullName));
    }

    //not pass
    public void verifyMaximumInputInFullName() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(organizationFullName, RandomStringUtils.randomAlphabetic(256));
        AssertCollector.assertEquals(organizationFullName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(255).length());
    }

    public void verifyFieldForTaxpayerId() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        AssertCollector.assertTrue(elementIsDisplayed(taxpayerId));
    }

    public void verifyValidInputInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(taxpayerId, "1234567891");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
    }

    public void verifyInputLettersInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(taxpayerId, "абвы456781");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        AssertCollector.assertFalse(taxpayerId.getAttribute("value").matches("[A-Za-zа-яёА-ЯЁ]"));
    }

    // TODO: change regex expression
    public void verifyInputSymbolsInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(taxpayerId, "%*&^@12121");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
    }

    public void verifyInputLessThenTenDigitsInTaxpayerIdField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(organizationFullName, RandomStringUtils.randomAlphabetic(10));
        fillInputField(taxpayerId, "7878");
        fillInputField(reasonCode, RandomStringUtils.randomNumeric(9));
        fillInputField(legalAddress, RandomStringUtils.randomAlphabetic(10));
        fillInputField(company, RandomStringUtils.randomAlphabetic(10));
        fillInputField(address, RandomStringUtils.randomAlphanumeric(10));
        fillInputField(firstName, RandomStringUtils.randomAlphabetic(10));
        fillInputField(lastName, RandomStringUtils.randomAlphabetic(10));
        fillInputField(email, "ashaulo@andersenlab.com");
        fillInputField(PersonalCabinetPage.phoneInEditPage, RandomStringUtils.randomNumeric(10));
        fillInputField(password, RandomStringUtils.randomAlphanumeric(8));
        fillInputField(confirmPassword, password.getAttribute("value"));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(checkboxConfirmLegal).click();
        elementFluentWaitVisibility(sendButton).click();
        textPresent("Значение \"ИНН\" должно содержать 10 символов.");
    }

    public void verifyReasonCodeFieldPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        AssertCollector.assertTrue(elementIsDisplayed(reasonCode));
    }

    public void verifyValidInputInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(reasonCode, RandomStringUtils.randomNumeric(9));
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        AssertCollector.assertTrue(reasonCode.getAttribute("value").matches("\\d+"));
    }

    public void verifyInputLettersInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(reasonCode, "абвы56781");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
        AssertCollector.assertFalse(reasonCode.getAttribute("value").matches("[A-Za-zа-яёА-ЯЁ]"));
    }

    // TODO: change regex expression
    public void verifyInputSymbolsInReasonCodeField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        fillInputField(reasonCode, "%*&^@212121");
        scrollToNecessaryElement(sendButton);
        elementFluentWaitVisibility(sendButton).click();
    }

    public void verifyIndividualEntrepreneurRadioButton() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton).click();
        elementFluentWaitVisibility(individualEntrepreneurButton).click();
        AssertCollector.assertTrue(organizationButton.isEnabled(), "Required radio button is selected");
    }
}
