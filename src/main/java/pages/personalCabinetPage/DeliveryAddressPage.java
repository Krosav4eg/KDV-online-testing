package pages.personalCabinetPage;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sergey Potapov
 */

public class DeliveryAddressPage extends BasePage {
    public DeliveryAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title.offset-b-5")
    public WebElement deliveryAddressHeader;

    @FindBy(xpath = "(//div[@class='address__info'])[1]")
    public WebElement nameDeliveryByDefault;

    @FindBy(xpath = "(//div[@class='address__info'])[2]")
    public WebElement deliveryAddressByDefault;

    @FindBy(xpath = "(//div[@class='address__info'])[3]")
    public WebElement phoneDeliveryByDefault;

    @FindBy(xpath = ".//span[text()='Адреса доставки']")
    public WebElement deliveryAddressItemButton;

    @FindBy(css = ".tag.tag_right.tag_default")
    public WebElement byDefaultMark;

    @FindBy(css = "a[href='http://tomsk.demo.dev.magonline.ru/customer/address/edit/id/6925/']")
    public WebElement editDeliveryLink;

    @FindBy(id = "firstname")
    public WebElement firstNameInEditDeliveryPage;

    @FindBy(id = "lastname")
    public WebElement lastNameInEditDeliveryPage;

    @FindBy(id = "telephone")
    public WebElement phoneInEditDeliveryPage;

    @FindBy(id = "street_1")
    public WebElement addressInEditDeliveryPage;

    @FindBy(id = "floor")
    public WebElement florInEditDeliveryPage;

    @FindBy(id = "porch")
    public WebElement porchInEditDeliveryPage;

    @FindBy(css = ".checkbox__label")
    public WebElement checkBoxDelivery;

    @FindBy(css = ".button.button_mobile-wide")
    public WebElement saveDeliveryAddressButton;

    @FindBy(xpath = "(//div[@class='profile__addresses']/div[@class='address'])[1]")
    public WebElement deliveryAddressList;
}
