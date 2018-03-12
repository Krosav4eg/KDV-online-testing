package KDV_business_logic.pages.MainPage;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static Core.utils.Constants.SECOND_TAB_BROWSER;
import static Core.utils.Constants.TWO_TABS_BROWSER;

public class FooterPage  extends BasePage{

    //========================FOOTER SECTION=========================================
    @FindBy(xpath = ".//a[text()='О магазине']")
    private WebElement aboutShopLink;

    @FindBy(xpath = ".//a[text()='Самовывоз']")
    private WebElement customerPickupLink;

    @FindBy(css = ".footer-menu")
    private WebElement footerMenu;

    @FindBy(xpath = ".//a[text()='Бесплатная доставка']")
    private WebElement freeDeliveryLink;

    @FindBy(xpath = ".//a[text()='Оплата']")
    private WebElement paymentLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='Как купить']")
    private WebElement howToBuyLink;

    @FindBy(xpath = ".//a[text()='Возврат и обмен']")
    private WebElement exchangeAndReturnLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='Информация для юридических лиц']")
    private WebElement infoLegalPersonLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='Договор купли-продажи']")
    private WebElement contractPurchaseSaleLink;

    @FindBy(xpath = ".//a[text()='Договор поставки']")
    private WebElement supplyContractLink;

    @FindBy(xpath = ".//a[text()='Персональные данные']")
    private WebElement personalDataLink;

    @FindBy(xpath = ".//*[@href='mailto:info@kdvonline.ru']")
    private WebElement mailToLink;

    @FindBy(xpath = ".//*[@class='footer__copyright']")
    private WebElement copywrite;

    @FindBy(xpath = "(.//*[@href=\"tel:+7 913 817-38-90\"])[2]")
    public WebElement additionalTelLink;

    @FindBy(xpath = ".//a[text()='Политика конфиденциальности']")
    private WebElement confidentialPoliticLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='Регламент']")
    private WebElement regulationsLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='Контакты']")
    private WebElement contactsLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='ВКонтакте']")
    private WebElement footerVkLink;

    @FindBy(xpath = ".//*[@id='footer']//a[text()='Instagram']")
    private WebElement footerInstaLink;

    @FindBy(css = ".footer-menu__social.footer-menu__social_android")
    private WebElement footerGooglePlayLink;

    @FindBy(xpath = "//div[@class=\"event-menu\"]//*[@href='tel:8 800 250 5555']")
    private WebElement telLink;

    @FindBy(css = ".button-scroll-top")
    private WebElement upButton;


    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAdditionalPhoneLink()
    {

        textPresent("8 800 250 5555");
        textPresent("Служба поддержки");
        AssertCollector.assertEqualsJ(telLink.getAttribute("href"), "tel:8 800 250 5555",
                "references are equals");
        textPresent("+7 913 817-38-90");
        textPresent("Служба доставки в городе Томск:");
        AssertCollector.assertEqualsJ(additionalTelLink.getAttribute("href"), "tel:+7 913 817-38-90",
                "references are equals");
    }

    public void openingVkLinkInFooter() {
        String originalHandle = driver.getWindowHandle();
        String linkTextAttribute = getValueOfAttributeByName(footerVkLink, "href");
        elementFluentWaitVisibility(footerVkLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of VK ",
                linkTextAttribute);
        driver.close();
        driver.switchTo().window(originalHandle);
    }


    public void openingInstaInFooter() {
        String originalHandle = driver.getWindowHandle();
        String linkTextAttribute = getValueOfAttributeByName(footerInstaLink, "href");
        elementFluentWaitVisibility(footerInstaLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of Instagram ",
                linkTextAttribute);
        driver.close();
        driver.switchTo().window(originalHandle);
    }


    public void openingGooglePlayInFooter() {
        String originalHandle = driver.getWindowHandle();
        String linkTextAttribute = getValueOfAttributeByName(footerGooglePlayLink, "href");
        elementFluentWaitVisibility(footerGooglePlayLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of Google play ",
                linkTextAttribute);
        driver.close();
        driver.switchTo().window(originalHandle);
    }



    public void clickingUpButtonInFooter() {
        elementFluentWaitVisibility(upButton).click();
        waitInvisibilityOfElement(upButton);
    }


    public void openingRegulationsLink() {
        String linkTextAttribute = getValueOfAttributeByName(regulationsLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(regulationsLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of regulations page ",
                linkTextAttribute);
    }

    public void openingContactsLink() {
        String linkTextAttribute = getValueOfAttributeByName(contactsLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(contactsLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of contacts ",
                linkTextAttribute);
    }


    public void verifyingCopyWriting() {
        AssertCollector.assertTrue(Objects.equals(copywrite.getText(), "© 2018 ООО «КДВ Групп»"));
    }


    public void openingPoliticConfidentialLink() {
        String linkTextAttribute = getValueOfAttributeByName(confidentialPoliticLink, "href");
        elementFluentWaitVisibility(confidentialPoliticLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingContactDataLink() {
        textPresent("Свяжитесь с нами");
        String expMailLink = getValueOfAttributeByName(mailToLink, "href");
        String actMailLink = "mailto:info@kdvonline.ru";
        String expTelLink = getValueOfAttributeByName(telLink, "href");
        String actTelLink = "tel:8 800 250 5555";
        AssertCollector.assertEquals(actMailLink, " is equal to ",
                expMailLink);
        AssertCollector.assertEquals(actTelLink, " is equal to ",
                expTelLink);
    }


    public void openingShopLink() {
        String linkTextAttribute = getValueOfAttributeByName(aboutShopLink, "href");
        elementFluentWaitVisibility(aboutShopLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingCustomerPickUpLink() {
        String linkTextAttribute = getValueOfAttributeByName(customerPickupLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(customerPickupLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of pick up ",
                linkTextAttribute);
    }

    public void openingFreeDeliveryLink() {
        String linkTextAttribute = getValueOfAttributeByName(freeDeliveryLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(freeDeliveryLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of free delivery ",
                linkTextAttribute);
    }

    public void openingPaymentLink() {
        String linkTextAttribute = getValueOfAttributeByName(paymentLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(paymentLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of payment ",
                linkTextAttribute);
    }

    public void openingHowToBuyLink() {
        String linkTextAttribute = getValueOfAttributeByName(howToBuyLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(howToBuyLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of how to buy page ",
                linkTextAttribute);
    }

    public void openingExchangeAndReturnLink() {
        String linkTextAttribute = getValueOfAttributeByName(exchangeAndReturnLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(exchangeAndReturnLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of exchange ",
                linkTextAttribute);
    }

    public void openingInfoForLegalPersonsLink() {
        String linkTextAttribute = getValueOfAttributeByName(infoLegalPersonLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(infoLegalPersonLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of info page ",
                linkTextAttribute);
    }

    public void openingContractPurchaseSaleLink() {
        String originalHandle = driver.getWindowHandle();
        String linkTextAttribute = getValueOfAttributeByName(contractPurchaseSaleLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(contractPurchaseSaleLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    public void openingSupplyContractLink() {
        String originalHandle = driver.getWindowHandle();
        String linkTextAttribute = "https://tomsk.kdvonline.ru/media/rules/Supply_contract.pdf";
        elementFluentWaitVisibility(supplyContractLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    public void openingPersonalDataLink() {
        String originalHandle = driver.getWindowHandle();
        String linkTextAttribute = getValueOfAttributeByName(personalDataLink, "href");
        elementFluentWaitVisibility(personalDataLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
        driver.close();
        driver.switchTo().window(originalHandle);
    }


}
