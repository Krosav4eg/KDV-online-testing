package testcases.MainPage;

import org.testng.annotations.Test;
import testcases.base.BaseTest;

/**
 * Created by Avic on 4/12/17.
 */
public class MainPageTest extends BaseTest {
    @Test
    public void verifyLowerPriceTest() {
        mainPage.verifyingOpeningLowerPricesSection();
    }

    @Test
    public void verifyClosingLowerPriceTest() {
        mainPage.verifyingClosingLowerPricesSection();
    }

    @Test
    public void verifyingAboutLinkLowerPrice() {
        mainPage.verifyingAboutLinkLowerPriceSection();
    }
}
