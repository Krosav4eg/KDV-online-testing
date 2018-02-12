package pages.PersonalAreaPage;

import Core.basePage.BasePage;
import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Constants.ACCOUNT_DELIVERY_ADDRESS_URL;
import static utils.WaitingUtility.elementFluentWaitClick;

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

    @FindBy(css = ".account__edit.link.offset-l-1")
    public WebElement editDeliveryLink;

    @FindBy(css = ".address__action.link")
    public WebElement addressActionLink;

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

    @FindBy(css = ".profile__addresses")
    public WebElement deliveryAddressContainer;

    @FindBy(css = "div.layout  div:nth-child(1) > div.address__info_actions > a")
    public WebElement editAddressLink;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(linkText = "Добавить")
    public WebElement addBtn;


    @FindBy(className = "success-msg")
    public WebElement messageSuccesTxt;

    @FindBy(css = ".suggestions-wrapper")
    public WebElement addressesContainerDropDown;

    @FindBy(css = "[title='Сохранить адрес']")
    public WebElement getSaveDeliveryAddressBtn;

    @FindBy(css = "[href='/about']")
    public WebElement getAboutLink;

    @FindBy(css = ".header-top")
    public WebElement headerDelivery;

    public void verifyCardNotApprovedAddress() {
        getUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        Verify.verify(getText(deliveryAddressContainer).contains("Илья Панфилов"));
        Verify.verify(getText(deliveryAddressContainer).contains("Томск, Нечевский переулок, 34"));
        Verify.verify(getText(deliveryAddressContainer).contains("Герцог мини-маркет"));
        Verify.verify(getText(deliveryAddressContainer).contains("+71111111111"));
        Verify.verify(getText(deliveryAddressContainer).contains("По умолчанию"));
        Verify.verify(getText(deliveryAddressContainer).contains("Не подтвержден"));
        elementFluentWaitClick(editAddressLink, driver).click();
        Verify.verify(getValueOfAttributeByName(company, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(company, "value").contains("Герцог мини-маркет"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "value").contains("Томск, Нечевский переулок, 34"));
    }

    public void verifyCardApprovedAddress() {
        getUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        Verify.verify(getText(deliveryAddressContainer).contains("Илья Панфилов"));
        Verify.verify(getText(deliveryAddressContainer).contains("Томск, Нечевский переулок, 34"));
        Verify.verify(getText(deliveryAddressContainer).contains("Герцог мини-маркет"));
        Verify.verify(getText(deliveryAddressContainer).contains("+71111111111"));
        Verify.verify(getText(deliveryAddressContainer).contains("По умолчанию"));
        Verify.verify(getText(deliveryAddressContainer).contains("Не подтвержден"));
        elementFluentWaitClick(editAddressLink, driver).click();
        Verify.verify(getValueOfAttributeByName(company, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(company, "value").contains("Герцог мини-маркет"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "value").contains("Томск, Нечевский переулок, 34"));
    }

    public void addAddresses() {
        getUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        elementFluentWaitClick(addBtn, driver).click();
        Verify.verify(getCurrentUrl().contains("/customer/address/new/"));
        Verify.verify(getValueOfAttributeByName(firstNameInEditDeliveryPage, "value").contains("Геннадий"));
        Verify.verify(getValueOfAttributeByName(lastNameInEditDeliveryPage, "value").contains("Фадеев"));
        Verify.verify(getValueOfAttributeByName(phoneInEditDeliveryPage, "value").contains("71119348926"));
        elementFluentWaitClick(company, driver).sendKeys("ТЕСТОВАЯ");
        elementFluentWaitClick(addressInEditDeliveryPage, driver).sendKeys("ул.Тестеров Тест 1");
        moveMouseTo(driver, getAboutLink);
        elementFluentWaitClick(addressInEditDeliveryPage, driver).click();
        Verify.verify(getText(addressesContainerDropDown).contains("Выберите адрес"));
        elementFluentWaitClick(getSaveDeliveryAddressBtn, driver).submit();
        Verify.verify(getText(messageSuccesTxt).contains("Адрес сохранён."));
    }
}
