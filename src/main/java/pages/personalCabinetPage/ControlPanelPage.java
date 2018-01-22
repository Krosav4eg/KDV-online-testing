package pages.personalCabinetPage;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sergey Potapov
 */

public class ControlPanelPage extends BasePage {
    public ControlPanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[2]/div/p[1]")
    public WebElement nameInPersonalData;

    @FindBy(xpath = "//div/p[2]")
    public WebElement emailInPersonalData;

    @FindBy(xpath = "//div/p[3]")
    public WebElement phoneInPersonalData;
}
