package pages.OrderingPage;

import Core.basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasketPages.BasketPage;

import static utils.Constants.BASE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;

public class OrderingGuestPage extends BasePage {

    public OrderingGuestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.button.cart__checkout-button.j_cart_checkout")
    private WebElement orderBtn;

    @FindBy(css = "[id='billing:firstname']")
    public WebElement firstNameTxt;

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement firstNameFieldAdvice;

    @FindBy(id = "advice-required-entry-billing:lastname")
    public WebElement lastNameFieldAdvice;

    @FindBy(xpath = "(//input[@name=\"billing[email]\"]/following-sibling::div)[1]")
    public WebElement emailFieldAdvice;

    @FindBy(id = "advice-required-entry-billing:telephone")
    public WebElement phoneFieldAdvice;

    @FindBy(css = ".notice__title")
    public WebElement phoneNotice;

    @FindBy(id = "advice-required-entry-billing:street_new")
    public WebElement addressFieldAdvice;

    @FindBy(css = "[id='billing:lastname']")
    public WebElement lastNameTxt;

    @FindBy(css = "[id='billing:email']")
    private WebElement emailTxt;

    @FindBy(css = "[id='billing:telephone']")
    public WebElement phoneTxt;

    @FindBy(id = "advice-required-entry-billing:is_agree")
    public WebElement agreementCheckBoxAdvice;

    @FindBy(css = ".link.j_modal_auth_link")
    public WebElement modalAuthLink;

    @FindBy(css = "#modal-auth-form")
    public WebElement modalAuthForm;

    @FindBy(css = "[id='auth-modal'] div[class='modal__close']")
    public WebElement closeModalButton;

    @FindBy(css = "#id_onestepcheckout_username")
    private WebElement emailAuth;

    @FindBy(css = "input[name=\"onestepcheckout_password\"]")
    private WebElement passwordAuth;

    @FindBy(css = ".button.modal-auth__forgot-btn.j_modal_auth_login_btn")
    public WebElement authEnterButton;

    @FindBy(css = ".modal-auth__errors.j_modal_auth_errors.text")
    public WebElement errorText;

    @FindBy(id = "review-btn")
    public WebElement createOrderButton;

    @FindBy(css = ".checkout-form__section.checkout-form__buyer.j_buyer_info")
    private WebElement identificationInfo;

    @FindBy(xpath = "//a[text()='Регламентом работы сайта']")
    public WebElement regulationsWebsiteLink;

    @FindBy(css = "#checkout-delivery-date")
    public WebElement checkoutDeliveryDate;

    @FindBy(xpath = ".//a[text()=\"Согласием на обработку персональных данных\"]")
    public WebElement consentPersonalDataProcessingLink;

    @FindBy(xpath = ".//a[contains(text(),'Договора купли-продажи.')]")
    public WebElement salesPurchaseAgreementLink;

    @FindBy(xpath = "//input[@id='billing:is_agree']/following-sibling::span")
    public WebElement agreeCheckBox;

    @FindBy(css = ".title.checkout-form__title.offset-b-4.offset-t-4")
    public WebElement deliveryHeader;

    @FindBy(xpath = "//span[contains(text(),'Самовывоз')]")
    public WebElement selfDeliveryRadioButton;

    @FindBy(id = "billing:street_new")
    public WebElement deliveryAddressField;

    @FindBy(css = "div[data-index='1']")
    public WebElement addressSuggestionList;

    @FindBy(id = "id_comments")
    public WebElement deliveryCommentField;

    @FindBy(xpath = "//span[contains(text(),'Курьерская доставка:')]")
    public WebElement courierDeliveryRadioButton;

    @FindBy(css = "#onepage-review>h2")
    public WebElement compositionOrderHeader;

    @FindBy(css = ".link.checkout-form__edit.float-right")
    public WebElement editCompositionOrderHeader;

    @FindBy(css = ".checkout-review__row.checkout-review__row_header")
    public WebElement reviewOrder;

    @FindBy(xpath = "(//tr[@class='checkout-review__row'])[2]")
    public WebElement totalShipping;

    @FindBy(css = ".checkout-review__row.checkout-review__row_last")
    public WebElement compositionOrderLastRow;

    @FindBy(xpath = ".//*[@id='checkout-review-table']/tbody/tr/td[4]/span")
    public WebElement totalPriceCompositionOrder;

    @FindBy(css = "label[for=\"p_method_beznal\"] span")
    public WebElement payBankCardRadioButton;

    @FindBy(id = "billing:floor")
    public WebElement deliveryFloorField;

    @FindBy(id = "billing:porch")
    public WebElement deliveryPorchField;

    @FindBy(xpath = "//div[@class=\"suggestions-wrapper\"]/following-sibling::p")
    public WebElement addressErrorField;


    public JSONObject data() {
        JSONObject data = new JSONObject();
        data.put("firstName", "ТЕСТ");
        data.put("lastName", "ТЕСТОВИЧ");
        data.put("email", RandomStringUtils.randomAlphabetic(15) + "@test.com");
        data.put("phone", RandomStringUtils.randomNumeric(11));
        return data;
    }

    public void addProductToBasket() {
        getUrl(BASE_URL);
        new BasketPage(driver).selectOneProduct();
        new BasketPage(driver).increaseProductCount();
        elementFluentWaitVisibility(orderBtn, driver).click();
    }

    public void createOrder(JSONObject data) {
        addProductToBasket();
        identificationBlock(data);
    }

    public String identificationBlock(JSONObject data) {
        elementFluentWaitVisibility(firstNameTxt, driver).clear();
        elementFluentWaitVisibility(firstNameTxt, driver).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameTxt, driver).clear();
        elementFluentWaitVisibility(lastNameTxt, driver).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(emailTxt, driver).clear();
        elementFluentWaitVisibility(emailTxt, driver).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(phoneTxt, driver).clear();
        elementFluentWaitVisibility(phoneTxt, driver).sendKeys(data.getString("phone"));
        return getText(identificationInfo);
    }

    public JSONObject authModalFormData() {
        JSONObject data = new JSONObject();
        data.put("email", "test_s.zuev@magdv.com");
        data.put("password", "YZde8m");
        return data;
    }

    public void authorizationBlockModalWindow(JSONObject data) {
        elementFluentWaitVisibility(emailAuth, driver).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(passwordAuth, driver).sendKeys(data.getString("password"));
        elementFluentWaitVisibility(authEnterButton, driver).click();
        sleepWait();
    }
}
