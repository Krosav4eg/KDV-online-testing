package pages.BasketPages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.WaitingUtility.elementFluentWaitVisibility;


public class BasketPage extends BasePage {
	public BasketPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".j_cart_control_add")
	private WebElement productAddBtn;

	@FindBy(css = ".product-item")
	private WebElement productContainer;

	public  void verifyBasket()
	{
		moveMouseTo(driver,productContainer);
		elementFluentWaitVisibility(productAddBtn,driver).click();
	}
}
