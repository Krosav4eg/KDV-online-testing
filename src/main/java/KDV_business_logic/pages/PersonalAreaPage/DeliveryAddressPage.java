package KDV_business_logic.pages.PersonalAreaPage;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Core.utils.Constants.ACCOUNT_DELIVERY_ADDRESS_URL;
import static Core.utils.Constants.ACCOUNT_INFORMATION_URL;
import static Core.utils.WaitingUtility.elementFluentWaitClick;

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

    @FindBy(css = ".field-address.j_field_address.required-entry.suggestions-input")
    public WebElement addressInEditDeliveryPage;

    @FindBy(id = "floor")
    public WebElement florInEditDeliveryPage;

    @FindBy(id = "porch")
    public WebElement porchInEditDeliveryPage;

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

    //в адрес доставки "Томск, Нечевский переулок, 34" был добавлен пробел
    public void verifyCardNotApprovedAddress() {
        getUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        Verify.verify(getText(deliveryAddressContainer).contains("Илья Панфилов"));
        Verify.verify(getText(deliveryAddressContainer).contains("Томск, Нечевский переулок, 34"));
        Verify.verify(getText(deliveryAddressContainer).contains("Герцог мини-маркет"));
        Verify.verify(getText(deliveryAddressContainer).contains("+71111111111"));
        Verify.verify(getText(deliveryAddressContainer).contains("По умолчанию"));
        Verify.verify(getText(deliveryAddressContainer).contains("Не подтвержден"));
        elementFluentWaitClick(editAddressLink).click();
        Verify.verify(getValueOfAttributeByName(company, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(company, "value").contains("Герцог мини-маркет"));
        scrollDown();
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "value").
                contains("Томск, Нечевский переулок, 34"));
    }

    public void verifyCardApprovedAddress() {
        getUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        Verify.verify(getText(deliveryAddressContainer).contains("Илья Панфилов"));
        Verify.verify(getText(deliveryAddressContainer).contains("Томск, Нечевский переулок, 34"));
        Verify.verify(getText(deliveryAddressContainer).contains("Герцог мини-маркет"));
        Verify.verify(getText(deliveryAddressContainer).contains("+71111111111"));
        Verify.verify(getText(deliveryAddressContainer).contains("По умолчанию"));
        Verify.verify(getText(deliveryAddressContainer).contains("Не подтвержден"));
        elementFluentWaitClick(editAddressLink).click();
        Verify.verify(getValueOfAttributeByName(company, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "readonly").contains("true"));
        Verify.verify(getValueOfAttributeByName(company, "value").contains("Герцог мини-маркет"));
        Verify.verify(getValueOfAttributeByName(addressInEditDeliveryPage, "value").
                contains("Томск, Нечевский переулок, 34"));
    }

    public void addAddresses() {
        getUrl(ACCOUNT_DELIVERY_ADDRESS_URL);
        elementFluentWaitClick(addBtn).click();
        Verify.verify(getCurrentUrl().contains("/customer/address/new/"));
        Verify.verify(getValueOfAttributeByName(firstNameInEditDeliveryPage, "value").contains("Геннадий"));
        Verify.verify(getValueOfAttributeByName(lastNameInEditDeliveryPage, "value").contains("Фадеев"));
        Verify.verify(getValueOfAttributeByName(phoneInEditDeliveryPage, "value").contains("71119348926"));
        elementFluentWaitClick(company).sendKeys("ТЕСТОВАЯ");
        elementFluentWaitClick(addressInEditDeliveryPage).sendKeys("ул.Тестеров Тест 1");
        moveMouseTo(driver, getAboutLink);
        elementFluentWaitClick(getSaveDeliveryAddressBtn).submit();
        Verify.verify(getText(messageSuccesTxt).contains("Адрес сохранён."));
    }


    public void verifyDeliveryAddressHeader() {
        AssertCollector.assertEqualsJ(getCurrentUrl(), ACCOUNT_DELIVERY_ADDRESS_URL,
                "Urls are equals");
        AssertCollector.assertTrue(elementIsVisible(deliveryAddressHeader),
                "Required header is displayed");
    }

    public void verifyChangingDeliveryAddress() {
        elementFluentWaitClick(editDeliveryLink).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(), ACCOUNT_INFORMATION_URL, "Urls are equals");
    }

    public void verifyAbsenceDeliveryAddress() {
        elementIsClickable(deliveryAddressItemButton).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(), ACCOUNT_DELIVERY_ADDRESS_URL, "Urls are equals");
        AssertCollector.assertEqualsJ(nameDeliveryByDefault.getText(), "Тимофей Большаков",
                "First name and last name are equals");
        AssertCollector.assertEqualsJ(deliveryAddressByDefault.getText(),
                "г Томск, ул Вавилова, д 13, кв 23",
                "Addresses are equals");
        AssertCollector.assertEqualsJ(phoneDeliveryByDefault.getText(), "+71111111111",
                "Phone numbers are equals");
        AssertCollector.assertTrue(elementIsVisible(byDefaultMark));
        elementFluentWaitClick(addressActionLink).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(), ACCOUNT_DELIVERY_ADDRESS_URL + "edit/id/4236/",
                "Urls are equals");
        AssertCollector.assertEqualsJ(firstNameInEditDeliveryPage.getAttribute("value"),
                "Тимофей", "First names are correct");
        AssertCollector.assertEqualsJ(lastNameInEditDeliveryPage.getAttribute("value"),
                "Большаков", "Last names are correct");
        AssertCollector.assertEqualsJ(phoneInEditDeliveryPage.getAttribute("value"),
                "+71111111111", "Phone numbers are equals");
        AssertCollector.assertEqualsJ(addressInEditDeliveryPage.getAttribute("value"),
                "г Томск, ул Вавилова, д 13, кв 23", "Addresses are equals");
        AssertCollector.assertEqualsJ(florInEditDeliveryPage.getAttribute("value"),
                "1", "Flores are equals");
        AssertCollector.assertEqualsJ(porchInEditDeliveryPage.getAttribute("value"),
                "2", "Porches are equals");
    }
}
