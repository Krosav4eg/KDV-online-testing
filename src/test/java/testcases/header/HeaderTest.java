package testcases.header;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

/**
 * @author Sergey Potapov
 */
public class HeaderTest extends BaseTest {

    @Test
    public void verifyLogoTest() {
        TestReporter.testTitle("Test ID - C34282");
        mainPage.checkCompanyLogo();
    }

    @Test
    public void verifyClosingModalWindowTest() {
        TestReporter.testTitle("Test ID - C34287");
        mainPage.closingModalWindow();
    }

    @Test
    public void verifyChangingCityTest() {
        TestReporter.testTitle("Test ID - C34283");
        mainPage.changeCity();
    }

    @Test
    public void verifyChangingCityToOtherTest() throws InterruptedException {
        TestReporter.testTitle("Test ID - C34285");
        mainPage.changeCityToOther();
    }

    @Test
    public void verifyChangingCityToCurrentTest() {
        TestReporter.testTitle("Test ID - C34316");
        mainPage.changeCityToCurrent();
    }

    @Test
    public void verifyOpeningRegistrationTest() {
        TestReporter.testTitle("Test ID - C34288");
        mainPage.openingRegistrationLink();
    }

    @Test
    public void verifyOpeningEnterTest() {
        TestReporter.testTitle("Test ID - C34289");
        mainPage.openingEnterLink();
    }

    @Test
    public void verifyingAnswerYourQuestionsTelNumberTest() {
        TestReporter.testTitle("Test ID - C34290");
        mainPage.verifyingAnswerYourQuestionsTelNumber();
    }

    @Test
    public void verifyMyCardIsEmptyTest() {
        TestReporter.testTitle("Test ID - C34292");
        mainPage.verifyMyCardIsEmpty();
    }

    @Test
    public void verifyMyBasketWithProductTest() {
        TestReporter.testTitle("Test ID - 34293");
        mainPage.verifyMyBasketWithProduct();
    }

    @Test
    public void verifyProductsInBasketTest() {
        TestReporter.testTitle("Test ID = 34299");
        mainPage.checkingProductsInBasket();
    }

    @Test
    public void verifyOpeningBasketPageFromHeaderTest() {
        TestReporter.testTitle("Test ID = 34296");
        mainPage.openingBasketPageFromHeader();
    }

    @Test
    public void verifyOpeningBasketAndOrderingTest() {
        TestReporter.testTitle("Test ID = 34297");
        mainPage.openingBasketAndOrdering();
    }

    @Test
    public void verifyOpeningCatalogAfterLeftMainPageTest() {
        TestReporter.testTitle("Test ID = 34308");
        mainPage.openingCatalogAfterLeftMainPage();
    }

    @Test
    public void verifyAuthAsPhysicalPersonTest() {
        TestReporter.testTitle("Test ID = 34309");
        authorizationPage.authAsPhysicalPerson();
    }

    @Test
    public void verifyStickingHeaderDuringScrollingTest() {
        TestReporter.testTitle("Test ID = 34317");
        mainPage.verifyStickingHeaderDuringScrolling();
    }
}

