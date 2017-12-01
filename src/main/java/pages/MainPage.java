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

    @FindBy(xpath = ".//div[@id='geo_modal']//*[@class='modal__overlay']")
    private WebElement background;

    @FindBy(xpath = "//*[@class='quicklink__item quicklink__item_geo j_geo_control j_geo_control_modal']")
    private WebElement cityLink;

    public void openMainPage() {
        logger.info("Open starting URL");
        driver.get(BASE_URL);
        closePopupButton.click();
    }

    public void checkCompanyLogo() {
        String urlActual = driver.getCurrentUrl();
        logger.info("Check logo company");
        companyLogo.click();
        waitForPageLoad(driver);
        String urlExpected = driver.getCurrentUrl();
        AssertCollector.assertEquals(urlActual, urlExpected);
    }

    public void closingModalWindow() {
        logger.info("Check closing modal window");
        cityLink.click();
        closePopupButton.click();
        cityLink.click();
        moveMouseToAndClick(driver, companyLogo);
        AssertCollector.assertFalse(modalContentWindow.isDisplayed());
    }
}
