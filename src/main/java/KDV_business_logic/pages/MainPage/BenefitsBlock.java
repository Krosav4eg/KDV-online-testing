package KDV_business_logic.pages.MainPage;

import Core.basePage.BasePage;
import Core.logger.MagDvLogger;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.utils.Constants.BASE_URL;

public class BenefitsBlock extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public BenefitsBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='benefit benefit_price j_benefit']")
    private WebElement lowerPriceSection;

    @FindBy(css = "[alt='КДВ']")
    private WebElement kdvImg;

    @FindBy(xpath = "(//*[@href='/about'])[2]")
    private WebElement aboutPricesLink;

    @FindBy(xpath = "//div[@class='benefit benefit_price j_benefit benefit_active']")
    private WebElement lowerPriceSectionOpen;

    @FindBy(css = ".benefit.benefit_delivery.j_benefit")
    private WebElement freeDeliveringSection;

    @FindBy(css = ".benefit.benefit_delivery.j_benefit.benefit_active")
    private WebElement freeDeliveringSectionOpen;

    @FindBy(xpath = "(//*[@href='/delivery'])[2]")
    private WebElement aboutFreeDeliveryLink;

    @FindBy(css = ".benefit.benefit_payment.j_benefit")
    private WebElement paymentUponReceivingSection;

    @FindBy(css = ".benefit.benefit_payment.j_benefit.benefit_active")
    private WebElement paymentUponReceivingSectionOpen;

    @FindBy(xpath = "//*[@class='benefit benefit_payment j_benefit benefit_active']//section//a")
    private WebElement aboutPaymentUponReceivingLink;

    @FindBy(xpath = "(//*[@class='benefit__header'])[1]")
    private WebElement lowerPriceSectionHeader;

    @FindBy(xpath = "(//*[@class='benefit__header'])[2]")
    private WebElement freeDeliveringSectionHeader;

    @FindBy(xpath = "(//*[@class='benefit__header'])[3]")
    private WebElement paymentUponReceivingHeader;

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

    public void verifyingOpeningLowerPricesSection() {
        LOGGER.log(Level.INFO, "Verifying opening lower prices section");
        TestReporter.step("Verifying opening lower prices section");
        elementIsClickable(lowerPriceSection).click();
        AssertCollector.assertTrue(lowerPriceSectionOpen.isDisplayed());
    }

    public void verifyingOpeningFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Verifying opening free delivering section");
        elementIsClickable(freeDeliveringSection).click();
        AssertCollector.assertTrue(elementIsVisible(freeDeliveringSectionOpen));
    }

    public void verifyingClosingFreeDeliveringSection() {
        LOGGER.log(Level.INFO, "Verifying closing free delivering section");
        TestReporter.step("Verifying closing free delivering section");
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
}
