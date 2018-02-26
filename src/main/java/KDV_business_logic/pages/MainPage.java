package KDV_business_logic.pages;

import Core.basePage.BasePage;
import Core.logger.MagDvLogger;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.fail;
import static Core.utils.Constants.*;
import static Core.utils.WaitingUtility.*;

/**
 * @author Sergey Potapov
 */
public class MainPage extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //========================HEADER SECTION=============================================
    @FindBy(xpath = "//*[@title='Вход']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@title='Регистрация']")
    private WebElement registrationButton;

    @FindBy(id = "geo_modal")
    private WebElement modelWindow;

    @FindBy(css = ".geo.j_geo")
    private WebElement selectCityModalWindow;

    @FindBy(xpath = "//div[text()='Кемерово']")
    private WebElement selectCityKemerovo;

    @FindBy(className = "geo__title_default")
    private WebElement geoWindowModal;

    @FindBy(xpath = "//div[text()='Томск']")
    private WebElement selectCityTomsk;

    @FindBy(css = ".geo-confirm__city")
    private WebElement geoConfirmModalWindow;

    @FindBy(xpath = "//button[text()='Да']")
    private WebElement acceptGeoConfirm;

    @FindBy(css = ".j_geo_confirm_confirm")
    private WebElement acceptBtn;

    @FindBy(xpath = "//*[@id='geo_modal']//div[@class='modal__close']")
    private WebElement closePopupButton;

    @FindBy(xpath = "(//a[@title='КДВ'])[1]")
    private WebElement companyLogo;

    @FindBy(xpath = "//*[@id='geo_modal']//div[@class='modal__content']")
    private WebElement modalContentWindow;

    @FindBy(css = ".quicklink__item.quicklink__item_geo.j_geo_control.j_geo_control_modal")
    private WebElement baseCityLink;

    @FindBy(className = "quicklink__item_geo")
    public WebElement cityLink;

    @FindBy(xpath = "//*[@class='modal__box']//div[@data-location]")
    private List<WebElement> otherCityLink;

    @FindBy(xpath = "(//*[@class='modal__box']//div[@data-location])[1]")
    private WebElement firstCityLink;

    @FindBy(css = ".select2-selection.select2-selection--single")
    private WebElement citySearchField;

    @FindBy(css = ".select2-results__options")
    private WebElement citySearchDropdown;

    @FindBy(css = ".top-link-myaccount")
    public WebElement myAccountLink;

    @FindBy(xpath = "//div[2]//h1")
    private WebElement resultsProductSearchTitle;

    @FindBy(xpath = "//div/p[1]")
    private WebElement resultsProductSearch;

    @FindBy(xpath = "(//a[@class=\"event-menu__phone\"])[1]")
    public WebElement firstPhoneLink;

    @FindBy(xpath = "(//a[@class=\"event-menu__phone\"])[2]")
    public WebElement secondPhoneLink;

    //========================
    @FindBy(css = ".mini-cart-summary__qty.mini-cart-summary__qty_empty")
    private WebElement myCart;

    @FindBy(xpath = "//*[@title='Конфеты «Томские классические», 300 г']")
    private WebElement productTitleToBasket;

    @FindBy(xpath = ".//*[@id='product-price-2465']/span[1]")
    private WebElement productPriceToBasket;

    @FindBy(css = ".mini-cart-product__name.mini-cart-product__name_link")
    private WebElement productTitleInBasket;

    @FindBy(css = ".mini-cart-product__price")
    private WebElement productPriceInBasket;

    @FindBy(css = ".mini-cart__dropdown.j_mini-cart__dropdown")
    private WebElement mainBasketToExpandButton;

    @FindBy(css = ".mini-cart__inner.mini-cart_clickable.j_mini-cart_clickable")
    private WebElement subBasketToExpandButton;

    @FindBy(css = ".mini-cart-summary__qty")
    private WebElement quantityOfProductsInBasket;

    @FindBy(css = ".mini-cart-summary__qty.mini-cart-summary__qty_empty")
    private WebElement basketIsEmpty;

    @FindBy(css = ".mini-cart-product__remove")
    private WebElement removeProductsFromBasket;

    @FindBy(css = ".mini-cart-dropdown__link.btn.btn-primary")
    private WebElement submitAddingToBasket;

    @FindBy(css = ".mini-cart-dropdown__link.mini-cart-dropdown__link_right.btn.btn-primary")
    private WebElement createOrderInBasket;

    //========================The unit with the advantages of the store==============
    @FindBy(xpath = "//*[@class='benefit benefit_price j_benefit']")
    private WebElement lowerPriceSection;

    @FindBy(css = "[alt='КДВ']")
    private WebElement kdvImg;

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

    @FindBy(css = ".filter__group")
    private WebElement filter;

    @FindBy(css = ".filter__value")
    private WebElement filterValue;

    @FindBy(css = ".menu-categories__link")
    private WebElement categoryLink;

    @FindBy(css = ".menu-categories__item")
    private WebElement parentItemOfProducts;

    @FindBy(xpath = "(//a[@href='http://tomsk.demo.dev.magonline.ru/new-year-gifts.html'])[2]")
    private WebElement firstGoodInLinkList;

    //========================
    @FindBy(xpath = "(.//span[@class='btn-catalog__label with-closed-expander'])[1]")
    private WebElement catalogExpand;

    @FindBy(css = ".header-bottom-left__catalog")
    private WebElement categoryList;
    //========================HIT OF SALES SECTION=========================================
    @FindBy(xpath = ".//*[@class='product-item__image-wrapper']")
    private List<WebElement> hitSalesList;

    @FindBy(css = ".product-item__summary-cart")
    private List<WebElement> hitSalesBasketButtons;

    @FindBy(className = "social")
    private WebElement socialContainer;

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

    @FindBy(xpath = "//div[@class=\"event-menu\"]//*[@href='tel:8 800 250 5555']")
    public WebElement telLink;

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

    @FindBy(css = ".button-scroll-top")
    private WebElement upButton;

    @FindBy(id = "footer")
    public WebElement footer;

    //========================
    @FindBy(css = ".header-bottom-left__logo_small.text-left")
    private WebElement smallLogo;

    @FindBy(xpath = "//div[@id='input-search-wrapper']/*[@id='search']")
    private WebElement searchProductField;

    @FindBy(xpath = ".//*[@id='select-search-wrapper']/div")
    private WebElement categoryDropdown;

    @FindBy(css = ".search-category__selected.j_search_category_selected")
    private WebElement categoriesHeader;

    @FindBy(xpath = ".//*[@id='inputs-search-table']//div[4]")
    private WebElement categoryFromList;

    @FindBy(xpath = ".//*[@id='inputs-search-table']//div[9]")
    private WebElement anotherCategoryFromList;

    @FindBy(css = ".search-button__btn")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='search-button__label']/span")
    private WebElement searchButtonLabel;

    @FindBy(css = ".mini-cart__dropdown.j_mini-cart__dropdown")
    private WebElement fullBasketDropdown;

    public void openMainPage() {
        driver.get(BASE_URL);
        if (elementIsPresent(selectCityModalWindow)) {
            elementIsClickable(selectCityTomsk).click();
            elementIsVisible(selectCityModalWindow);
        } else if (elementIsPresent(geoConfirmModalWindow)) {
            elementIsClickable(acceptGeoConfirm).click();
            elementIsVisible(geoConfirmModalWindow);
        }
        driver.navigate().refresh();
    }


    public void checkCompanyLogo() {
        String urlActual = driver.getCurrentUrl();
        elementIsClickable(companyLogo).click();
        String urlExpected = driver.getCurrentUrl();
        AssertCollector.assertEquals(urlActual, " URL IS EQUAL ", urlExpected);
    }

    public void closingModalWindow() {
        elementFluentWaitVisibility(baseCityLink).click();
        elementFluentWaitVisibility(closePopupButton).click();
        elementFluentWaitVisibility(baseCityLink).click();
        moveMouseToAndClick(driver, companyLogo, 1, 1);
        AssertCollector.assertFalse(elementIsVisible(modalContentWindow));
    }

    public void changeCity() {
        elementIsClickable(baseCityLink).click();
        elementIsClickable(firstCityLink).click();
        AssertCollector.assertEquals(getText(baseCityLink), " LINK IS EQUAL ", getText(baseCityLink));
    }

    public void changeCityToCurrent() {
        LOGGER.log(Level.INFO, "Check changing city to current");
        TestReporter.step("Check changing city to current");
        textIsPresent(baseCityLink, "Кемерово");
        elementIsClickable(cityLink).click();
        textIsPresent(geoWindowModal, "Или выберите из списка");
        String currentCity = getText(baseCityLink);
        moveMouseTo(driver, baseCityLink);
        textIsPresent(geoWindowModal, "Или выберите из списка");
        Actions actions = new Actions(driver);
        actions.moveToElement(citySearchField);
        actions.click();
        actions.sendKeys(currentCity);
        actions.build().perform();
        elementIsClickable(citySearchDropdown).click();
        AssertCollector.assertEquals(currentCity, " City link is equal ", getText(baseCityLink));
    }

    public void changeCityToOther() {
        textIsPresent(baseCityLink, "Астрахань");
        elementIsClickable(cityLink).click();
        LOGGER.log(Level.INFO, "Check changing city to other");
        TestReporter.step("Check changing city to other");
        String otherCity = "Кемерово";
        textIsPresent(geoWindowModal, "Или выберите из списка");
        elementIsClickable(selectCityKemerovo).click();
        textIsPresent(baseCityLink, "Кемерово");
        AssertCollector.assertEquals(baseCityLink.getAttribute("title"), " LINK IS EQUAL ", otherCity);
    }

    public void verifyingOpeningLowerPricesSection() {
        LOGGER.log(Level.INFO, "Verifying opening lower prices section");
        TestReporter.step("Verifying opening lower prices section");
        elementIsClickable(lowerPriceSection).click();
        AssertCollector.assertTrue(lowerPriceSectionOpen.isDisplayed());
    }

    public void verifyingClosingLowerPricesSection() {
        getUrl(BASE_URL);
        LOGGER.log(Level.INFO, "Verifying closing lower prices section");
        TestReporter.step("Verifying opening lower prices section");
        elementIsClickable(lowerPriceSection).click();
        elementIsClickable(kdvImg).click();
        AssertCollector.assertTrue(elementIsVisible(lowerPriceSection));
    }

    public void verifyingAboutLinkLowerPriceSection() {
        getUrl(BASE_URL);
        LOGGER.log(Level.INFO, "Get current url");
        TestReporter.step("Get current url");
        getCurrentUrl();
        LOGGER.log(Level.INFO, "Verifying opening lower prices section");
        TestReporter.step("Verifying opening lower prices section");
        elementIsClickable(lowerPriceSection).click();
        elementIsClickable(aboutPricesLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }

    public void verifyingOpeningFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Verifying opening free delivering section");
        elementIsClickable(freeDeliveringSection).click();
        AssertCollector.assertTrue(elementIsVisible(freeDeliveringSectionOpen));
    }

    public void verifyingClosingFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Verifying closing free delivering section");
        TestReporter.step("Verifying closing free delivering section");
        //elementIsClickable(freeDeliveringSection).click();
        elementIsClickable(freeDeliveringSectionOpen).click();
        AssertCollector.assertTrue(elementIsDisplayed(freeDeliveringSection));
    }

    public void verifyingAboutLinkFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Get current url");
        TestReporter.step("VGet current url");
        getCurrentUrl();
        LOGGER.log(Level.INFO, "Opening free delivering section");
        TestReporter.step("Opening free delivering section");
        elementIsClickable(freeDeliveringSection).click();
        LOGGER.log(Level.INFO, "Click about link free delivering section");
        TestReporter.step("Click about link free delivering section");
        elementIsClickable(aboutFreeDeliveryLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }

    public void verifyingOpeningPaymentUponReceivingSection() {
        LOGGER.log(Level.INFO, "Verifying opening payment upon receiving section");
        TestReporter.step("Verifying opening payment upon receiving section");
        elementIsClickable(paymentUponReceivingSection).click();
        AssertCollector.assertTrue(elementIsVisible(paymentUponReceivingSectionOpen));
    }

    public void verifyingClosingPaymentUponReceivingSection() {
        LOGGER.log(Level.INFO, "Verifying closing payment upon receiving section");
        elementIsClickable(paymentUponReceivingSectionOpen).click();
        AssertCollector.assertTrue(elementIsVisible(paymentUponReceivingSection));
    }

    public void verifyingAboutLinkPaymentUponReceivingSection() {
        LOGGER.log(Level.INFO, "Get current url");
        TestReporter.step("Get current url");
        getCurrentUrl();
        LOGGER.log(Level.INFO, "Opening payment upon receiving section");
        TestReporter.step("Opening payment upon receiving section");
        elementIsClickable(paymentUponReceivingSection).click();
        LOGGER.log(Level.INFO, "Click about link free delivering section");
        TestReporter.step("Click about link free delivering section");
        elementIsClickable(aboutPaymentUponReceivingLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }

    public void verifyBorderColor() {
        elementIsClickable(lowerPriceSection).click();
        String actualColorLowerPriceSection = "#ce0022";
        String expectedColorLowerPriceSection = getElementColor(lowerPriceSectionHeader, "border-color");
        AssertCollector.assertEqualsJ(actualColorLowerPriceSection, expectedColorLowerPriceSection,
                " Verify elements color of lower price section ");
        elementIsClickable(freeDeliveringSection).click();
        String actualColorFreeDeliveringSection = "#ce0022";
        String expectedColorFreeDeliveringSection = getElementColor(freeDeliveringSectionHeader,
                "border-color");
        AssertCollector.assertEqualsJ(actualColorFreeDeliveringSection, expectedColorFreeDeliveringSection,
                " Verify elements color of free delivering section section ");
        elementIsClickable(paymentUponReceivingSection).click();
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
        AssertCollector.assertTrue(elementIsVisible(newSlideSelected));
    }

    public void switchSlidePreviously() {
        LOGGER.log(Level.INFO, "Click slide previously button");
        TestReporter.step("Click slide previously button");
        hoverAndClick(driver, slideMenuSection, slidePreviouslyButton);
        AssertCollector.assertTrue(elementIsDisplayed(newSlideSelected));
    }

    public void switchBetweenSlides() {
        LOGGER.log(Level.INFO, "Switch between slides");
        TestReporter.step("Switch between slides");
        elementIsClickable(slideSecondPoint);
        String actualColor = "#ff1b41";
        String expectedColor = getElementColor(slideSecondPoint, "border-color");
        AssertCollector.assertEqualsJ(actualColor, expectedColor,
                " Verify elements color of free delivering section section ");
    }

    public void moveToCategory() {
        LOGGER.log(Level.INFO, "Move to category");
        TestReporter.step("Move to category");
        moveMouseTo(driver, parentItemOfProducts);
        AssertCollector.assertTrue(getValueOfAttributeByName(parentItemOfProducts, "class").contains("menu-categories__item"));
    }

    public void verifySumAllElements() {
        int expectedElementsInList = 15;
        int actualElementsInList = getSumOfAllElementFromList(hitSalesList);
        AssertCollector.assertEqualsJ(actualElementsInList, expectedElementsInList,
                " Verify total count of products in 'Hit Salary list' ");
    }

    public void verifyAddingIntoBasket() {
        String expectedDescription = getText(firstItem);
        moveToElementJS(driver, socialContainer);
        clickOnIndexFromElementList(hitSalesBasketButtons, 0);
        if (elementIsVisible(productAddedButton)) {
            LOGGER.log(Level.INFO, "Button hitSalesBasketButtons is displayed");
            TestReporter.step("Button hitSalesBasketButtons is displayed");
            elementFluentWaitVisibility(productAddedButton);
            getUrl(BASE_URL + "/checkout/cart/");
        } else {
            LOGGER.log(Level.WARNING, "Button hitSalesBasketButtons isn't displayed");
            TestReporter.step("Button hitSalesBasketButtons isn't displayed");
            fail();
        }
        elementIsClickable(descriptionProductInBasket);
        String actualDescription = getText(descriptionProductInBasket);
        AssertCollector.assertEquals(actualDescription, " Description in Singleton page equals description in" +
                " basket page ", expectedDescription);
    }

    public void openingModalWindowProductCard() {
        getUrl(BASE_URL);
        LOGGER.log(Level.INFO, "Select category");
        TestReporter.step("Select category");
        scrollDown();
        moveMouseTo(driver, productInnerItem);
        clickElementByJS(driver, loupeButton);
        AssertCollector.assertTrue(elementIsVisible(modalWindow));
    }

    public void openProductCard() {
        getUrl(BASE_URL);
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
        String originalHandle = driver.getWindowHandle();
        String expUrl = "https://vk.com/kdvonline";
        textPresent("Мы стали еще ближе, присоединяйтесь к нам в соцсетях");
        elementFluentWaitVisibility(vkLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", expUrl);
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    public void openingInstagramLink() {

        String originalHandle = driver.getWindowHandle();
        String expUrl = "https://www.instagram.com/kdvonline/";
        elementFluentWaitVisibility(instaLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", expUrl);
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    public void openingGooglePlayLink() {
        String originalHandle = driver.getWindowHandle();
        String expUrl = "https://play.google.com/store/apps/details?id=com.magonline.app";
        textPresent("Скачивайте приложение для Android");
        elementFluentWaitVisibility(googlePlayLink).click();
        switchDriverToAnyTabOfBrowser(SECOND_TAB_BROWSER);
        verifyTabsCountAsExpected(TWO_TABS_BROWSER);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", expUrl);
        driver.close();
        driver.switchTo().window(originalHandle);
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
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingFreeDeliveryLink() {
        String linkTextAttribute = getValueOfAttributeByName(freeDeliveryLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(freeDeliveryLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingPaymentLink() {
        String linkTextAttribute = getValueOfAttributeByName(paymentLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(paymentLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingHowToBuyLink() {
        String linkTextAttribute = getValueOfAttributeByName(howToBuyLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(howToBuyLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingExchangeAndReturnLink() {
        String linkTextAttribute = getValueOfAttributeByName(exchangeAndReturnLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(exchangeAndReturnLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingInfoForLegalPersonsLink() {
        String linkTextAttribute = getValueOfAttributeByName(infoLegalPersonLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(infoLegalPersonLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
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

    public void openingPoliticConfidentialLink() {
        String linkTextAttribute = getValueOfAttributeByName(confidentialPoliticLink, "href");
        elementFluentWaitVisibility(confidentialPoliticLink).click();
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
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(regulationsLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
    }

    public void openingContactsLink() {
        String linkTextAttribute = getValueOfAttributeByName(contactsLink, "href");
        moveToElementJS(driver, footerMenu);
        elementFluentWaitVisibility(contactsLink).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of product ",
                linkTextAttribute);
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

    public void openingRegistrationLink() {
        String linkTextAttribute = getValueOfAttributeByName(registrationButton, "href");
        elementFluentWaitVisibility(registrationButton).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of registration ",
                linkTextAttribute);
    }

    public void openingEnterLink() {
        String linkTextAttribute = getValueOfAttributeByName(enterButton, "href");
        elementFluentWaitVisibility(enterButton).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of enter ",
                linkTextAttribute);
    }

    public void verifyingAnswerYourQuestionsTelNumber() {
        getUrl(BASE_URL);
        textPresent("Ответим на ваши вопросы");
        String expTelLink = "tel:8 800 250 5555";
        String actTelLink = getValueOfAttributeByName(telLink, "href");
        AssertCollector.assertEquals(actTelLink, " Current telephone is equal to ",
                expTelLink);
    }

    public void verifyMyCardIsEmpty() {
        LOGGER.log(Level.INFO, "Verifying clicking my basket");
        TestReporter.step("Verifying clicking my basket");
        elementIsClickable(myCart).click();
        AssertCollector.assertTrue(elementIsVisible(myCart));
        textPresent("Корзина пока пуста");
    }

    public void verifyMyBasketWithProduct() {
        getUrl(BASE_URL);
        String actTitle = getValueOfAttributeByName(productTitleToBasket, "title");
        String actPrice = getValueOfAttributeByName(productPriceToBasket, "title");
        moveToElementJS(driver, socialContainer);
        clickOnIndexFromElementList(hitSalesBasketButtons, 0);
        elementIsClickable(productAddedButton);
        if (elementIsVisible(productAddedButton)) {
            LOGGER.log(Level.INFO, "Button hitSalesBasketButtons is displayed");
            TestReporter.step("Button hitSalesBasketButtons is displayed");
            AssertCollector.assertTrue(elementIsVisible(productAddedButton));
        } else {
            LOGGER.log(Level.WARNING, "Button hitSalesBasketButtons isn't displayed");
            TestReporter.step("Button hitSalesBasketButtons isn't displayed");
            fail();
        }
        elementFluentWaitVisibility(upButton).click();
        hoverAndClick(driver, mainBasketToExpandButton, subBasketToExpandButton);
        String expTitle = getValueOfAttributeByName(productTitleInBasket, "title");
        String expPrice = getValueOfAttributeByName(productPriceInBasket, "title");
        AssertCollector.assertEquals(actTitle, " Title in Singleton page equals title in" +
                " basket page ", expTitle);
        AssertCollector.assertEquals(actPrice, " Price in Singleton page equals price in" +
                " basket page ", expPrice);
    }

    public void checkingProductsInBasket() throws NoSuchElementException {
        if (elementIsVisible(basketIsEmpty)) {
            scrollToNecessaryElement(socialContainer);
            moveToCategory();
            clickOnIndexFromElementList(hitSalesBasketButtons, 0);
            if (elementIsVisible(productAddedButton)) {
                AssertCollector.assertTrue(elementIsVisible(productAddedButton));
                LOGGER.log(Level.INFO, "Button hitSalesBasketButtons is displayed");
                TestReporter.step("Button hitSalesBasketButtons is displayed");
            } else {
                LOGGER.log(Level.WARNING, "Button hitSalesBasketButtons isn't displayed");
                TestReporter.step("Button hitSalesBasketButtons isn't displayed");
                fail();
            }
            elementFluentWaitVisibility(upButton).click();
            hoverAndClick(driver, mainBasketToExpandButton, subBasketToExpandButton);
            textPresent("2 тов.");
            TestReporter.step("2 products are in the basket");
        } else {
            while (!basketIsEmpty.isDisplayed()) {
                hoverAndClick(driver, mainBasketToExpandButton, subBasketToExpandButton);
                elementFluentWaitVisibility(removeProductsFromBasket).click();
            }
        }
    }

    public void openingBasketPageFromHeader() {
        verifyMyBasketWithProduct();
        String linkTextAttribute = getValueOfAttributeByName(submitAddingToBasket, "href");
        elementFluentWaitVisibility(submitAddingToBasket).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of adding to basket ",
                linkTextAttribute);
    }

    public void openingCatalogAfterLeftMainPage() {
        elementFluentWaitVisibility(registrationButton).click();
        elementFluentWaitVisibility(catalogExpand).click();
        AssertCollector.assertTrue(elementIsVisible(categoryList));
    }

    public void verifyStickingHeaderDuringScrolling() {
        scrollToNecessaryElement(footer);
        AssertCollector.assertTrue(elementIsVisible(smallLogo));
        AssertCollector.assertTrue(elementIsVisible(searchProductField));
        AssertCollector.assertTrue(elementIsVisible(categoryDropdown));
        AssertCollector.assertTrue(elementIsVisible(searchButton));
        textPresent("Корзина пока пуста");
        clickOnIndexFromElementList(hitSalesBasketButtons, 14);
        elementIsClickable(quantityOfProductsInBasket).click();
        AssertCollector.assertTrue(elementIsVisible(fullBasketDropdown));
    }

    public void verifyPhysicalAuthCredential() {
        String linkTextValue = getValueOfAttributeByName(myAccountLink, "href");
        elementFluentWaitVisibility(myAccountLink).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of ",
                linkTextValue);
    }

    public void verifyToolTypeText() {
        moveMouseTo(driver, companyLogo);
        String companyLogoValue = getValueOfAttributeByName(companyLogo, "title");
        AssertCollector.assertEquals("КДВ", " tooltip text is equal of ",
                companyLogoValue);
        moveMouseTo(driver, baseCityLink);
        String baseCityLinkValue = getValueOfAttributeByName(baseCityLink, "title");
        AssertCollector.assertEquals(getText(baseCityLink), " tooltip text is equal of ",
                baseCityLinkValue);
        moveMouseTo(driver, registrationButton);
        String registrationButtonValue = getValueOfAttributeByName(registrationButton, "title");
        AssertCollector.assertEquals(getText(registrationButton), " tooltip text is equal of ",
                registrationButtonValue);
        moveMouseTo(driver, enterButton);
        String enterButtonValue = getValueOfAttributeByName(enterButton, "title");
        AssertCollector.assertEquals(getText(enterButton), " tooltip text is equal of ",
                enterButtonValue);
    }

    public void verifySearchButton() {
        String actualTitle = "Поиск";
        String expectedTitle = searchButton.getAttribute("title");
        AssertCollector.assertEquals(actualTitle, " Current title is equal to title of ", expectedTitle);
        String enterButtonValue = getValueOfAttributeByName(searchProductField, "placeholder");
        AssertCollector.assertEqualsJ(enterButtonValue, "Введите название товара", "Placeholder values are equals");
    }

    public void placeholderCheckingInSearchField() {
        getUrl(BASE_URL);
        String actPlaceholder = "Введите название товара";
        String expPlaceholder = searchProductField.getAttribute("placeholder");
        AssertCollector.assertEquals(actPlaceholder, " Current placeholder is equal to placeholder of ", expPlaceholder);
        moveMouseTo(driver, searchProductField);
        elementIsClickable(searchProductField).click();
        fillInputField(searchProductField, "вафли");
        String textFromPlaceholder = searchProductField.getAttribute("value");
        AssertCollector.assertEquals(textFromPlaceholder, " Current  text from placeholder is equal to ", textFromPlaceholder);
    }

    public void verificationOfCategoriesDropdownInSearchField() {
        elementIsClickable(categoriesHeader).click();
        String expCategoryFromList = getText(categoryFromList);
        elementIsClickable(categoryFromList).click();
        String actCategoryFromList = getText(categoriesHeader);
        AssertCollector.assertEquals(actCategoryFromList, " Current name of category is equal to ", expCategoryFromList);
    }

    public void verifyLatinTextInProductInputField() {
        fillInputFieldAndPressEnterButton(searchProductField, "biscuit");
        textPresent("По вашему запросу ничего не найдено.");
        verifySpecialSymbolsInProductInputField();
        verifyNumbersInProductInputField();
        verifyLongStringsWithNumbersInProductInputField();
    }

    public void verifySpecialSymbolsInProductInputField() {
        String expSymbols = "~`!@#$%^dfddgdfg&*()_+?:'dfvdfg{}[];";
        fillInputFieldAndPressEnterButton(searchProductField, expSymbols);
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(expSymbols));
    }

    public void verifyNumbersInProductInputField() {
        String expNumbers = "564654";
        fillInputFieldAndPressEnterButton(searchProductField, expNumbers);
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(expNumbers));
    }

    public void verifyLongStringsWithNumbersInProductInputField() {
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(255));
        String textFromInputField = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(256));
        String textFromInputField1 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField1));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(257));
        String textFromInputField2 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField2));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(1000));
        String textFromInputField3 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField3));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(1024));
        String textFromInputField4 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField4));
    }

    public void verifySearchQueryWithInputTextWithCategory() {
        fillInputField(searchProductField, "суфле");
        try {
            if (elementIsVisible(geoConfirmModalWindow)) {
                elementIsClickable(acceptGeoConfirm).click();
            }
        } catch (NoSuchElementException ex) {
            ex.getMessage();
        }
        elementIsClickable(categoriesHeader).click();
        String expResult = anotherCategoryFromList.getText();
        elementIsClickable(anotherCategoryFromList).click();
        elementIsClickable(searchButton).click();
        String actResult = filterValue.getText();
        String title = driver.getTitle();
        AssertCollector.assertTrue(title.contains("суфле"));
        AssertCollector.assertEquals(actResult, " Names of categories are equal ", expResult);
    }
}
