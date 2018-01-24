package pages.personalCabinetPage;

import basePage.BasePage;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.AUTORIZATION_PAGE_URL;
import static utils.Constants.BASE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.waitInvisibilityOfElement;

/**
 * @author Sergey Potapov
 */

public class ControlPanelPage extends BasePage {
    public ControlPanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[2]/div/p[1]")
    public WebElement nameInPersonalData;

    @FindBy(xpath = "//div/p[2]")
    public WebElement emailInPersonalData;

    @FindBy(xpath = "//div/p[3]")
    public WebElement phoneInPersonalData;

    @FindBy(css = "#email")
    private WebElement emailInputField;

    @FindBy(css = "#pass")
    private WebElement passwordField;

    @FindBy(css = "#send2")
    private WebElement authorizationButton;

    @FindBy(xpath = ".//*[@class='title']")
    private WebElement controlPanelHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Заказы\")]")
    private WebElement ordersHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Адрес по умолчанию\")]")
    private WebElement addressByDefaultHeader;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_cost hidden-xs hidden-xxs']")
    private WebElement orderCost;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_view hidden-xs hidden-xxs']")
    private WebElement orderView;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_link']")
    private WebElement orderRepeat;

    @FindBy(xpath = "//h2//a[contains(text(), \"Показать все\")]")
    private WebElement showAll;

    @FindBy(xpath = "//h2[contains(text(), \"Учётная запись\")]")
    private WebElement personalDataHeader;

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


    public void verifyControlPanelHeader() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_i.makarov@magdv.com");
        fillInputField(passwordField, driver, "SWgeZWPs");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        String expUrl = BASE_URL + "/customer/account/";
        AssertCollector.assertEquals(getCurrentUrl(), " Url are equal ", expUrl);
        AssertCollector.assertTrue(controlPanelHeader.isDisplayed(), "Required menu item is displayed");
    }

    public void verifyGreetingsBlock() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_i.makarov@magdv.com");
        fillInputField(passwordField, driver, "SWgeZWPs");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        textPresent("Здравствуйте, Иннокентий Макаров!");
        textPresent("Здесь вы можете просмотреть краткий обзор активности вашей учётной записи.");
    }

    public void verifyOrdersBlockAbsence() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_i.makarov@magdv.com");
        fillInputField(passwordField, driver, "SWgeZWPs");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        try {
            waitInvisibilityOfElement(ordersHeader, driver);
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    public void verifyOrdersBlockWithQuantityLessThenFive() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_i.kononov@magdv.com");
        fillInputField(passwordField, driver, "M9fraZ");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertTrue(ordersHeader.isDisplayed(), "Required menu item is displayed");
        AssertCollector.assertTrue(orderId.isDisplayed(), "Required menu item is displayed");
        AssertCollector.assertTrue(orderDate.isDisplayed(), "Required menu item is displayed");
        AssertCollector.assertTrue(orderStatus.isDisplayed(), "Required menu item is displayed");
        AssertCollector.assertTrue(orderCost.isDisplayed(), "Required menu item is displayed");
        AssertCollector.assertTrue(orderView.isDisplayed(), "Required menu item is displayed");
        AssertCollector.assertTrue(orderRepeat.isDisplayed(), "Required menu item is displayed");
    }

    //TODO verify total orders
    public void verifyOrdersBlockWithQuantityMoreThenFive() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_t.bolshakov@magdv.com");
        fillInputField(passwordField, driver, "sTU1iJ46");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertTrue(ordersHeader.isDisplayed());
        AssertCollector.assertTrue(orderId.isDisplayed());
        AssertCollector.assertTrue(orderDate.isDisplayed());
        AssertCollector.assertTrue(orderStatus.isDisplayed());
        AssertCollector.assertTrue(orderCost.isDisplayed());
        AssertCollector.assertTrue(orderView.isDisplayed());
        AssertCollector.assertTrue(orderRepeat.isDisplayed());
    }

    public void verifyLinkShowAll() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_t.bolshakov@magdv.com");
        fillInputField(passwordField, driver, "sTU1iJ46");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        String expLink = getValueOfAttributeByName(showAll, "href");
        elementFluentWaitVisibility(showAll, driver).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Url is equal to ", expLink);
    }

    // TODO: 12.01.2018 C38045 take id from DB

    public void verifyPersonalDataHeader() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertTrue(personalDataHeader.isDisplayed(), "Required header is displayed");
    }

    public void verifyUserFirstNameAndLastNameInPersonalData() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertEquals(nameInPersonalData.getText(), " Name are equal ", "Аркадий Евдокимов");
    }

    public void verifyUserEmail() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertEquals(emailInPersonalData.getText(), " Emails are equal ", "test_a.evdokimov@magdv.com");
    }

    public void verifyUserPhone() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertEquals(phoneInPersonalData.getText(), " Phones are equal ", "+71111111111");
    }

    public void verifyPersonalDataEditButton() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        String expLink = getValueOfAttributeByName(editPersonalDataButton, "href");
        elementFluentWaitVisibility(editPersonalDataButton, driver).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Url is equal to ", expLink);
    }

    public void verifyAddressByDefaultHeader() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertTrue(addressByDefaultHeader.isDisplayed(), " Required header is displayed ");
    }

    public void verifyUserFirstNameAndLastNameInAddressByDefault() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertEquals(nameInAddressByDefault.getText(), " Names are equal ", "Аркадий Евдокимов");
    }

    public void verifyAddressByDefault() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertEquals(addressInAddressByDefault.getText(), " Addresses are equal ",
                "г Кемерово, ул Варшавская, д 87, кв 12");
    }

    public void verifyUserPhoneInAddressByDefault() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertEquals(phoneInAddressByDefault.getText(), " Phones  are equal ", "+71111111111");
    }

    public void verifyAddressEditButton() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, "test_a.evdokimov@magdv.com");
        fillInputField(passwordField, driver, "JOviF7J2");
        elementFluentWaitVisibility(authorizationButton, driver).click();
        String expLink = getValueOfAttributeByName(editAddressButton, "href");
        elementFluentWaitVisibility(editAddressButton, driver).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Urls are equal ", expLink);
    }
}
