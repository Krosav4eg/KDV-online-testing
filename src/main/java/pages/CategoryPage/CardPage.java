package pages.CategoryPage;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.AssertCollector;

import static utils.Constants.BASE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;

public class CardPage extends BasePage {
	public CardPage(WebDriver driver) {
		super(driver);
	}
	//========================CARD PAGE=============================================
	@FindBy(id = "search")
	private WebElement searchField;

	@FindBy(css = "[title='Поиск']")
	private WebElement searchBtn;

	@FindBy(css = "#select-search-wrapper div")
	private WebElement selectCategorySearchBtn;

	@FindBy(css = ".product-item")
	private WebElement categoryContainer;

	@FindBy(css = ".cart-control__add")
	private WebElement categoryAddBtn;

	@FindBy(css = "[href='/about']")
	private WebElement aboutLink;

	@FindBy(css = ".j_cart_control_input")
	private WebElement categoryInputTxt;

	@FindBy(css = ".j_cart_control_dec")
	private WebElement categoryDecBtn;

	@FindBy(css = ".event-menu")
	private WebElement mainTxt;



	public void searchAndSelect()
	{
		driver.navigate().refresh();
		driver.navigate().to(BASE_URL+"/konfety.html");
		elementFluentWaitVisibility(selectCategorySearchBtn,driver).click();
		CallJS("jQuery(\"#inputs-search-table div.search-category-dropdown__list div:contains('Конфеты')\").click()",driver);
		elementFluentWaitVisibility(searchField,driver).sendKeys("Томские классические");
		elementFluentWaitVisibility(searchBtn,driver).click();
		moveMouseTo(driver,aboutLink);
	}

	public void verifyFieldsCard()
	{
		searchAndSelect();
		AssertCollector.assertTrue(getText(categoryContainer).contains("Конфеты «Томские классические», 300 г"),"Text is present");
		AssertCollector.assertTrue(getText(categoryContainer).contains("95,20"),"Text is present");
		AssertCollector.assertTrue(getText(categoryContainer).contains("\u20BD"),"Text is present");
		AssertCollector.assertTrue(categoryAddBtn.isDisplayed(),"element is visible");

	}
	public void addProductFromCard()
	{
		searchAndSelect();
		clickElementByJS(driver,categoryAddBtn);
		driver.navigate().refresh();
		AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt,"value").contains("1"),"");
		elementFluentWaitVisibility(categoryDecBtn,driver).click();
		driver.navigate().refresh();
		AssertCollector.assertTrue(categoryAddBtn.isDisplayed());
	}
	public void addProductNotValidFromCard()
	{
		searchAndSelect();
		moveMouseTo(driver,aboutLink);
		elementFluentWaitVisibility(categoryAddBtn,driver).click();
		driver.navigate().refresh();
		AssertCollector.assertEquals(getValueOfAttributeByName(categoryInputTxt,"value"),"",1);
		addTxtToInput("-5");
		System.out.println(getValueOfAttributeByName(categoryInputTxt,"value"));
		AssertCollector.assertEquals(getValueOfAttributeByName(categoryInputTxt,"value"),"",51);
		addTxtToInput("99999");
		System.out.println(getValueOfAttributeByName(categoryInputTxt,"value"));
		AssertCollector.assertEquals(getValueOfAttributeByName(categoryInputTxt,"value"),"",51);
		addTxtToInput("@!$^*&$#@*()");
		AssertCollector.assertEquals(getValueOfAttributeByName(categoryInputTxt,"value"),"",51);

	}
	private void addTxtToInput(String txt)
	{
		elementFluentWaitVisibility(categoryInputTxt,driver).click();
		elementFluentWaitVisibility(categoryInputTxt,driver).clear();
		elementFluentWaitVisibility(categoryAddBtn,driver).click();
		elementFluentWaitVisibility(categoryInputTxt,driver).sendKeys(txt);
		moveMouseToAndClick(driver,mainTxt,0,0);
		sleepWait();
		driver.navigate().refresh();
	}

}
