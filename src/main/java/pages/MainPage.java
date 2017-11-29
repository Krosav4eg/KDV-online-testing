package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sergey Potapov
 */

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //========================MAIN PAGE=============================================

    @FindBy(xpath = "//*[@title='Вход']")
    private WebElement enterButton;

    @FindBy(xpath = "(//div[@class='modal__close'])[2]")
    private WebElement closePopupButton;

    //========================

    public void authorization() {
        getUrl();
        closePopupButton.click();
        enterButton.click();
    }

}
