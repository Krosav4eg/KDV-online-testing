package KDV_business_logic.pages.MainPage;

import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Core.utils.Constants.SECOND_TAB_BROWSER;
import static Core.utils.Constants.TWO_TABS_BROWSER;

public class BlockSmm extends BasePage {

    public BlockSmm(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".social__link.social__link_vk")
    private WebElement vkLink;

    @FindBy(css = ".social__link.social__link_instagram")
    private WebElement instaLink;

    @FindBy(css = ".social__link.social__link_android")
    private WebElement googlePlayLink;

    @FindBy(css = ".social")
    private WebElement socialLinkSection;

    public void openingVkLink() {
        scrollToNecessaryElement(socialLinkSection);
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
        scrollToNecessaryElement(socialLinkSection);
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
        scrollToNecessaryElement(socialLinkSection);
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
}
