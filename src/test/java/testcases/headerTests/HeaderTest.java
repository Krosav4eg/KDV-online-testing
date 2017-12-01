package testcases.headerTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testcases.base.BaseTest;

/**
 * @author Sergey Potapov
 */
public class HeaderTest extends BaseTest {

    @BeforeClass
    public void beforeGeneralTests() {
        mainPage.openMainPage();
    }

    @Test
    public void verifyLogoTest() {
        mainPage.checkCompanyLogo();
    }

    @Test
    public void closingModalWindowTest() {
        mainPage.closingModalWindow();
    }
}

