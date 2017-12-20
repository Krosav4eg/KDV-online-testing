package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.WaitingUtility.elementFluentWaitVisibility;

/**
 * @author Sergey Potapov
 */
public class CustomerAccountPage extends BasePage {

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }

    protected MainPage mainPage;

    //========================Customer Account Page=============================================
    @FindBy(css = ".//a[@title='Выйти']")
    private WebElement exitFromAccountButton;

    public void pressExitFromAccountButton() {
        elementFluentWaitVisibility(exitFromAccountButton, driver).click();
    }
}
