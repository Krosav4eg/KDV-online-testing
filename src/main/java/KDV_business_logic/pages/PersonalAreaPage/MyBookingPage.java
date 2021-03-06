package KDV_business_logic.pages.PersonalAreaPage;

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

    public void selectItem() {
        elementFluentWaitClick(myBookingsItemButton);
    }
}
