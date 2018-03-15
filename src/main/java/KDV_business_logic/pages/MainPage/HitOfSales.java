package KDV_business_logic.pages.MainPage;

import Core.basePage.BasePage;
import Core.logger.MagDvLogger;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.utils.Constants.BASE_URL;
import static org.testng.Assert.fail;

public class HitOfSales extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public HitOfSales(WebDriver driver) {
        super(driver);
    }

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
}
