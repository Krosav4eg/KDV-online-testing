package KDV_business_logic.pages.PersonalAreaPage;

import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
