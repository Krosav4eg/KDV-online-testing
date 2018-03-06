package KDV_business_logic.pages.OrderingPage;


import Core.basePage.BasePage;
import KDV_business_logic.pages.BasketPages.BasketPage;
import KDV_business_logic.pages.OrderingPage.OrderGuest.OrderingGuestPage;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Core.utils.WaitingUtility.elementFluentWaitVisibility;

public class OrderingLegalPage extends BasePage {
    public OrderingLegalPage(WebDriver driver) {
        super(driver);
    }
    BasketPage basketPage= new BasketPage(driver);

    @FindBy(css = ".select2-selection__rendered#select2-billing-address-select-container")
    public WebElement deliveryAddress;

    @FindBy(xpath = "//span[@aria-expanded='true']")
    public WebElement addressDropDownArea;

    @FindBy(xpath = "//select/option[text()='Кемерово, 50 лет Октября, 16']")
    public WebElement secondAddressDropDownList;

    @FindBy(xpath = "//select/option[text()='ул. Тевлянто, 9, Анадырь, Чукотский автономный округ']")
    public WebElement thirdAddressDropDownList;

    @FindBy(xpath = "//span[@class=\"text\"]")
    public WebElement transportDescription;

    @FindBy(css = ".button.button_mobile-wide.j_button_metrics_goals")
    public WebElement continueShoppingButton;

    @FindBy(css = ".text a.link")
    public WebElement orderLink;

    @FindBy(css = ".profile-orders__col.profile-orders__col_id.hidden-xs.hidden-xxs")
    public List<WebElement> orderNumberInList;

    public void createOrderForLegalPerson() {
        basketPage.addProductToBasket();
    }

    public String getElementTextFromList(List<WebElement> element, int elementIndex) {
        return element.get(elementIndex).getText();
    }

    public JSONObject data() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Геннадий");
        data.put("lastName", "Фадеев");
        data.put("phone", "+71111111111");
        return data;
    }

    public void deliveryAddressBlock(JSONObject data) {
        elementFluentWaitVisibility(new OrderingGuestPage(driver).firstNameTxt).clear();
        elementFluentWaitVisibility(new OrderingGuestPage(driver).firstNameTxt).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(new OrderingGuestPage(driver).lastNameTxt).clear();
        elementFluentWaitVisibility(new OrderingGuestPage(driver).lastNameTxt).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(new OrderingGuestPage(driver).phoneTxt).clear();
        elementFluentWaitVisibility(new OrderingGuestPage(driver).phoneTxt).sendKeys(data.getString("phone"));
    }
}
