package pages;

import basePage.BasePage;
import logger.MagDvLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;
import utils.TestReporter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.fail;
import static utils.Constants.*;
import static utils.WaitingUtility.*;

/**
 * @author Sergey Potapov
 */
public class MainPage extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //========================MAIN PAGE=============================================
    @FindBy(xpath = "//*[@title='Вход']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@id='geo_modal']//div[@class='modal__close']")
    private WebElement closePopupButton;

    @FindBy(xpath = "//img[@alt='КДВ']")
    private WebElement companyLogo;

    @FindBy(xpath = "//*[@id='geo_modal']//div[@class='modal__content']")
    private WebElement modalContentWindow;

    @FindBy(xpath = "//*[@class='header-top']//li[@class='first']")
    private WebElement baseCityLink;

    @FindBy(xpath = "//*[@class='modal__box']//div[@data-location]")
    private WebElement otherCityLink;

    //========================The unit with the advantages of the store==============
    @FindBy(xpath = "//*[@class='benefit benefit_price j_benefit']")
    private WebElement lowerPriceSection;

    @FindBy(xpath = "//div[@class='benefit benefit_price j_benefit benefit_active']")
    private WebElement lowerPriceSectionOpen;

    @FindBy(xpath = "(//*[@href='/about'])[2]")
    private WebElement aboutPricesLink;

    @FindBy(xpath = "(//*[@class='benefit__header'])[1]")
    private WebElement lowerPriceSectionHeader;

    //========================
    @FindBy(css = ".benefit.benefit_delivery.j_benefit")
    private WebElement freeDeliveringSection;

    @FindBy(css = ".benefit.benefit_delivery.j_benefit.benefit_active")
    private WebElement freeDeliveringSectionOpen;

    @FindBy(xpath = "(//*[@href='/delivery'])[2]")
    private WebElement aboutFreeDeliveryLink;

    @FindBy(xpath = "(//*[@class='benefit__header'])[2]")
    private WebElement freeDeliveringSectionHeader;

    //========================
    @FindBy(css = ".benefit.benefit_payment.j_benefit")
    private WebElement paymentUponReceivingSection;

    @FindBy(css = ".benefit.benefit_payment.j_benefit.benefit_active")
    private WebElement paymentUponReceivingSectionOpen;

    @FindBy(xpath = "//*[@class='benefit benefit_payment j_benefit benefit_active']//section//a")
    private WebElement aboutPaymentUponReceivingLink;

    @FindBy(xpath = "(//*[@class='benefit__header'])[3]")
    private WebElement paymentUponReceivingHeader;

    //========================BANNER SECTION=========================================
    @FindBy(css = ".filmore_next.filmore_command")
    private WebElement slideForwardButton;

    @FindBy(css = ".filmore_next.filmore_command")
    private WebElement slidePreviouslyButton;

    @FindBy(css = ".pix_slideshow_target")
    private WebElement newSlideSelected;

    @FindBy(xpath = ".//*[@id='1_enfinity_1']")
    private WebElement slideMenuSection;

    @FindBy(css = ".filmore_pag.filmore_pag_1")
    private WebElement slideSecondPoint;

    //========================CATEGORIES LIST SECTION=========================================
    @FindBy(css = ".menu-categories__title")
    private List<WebElement> categoryGoodsList;

    @FindBy(css = ".menu-categories__item:hover")
    private WebElement parentItemOfProducts;

    @FindBy(xpath = "(//a[@href='http://tomsk.demo.dev.magonline.ru/new-year-gifts.html'])[2]")
    private WebElement firstGoodInLinkList;

    //========================HIT OF SALES SECTION=========================================
    @FindBy(xpath = ".//*[@class='product-item__image-wrapper']")
    private List<WebElement> hitSalesList;

    @FindBy(css = ".product-item__summary-cart")
    private List<WebElement> hitSalesBasketButtons;

    @FindBy(css = ".cart-control__active")
    private WebElement productAddedButton;

    @FindBy(css = ".cart-item__title.cart-item__text.cart-item__link")
    private WebElement descriptionProductInBasket;

    @FindBy(xpath = "(//div[@class='product-item__title'])[1]")
    private WebElement firstItem;

    @FindBy(xpath = ".//*[@class='product-item__image-link']")
    private WebElement productImageLink;

    @FindBy(css = ".product-item__inner")
    private WebElement productInnerItem;

    @FindBy(xpath = "(//*[@class='product-item__image-preview'])[1]")
    private WebElement loupeButton;

    @FindBy(css = ".modal__content")
    private WebElement modalWindow;

    @FindBy(css = ".product__title")
    private WebElement descroptionProdictModalVindow;

    //========================SMM SECTION=========================================
    @FindBy(css = ".social__link.social__link_vk")
    public WebElement vkLink;

    @FindBy(css = ".social__link.social__link_instagram")
    private WebElement instaLink;

    @FindBy(css = ".social__link.social__link_android")
    private WebElement googlePlayLink;

    @FindBy(css = ".social")
    public WebElement socialLinkSection;

    //========================FOOTER SECTION=========================================
    @FindBy(xpath = ".//a[text()='О магазине']")
    private WebElement aboutShopLink;

    @FindBy(xpath = ".//a[text()='Самовывоз']")
    private WebElement customerPickupLink;

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

    @FindBy(xpath = ".//*[@href='tel:8 800 250 5555']")
    private WebElement telLink;

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

    @FindBy(xpath = ".//*[@id='footer']")
    public WebElement footer;


    public void openMainPage() {
        LOGGER.log(Level.INFO, "Open starting url");
        driver.get(BASE_URL);
        elementIsClickable(closePopupButton, driver).click();
    }

    public void checkCompanyLogo() {
        String urlActual = driver.getCurrentUrl();
        LOGGER.log(Level.INFO, "Check logo company");
        elementIsClickable(companyLogo, driver).click();
        waitForPageLoad(driver);
        String urlExpected = driver.getCurrentUrl();
        AssertCollector.assertEquals(urlActual, " URL IS EQUAL ", urlExpected);
    }

    public void closingModalWindow() {
        LOGGER.log(Level.INFO, "Check closing modal window");
        elementIsClickable(baseCityLink, driver).click();
        elementIsClickable(closePopupButton, driver).click();
        elementIsClickable(baseCityLink, driver).click();
        moveMouseToAndClick(driver, companyLogo, 1, 1);
        AssertCollector.assertFalse(modalContentWindow.isDisplayed());
    }

    public void changeCity() {
        LOGGER.log(Level.INFO, "Check changing city");
        elementIsClickable(baseCityLink, driver).click();
        elementIsClickable(otherCityLink, driver).click();
        waitForPageLoad(driver);
        AssertCollector.assertEquals(getText(baseCityLink), " LINK IS EQUAL ", getText(baseCityLink));
    }

    public void verifyingOpeningLowerPricesSection() {
        LOGGER.log(Level.INFO, "Verifying opening lower prices section");
        waitForPageLoad(driver);
        elementIsClickable(lowerPriceSection, driver).click();
        AssertCollector.assertTrue(lowerPriceSectionOpen.isDisplayed());
    }

    public void verifyingClosingLowerPricesSection() {
        LOGGER.log(Level.INFO, "Verifying closing lower prices section");
        waitForPageLoad(driver);
        elementIsClickable(lowerPriceSection, driver).click();
        elementIsClickable(lowerPriceSectionOpen, driver).click();
        AssertCollector.assertTrue(lowerPriceSection.isDisplayed());
    }

    public void verifyingAboutLinkLowerPriceSection() {
        LOGGER.log(Level.INFO, "Get current url");
        getCurrentUrl();
        LOGGER.log(Level.INFO, "Verifying opening lower prices section");
        waitForPageLoad(driver);
        elementIsClickable(lowerPriceSection, driver).click();
        elementIsClickable(aboutPricesLink, driver).click();
        waitForPageLoad(driver);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }

    public void verifyingOpeningFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Verifying opening free delivering section");
        waitForPageLoad(driver);
        elementIsClickable(freeDeliveringSection, driver).click();
        AssertCollector.assertTrue(freeDeliveringSectionOpen.isDisplayed());
    }

    public void verifyingClosingFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Verifying closing free delivering section");
        waitForPageLoad(driver);
        elementIsClickable(freeDeliveringSection, driver).click();
        elementIsClickable(freeDeliveringSectionOpen, driver).click();
        AssertCollector.assertTrue(freeDeliveringSection.isDisplayed());
    }

    public void verifyingAboutLinkFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Get current url");
        TestReporter.step("VGet current url");
        getCurrentUrl();
        LOGGER.log(Level.INFO, "Opening free delivering section");
        TestReporter.step("Opening free delivering section");
        waitForPageLoad(driver);
        elementIsClickable(freeDeliveringSection, driver).click();
        LOGGER.log(Level.INFO, "Click about link free delivering section");
        TestReporter.step("Click about link free delivering section");
        elementIsClickable(aboutFreeDeliveryLink, driver).click();
        waitForPageLoad(driver);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }

    public void verifyingOpeningPaymentUponReceivingSection() {
        LOGGER.log(Level.INFO, "Verifying opening payment upon receiving section");
        TestReporter.step("Verifying opening payment upon receiving section");
        waitForPageLoad(driver);
        elementIsClickable(paymentUponReceivingSection, driver).click();
        AssertCollector.assertTrue(paymentUponReceivingSectionOpen.isDisplayed());
    }

    public void verifyingClosingPaymentUponReceivingSection() {
        LOGGER.log(Level.INFO, "Verifying closing payment upon receiving section");
        waitForPageLoad(driver);
        elementIsClickable(paymentUponReceivingSection, driver).click();
        elementIsClickable(paymentUponReceivingSectionOpen, driver).click();
        AssertCollector.assertTrue(paymentUponReceivingSection.isDisplayed());
    }

    public void verifyingAboutLinkPaymentUponReceivingSection() {
        LOGGER.log(Level.INFO, "Get current url");
        TestReporter.step("Get current url");
        getCurrentUrl();
        LOGGER.log(Level.INFO, "Opening payment upon receiving section");
        TestReporter.step("Opening payment upon receiving section");
        waitForPageLoad(driver);
        elementIsClickable(paymentUponReceivingSection, driver).click();
        LOGGER.log(Level.INFO, "Click about link free delivering section");
        TestReporter.step("Click about link free delivering section");
        elementIsClickable(aboutPaymentUponReceivingLink, driver).click();
        waitForPageLoad(driver);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }

    public void verifyBorderColor() {
        elementIsClickable(lowerPriceSection, driver).click();
        String actualColorLowerPriceSection = "#ce0022";
        String expectedColorLowerPriceSection = getElementColor(lowerPriceSectionHeader, "border-color");
        AssertCollector.assertEqualsJ(actualColorLowerPriceSection, expectedColorLowerPriceSection,
                " Verify elements color of lower price section ");
        elementIsClickable(freeDeliveringSection, driver).click();
        String actualColorFreeDeliveringSection = "#ce0022";
        String expectedColorFreeDeliveringSection = getElementColor(freeDeliveringSectionHeader,
                "border-color");
        AssertCollector.assertEqualsJ(actualColorFreeDeliveringSection, expectedColorFreeDeliveringSection,
                " Verify elements color of free delivering section section ");
        elementIsClickable(paymentUponReceivingSection, driver).click();
        String actualColorPaymentUponReceivingSection = "#ce0022";
        String expectedColorPaymentUponReceivingSection = getElementColor(paymentUponReceivingHeader,
                "border-color");
        AssertCollector.assertEqualsJ(actualColorPaymentUponReceivingSection, expectedColorPaymentUponReceivingSection,
                " Verify elements color of free delivering section section ");
    }

    public void switchSlideForward() {
        LOGGER.log(Level.INFO, "Click slide forward button");
        TestReporter.step("Click slide forward button");
        hoverAndClick(driver, slideMenuSection, slideForwardButton);
        AssertCollector.assertTrue(newSlideSelected.isDisplayed());
    }

    public void switchSlidePreviously() {
        LOGGER.log(Level.INFO, "Click slide previously button");
        TestReporter.step("Click slide previously button");
        hoverAndClick(driver, slideMenuSection, slidePreviouslyButton);
        AssertCollector.assertTrue(newSlideSelected.isDisplayed());
    }

    public void switchBetweenSlides() {
        LOGGER.log(Level.INFO, "Switch between slides");
        TestReporter.step("Switch between slides");
        elementIsClickable(slideSecondPoint, driver);
        String actualColor = "#ff1b41";
        String expectedColor = getElementColor(slideSecondPoint, "border-color");
        AssertCollector.assertEqualsJ(actualColor, expectedColor,
                " Verify elements color of free delivering section section ");
    }

    public void selectingCategory() {
        LOGGER.log(Level.INFO, "Select category");
        TestReporter.step("Select category");
        clickOnIndexFromElementList(categoryGoodsList, 20);
        String textAttribute = getValueOfAttributeByName(firstGoodInLinkList, "href");
        getCurrentUrl();
        AssertCollector.assertEqualsJ(getCurrentUrl(), textAttribute,
                " Current url is equal link of product ");
    }

    public void moveToCategory() {
        LOGGER.log(Level.INFO, "Move to category");
        TestReporter.step("Move to category");
        moveMouseTo(driver, firstGoodInLinkList);
        String expectedColor = "#f6f6f6";
        String actualColor = getElementColor(parentItemOfProducts, "background-color");
        AssertCollector.assertEqualsJ(actualColor, expectedColor,
                " Verify elements color of free delivering section section ");
    }

    public void verifySumAllElements() {
        int expectedElementsInList = 15;
        int actualElementsInList = getSumOfAllElementFromList(hitSalesList);
        AssertCollector.assertEqualsJ(actualElementsInList, expectedElementsInList,
                " Verify total count of products in 'Hit Salary list' ");
    }

    public void verifyAddingIntoBasket() {
        String expectedDescription = getText(firstItem);
        scrollDown();
        waitForJSandJQueryToLoad();
        clickOnIndexFromElementList(hitSalesBasketButtons, 0);
        if (productAddedButton.isDisplayed()) {
            LOGGER.log(Level.INFO, "Button hitSalesBasketButtons is displayed");
            TestReporter.step("Button hitSalesBasketButtons is displayed");
            elementFluentWaitVisibility(productAddedButton, driver);
            getUrl(BASE_URL + "/checkout/cart/");
        } else {
            LOGGER.log(Level.WARNING, "Button hitSalesBasketButtons isn't displayed");
            TestReporter.step("Button hitSalesBasketButtons isn't displayed");
            fail();
        }
        elementIsClickable(descriptionProductInBasket, driver);
        String actualDescription = getText(descriptionProductInBasket);
        AssertCollector.assertEquals(actualDescription, " Description in main page equals description in" +
                " basket page ", expectedDescription);
    }

    public void openingModalWindowProductCard() {
        LOGGER.log(Level.INFO, "Select category");
        TestReporter.step("Select category");
        scrollDown();
        moveMouseTo(driver, productInnerItem);
        clickElementByJS(driver, loupeButton);
        if (modalWindow.isDisplayed()) {
            LOGGER.log(Level.INFO, "Product modal window is displayed");
            TestReporter.step("Product modal window is displayed");
        } else {
            LOGGER.log(Level.WARNING, "Product modal window isn't displayed");
            TestReporter.step("Product modal window isn't displayed");
            fail();
        }
    }

    public void openProductCard() {
        LOGGER.log(Level.INFO, "Select category");
        TestReporter.step("Select category");
        scrollDown();
        String textAttribute = getValueOfAttributeByName(productImageLink, "href");
        clickOnIndexFromElementList(hitSalesList, 0);
        getCurrentUrl();
        AssertCollector.assertEqualsJ(getCurrentUrl(), textAttribute,
                " Current url is equal link of product ");
    }

    public void openingVkLink() {
        String expUrl = "https://vk.com/kdvonline";
        textPresent("Мы стали еще ближе, присоединяйтесь к нам в соцсетях");
        elementFluentWaitVisibility(vkLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", expUrl);
    }

    public void openingInstagramLink() {
        String expUrl = "https://www.instagram.com/kdvonline/";
        elementFluentWaitVisibility(instaLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", expUrl);
    }

    public void openingGooglePlayLink() {
        String expUrl = "https://play.google.com/store/apps/details?id=com.magonline.app";
        textPresent("Скачивайте приложение для Android");
        elementFluentWaitVisibility(googlePlayLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", expUrl);
    }

    public void openingShopLink() {
        String linkTextAttribute = getValueOfAttributeByName(aboutShopLink, "href");
        elementFluentWaitVisibility(aboutShopLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingCustomerPickUpLink() {
        String linkTextAttribute = getValueOfAttributeByName(customerPickupLink, "href");
        elementFluentWaitVisibility(customerPickupLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingFreeDeliveryLink() {
        String linkTextAttribute = getValueOfAttributeByName(freeDeliveryLink, "href");
        elementFluentWaitVisibility(freeDeliveryLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingPaymentLink() {
        String linkTextAttribute = getValueOfAttributeByName(paymentLink, "href");
        elementFluentWaitVisibility(paymentLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingHowToBuyLink() {
        String linkTextAttribute = getValueOfAttributeByName(howToBuyLink, "href");
        elementFluentWaitVisibility(howToBuyLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingExchangeAndReturnLink() {
        String linkTextAttribute = getValueOfAttributeByName(exchangeAndReturnLink, "href");
        elementFluentWaitVisibility(exchangeAndReturnLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingInfoForLegalPersonsLink() {
        String linkTextAttribute = getValueOfAttributeByName(infoLegalPersonLink, "href");
        elementFluentWaitVisibility(infoLegalPersonLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingContractPurchaseSaleLink() {
        String linkTextAttribute = getValueOfAttributeByName(contractPurchaseSaleLink, "href");
        System.out.println(linkTextAttribute);
        elementFluentWaitVisibility(contractPurchaseSaleLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        System.out.println(getCurrentUrl());
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingSupplyContractLink() {
        String linkTextAttribute = "https://tomsk.kdvonline.ru/media/rules/Supply_contract.pdf";
        elementFluentWaitVisibility(supplyContractLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingPersonalDataLink() {
        String linkTextAttribute = getValueOfAttributeByName(personalDataLink, "href");
        elementFluentWaitVisibility(personalDataLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingPoliticConfidentialLink() {
        String linkTextAttribute = getValueOfAttributeByName(confidentialPoliticLink, "href");
        elementFluentWaitVisibility(confidentialPoliticLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingContactDataLink() {
        textPresent("Свяжитесь с нами");
        textPresent("Звонок по России бесплатный");
        String expMailLink = getValueOfAttributeByName(mailToLink, "href");
        String actMailLink = "mailto:info@kdvonline.ru";
        String expTelLink = getValueOfAttributeByName(telLink, "href");
        String actTelLink = "tel:8 800 250 5555";
        AssertCollector.assertEquals(actMailLink, " is equal to ",
                expMailLink);
        AssertCollector.assertEquals(actTelLink, " is equal to ",
                expTelLink);
    }

    public void verifyingCopyWriting() {
        textPresent("© 2017 ООО «КДВ Групп»");
    }

    public void openingRegulationsLink() {
        String linkTextAttribute = getValueOfAttributeByName(regulationsLink, "href");
        elementFluentWaitVisibility(regulationsLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingContactsLink() {
        String linkTextAttribute = getValueOfAttributeByName(contactsLink, "href");
        elementFluentWaitVisibility(contactsLink, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingVkLinkInFooter() {
        String linkTextAttribute = getValueOfAttributeByName(footerVkLink, "href");
        elementFluentWaitVisibility(footerVkLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of VK ",
                linkTextAttribute);
    }

    public void openingInstaInFooter() {
        String linkTextAttribute = getValueOfAttributeByName(footerInstaLink, "href");
        elementFluentWaitVisibility(footerInstaLink, driver).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of Instagram ",
                linkTextAttribute);
    }
}

