package pages.OrderingPage;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasketPages.BasketPage;

import static utils.WaitingUtility.elementFluentWaitVisibility;

public class OrderingGuest extends BasePage {

    public OrderingGuest(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.button.cart__checkout-button.j_cart_checkout")
    private WebElement orderBtn;

    @FindBy(css = "[id='billing:firstname']")
    public WebElement firstNameTxt;

    @FindBy(css = "[id='billing:lastname']")
    public WebElement lastNameTxt;

    @FindBy(css = "[id='billing:email']")
    private WebElement emailTxt;

    @FindBy(css = "[id='billing:telephone']")
    public WebElement phoneTxt;

    @FindBy(css = "label[for=\"billing:is_agree\"]")
    public WebElement agreementBtn;

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
    private WebElement authEnterButton;

    @FindBy(css = "#review-btn")
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

    @FindBy(xpath = "//span[contains(text(),'Согласен получать выгодные предложения на покупку продуктов')]")
    public WebElement agreeCheckBox;


    public JSONObject data() {
        JSONObject data = new JSONObject();
        data.put("firstName", "ТЕСТ");
        data.put("lastName", "ТЕСТОВИЧ");
        data.put("email", RandomStringUtils.randomAlphabetic(15) + "@test.com");
        data.put("phone", RandomStringUtils.randomNumeric(11));
        return data;
    }

    public void createOrder(JSONObject data) {
        new BasketPage(driver).selectOneProduct();
        new BasketPage(driver).increaseProductCount();
        elementFluentWaitVisibility(orderBtn, driver).click();
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
