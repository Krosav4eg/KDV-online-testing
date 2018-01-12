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
		TestReporter.testTitle("Test ID - C39080");
		categoryPage.header();
		
	}
	@Test
	public void verifyCommodityGrid() {
		TestReporter.testTitle("Test ID - C39081");
		categoryPage.commodityGridList("Grid");

	}
	@Test
	public void verifyCommodityList() {
		TestReporter.testTitle("Test ID - C39082");
		categoryPage.commodityGridList("List");

	}
	@Test
	public void verifyStatusBlock() {
		TestReporter.testTitle("Test ID - C39083");
		categoryPage.statusBlock();
	}
	@Test
	public void verifyCheckBoxIsPresent() {
		TestReporter.testTitle("Test ID - C39086");
		categoryPage.CheckBox("Is Present");
	}
	@Test
	public void verifyBlockSelectedParameter() {
		TestReporter.testTitle("Test ID - C39088");
		categoryPage.CheckBox("Is Active");
	}
	@Test
	public void verifyDeletedBtnFromBlockSelectedParameter() {
		TestReporter.testTitle("Test ID - C39089");
		categoryPage.CheckBox("DeleteBtn All");
	}
	@Test
	public void verifyDeletedAllFromBlockSelectedParameter() {
		TestReporter.testTitle("Test ID - C39090");
		categoryPage.CheckBox("Delete All");
	}
	@Test
	public void verifySortDefaultAsc() {
		TestReporter.testTitle("Test ID - C39206");
		categoryPage.sortFilter("Asc");
	}
	@Test
	public void verifySortDefaultDesc() {
		TestReporter.testTitle("Test ID - C39215");
		categoryPage.sortFilter("Deasc");
	}
	@Test
	public void verifySortPriceDesc() {
		TestReporter.testTitle("Test ID - C39218");
		categoryPage.sortFilter("Price Deasc");
	}
	@Test
	public void verifySortPriceAsc() {
		TestReporter.testTitle("Test ID - C39220");
		categoryPage.sortFilter("Price Asc");
	}
	
}
