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
    private WebElement firstNameTxt;

    @FindBy(css = "[id='billing:lastname']")
    private WebElement lastNameTxt;

    @FindBy(css = "[id='billing:email']")
    private WebElement emailTxt;

    @FindBy(css = "[id='billing:telephone']")
    private WebElement phoneTxt;

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


    public JSONObject data() {
        JSONObject data = new JSONObject();
        data.put("firstName", "ТЕСТ");
        data.put("lastName", "ТЕСТОВИЧ");
        data.put("email", RandomStringUtils.randomAlphabetic(15) + "@test.com");
        data.put("phone", RandomStringUtils.randomNumeric(10));
        return data;
    }

    public void createOrder(JSONObject data) {
        new BasketPage(driver).selectOneProduct();
        new BasketPage(driver).increaseProductCount();
        elementFluentWaitVisibility(orderBtn, driver).click();
        identificationBlock(data);
        authorizationBlock(data);
    }

    private void identificationBlock(JSONObject data) {
        elementFluentWaitVisibility(firstNameTxt, driver).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(lastNameTxt, driver).sendKeys(data.getString("lastName"));
    }

    private void authorizationBlock(JSONObject data) {
        elementFluentWaitVisibility(emailTxt, driver).sendKeys(data.getString("email"));
        elementFluentWaitVisibility(phoneTxt, driver).sendKeys(data.getString("phone"));
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
