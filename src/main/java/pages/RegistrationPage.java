package pages;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import java.util.Objects;

import static utils.Constants.REGISTRATION_PAGE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@rel='general']")
    private WebElement individualButton;

    @FindBy(xpath = "//a[@rel='legal']")
    private WebElement organizationButton;

    public void verifyLegalFormByDefault() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(individualButton.isEnabled());
    }

    public void verifyChoosingLegalForm() {
        getUrl(REGISTRATION_PAGE_URL);
        String linkTextAttribute = getValueOfAttributeByName(organizationButton, "href");
        elementFluentWaitVisibility(organizationButton, driver).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal to url with selected organization ",
                linkTextAttribute);
    }
}
