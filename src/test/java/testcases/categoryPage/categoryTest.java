package testcases.categoryPage;

import org.testng.annotations.Test;
import testcases.base.BaseTest;
import utils.TestReporter;


public class categoryTest extends BaseTest {

	

	@Test
	public void verifyBreadCrumbs() {
		TestReporter.testTitle("Test ID - C39078");
		categoryPage.breadCrumbs();
	}

	@Test
	public void verifyHeader() {
		TestReporter.testTitle("Test ID - C39075");
		categoryPage.selectFromCategoryDropDown();
		
	}
	@Test
	public void verifyCommodityGrid() {
		TestReporter.testTitle("Test ID - C39081");
		categoryPage.commodityGridList();

	}
	@Test
	public void verifyCheckBoxIsPresent() {
		TestReporter.testTitle("Test ID - C39083");
		categoryPage.CheckBox();
	}
	@Test
	public void verifySortDefault() {
		TestReporter.testTitle("Test ID - C39206");
		categoryPage.sortFilterDefault();
	}
	@Test
	public void verifySortPriceDesc() {
		TestReporter.testTitle("Test ID - C40223");
		categoryPage.sortFilterPrice();
	}

}
