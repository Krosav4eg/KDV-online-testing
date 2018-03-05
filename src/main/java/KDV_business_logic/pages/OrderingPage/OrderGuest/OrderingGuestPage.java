package KDV_business_logic.pages.OrderingPage.OrderGuest;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import KDV_business_logic.pages.PersonalAreaPage.PersonalCabinetPage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import KDV_business_logic.pages.BasketPages.BasketPage;

import static Core.utils.Constants.BASE_URL;
import static Core.utils.WaitingUtility.*;

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

    @FindBy(xpath = ".//a[text()=\"Согласием на обработку персональных данных\"]")
    public WebElement consentPersonalDataProcessingLink;

    @FindBy(xpath = ".//a[contains(text(),'Договора купли-продажи.')]")
    public WebElement salesPurchaseAgreementLink;

    @FindBy(css = "label[for='s_method_pickup_delivery_pickup_delivery']")
    public WebElement selfDeliveryRadioButton;

    @FindBy(css = ".offset-t-4")
    public WebElement deliveryTxt;

    @FindBy(id = "billing:street_new")
    public WebElement deliveryAddressField;

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

    @FindBy (css = "label[for='p_method_beznal'] span")
    public WebElement payBankCardRadioButton;

    @FindBy(id = "billing:floor")
    public WebElement deliveryFloorField;

    @FindBy(id = "billing:porch")
    public WebElement deliveryPorchField;

    @FindBy(css = ".message__item")
    public WebElement messageOrderError;

    @FindBy(css = "div.j_mini_cart_summary")
    private WebElement selectMiniCart;

    @FindBy(css = "[title='Просмотр корзины ']")
    private WebElement selectBasket;

    @FindBy(css = ".checkout-layout__inner h1")
    private WebElement headerTxt;


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
        elementFluentWaitVisibility(orderBtn).click();
        try {
            elementIsPresent(messageOrderError);
            if (elementIsDisplayedTime(messageOrderError)) {
                elementFluentWaitVisibility(selectMiniCart).click();
                elementFluentWaitVisibility(selectBasket).click();
            }
            new BasketPage(driver).increaseLegalPersonProductCount();
            elementFluentWaitVisibility(orderBtn).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void createOrder(JSONObject data) {
        addProductToBasket();
        identificationBlock(data);
    }

    public void clickOrderButton() {
        elementFluentWaitVisibility(createOrderButton).click();
    }

    public void orderingSelfGet(JSONObject data)
    {

        moveToElementJS(driver,headerTxt);
        elementIsClickable(payBankCardRadioButton).click();
        AssertCollector.verifyCondition(payBankCardRadioButton.isEnabled());
        data = deliveryFormData();
        deliveryFormInfo(data);
        moveToElementJS(driver,deliveryTxt);
        elementIsClickable(selfDeliveryRadioButton).click();
        elementIsClickable(createOrderButton).click();
    }


    public void clickOnWebElement(WebElement element) {
        elementFluentWaitVisibility(element).click();
        sleepWait();
    }

    public void clickCheckBoxAndOrderButton() {
        sleepWait();
        elementFluentWaitVisibility(agreementCheckBoxAdvice).click();
        elementFluentWaitVisibility(createOrderButton).click();
        sleepWait();
    }

    public String identificationBlock(JSONObject data) {
        elementFluentWaitVisibility(firstNameTxt).clear();
        elementFluentWaitVisibility(firstNameTxt).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameTxt).clear();
        elementFluentWaitVisibility(lastNameTxt).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(emailTxt).clear();
        elementFluentWaitVisibility(emailTxt).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(phoneTxt).clear();
        elementFluentWaitVisibility(phoneTxt).sendKeys(data.getString("phone"));
        return getText(identificationInfo);
    }

    public JSONObject authModalFormData() {
        JSONObject data = new JSONObject();
        data.put("email", "test_s.zuev@magdv.com");
        data.put("password", "YZde8m");
        return data;
    }

    public void authorizationBlockModalWindow(JSONObject data) {
        elementFluentWaitVisibility(emailAuth).clear();
        elementFluentWaitVisibility(emailAuth).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(passwordAuth).clear();
        elementFluentWaitVisibility(passwordAuth).sendKeys(data.getString("password"));
        elementFluentWaitVisibility(authEnterButton).click();
        sleepWait();
    }

    public JSONObject deliveryFormData() {
        JSONObject data = new JSONObject();
        data.put("address", "Томск, пр. Мира 20, оф.4");
        data.put("floor", "1");
        data.put("porch", "3");
        data.put("comment", RandomStringUtils.randomAlphabetic(10));
        return data;
    }

    public void deliveryFormInfo(JSONObject data) {
        elementFluentWaitVisibility(deliveryAddressField).clear();
        elementFluentWaitVisibility(deliveryAddressField).sendKeys(data.getString("address"));
        elementFluentWaitVisibility(deliveryFloorField).clear();
        elementFluentWaitVisibility(deliveryFloorField).sendKeys(data.getString("floor"));
        elementFluentWaitVisibility(deliveryPorchField).clear();
        elementFluentWaitVisibility(deliveryPorchField).sendKeys(data.getString("porch"));
        elementFluentWaitVisibility(deliveryCommentField).clear();
        elementFluentWaitVisibility(deliveryCommentField).sendKeys(data.getString("comment"));
        sleepWait();
    }
}
