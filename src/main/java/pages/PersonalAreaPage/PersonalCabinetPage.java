package pages.PersonalAreaPage;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.*;
import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.textIsPresent;

public class PersonalCabinetPage extends BasePage {
    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".profile__section .offset-l-1")
    public WebElement linkElement;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(css = "a.account__edit")
    private WebElement editBtn;

    @FindBy(css = ".notice-msg .text")
    private WebElement allertTxt;

    @FindBy(css = ".offset-l-1")
    private WebElement linkTxt;

    @FindBy(className = "profile")
    private WebElement profileContainer;

    @FindBy(id = "password")
    private WebElement newPasswordField;

    @FindBy(css = "h1.title")
    private WebElement titleField;

    @FindBy(id = "confirmation")
    private WebElement newConfirmationField;

    @FindBy(id = "firstname")
    private WebElement firstNameInEditPage;

    @FindBy(id = "lastname")
    private WebElement lastNameInEditPage;

    @FindBy(css = ".button.button_mobile-wide")
    private WebElement saveButtonInEditPage;

    @FindBy(id = "adv_phone")
    private WebElement phoneInEditPage;

    @FindBy(id = "current_password")
    private WebElement passwordInEditPage;

    @FindBy(css = "[name='change_password']")
    private WebElement changerPassBtn;

    @FindBy(css = "[name='is_subscribed']")
    private WebElement isSubscribedBtn;

    @FindBy(id = "email")
    private WebElement emailInEditPage;


    public JSONObject mainAccountInfo() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        data.put("email", "test_a.evdokimov@magdv.com");
        data.put("phone", "+71111111111");
        data.put("currentPassword", AUTHORIZATION_PASSWORD);
        return data;
    }

    public void verifyEditAccountFields(JSONObject data) {
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
    }

    /*******Legal Room********/

    public void verifyFieldsNotAuthorization() {
        AssertCollector.verifyCondition(getText(allertTxt).contains("Обратите внимание, что юридические лица и организации могут " +
                "оформлять заказы в интернет-магазине KDV только после рассмотрения заявки менеджером. "));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Здравствуйте, Александр Григорьев!"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("test_a.grigoriev@magdv.com"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71113959049"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Томск, Комсомольский проспект, 57"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71111111111"));
        elementFluentWaitVisibility(editBtn, driver).click();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/edit/"));
        backPage();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/"));
    }

    public void verifyFieldsAuthorization() {
        textIsPresent(titleField, driver, "Панель управления");
        AssertCollector.verifyCondition(getText(profileContainer).contains("Здравствуйте, Геннадий Фадеев!"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("test_g.fadeev@magdv.com"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71119348926"));
        moveToElementJS(driver, linkTxt);
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71111111111"));
        moveToElementJS(driver, linkElement);
        elementFluentWaitVisibility(editBtn, driver).click();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/edit/"));
        backPage();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/"));
    }

    public void verifyFieldsNotAuthorizationInfo() {
        getUrl(BASE_URL + "/advancedcustomer/legalinformation/");
        AssertCollector.verifyCondition(getText(allertTxt).contains("Обратите внимание, что юридические лица и организации могут " +
                "оформлять заказы в интернет-магазине KDV только после рассмотрения заявки менеджером. "));
        AssertCollector.verifyCondition(getText(profileContainer).contains("ООО Арман"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("ИНН: 7017138320"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("КПП: 701701001"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Юридический адрес: 634062, Томская обл, Томск г, Иркутский тракт, 102, кв. 2"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Способ оплаты: -"));
    }

    public void verifyFieldsAuthorizationInfo() {
        getUrl(BASE_URL + "/advancedcustomer/legalinformation/");
        AssertCollector.verifyCondition(getText(profileContainer).contains("ООО Юрмет"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("ИНН: 7002000827"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("КПП: 701701001"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Юридический адрес: 636820, Томская обл, Асиновский р-н, Батурино с, Промышленная ул, дом № 11"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Способ оплаты: НаличныеОтсрочка"));
    }

    public void verifyFieldsData() {
        getUrl(BASE_URL + "/customer/account/edit/");
        AssertCollector.verifyCondition(firstNameInEditPage.isDisplayed());
        AssertCollector.verifyCondition(lastNameInEditPage.isDisplayed());
        AssertCollector.verifyCondition(emailField.isDisplayed());
        AssertCollector.verifyCondition(passwordInEditPage.isDisplayed());
        AssertCollector.verifyCondition(phoneInEditPage.isDisplayed());
        if (!isSubscribedBtn.isSelected()) {
            clickElementByJS(driver, isSubscribedBtn);
        }
        if (!changerPassBtn.isSelected()) {
            clickElementByJS(driver, changerPassBtn);
        }
        AssertCollector.verifyCondition(isSubscribedBtn.isSelected());
        AssertCollector.verifyCondition(changerPassBtn.isSelected());
        AssertCollector.verifyCondition(newConfirmationField.isDisplayed());
        AssertCollector.assertTrue(newPasswordField.isDisplayed());
    }

    public JSONObject dataPersonal() {
        JSONObject data = new JSONObject();
        data.put("first", "Тест");
        data.put("last", "Тестович");
        data.put("email", "test@test.com");
        data.put("phone", RandomStringUtils.randomNumeric(10));
        data.put("currentPass", "bu5ttq");
        data.put("newPass", "");
        data.put("confirmPass", "");
        return data;
    }

    public String fillFields(JSONObject data, boolean select) {

        getUrl(BASE_URL + "/customer/account/edit/");
        elementFluentWaitVisibility(firstNameInEditPage, driver).clear();
        elementFluentWaitVisibility(lastNameInEditPage, driver).clear();
        elementFluentWaitVisibility(emailField, driver).clear();
        elementFluentWaitVisibility(passwordInEditPage, driver).clear();
        elementFluentWaitVisibility(phoneInEditPage, driver).clear();
        elementFluentWaitVisibility(firstNameInEditPage, driver).sendKeys(data.getString("first"));
        elementFluentWaitVisibility(lastNameInEditPage, driver).sendKeys(data.getString("last"));
        elementFluentWaitVisibility(emailField, driver).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(passwordInEditPage, driver).sendKeys(data.getString("currentPass"));
        elementFluentWaitVisibility(phoneInEditPage, driver).sendKeys(data.getString("phone"));
        if (select) {
            if (!changerPassBtn.isSelected()) {
                clickElementByJS(driver, changerPassBtn);
            }

            elementFluentWaitVisibility(newPasswordField, driver).sendKeys(data.getString("newPass"));
            elementFluentWaitVisibility(newConfirmationField, driver).sendKeys(data.getString("confirmPass"));
        }
        moveToElementJS(driver, saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage, driver).click();
        return getText(profileContainer);
    }
}
