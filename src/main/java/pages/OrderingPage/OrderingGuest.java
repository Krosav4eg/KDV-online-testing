package pages.OrderingPage;

import basePage.BasePage;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasketPages.BasketPage;

import static utils.WaitingUtility.elementFluentWaitVisibility;

public class OrderingGuest extends BasePage {

	public OrderingGuest(WebDriver driver) {
		super(driver);
	}

//
	@FindBy(css = ".j_cart_checkout")
	private WebElement orderBtn;

	@FindBy(id = "billing:firstname")
	private WebElement firstNameTxt;

	@FindBy(id = "billing:lastname")
	private WebElement lastNameTxt;

	@FindBy(id = "billing:email")
	private WebElement emailTxt;

	@FindBy(id = "billing:telephone")
	private WebElement phoneTxt;

	@FindBy(id = "label[for='billing:is_agree']")
	private WebElement agreementBtn;
	//

	public JSONObject data()
	{
		JSONObject data= new JSONObject();
		data.put("firstName","ТЕСТ");
		data.put("lastName","ТЕСТОВИЧ");
		data.put("email", RandomStringUtils.randomAlphabetic(15)+"@test.com");
		data.put("phone",RandomStringUtils.randomNumeric(10));
		return data;
	}
	public void createOrder(JSONObject data)
	{
		new BasketPage(driver).selectOneProduct();
		new BasketPage(driver).increaseProductCount();
		elementFluentWaitVisibility(orderBtn,driver).click();
		identificationBlock(data);
		authorizationBlock(data);
		elementFluentWaitVisibility(agreementBtn,driver).click();
	}

	private void identificationBlock(JSONObject data)
	{
		elementFluentWaitVisibility(firstNameTxt,driver).sendKeys(data.getString("firstName"));
		elementFluentWaitVisibility(lastNameTxt,driver).sendKeys(data.getString("lastName"));
	}
	private void authorizationBlock(JSONObject data)
	{
		elementFluentWaitVisibility(emailTxt,driver).sendKeys(data.getString("email"));
		elementFluentWaitVisibility(phoneTxt,driver).sendKeys(data.getString("phone"));
	}
}
