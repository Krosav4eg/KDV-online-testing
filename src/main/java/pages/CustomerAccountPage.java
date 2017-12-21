package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

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

    @FindBy(xpath = "(//a[@title='КДВ'])[1]")
    private WebElement companyLogo;

    @FindBy(css = ".search-button__btn")
    private WebElement searchButton;

    @FindBy(css = ".quicklink__item.quicklink__item_geo.j_geo_control.j_geo_control_modal")
    private WebElement baseCityLink;

    @FindBy(xpath = "//*[@title='Выйти']")
    private WebElement exitButton;

    @FindBy(css = ".top-link-myaccount")
    private WebElement myAccountLink;


    public void verifyToolTypeTextInPhysicalPersonAccount() {
        moveMouseTo(driver, baseCityLink);
        String baseCityLinkValue = getValueOfAttributeByName(baseCityLink, "title");
        AssertCollector.assertEquals(getText(baseCityLink), " tooltip text is equal of ",
                baseCityLinkValue);
        moveMouseTo(driver, searchButton);
        String registrationButtonValue = getValueOfAttributeByName(searchButton, "title");
        AssertCollector.assertEquals(getText(searchButton), " tooltip text is equal of ",
                registrationButtonValue);
        moveMouseTo(driver, exitButton);
        String enterButtonValue = getValueOfAttributeByName(exitButton, "title");
        AssertCollector.assertEquals(getText(exitButton), " tooltip text is equal of ",
                enterButtonValue);
        moveMouseTo(driver, companyLogo);
        String companyLogoValue = getValueOfAttributeByName(companyLogo, "title");
        AssertCollector.assertEquals("КДВ", " tooltip text is equal of ",
                companyLogoValue);
        String myAccountLinkValue = getValueOfAttributeByName(myAccountLink, "title");
        AssertCollector.assertEquals(getText(myAccountLink), " tooltip text is equal of ",
                myAccountLinkValue);
    }
}
