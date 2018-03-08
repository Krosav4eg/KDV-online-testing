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

/**
 * @author Sergey Potapov
 */
public class HeaderTest extends BaseTest {

    @Test
    public void verifyLogoTest() {
        TestReporter.testTitle("Test ID - C34282");
        mainPageSelector.checkCompanyLogo();
    }

    //TODO fix it too long
    // @Test(timeOut = 60000)
    public void verifyChangingCityTest() {
        TestReporter.testTitle("Test ID - C34287");//C34287 - в этом кейсе объеденены C34283, C34285, C34316
        mainPageSelector.changeCity();
        mainPageSelector.changeCityToOther();
        mainPageSelector.changeCityToCurrent();
    }

    @Test
    public void verifyOpeningRegistrationTest() {//C34288 - в этом кейсе объеденены C34289, C34290
        TestReporter.testTitle("Test ID - C34288");
        mainPageSelector.openingRegistrationLink();
        TestReporter.testTitle("Test ID - C34289");
        mainPageSelector.openingEnterLink();
        TestReporter.testTitle("Test ID - C34290");
        mainPageSelector.verifyingAnswerYourQuestionsTelNumber();
    }

    @Test
    public void verifyMyCardIsEmptyTest() {
        TestReporter.testTitle("Test ID - C34292");
        mainPageSelector.verifyMyCardIsEmpty();
    }

    //TODO it`s failed can`t  find other element , some element isn`t visible
    @Test
    public void verifyMyBasketWithProductTest() {
        TestReporter.testTitle("Test ID - C34292");//C34292 - в этом кейсе объеденены C34293, C34299, C34296, C34297
        mainPageSelector.verifyMyBasketWithProduct();
    }

    @Test
    public void verifyOpeningCatalogAfterLeftMainPageTest() {
        TestReporter.testTitle("Test ID = 34308");
        mainPageSelector.openingCatalogAfterLeftMainPage();
    }

    @Test
    public void verifyAuthAsPhysicalPersonTest() {
        TestReporter.testTitle("Test ID = 34309-34310");
        JSONObject data = new JSONObject();
        data.put("email", PHYSICAL_PERSON_EMAIL);
        data.put("password", PHYSICAL_PERSON_PASSWORD);
        authorizationPage.verifyAuthFields(data);
        mainPageSelector.verifyPhysicalAuthCredential();
    }

    //TODO appear additional slash after base url
    @Test
    public void verifyPersonalCabinetLinkTest() {
        TestReporter.testTitle("Test ID = 34312");
        JSONObject data = authorizationPage.mainAuthorizationInfo();
        data.put("email", "test_n.moiseeva@magdv.com");
        data.put("password", "bu5ttq");
        authorizationPage.verifyAuthFields(data);

        mainPageSelector.cabinetLink();
    }

    @Test
    public void verifyStickingHeaderDuringScrollingTest() {
        TestReporter.testTitle("Test ID = 34317");
        mainPageSelector.verifyStickingHeaderDuringScrolling();
    }

    @Test
    public void verifyToolTypeTextTest() {
        TestReporter.testTitle("Test ID = 34346");
        mainPageSelector.verifyToolTypeText();
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
        mainPageSelector.verifySearchButton();
        mainPageSelector.placeholderCheckingInSearchField();
        mainPageSelector.verificationOfCategoriesDropdownInSearchField();
    }

    @Test
    public void verifyLatinTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34377,34382-34384");
        mainPageSelector.verifyLatinTextInProductInputField();
    }

    @Test
    public void verifySearchQueryWithInputTextWithoutCategoryTest() {
        TestReporter.testTitle("Test ID = 37066");
        TestReporter.testTitle("Test ID = 37067");
        mainPageSelector.verifySearchQueryWithInputTextWithCategory();
    }

}

