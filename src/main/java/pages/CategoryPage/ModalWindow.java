package pages.CategoryPage;

import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertCollector;

import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.elementIsClickable;

public class ModalWindow  extends BasePage {
	public ModalWindow(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".modal__box")
	private WebElement modalContainerWindow;
	@FindBy(css = ".product")
	private WebElement productContainer;

	@FindBy(css = ".product-item")
	private WebElement categoryContainer;

	@FindBy(css = ".cart-control__add-text")
	private WebElement addCartModalBtn;


	@FindBy(css = ".modal__content .cart-control__btn_inc")
	private WebElement cartControlModalIncBtn;

	@FindBy(css = ".modal__content .cart-control__btn_dec")
	private WebElement cartControlModalDecBtn;

	@FindBy(css = ".modal__close")
	private WebElement closeBtn;

	@FindBy(css = ".j_cart_control_input")
	private WebElement categoryInputTxt;

	@FindBy(css = ".product-item__image-preview")
	private WebElement openModalBtn;

	@FindBy(css = "[title='КДВ']")
	private WebElement logoBtn;


	private void openModal()
	{
		new CardPage(driver).searchAndSelect();
		sleepWait();
		moveMouseTo(driver,categoryContainer);
		clickElementByJS(driver,openModalBtn);
		sleepWait();
	}

	public void checkModalWindow()
	{
		openModal();
		AssertCollector.assertTrue(getText(productContainer).contains("Конфеты «Томские классические», 300 г"),"");
		AssertCollector.assertTrue(getText(productContainer).contains("Конфеты «Томские классические» – суфле в шоколаде – визитная карточка Томска, где история сладкого бренда началась 50 лет назад."));
		AssertCollector.assertTrue(getText(productContainer).contains("95,20"),"");
		AssertCollector.assertTrue(getText(productContainer).contains("\u20BD"),"Text is present");
		AssertCollector.assertTrue(addCartModalBtn.isDisplayed(),"element is visible");
		elementFluentWaitVisibility(addCartModalBtn,driver).click();
		sleepWait();
		AssertCollector.assertTrue(cartControlModalIncBtn.isDisplayed(),"element is visible");
		AssertCollector.assertTrue(cartControlModalDecBtn.isDisplayed(),"element is visible");
		clickElementByJS(driver,cartControlModalIncBtn);
		sleepWait();
		clickElementByJS(driver,cartControlModalDecBtn);
		elementIsClickable(closeBtn,driver).click();
		AssertCollector.assertFalse(modalContainerWindow.isDisplayed());
		moveMouseTo(driver,categoryContainer);
		clickElementByJS(driver,openModalBtn);
		sleepWait();
		clickElementByJS(driver,logoBtn);
		AssertCollector.assertFalse(modalContainerWindow.isDisplayed());
	}
	public  void addProductNotValidModalWindow()
	{
		openModal();
		AssertCollector.assertEquals(addText("-5"),"","15");
		AssertCollector.assertEquals(addText("123123"),"","9999");
		AssertCollector.assertEquals(addText("asdasdasd"),"","1");
		AssertCollector.assertEquals(addText("@!$^*&$#@*()"),"","1");
		elementFluentWaitVisibility(categoryInputTxt,driver).clear();
	}


	private String addText(String text) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(addCartModalBtn)).click();
	}
	catch (Exception ex)
	{
		System.out.println("Element Card not valid");
	}
		//elementFluentWaitVisibility(addCartModalBtn,driver).click();
		clickElementByJS(driver,categoryInputTxt);
		elementFluentWaitVisibility(categoryInputTxt,driver).sendKeys(text);
		sleepWait();
		return getValueOfAttributeByName(categoryInputTxt,"value");
	}
}
