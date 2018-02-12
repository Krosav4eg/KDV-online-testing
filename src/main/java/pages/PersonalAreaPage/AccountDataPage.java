package pages.PersonalAreaPage;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.*;
import static utils.WaitingUtility.elementFluentWaitVisibility;

/**
 * @author Sergey Potapov
 */

public class AccountDataPage extends BasePage {
    public AccountDataPage(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(id = "adv_phone")
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

    BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

    public JSONObject mainAccountInfo() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        data.put("email", "test_a.evdokimov@magdv.com");
        data.put("phone", "+71111111111");
        data.put("currentPassword", AUTHORIZATION_PASSWORD);
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
        elementFluentWaitVisibility(firstNameInEditPage, driver).clear();
        elementFluentWaitVisibility(firstNameInEditPage, driver).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameInEditPage, driver).clear();
        elementFluentWaitVisibility(lastNameInEditPage, driver).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(emailInEditPage, driver).clear();
        elementFluentWaitVisibility(emailInEditPage, driver).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(phoneInEditPage, driver).clear();
        elementFluentWaitVisibility(phoneInEditPage, driver).sendKeys(data.getString("phone"));
        elementFluentWaitVisibility(passwordInEditPage, driver).clear();
        elementFluentWaitVisibility(passwordInEditPage, driver).sendKeys(data.getString("currentPassword"));
        AssertCollector.assertTrue(getCurrentUrl().contains(ACCOUNT_PAGE_URL), "Verify current url");
        return getText(informationAccountEdit);
    }

    public String verifyAddingNewAccountFields(JSONObject data) {
        getUrl(BASE_URL + "/customer/address/new/");
        elementFluentWaitVisibility(firstNameInEditPage, driver).clear();
        elementFluentWaitVisibility(firstNameInEditPage, driver).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameInEditPage, driver).clear();
        elementFluentWaitVisibility(lastNameInEditPage, driver).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(newPhoneField, driver).clear();
        elementFluentWaitVisibility(newPhoneField, driver).sendKeys(data.getString("phone"));
        elementFluentWaitVisibility(newAddressField, driver).clear();
        elementFluentWaitVisibility(newAddressField, driver).sendKeys(data.getString("address"));
        del.scrollByCoordinate();
        elementFluentWaitVisibility(newFloorField, driver).clear();
        elementFluentWaitVisibility(newFloorField, driver).sendKeys(data.getString("floor"));
        elementFluentWaitVisibility(newPorchField, driver).clear();
        elementFluentWaitVisibility(newPorchField, driver).sendKeys(data.getString("porch"));
        return getText(informationAccountEdit);
    }

    public void verifyAddressDropDownAddress() {
        elementFluentWaitVisibility(newAddressField, driver).clear();
        fillInputFieldAndPressEnterButton(newAddressField, "г Кемерово, ул 50 лет Октября, д 16 ");
    }
}
