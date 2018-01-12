package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;
import utils.TestReporter;

import java.util.logging.Level;

import static utils.Constants.REGISTRATION_PAGE_URL;
import static utils.WaitingUtility.CallJS;
import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.elementIsClickable;

public class CategoryPage 	extends BasePage
	{
    public CategoryPage(WebDriver driver) {
		super(driver);
	}

		//========================Categor PAGE=============================================
		@FindBy(css = "[alt='Конфеты']")
		private WebElement candyLink;

		@FindBy(css = ".breadcrumbs")
		private WebElement breadcrumbsTxt;

		@FindBy(css = "h1.title")
		private WebElement headerTxt;

		@FindBy(css = " [title='Список']")
		private WebElement listBtn;

		@FindBy(css = "[title='Сетка']")
		private WebElement gridBtn;

		@FindBy(css = "div.columns-layout__aside > div > div:nth-child(1)")
		private WebElement statusTxt;

		@FindBy(css = "div.columns-layout__aside > div > div:nth-child(1) a")
		private WebElement existBtn;

		@FindBy(css = ".filter__group_active")
		private WebElement activeFilter;

		@FindBy(css = "[title='Удалить позицию']")
		private WebElement deletePositionBtn;

		@FindBy(css = ".filter__group_active a.link")
		private WebElement deletePositionLink;

		@FindBy(css = ".columns-layout__aside")
		private WebElement leftSideNavigateTxt;

		@FindBy(css = ".toolbar-sort a.toolbar-select__direction")
		private WebElement sortBtn;

		@FindBy(css = ".toolbar-select__list a:nth-child(3)")
		private WebElement sortPriceLink;
		@FindBy(css = ".toolbar-select__list a:nth-child(2)")
		private WebElement sortDeafultLink;
		@FindBy(css = "div.yt-products-container.clearfix > div > div:nth-child(1)")
		private WebElement categoryElementTxt;
		@FindBy(css = ".toolbar-select__value")
		private WebElement dropDownMenu;
		@FindBy(css = "div.yt-products-container.clearfix > div > div:nth-child(1) .product-total-price")
		private WebElement priceTxt;
		//
		//
		//
		private void  selectCategory()
		{

			driver.navigate().refresh();
			clickElementByJS(driver, candyLink);
		}

		public void breadCrumbs() {
			selectCategory();
			AssertCollector.assertTrue(breadcrumbsTxt.getText().contains("Конфеты"),"required bread Crumbs  is present");
			}


		public void header() {
			selectCategory();
			AssertCollector.assertTrue(headerTxt.getText().contains("Конфеты"),"required header  is present");
		}
		//TODO del before commit document.querySelector("[alt='Конфеты']").click()
		public void commodityGridList(String navigate) {
			selectCategory();
			if(navigate.contains("List"))
				{
					elementFluentWaitVisibility(listBtn,driver).click();
					AssertCollector.assertTrue(listBtn.getAttribute("class").contains("list-mode__item_active"),"required list  is active");
					AssertCollector.assertTrue(listBtn.getCssValue("color").contains("rgba(255, 27, 65, 1)"),"required list color is present");
				}
				else
				{
					elementFluentWaitVisibility(gridBtn,driver).click();
					AssertCollector.assertTrue(gridBtn.getAttribute("class").contains("list-mode__item_active"),"required grid  is active");
					AssertCollector.assertTrue(gridBtn.getCssValue("color").contains("rgba(255, 27, 65, 1)"),"required grid color is present");
				}
		}

		public void statusBlock()
		{
			selectCategory();
			AssertCollector.assertTrue(getText(statusTxt).contains("Статус"),"required status  is present");
			AssertCollector.assertTrue(getText(statusTxt).contains("в наличии"),"required text  is present");
			int number= Integer.parseInt(getText(statusTxt).replaceAll("[^0-9]", ""));
			AssertCollector.assertTrue(number>0,"required number  is present");
		}

		public void CheckBox(String testCase) {
			selectCategory();
			elementFluentWaitVisibility(existBtn, driver).click();
			AssertCollector.assertTrue(getText(activeFilter).contains("Выбранные параметры"), "text 'Выбранные параметры' is present");
			AssertCollector.assertTrue(getText(activeFilter).contains("Статус"), "text 'Статус' is present");
			AssertCollector.assertTrue(getText(activeFilter).contains("в наличии"), "text 'В наличии' is present");
			AssertCollector.assertTrue(deletePositionBtn.isDisplayed(), "checkbox delete is present");
			switch (testCase) {
				case "Is Present": {
					AssertCollector.assertTrue(existBtn.isDisplayed(), "checkbox is present");
					break;
				}
				case "Is Active": {
					AssertCollector.assertTrue(getText(leftSideNavigateTxt).contains("Выбранные параметры"), "all condition deleted");
					break;
				}
				case "DeleteBtn All": {
					elementFluentWaitVisibility(deletePositionBtn, driver).click();
					break;
				}
				case "Delete All": {
					elementFluentWaitVisibility(deletePositionLink, driver).click();
				}
				AssertCollector.assertTrue(!getText(leftSideNavigateTxt).contains("Выбранные параметры"), "all condition deleted");
			}
		}
		public void sortFilter(String testCase) {
			selectCategory();
			moveMouseTo(driver,dropDownMenu);
			switch (testCase)
			{
				case "Asc":
				{

					String firstElement=getText(categoryElementTxt);
					elementFluentWaitVisibility(sortDeafultLink,driver).click();
					AssertCollector.assertTrue(firstElement.contains(getText(categoryElementTxt)),"price filter is active");
					break;
				}
				case "Deasc":
				{
					elementFluentWaitVisibility(sortDeafultLink,driver).click();
					String firstElement=getText(categoryElementTxt);
					elementFluentWaitVisibility(sortBtn,driver).click();
					AssertCollector.assertTrue(!firstElement.contains(getText(categoryElementTxt)),"price filter is active");
					break;
				}
				case "Price Deasc":
				{
					Double firstValue= Double.valueOf(getText(priceTxt).replaceAll("[^0-9]",""));
					elementFluentWaitVisibility(sortPriceLink,driver).click();
					elementFluentWaitVisibility(sortBtn,driver).click();
					System.out.println(getText(categoryElementTxt));
					Double lastValue= Double.valueOf(getText(priceTxt).replaceAll("[^0-9]",""));
					AssertCollector.assertTrue(lastValue>firstValue,"Asc filter is active");
					break;
				}
				case "Price Asc":
				{
					Double firstValue= Double.valueOf(getText(priceTxt).replaceAll("[^0-9]",""));
					elementFluentWaitVisibility(sortPriceLink,driver).click();
					System.out.println(getText(categoryElementTxt));
					Double lastValue= Double.valueOf(getText(priceTxt).replaceAll("[^0-9]",""));
					AssertCollector.assertTrue(lastValue<firstValue,"Asc filter is active");	break;
				}
		}
		}
	}
