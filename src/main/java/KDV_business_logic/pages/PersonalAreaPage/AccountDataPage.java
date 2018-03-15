package KDV_business_logic.pages.PersonalAreaPage;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Core.utils.AssertCollector;

import static Core.utils.Constants.*;

/**
 * @author Sergey Potapov
 */

public class AccountDataPage extends BasePage {
    public AccountDataPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class=\"success-msg\"]")
    public WebElement sucsessMessage;

    @FindBy(xpath = "//h1[contains(text(), \"Учётная запись\")]")
    public WebElement personalDataHeaderInEditPage;

    @FindBy(xpath = "//h2[contains(text(), \"Личные данные\")]")
    public WebElement personalDataInEditPage;

    @FindBy(xpath = "//h2[contains(text(), \"Рассылка\")]")
    public WebElement sharingInEditPage;

    @FindBy(css = "#firstname")
    public WebElement firstNameInEditPage;

    @FindBy(css = "#lastname")
    public WebElement lastNameInEditPage;

    @FindBy(css = ".button.button_mobile-wide")
    public WebElement saveButtonInEditPage;

    @FindBy(css = ".address__action.link.offset-l-2")
    public WebElement deleteNewAddress;

    @FindBy(id = "phone")
    public WebElement phoneInEditPage;

    @FindBy(css = "input[name=\"telephone\"]")
    public WebElement newPhoneField;

    @FindBy(css = "input[name=\"street[]\"]")
    public WebElement newAddressField;

    @FindBy(id = "floor")
    public WebElement newFloorField;

    @FindBy(id = "porch")
    public WebElement newPorchField;

    @FindBy(css = "#current_password")
    public WebElement passwordInEditPage;

    @FindBy(css = "#email")
    public WebElement emailInEditPage;

    @FindBy(xpath = ".//*[@id='form-validate']/div[1]")
    private WebElement informationAccountEdit;

    @FindBy(css = ".checkbox__label")
    public WebElement changePasswordCheckbox;

    @FindBy(xpath = "//h2[text()='Изменить пароль']")
    public WebElement changePasswordHeader;

    @FindBy(css = "#password")
    public WebElement newPasswordField;

    @FindBy(css = "#confirmation")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//span[text()='Адрес удалён.']")
    public WebElement deletionAddress;

    ControlPanelPage controlPanelPage = new ControlPanelPage(driver);

    public JSONObject mainAccountInfo() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        data.put("email", "test_a.evdokimov@magdv.com");
        data.put("phone", "+71111111111");
        data.put("currentPassword", AUTHORIZATION_PASSWORD);
        data.put("newPassword", "");
        data.put("confirmPassword", "");
        return data;
    }

    public JSONObject addingNewAddressInfo() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Вера");
        data.put("lastName", "Калашникова");
        data.put("phone", "+71111111111");
        data.put("address", "Томск, пр. Мира 20, оф.1");
        data.put("floor", "1");
        data.put("porch", "6");
        return data;
    }

    public String verifyEditAccountFields(JSONObject data) {
        getUrl(ACCOUNT_INFORMATION_URL);
        elementFluentWaitVisibility(firstNameInEditPage).clear();
        elementFluentWaitVisibility(firstNameInEditPage).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameInEditPage).clear();
        elementFluentWaitVisibility(lastNameInEditPage).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(emailInEditPage).clear();
        elementFluentWaitVisibility(emailInEditPage).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(phoneInEditPage).clear();
        elementFluentWaitVisibility(phoneInEditPage).sendKeys(data.getString("phone"));
        elementFluentWaitVisibility(passwordInEditPage).clear();
        elementFluentWaitVisibility(passwordInEditPage).sendKeys(data.getString("currentPassword"));
        AssertCollector.assertEqualsJ(getCurrentUrl(), ACCOUNT_INFORMATION_URL, "Verify current url");
        return getText(informationAccountEdit);
    }

    public void verifyUserNameAfterChangingFirstAndLastName() {
        scrollToNecessaryElement(saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        AssertCollector.verifyCondition(getCurrentUrl().contains(ACCOUNT_PAGE_URL));
        AssertCollector.verifyCondition(controlPanelPage.nameInPersonalData.getText().contains("Аркадий Евдокимов"));
    }

    public void verifyEmailFieldValidation() {
        AssertCollector.assertEquals(emailInEditPage.getAttribute("value"),
                " Value of current password field is equal ", emailInEditPage.
                        getAttribute("value"));
        scrollToNecessaryElement(saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        AssertCollector.assertEquals(getCurrentUrl(), "Current url is equals", ACCOUNT_PAGE_URL);
        AssertCollector.assertTrue(controlPanelPage.emailInPersonalData.getText().contains(AUTHORIZATION_EMAIL));
    }

    public void verifyPhoneFieldValidation() {
        AssertCollector.assertEquals(phoneInEditPage.getAttribute("value"),
                " Value of phone field is equal ", phoneInEditPage.
                        getAttribute("value"));
        scrollToNecessaryElement(saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(), ACCOUNT_PAGE_URL, "Urls are equals");
        AssertCollector.assertTrue(controlPanelPage.phoneInPersonalData.getText().contains("+77711111111"));
    }

    public void verifyPhoneFieldLengthValidation() {
        scrollUp();
        AssertCollector.verifyCondition(newPhoneField.getAttribute("value").length() ==
                RandomStringUtils.randomNumeric(11).length());
    }

    public void verifyPasswordFieldValidation() {
        AssertCollector.assertEquals(passwordInEditPage.getAttribute("value"),
                " Value of current password field is equal ", passwordInEditPage.
                        getAttribute("value"));
        scrollToNecessaryElement(saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        AssertCollector.assertEquals(getCurrentUrl(), "Current url is equals", ACCOUNT_PAGE_URL);
    }

    public void verifyLengthFirstAndLastName() {
        AssertCollector.verifyCondition(firstNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(45).length());
        AssertCollector.verifyCondition(lastNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(45).length());
    }

    public void verifyFirstAndLastNameSpecialSymbols() {
        AssertCollector.verifyCondition(firstNameInEditPage.getAttribute("value") ==
                "Анна-Мар'я");
        AssertCollector.verifyCondition(lastNameInEditPage.getAttribute("value") ==
                "Анна-Мар'я");
    }

    public String verifyAddingNewAccountFields(JSONObject data) {
        getUrl(BASE_URL + "/customer/address/new/");
        elementFluentWaitVisibility(firstNameInEditPage).clear();
        elementFluentWaitVisibility(firstNameInEditPage).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameInEditPage).clear();
        elementFluentWaitVisibility(lastNameInEditPage).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(newPhoneField).clear();
        elementFluentWaitVisibility(newPhoneField).sendKeys(data.getString("phone"));
        elementFluentWaitVisibility(newAddressField).clear();
        elementFluentWaitVisibility(newAddressField).sendKeys(data.getString("address"));
        scrollByCoordinate();
        elementFluentWaitVisibility(newFloorField).clear();
        elementFluentWaitVisibility(newFloorField).sendKeys(data.getString("floor"));
        elementFluentWaitVisibility(newPorchField).clear();
        elementFluentWaitVisibility(newPorchField).sendKeys(data.getString("porch"));
        return getText(informationAccountEdit);
    }

    public void verifyAddressMaximumLength() {
        AssertCollector.verifyCondition(firstNameInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(255).length());
        elementFluentWaitVisibility(newAddressField).clear();
        fillInputFieldAndPressEnterButton(newAddressField, "г Кемерово, ул 50 лет Октября");
        textPresent("Внимание! Вы не указали номер квартиры, офиса.");
    }

    public void changingPassword(String currentPass, String newPass) {
        getUrl(BASE_URL + "/customer/account/edit/");
        elementFluentWaitVisibility(phoneInEditPage).clear();
        elementFluentWaitVisibility(phoneInEditPage).sendKeys(RandomStringUtils.randomNumeric(10));
        fillInputField(passwordInEditPage, currentPass);
        elementFluentWaitVisibility(changePasswordCheckbox).click();
        fillInputField(newPasswordField, newPass);
        fillInputField(confirmPasswordField, newPass);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        AssertCollector.assertTrue(sucsessMessage.getText().contains("Данные учётной записи сохранены."));
    }

    public void verifyFirstAndLastNameValues() {
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        textPresent("Адрес сохранён.");
        textPresent("Анна-Мар'я");
        textPresent("Томск, пр. Мира 20, оф.1");
        scrollByCoordinate();
        elementFluentWaitVisibility(deleteNewAddress).click();
        AssertCollector.verifyCondition(deletionAddress.isDisplayed());
    }

    public void verifyAccountInfoVisibility() {
        getUrl(ACCOUNT_INFORMATION_URL);
        AssertCollector.verifyCondition(elementIsVisible(personalDataHeaderInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(personalDataInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(sharingInEditPage));
    }

    public void verifyImportantEmptyFieldAdvices() {
        elementFluentWaitVisibility(changePasswordCheckbox).click();
        scrollToNecessaryElement(saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        textPresent("Это поле обязательно для заполнения");
        scrollToNecessaryElement(saveButtonInEditPage);
        AssertCollector.assertTrue(elementIsVisible(changePasswordHeader),
                "Required field is displayed");
        AssertCollector.assertTrue(elementIsVisible(newPasswordField),
                "Required field is displayed");
        AssertCollector.assertTrue(elementIsVisible(confirmPasswordField),
                "Required field is displayed");
    }

    public void checkRequiredFieldsMessage() {
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        textPresent("Это поле обязательно для заполнения.");
    }
}
