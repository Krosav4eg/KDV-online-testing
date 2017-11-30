package regressionSuit;

import org.testng.annotations.Test;
import pages.MainPage;
import regressionSuit.base.BaseTest;

/**
 * Created by Avic on 29/11/17.
 */
public class SecondTest extends BaseTest {
    @Test
    public void authorizationTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.authorization();
    }
}
