package pages.PersonalAreaPage;

import Core.basePage.BasePage;
import com.google.common.base.Verify;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import javax.swing.*;

import static utils.Constants.*;
import static utils.WaitingUtility.elementFluentWaitVisibility;

public class PersonalCabinetPage extends BasePage {
    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement authorizationButton;

    @FindBy(css = "a.account__edit")
    private WebElement editBtn;

    @FindBy(css = ".notice-msg .text")
    private WebElement allertTxt;

    @FindBy(css = ".profile")
    private WebElement profileContainer;

    @FindBy(css = ".profile-nav__title")
    private WebElement personalCabinet;

    @FindBy(xpath = "//span[contains(text(), \"Панель управления\")]")
    private WebElement controlPanel;

    @FindBy(xpath = "//span[contains(text(), \"Данные учётной записи\")]")
    private WebElement personalData;

    @FindBy(xpath = "//span[contains(text(), \"Адреса доставки\")]")
    private WebElement deliveryAddresses;

    @FindBy(xpath = "//span[contains(text(), \"Мои заказы\")]")
    private WebElement orders;

    @FindBy(xpath = ".//*[@class=\"profile-nav__item profile-nav__item_active\"]")
    private WebElement activeByDefault;

    @FindBy(xpath = ".//*[@class='title']")
    private WebElement controlPanelHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Заказы\")]")
    private WebElement ordersHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Учётная запись\")]")
    private WebElement personalDataHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Адрес по умолчанию\")]")
    private WebElement addressByDefaultHeader;

    @FindBy(xpath = "//p[contains(text(), 'Аркадий Евдокимов')]")
    public WebElement nameInPersonalData;

    @FindBy(xpath = "//p[contains(text(), \"test_a.evdokimov@magdv.com\")]")
    private WebElement emailInPersonalData;

    @FindBy(xpath = "//p[contains(text(), \"+71111111111\")]")
    private WebElement phoneInPersonalData;

    @FindBy(xpath = "//h2//a[@class='account__edit link offset-l-1']")
    private WebElement editPersonalDataButton;

    @FindBy(xpath = "//div[contains(text(), \"Аркадий Евдокимов\")]")
    private WebElement nameInAddressByDefault;

    @FindBy(xpath = "//div[contains(text(), \"г Кемерово, ул Варшавская, д 87, кв 12 \")]")
    private WebElement addressInAddressByDefault;

    @FindBy(xpath = "//div[contains(text(), \"+71111111111 \")]")
    private WebElement phoneInAddressByDefault;

    @FindBy(xpath = "//h2//a[@class='address__action link offset-l-1']")
    private WebElement editAddressButton;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_id hidden-xs hidden-xxs']")
    private WebElement orderId;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_date hidden-xs hidden-xxs']")
    private WebElement orderDate;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_status hidden-xs hidden-xxs']")
    private WebElement orderStatus;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_cost hidden-xs hidden-xxs']")
    private WebElement orderCost;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_view hidden-xs hidden-xxs']")
    private WebElement orderView;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_link']")
    private WebElement orderRepeat;

    @FindBy(xpath = "//h2//a[contains(text(), \"Показать все\")]")
    private WebElement showAll;

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

    @FindBy(css = "#adv_phone")
    public WebElement phoneInEditPage;

    @FindBy(css = "#current_password")
    public WebElement passwordInEditPage;

    @FindBy(css = "#email")
    public WebElement emailInEditPage;

    @FindBy(xpath = ".//*[@id='form-validate']//span[contains(text(), \"Согласен\")]")
    private WebElement checkboxAgreement;

    @FindBy(xpath = ".//*[@id='form-validate']/div[1]")
    private WebElement informationAccountEdit;

    @FindBy(css = ".checkbox__label")
    public WebElement changePasswordCheckbox;

    public JSONObject mainAccountInfo() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Аркадий");
        data.put("lastName", "Евдокимов");
        data.put("email", "test_a.evdokimov@magdv.com");
        data.put("phone", "+71111111111");
        data.put("currentPassword", AUTORIZATION_PASSWORD);
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
        AssertCollector.assertTrue(getCurrentUrl().contains(ACCOUNT_PAGE_URL),"Verify current url");
        return getText(informationAccountEdit);
    }

    /*******Legal Room********/

    public JSONObject verifyFields(JSONObject dataInput)
    {
        JSONObject data = new JSONObject();
        return  data;
    }

    public void verifyFieldsNotAuthorization()
    {
        Verify.verify(getText(allertTxt).contains("Обратите внимание, что юридические лица и организации могут " +
                "оформлять заказы в интернет-магазине KDV только после рассмотрения заявки менеджером. ") );
        Verify.verify(getText(profileContainer).contains("Здравствуйте, Александр Григорьев!"));
        Verify.verify(getText(profileContainer).contains("test_a.grigoriev@magdv.com"));
        Verify.verify(getText(profileContainer).contains("+71113959049"));
        Verify.verify(getText(profileContainer).contains("Томск, Комсомольский проспект, 57"));
        Verify.verify(getText(profileContainer).contains("+71111111111"));
        elementFluentWaitVisibility(editBtn,driver).click();
        Verify.verify(getCurrentUrl().contains("/customer/account/edit/"));
        backPage();
        Verify.verify(getCurrentUrl().contains("/customer/account/"));
    }
    public void verifyFieldsAuthorization()
    {
        Verify.verify(getText(profileContainer).contains("Здравствуйте, Геннадий Фадеев!"));
        Verify.verify(getText(profileContainer).contains("test_g.fadeev@magdv.com"));
        Verify.verify(getText(profileContainer).contains("+71119348926"));
        Verify.verify(getText(profileContainer).contains("Томск, Иркутский тракт 114/1"));
        Verify.verify(getText(profileContainer).contains("+71111111111"));
        elementFluentWaitVisibility(editBtn,driver).click();
        Verify.verify(getCurrentUrl().contains("/customer/account/edit/"));
        backPage();
        Verify.verify(getCurrentUrl().contains("/customer/account/"));
    }

    public void verifyFieldsNotAuthorizationInfo()
    {
        getUrl(BASE_URL+"/advancedcustomer/legalinformation/");
        Verify.verify(getText(allertTxt).contains("Обратите внимание, что юридические лица и организации могут " +
                "оформлять заказы в интернет-магазине KDV только после рассмотрения заявки менеджером. ") );
        Verify.verify(getText(profileContainer).contains("ООО Арман"));
        Verify.verify(getText(profileContainer).contains("ИНН: 7017138320"));
        Verify.verify(getText(profileContainer).contains("КПП: 701701001"));
        Verify.verify(getText(profileContainer).contains("Юридический адрес: 634062, Томская обл, Томск г, Иркутский тракт, 102, кв. 2"));
        Verify.verify(getText(profileContainer).contains("Способ оплаты: -"));
    }
    public void verifyFieldsAuthorizationInfo()
    {
        getUrl(BASE_URL+"/advancedcustomer/legalinformation/");
        Verify.verify(getText(profileContainer).contains("ООО Юрмет"));
        Verify.verify(getText(profileContainer).contains("ИНН: 7002000827"));
        Verify.verify(getText(profileContainer).contains("КПП: 701701001"));
        Verify.verify(getText(profileContainer).contains("Юридический адрес: 636820, Томская обл, Асиновский р-н, Батурино с, Промышленная ул, дом № 11"));
        Verify.verify(getText(profileContainer).contains("Способ оплаты: НаличныеОтсрочка"));
    }
}
