package KDV_business_logic.pages.PersonalAreaPage;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import Core.utils.WaitingUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Core.utils.Constants.AUTHORIZATION_EMAIL;

/**
 * @author Sergey Potapov
 */

public class ControlPanelPage extends BasePage {
    public ControlPanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[2]//p/../h2")
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
    public WebElement controlPanelHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Заказы\")]")
    public WebElement ordersHeader;

    @FindBy(xpath = "//h2[contains(text(), \"Адрес по умолчанию\")]")
    public WebElement addressByDefaultHeader;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_cost hidden-xs hidden-xxs']")
    public WebElement orderCost;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_view hidden-xs hidden-xxs']")
    public WebElement orderView;

    @FindBy(xpath = ".//*[@class='profile-orders__col profile-orders__col_link']")
    public WebElement orderRepeat;

    @FindBy(xpath = "//h2//a[contains(text(), \"Показать все\")]")
    public WebElement showAll;

    @FindBy(xpath = "//h2[contains(text(), \"Учётная запись\")]")
    public WebElement personalDataHeader;

    @FindBy(xpath = "//h2//a[@class='account__edit link offset-l-1']")
    public WebElement editPersonalDataButton;

    @FindBy(xpath = "//div[contains(text(), \"Аркадий Евдокимов\")]")
    public WebElement nameInAddressByDefault;

    @FindBy(xpath = "//div[contains(text(), \"г Кемерово, ул Варшавская, д 87, кв 12 \")]")
    public WebElement addressInAddressByDefault;

    @FindBy(xpath = "//div[contains(text(), \"+71111111111 \")]")
    public WebElement phoneInAddressByDefault;

    @FindBy(xpath = "//h2//a[@class='address__action link offset-l-1']")
    public WebElement editAddressButton;


    public void verifyAccountAndAddressByDefault() {
        AssertCollector.verifyCondition(elementIsVisible(personalDataHeader));
        AssertCollector.verifyCondition(nameInPersonalData.getText().
                contains("Аркадий Евдокимов"));
        AssertCollector.verifyCondition(emailInPersonalData.getText().equals(AUTHORIZATION_EMAIL));
        AssertCollector.verifyCondition(phoneInPersonalData.getText().equals("+77111111111"));
        String expLink = getValueOfAttributeByName(editPersonalDataButton, "href");
        elementFluentWaitVisibility(editPersonalDataButton).click();
        AssertCollector.verifyCondition(getCurrentUrl().equals(expLink));
        navigateBack();
        AssertCollector.verifyCondition(elementIsVisible(addressByDefaultHeader));
        AssertCollector.verifyCondition(nameInAddressByDefault.getText().equals("Аркадий Евдокимов"));
        AssertCollector.verifyCondition(addressInAddressByDefault.getText().
                equals("г Кемерово, ул Варшавская, д 87, кв 12"));
        AssertCollector.verifyCondition(phoneInAddressByDefault.getText().equals("+71111111111"));
        scrollToNecessaryElement(editAddressButton);
        String expLink1 = getValueOfAttributeByName(editAddressButton, "href");
        elementIsClickable(editAddressButton).click();
        AssertCollector.verifyCondition(getCurrentUrl().equals(expLink1));
    }

    public void verifyControlPanel() {
        AssertCollector.verifyCondition(elementIsVisible(controlPanelHeader));
        textPresent("Здравствуйте, Иннокентий Макаров!");
        textPresent("Здесь вы можете просмотреть краткий обзор активности вашей учётной записи.");
    }
}
