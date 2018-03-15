package KDV_business_logic.pages.MainPage;

import Core.basePage.BasePage;
import Core.logger.MagDvLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.utils.Constants.*;

/**
 * @author Sergey Potapov
 */
public class MainPage extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".geo.j_geo")
    private WebElement selectCityModalWindow;

    @FindBy(xpath = "//div[text()='Томск']")
    private WebElement selectCityTomsk;

    @FindBy(css = ".geo-confirm__city")
    private WebElement geoConfirmModalWindow;

    @FindBy(xpath = "//button[text()='Да']")
    private WebElement acceptGeoConfirm;

    @FindBy(css = ".top-link-myaccount")
    public WebElement myAccountLink;

    @FindBy(css = ".menu-categories__item")
    private WebElement parentItemOfProducts;

    @FindBy(id = "footer")
    public WebElement footer;

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

    public void moveToCategory() {
        LOGGER.log(Level.INFO, "Move to category");
        TestReporter.step("Move to category");
        moveMouseTo(driver, parentItemOfProducts);
        AssertCollector.assertTrue(getValueOfAttributeByName(parentItemOfProducts, "class").
                contains("menu-categories__item"));
    }
}

