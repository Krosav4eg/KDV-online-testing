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

public class BannerSection extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public BannerSection(WebDriver driver) {
        super(driver);
    }

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
}
