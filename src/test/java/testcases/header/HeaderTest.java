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
    public void verifyPhysicalAuthCredentialTest() {
        TestReporter.testTitle("Test ID = 34310");
        authorizationPage.authAsPhysicalPerson();
        mainPage.verifyPhysicalAuthCredential();
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
        authorizationPage.authAsPhysicalPerson();
        customerAccountPage.verifyToolTypeTextInPhysicalPersonAccount();
    }

    @Test
    public void verifySearchButtonTest() {
        TestReporter.testTitle("Test ID = 34374");
        mainPage.verifySearchButton();
    }

    @Test
    public void placeholderCheckingInSearchFieldTest() {
        TestReporter.testTitle("Test ID = 34375");
        mainPage.placeholderCheckingInSearchField();
    }

    @Test
    public void verificationOfCategoriesDropdownInSearchFieldTest() {
        TestReporter.testTitle("Test ID = 34376");
        mainPage.verificationOfCategoriesDropdownInSearchField();
    }

    @Test
    public void verifyLatinTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34377");
        mainPage.verifyLatinTextInProductInputField();
    }

    @Test
    public void verifyCyrillicTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34378");
        mainPage.verifyCyrillicTextInProductInputField();
    }

    @Test
    public void verifyUpperCaseTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34379");
        mainPage.verifyUpperCaseTextInProductInputField();
    }

    @Test
    public void verifyLowerCaseTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34380");
        mainPage.verifyLowerCaseTextInProductInputField();
    }

    @Test
    public void verifyUpperAndLowerCaseTextInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34381");
        mainPage.verifyUpperAndLowerCaseTextInProductInputField();
    }

    @Test
    public void verifySpecialSymbolsInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34382");
        mainPage.verifySpecialSymbolsInProductInputField();
    }

    @Test
    public void verifyNumbersInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34383");
        mainPage.verifyNumbersInProductInputField();
    }

    @Test
    public void verifyLongStringsWithNumbersInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34384");
        mainPage.verifyLongStringsWithNumbersInProductInputField();
    }

    @Test
    public void verifySpacesInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34385");
        mainPage.verifySpacesInProductInputField();
    }

    @Test
    public void verifySpacesWithWordInProductInputFieldTest() {
        TestReporter.testTitle("Test ID = 34386");
        mainPage.verifySpacesWithWordInProductInputField();
    }

    @Test
    public void verifyEmptyFieldTest() {
        TestReporter.testTitle("Test ID = 34389");
        mainPage.verifyEmptyField();
    }

    @Test
    public void verifySearchQueryWithoutCategoryTest() {
        TestReporter.testTitle("Test ID = 37064");
        mainPage.verifySearchQueryWithoutCategory();
    }

    @Test
    public void verifySearchQueryWithCategoryTest() {
        TestReporter.testTitle("Test ID = 37065");
        mainPage.verifySearchQueryWithCategory();
    }
}

