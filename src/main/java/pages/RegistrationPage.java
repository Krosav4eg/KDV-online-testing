package pages;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

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

    @FindBy(xpath = ".//*[@id='firstname']")
    private WebElement firstName;

    @FindBy(css = ".layout__content")
    private WebElement layout;

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

    public void verifyForOrganizationsTextPresence() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(organizationButton, driver).click();
        textPresent("Внимание! Все заявки на регистрацию контрагентов - индивидуальных предпринимателей и " +
                "юридических лиц рассматриваются специалистами отдела продаж. Это может занять некоторое время. " +
                "До тех пор, пока контрагент не зарегистрирован, оформление заказов невозможно. Как правило, " +
                "рассмотрение заявки занимает не более одного рабочего дня.");
    }

    public void verifyFieldFirstNamePresence() {
        getUrl(REGISTRATION_PAGE_URL);
        AssertCollector.assertTrue(firstName.isDisplayed());
    }

    public void verifyInputInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        elementFluentWaitVisibility(firstName, driver).click();
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(46));
        elementFluentWaitVisibility(layout, driver).click();
        String text = firstName.getAttribute("value");
        AssertCollector.assertEquals(text, " Current text is equal to ", text);
    }

    //test not pass(validation problems)
    public void verifyMaximumInputInFirstNameField() {
        getUrl(REGISTRATION_PAGE_URL);
        fillInputField(firstName, driver, RandomStringUtils.randomAlphabetic(46));
        AssertCollector.assertEquals(firstName.getAttribute("value").length(), " Number of symbols is equal ",
                RandomStringUtils.randomAlphabetic(45).length());
    }
}
