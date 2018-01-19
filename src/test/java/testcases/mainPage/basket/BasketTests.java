package testcases.mainPage.basket;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

public class BasketTests  extends BaseTest {

	@Test
	public void verifyBasketTest() {
		TestReporter.testTitle("Test ID - C40361");
		basketPage.verifyBasket();
	}
}
