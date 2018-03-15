package KDV_business_logic.pages.PersonalAreaPage;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import Core.utils.WaitingUtility;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Core.utils.Constants.AUTHORIZATION_EMAIL;
import static Core.utils.Constants.AUTHORIZATION_PASSWORD;
import static Core.utils.Constants.BASE_URL;

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
    public WebElement titleField;

    @FindBy(id = "confirmation")
    private WebElement newConfirmationField;

    @FindBy(id = "firstname")
    private WebElement firstNameInEditPage;

    @FindBy(id = "lastname")
    private WebElement lastNameInEditPage;

    @FindBy(css = ".button.button_mobile-wide")
    private WebElement saveButtonInEditPage;

    @FindBy(id = "phone")
    public static WebElement phoneInEditPage;

    @FindBy(id = "current_password")
    private WebElement passwordInEditPage;

    @FindBy(css = "[name='change_password']")
    private WebElement changerPassBtn;

    @FindBy(css = "[name='is_subscribed']")
    private WebElement isSubscribedBtn;

    public JSONObject mainAccountInfo() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        data.put("email", "test_a.evdokimov@magdv.com");
        data.put("phone", "+71111111111 ");
        data.put("currentPassword", AUTHORIZATION_PASSWORD);
        return data;
    }

    /*******Legal Room********/

    public void verifyFieldsNotAuthorization() {
        AssertCollector.verifyCondition(getText(allertTxt).
                contains("Обратите внимание, что юридические лица и организации могут " +
                        "оформлять заказы в интернет-магазине KDV только после рассмотрения заявки менеджером. "));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Здравствуйте, Александр Григорьев!"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("test_a.grigoriev@magdv.com"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71113959049"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Томск, Комсомольский проспект, 57"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71111111111"));
        elementFluentWaitVisibility(editBtn).click();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/edit/"));
        backPage();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/"));
    }

    public void verifyFieldsAuthorization() {
        textIsPresent(titleField, "Панель управления");
        AssertCollector.verifyCondition(getText(profileContainer).contains("Здравствуйте, Геннадий Фадеев!"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("test_g.fadeev@magdv.com"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71119348926"));
        moveToElementJS(driver, linkTxt);
        AssertCollector.verifyCondition(getText(profileContainer).contains("+71111111111"));
        moveToElementJS(driver, linkElement);
        elementFluentWaitVisibility(editBtn).click();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/edit/"));
        backPage();
        AssertCollector.verifyCondition(getCurrentUrl().contains("/customer/account/"));
    }

    public void verifyFieldsNotAuthorizationInfo() {
        getUrl(BASE_URL + "/advancedcustomer/legalinformation/");
        AssertCollector.verifyCondition(getText(allertTxt).
                contains("Обратите внимание, что юридические лица и организации могут " +
                        "оформлять заказы в интернет-магазине KDV только после рассмотрения заявки менеджером. "));
        AssertCollector.verifyCondition(getText(profileContainer).contains("ООО Арман"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("ИНН: 7017138320"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("КПП: 701701001"));
        AssertCollector.verifyCondition(getText(profileContainer).
                contains("Юридический адрес: 634062, Томская обл, Томск г, Иркутский тракт, 102, кв. 2"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Способ оплаты: -"));
    }

    public void verifyFieldsAuthorizationInfo() {
        getUrl(BASE_URL + "/advancedcustomer/legalinformation/");
        AssertCollector.verifyCondition(getText(profileContainer).contains("ООО Юрмет"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("ИНН: 7002000827"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("КПП: 701701001"));
        AssertCollector.verifyCondition(getText(profileContainer).
                contains("Юридический адрес: 636820, Томская обл, Асиновский р-н, Батурино с, Промышленная ул, дом № 11"));
        AssertCollector.verifyCondition(getText(profileContainer).contains("Способ оплаты: НаличныеОтсрочка"));
    }

    public void verifyFieldsData() {
        textPresent("Мои заказы");
        textPresent("У вас пока нет оформленных заказов.");
        getUrl(BASE_URL + "/customer/account/edit/");
        AssertCollector.verifyCondition(elementIsVisible(firstNameInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(lastNameInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(emailField));
        AssertCollector.verifyCondition(elementIsVisible(passwordInEditPage));
        AssertCollector.verifyCondition(elementIsVisible(phoneInEditPage));
        if (!isSubscribedBtn.isSelected()) {
            clickElementByJS(driver, isSubscribedBtn);
        }
        if (!changerPassBtn.isSelected()) {
            clickElementByJS(driver, changerPassBtn);
        }
        AssertCollector.verifyCondition(elementIsSelected(isSubscribedBtn));
        AssertCollector.verifyCondition(elementIsSelected(changerPassBtn));
        AssertCollector.verifyCondition(elementIsVisible(newConfirmationField));
        AssertCollector.assertTrue(elementIsVisible(newPasswordField));
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
        elementFluentWaitVisibility(firstNameInEditPage).clear();
        elementFluentWaitVisibility(lastNameInEditPage).clear();
        elementFluentWaitVisibility(emailField).clear();
        elementFluentWaitVisibility(passwordInEditPage).clear();
        elementFluentWaitVisibility(phoneInEditPage).clear();
        elementFluentWaitVisibility(firstNameInEditPage).sendKeys(data.getString("first"));
        elementFluentWaitVisibility(lastNameInEditPage).sendKeys(data.getString("last"));
        elementFluentWaitVisibility(emailField).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(passwordInEditPage).sendKeys(data.getString("currentPass"));
        elementFluentWaitVisibility(phoneInEditPage).sendKeys(data.getString("phone"));
        if (select) {
            if (!changerPassBtn.isSelected()) {
                clickElementByJS(driver, changerPassBtn);
            }
            elementFluentWaitVisibility(newPasswordField).sendKeys(data.getString("newPass"));
            elementFluentWaitVisibility(newConfirmationField).sendKeys(data.getString("confirmPass"));
        }
        moveToElementJS(driver, saveButtonInEditPage);
        elementFluentWaitVisibility(saveButtonInEditPage).click();
        return getText(profileContainer);
    }

    public void fieldIsNecessaryToInputFalse(JSONObject data) {
        AssertCollector.assertTrue(fillFields(data, false).contains("Это поле обязательно для заполнения."));
    }

    public void fieldIsNecessaryToInputTrue(JSONObject data) {
        AssertCollector.assertTrue(fillFields(data, true).contains("Это поле обязательно для заполнения."));
    }

    public void verifyRewritingFields(JSONObject data) {
        String first = RandomStringUtils.randomAlphabetic(5);
        String last = RandomStringUtils.randomAlphabetic(5);
        String email = "test_n.moiseeva@magdv.com";
        String phone = RandomStringUtils.randomNumeric(10);
        String allResult = fillFields(data, false);
        AssertCollector.verifyCondition(allResult.contains(first));
        AssertCollector.verifyCondition(allResult.contains(last));
        AssertCollector.verifyCondition(allResult.contains(email));
        AssertCollector.verifyCondition(allResult.contains(phone));
    }

    public void verifyInputWrongNameAndSurname(JSONObject data) {
        String allResult = fillFields(data, false);
        AssertCollector.verifyCondition(allResult.contains("Значение 'Фамилия' не должно быть пустым и может содержать " +
                "только буквы, тире и апостроф."));
        AssertCollector.verifyCondition(allResult.contains("Значение 'Имя' не должно быть пустым и может содержать " +
                "только буквы, тире и апостроф."));
    }

    public void obligatorilyFillTheField(JSONObject data) {
        String allResult = fillFields(data, false);
        AssertCollector.verifyCondition(allResult.contains("Это поле обязательно для заполнения."));
    }

    public void personDataSaved(JSONObject data) {
        String allResult = fillFields(data, false);
        AssertCollector.verifyCondition(allResult.contains("Данные учётной записи сохранены."));
    }

    public void isPasswordWrong(JSONObject data) {
        String allResult = fillFields(data, false);
        AssertCollector.verifyCondition(allResult.contains("Неправильный текущий пароль"));
    }

    public void arePasswordsTheSame(JSONObject data) {
        String allResult = fillFields(data, true);
        AssertCollector.verifyCondition(allResult.contains("Пожалуйста, убедитесь, что ваши пароли совпадают."));
    }

    public void checkTheAddressIsCorrect(JSONObject data) {
        String allResult = fillFields(data, false);
        AssertCollector.verifyCondition(allResult.contains("Пожалуйста, введите правильный адрес электронной почты " +
                "(email)."));
    }

    public void verifyLengthOfPhone() {
        AssertCollector.verifyCondition(phoneInEditPage.getAttribute("value").length() ==
                RandomStringUtils.randomAlphabetic(11).length());
    }

    public void verifyPhoneIsEmpty() {
        AssertCollector.verifyCondition(phoneInEditPage.getText().isEmpty());
    }
}
