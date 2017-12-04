package pages;

import basePage.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.BASE_URL;

/**
 * @author Sergey Potapov
 */
public class MainPage extends BasePage {
    protected static final Logger logger = LogManager.getLogger(MainPage.class);

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

    @FindBy(xpath = "//*[@class='benefit benefit_price j_benefit']")
    private WebElement lowerPriceSection;

    @FindBy(xpath = "//div[@class='benefit benefit_price j_benefit benefit_active']")
    private WebElement lowerPriceSectionOpen;

    @FindBy(xpath = "(//*[@href='/about'])[1]")
    private WebElement aboutPricesLink;

    public void openMainPage() {
        logger.info("Open starting URL");
        driver.get(BASE_URL);
        elementIsClickable(closePopupButton, driver).click();
    }

    public void checkCompanyLogo() {
        String urlActual = driver.getCurrentUrl();
        logger.info("Check logo company");
        elementIsClickable(companyLogo, driver).click();
        waitForPageLoad(driver);
        String urlExpected = driver.getCurrentUrl();
        AssertCollector.assertEquals(urlActual, " URL IS EQUAL ", urlExpected);
    }

    public void closingModalWindow() {
        logger.info("Check closing modal window");
        elementIsClickable(baseCityLink, driver).click();
        elementIsClickable(closePopupButton, driver).click();
        elementIsClickable(baseCityLink, driver).click();
        moveMouseToAndClick(driver, companyLogo);
        AssertCollector.assertFalse(modalContentWindow.isDisplayed());
    }

    public void changeCity() {
        logger.info("Check changing city");
        elementIsClickable(baseCityLink, driver).click();
        elementIsClickable(otherCityLink, driver).click();
        waitForPageLoad(driver);
        AssertCollector.assertEquals(getText(baseCityLink), " LINK IS EQUAL ", getText(baseCityLink));
    }

    public void verifyingOpeningLowerPricesSection() {
        logger.info("Verifying Opening Lower Prices Section");
        waitForPageLoad(driver);
        elementIsClickable(lowerPriceSection, driver).click();
        AssertCollector.assertTrue(lowerPriceSectionOpen.isDisplayed());
    }

    public void verifyingClosingLowerPricesSection() {
        logger.info("Verifying Closing Lower Prices Section");
        waitForPageLoad(driver);
        elementIsClickable(lowerPriceSection, driver).click();
        elementIsClickable(lowerPriceSectionOpen, driver).click();
        AssertCollector.assertTrue(lowerPriceSection.isDisplayed());
    }

    public void verifyingAboutLinkLowerPriceSection() {
        logger.info("Check logo company");
        getCurrentUrl();
        logger.info("Verifying Opening Lower Prices Section");
        waitForPageLoad(driver);
        elementIsClickable(lowerPriceSection, driver).click();
        elementIsClickable(aboutPricesLink, driver).click();
        waitForPageLoad(driver);
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " URL IS EQUAL ", getCurrentUrl());
    }
}
