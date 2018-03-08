package KDV_business_logic.pages.PersonalAreaPage;

import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Core.utils.AssertCollector;
/**
 * @author Sergey Potapov
 */
public class MyBookingPage extends BasePage {
    public MyBookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[text()='Мои заказы']")
    public WebElement myBookingsItemButton;

    public void selectOrderPage()
    {

    }
}
