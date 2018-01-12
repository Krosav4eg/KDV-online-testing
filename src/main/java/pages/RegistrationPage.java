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
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty());
    }

    public void verifyInputLettersInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, RandomStringUtils.randomAlphabetic(10));
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty());
    }

    public void verifyInputSpacesInPhoneField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(phone, driver, EMPTY_DATA);
        AssertCollector.assertTrue(phone.getAttribute("value").isEmpty());
    }
}
