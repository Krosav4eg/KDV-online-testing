package pages.OrderingPage;


import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderingLegalPage extends BasePage {
    public OrderingLegalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".select2-selection__rendered#select2-billing-address-select-container")
    public WebElement deliveryAddress;

    @FindBy(xpath = "//span[@aria-expanded='true']")
    public WebElement addressDropDownList;

    @FindBy(xpath = "//span[@class=\"text\"]")
    public WebElement transportDescription;

    @FindBy(css = ".load-wait.text")
    public WebElement orderLoadingMessage;

    @FindBy(css = ".button.button_mobile-wide.j_button_metrics_goals")
    public WebElement continueShoppingButton;

    @FindBy(css = ".link")
    public WebElement orderLink;

    @FindBy(css = ".profile-orders__col.profile-orders__col_id.hidden-xs.hidden-xxs")
    public List<WebElement> orderNumberInList;

    public void createOrderForLegalPerson() {
        new OrderingGuestPage(driver).addProductToBasket();
    }

    public String getElementTextFromList(List<WebElement> element, int elementIndex) {
        return element.get(elementIndex).getText();
    }
}
