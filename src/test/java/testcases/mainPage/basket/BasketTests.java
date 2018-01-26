package testcases.mainPage.basket;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;

public class BasketTests  extends BaseTest {

	@Test
	public void verifyBasketTest() {
		TestReporter.testTitle("Test ID - C40361");
		basketPage. verifyBasket();
	}

	@Test
	public void verifyAddProductToBasket() {
		TestReporter.testTitle("Test ID - C40543");
		basketPage. verifyAddProductToBasket();
	}
	@Test
	public void verifyDeleteProduct() {
		TestReporter.testTitle("Test ID - C40921");
		basketPage. verifyDeleteProduct();
	}

	@Test
	public void verifyDeleteAllProduct() {
		TestReporter.testTitle("Test ID - C40991");
		basketPage. verifyDeleteAllProduct();
	}
	@Test
	public void verifyProductAbsent() {
		TestReporter.testTitle("Test ID - C40992");
		basketPage.verifyProductAbsent();
	}
}
