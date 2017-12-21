package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import static utils.Constants.AUTORIZATION_PAGE_URL;
import static utils.Constants.PHYSICAL_PERSON_EMAIL;
import static utils.Constants.PHYSICAL_PERSON_PASSWORD;
import static utils.WaitingUtility.elementFluentWaitVisibility;

/**
 * @author Sergey Potapov
 */
public class AuthorizationPage extends BasePage {
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    //========================AUTHORIZATION PAGE=============================================
    @FindBy(css = "#email")
    private WebElement emailInputField;

    @FindBy(css = "#pass")
    private WebElement passwordField;

    @FindBy(css = "#send2")
    private WebElement authorizationButton;

    public void authAsPhysicalPerson() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, driver, PHYSICAL_PERSON_EMAIL);
        fillInputField(passwordField, driver, PHYSICAL_PERSON_PASSWORD);
        elementFluentWaitVisibility(authorizationButton, driver).click();
        AssertCollector.assertTrue(getCurrentUrl().contains("http://kemerovo.demo.dev.magonline.ru/customer/account/"));
    }
}
