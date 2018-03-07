package KDV_testcases.header;

import Core.basePage.BasePage;
import org.json.JSONObject;
import org.testng.annotations.Test;
import KDV_testcases.base.BaseTest;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;

import static Core.utils.Constants.BASE_URL;
import static Core.utils.Constants.PHYSICAL_PERSON_EMAIL;
import static Core.utils.Constants.PHYSICAL_PERSON_PASSWORD;
import static Core.utils.WaitingUtility.elementFluentWaitVisibility;
import static Core.utils.WaitingUtility.elementIsVisible;

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

    //TODO appear additional slash after base url
    @Test
    public void verifyPersonalCabinetLinkTest() {
        TestReporter.testTitle("Test ID = 34312");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);
        del.getUrlDelegate(BASE_URL);
        mainPage.cabinetLink();
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

    @Test
    public void verifyAdditionalPhoneNumbersTest() {
        TestReporter.testTitle("Test ID = 43017");
        del.textPresentDelegate("8 800 250 5555");
        del.textPresentDelegate("Служба поддержки");
        AssertCollector.assertEqualsJ(mainPage.firstPhoneLink.getAttribute("href"), "tel:8 800 250 5555",
                "references are equals");
        del.textPresentDelegate("+7 913 817-38-90");
        del.textPresentDelegate("По вопросам заказа в городе Томск");
        AssertCollector.assertEqualsJ(mainPage.secondPhoneLink.getAttribute("href"), "tel:+7 913 817-38-90",
                "references are equals");
    }
}

