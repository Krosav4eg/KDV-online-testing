package regressionSuit;

import org.testng.annotations.Test;
import pages.MainPage;
import regressionSuit.base.BaseTest;

/**
 * @author Sergey Potapov
 */

public class FirstTest extends BaseTest {
    @Test
    public void authorizationTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.authorization();
    }
}
