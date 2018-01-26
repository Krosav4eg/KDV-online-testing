package pages.PersonalAreaPage.Individuals;

import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sergey Potapov
 */
public class MyBookingPage extends BasePage {
    public MyBookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[text()='Мои заказы']")
    public WebElement myBookingsItemButton;

}
