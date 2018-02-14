package testcases.header;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.AssertCollector;
import utils.TestReporter;

import static utils.Constants.BASE_URL;
import static utils.Constants.PHYSICAL_PERSON_EMAIL;
import static utils.Constants.PHYSICAL_PERSON_PASSWORD;
import static utils.WaitingUtility.elementIsVisible;

/**
 * @author Sergey Potapov
 */
public class HeaderTest extends BaseTest {

    private BasePage.MyDelegate del = new BasePage.MyDelegate() {
    };

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

    //TODO fix it too long
    // @Test(timeOut = 60000)
    public void verifyChangingCityTest() {
        TestReporter.testTitle("Test ID - C34287");//C34287 - в этом кейсе объеденены C34283, C34285, C34316
        mainPage.changeCity();
        mainPage.changeCityToOther();
        mainPage.changeCityToCurrent();
    }

    @Test
    public void verifyOpeningRegistrationTest() {//C34288 - в этом кейсе объеденены C34289, C34290
        TestReporter.testTitle("Test ID - C34288");
        mainPage.openingRegistrationLink();
        TestReporter.testTitle("Test ID - C34289");
        mainPage.openingEnterLink();
        TestReporter.testTitle("Test ID - C34290");
        mainPage.verifyingAnswerYourQuestionsTelNumber();
    }

    @Test
    public void verifyMyCardIsEmptyTest() {
        TestReporter.testTitle("Test ID - C34292");
        mainPage.verifyMyCardIsEmpty();
    }

    //TODO it`s failed can`t  find other element , some element isn`t visible
    @Test
    public void verifyMyBasketWithProductTest() {
        TestReporter.testTitle("Test ID - C34292");//C34292 - в этом кейсе объеденены C34293, C34299, C34296, C34297
        mainPage.verifyMyBasketWithProduct();
    }

    @Test()
    public void verifyProductsInBasketTest() {
        TestReporter.testTitle("Test ID = 34299");
        mainPage.checkingProductsInBasket();
//TODO not fix in progress
//    @Test//(timeOut = 30000)
//    public void verifyOpeningBasketPageFromHeaderTest() {
        TestReporter.testTitle("Test ID = 34296");
        mainPage.openingBasketPageFromHeader();
    }

    @Test
    public void verifyOpeningCatalogAfterLeftMainPageTest() {
        TestReporter.testTitle("Test ID = 34308");
        mainPage.openingCatalogAfterLeftMainPage();
    }

    @Test
    public void verifyAuthAsPhysicalPersonTest() {
        TestReporter.testTitle("Test ID = 34309-34310");
        JSONObject data = new JSONObject();
        data.put("email", PHYSICAL_PERSON_EMAIL);
        data.put("password", PHYSICAL_PERSON_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        mainPage.verifyPhysicalAuthCredential();
    }

    @Test
    public void verifyPersonalCabinetLinkTest() {
        TestReporter.testTitle("Test ID = 34312");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(BASE_URL);
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), BASE_URL, "Urls are equals");
        AssertCollector.assertEqualsJ(mainPage.myAccountLink.getText(),
                "ООО Аванс", "Organization name is correct");
        orderingGuestPage.clickOnWebElement(mainPage.myAccountLink);
        AssertCollector.assertEqualsJ(del.getCurrentUrlDelegate(), BASE_URL + "customer/account",
                "Urls are equals");
        orderingGuestPage.clickOnWebElement(authorizationPage.exitButton);
        AssertCollector.assertTrue(elementIsVisible(authorizationPage.registBtn,driver), "Registration button is appear");
        AssertCollector.assertTrue(elementIsVisible(authorizationPage.loginButton,driver), "Login button is appear");
    }

    @Test
    public void verifyStickingHeaderDuringScrollingTest() {
        TestReporter.testTitle("Test ID = 34317");
        mainPage.verifyStickingHeaderDuringScrolling();
    }

    @Test
    public void verifyToolTypeTextTest() {
        TestReporter.testTitle("Test ID = 34346");
        mainPage.verifyToolTypeText();
    }

    @Test
    public void verifyToolTypeTextInPhysicalPersonAccountTest() {
        TestReporter.testTitle("Test ID = 34347");
        JSONObject data = new JSONObject();
        data.put("email", PHYSICAL_PERSON_EMAIL);
        data.put("password", PHYSICAL_PERSON_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        customerAccountPage.verifyToolTypeTextInPhysicalPersonAccount();
    }

    @Test
    public void verifySearchButtonTest() {
        TestReporter.testTitle("Test ID = 34374-34376");
        mainPage.verifySearchButton();
        mainPage.placeholderCheckingInSearchField();
        mainPage.verificationOfCategoriesDropdownInSearchField();
    }

    @Test
    public void verifyLatinTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34377,34382-34384");
        mainPage.verifyLatinTextInProductInputField();
    }

    @Test
    public void verifySearchQueryWithInputTextWithoutCategoryTest() {
        TestReporter.testTitle("Test ID = 37066");
        TestReporter.testTitle("Test ID = 37067");
        mainPage.verifySearchQueryWithInputTextWithCategory();
    }
}

