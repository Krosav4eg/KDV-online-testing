package pages.OrderingPage;

import basePage.BasePage;
import com.google.common.base.Verify;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AssertCollector;

import static utils.Constants.AUTORIZATION_PAGE_URL;
import static utils.Constants.BASE_URL;
import static utils.WaitingUtility.elementFluentWaitClick;
import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.textIsPresent;

public class OrderingPhysicalPage extends BasePage {

	public OrderingPhysicalPage(WebDriver driver) {
		super(driver);
	}

	OrderingGuestPage guest= new OrderingGuestPage(driver);
	@FindBy(id = "email")
	private WebElement emailInputField;

	@FindBy(id = "pass")
	private WebElement passwordField;

	@FindBy(css = ".j_mini_cart_summary .price")
	private WebElement basketTxt;

	@FindBy(css = ".header-top")
	private WebElement headerTxt;

	@FindBy(css = "[href='/customer/account']")
	private WebElement accountLink;

	@FindBy(css = ".mini-cart-summary")
	public WebElement basketSummaryTxt;


	@FindBy(css = "div.j_mini_cart_summary")
	private WebElement selectMiniCart;

	@FindBy(css = "[title='Просмотр корзины ']")
	private WebElement selectBasket;


	@FindBy(css = "a.button.cart__checkout-button.j_cart_checkout")
	private WebElement orderBtn;


	@FindBy(id = "onepage-billing")
	private WebElement orderBillingTxt;

	@FindBy(css = ".page__inner")
	private WebElement orderContainer;

	@FindBy(css = ".text a")
	private WebElement orderTxt;

	@FindBy(css = ".profile-orders")
	private WebElement orderConteiner;

	@FindBy(css = "[title='Продолжить покупать']")
	private WebElement byeBtn;


	@FindBy(css = ".checkbox__label")
	public  WebElement checkboxLabelBtn;

	@FindBy(id = "billing:street_new")
	private WebElement addressesField;

	@FindBy(id = "billing:floor")
	private WebElement floorField;


	@FindBy(id = "billing:porch")
	private WebElement porchField;

	@FindBy(css = "[href='"+BASE_URL+"/customer/address/']")
	private WebElement addressesLink;

	@FindBy(css = ".profile__addresses")
	public WebElement addressesContaineer;

	@FindBy(css = ".select2-container")
	public WebElement dropListAddresses;

	@FindBy(css = "div.checkout-layout__inner h1")
	public WebElement headerOrderTxt;

	@FindBy(id = "loc-changed")
	public  WebElement  modelWindows;

	@FindBy(css = "button.j_confirm_confirm")
	private WebElement confirmBtn;

	@FindBy(css = "button.j_confirm_cancel")
	private WebElement cancelBtn;

	@FindBy(css = "#loc-changed .modal__close")
	private WebElement closedBtn;

	@FindBy(id="billing-address-select")
	private WebElement addressesList;

	/**
	 * Authorization and select product
	 */
	private void selectProduct()
	{
		getUrl(AUTORIZATION_PAGE_URL);
		getUrl(AUTORIZATION_PAGE_URL);
		fillInputField(emailInputField, driver, "test_m.ponomareva@magdv.com");
		fillInputFieldAndPressEnterButton(passwordField, "ztq0d9e6");
		if(!getText(basketSummaryTxt).contains("тов."))
		{
			new OrderingGuestPage(driver).addProductToBasket();
		}
		else
		{
			elementFluentWaitVisibility(selectMiniCart, driver).click();
			elementFluentWaitVisibility(selectBasket, driver).click();
			elementFluentWaitVisibility(orderBtn, driver).click();
		}
	}

	/**
	 * Validate Data after ordering
	 */
	private void validateMainData()
	{
		textIsPresent(orderContainer,driver,"Ваш заказ принят");
		String order=getText(orderTxt);
		Verify.verify(getText(orderContainer).contains("Ваш заказ принят"));
		Verify.verify(getText(orderContainer).contains("Спасибо за покупку!"));
		Verify.verify(getText(orderContainer).contains("Номер вашего заказа"));
		Verify.verify(getText(orderContainer).contains("Вы получите письмо на ваш адрес электронной почты"));
		Verify.verify(getText(orderContainer).contains("Продолжить покупать"));
		elementFluentWaitVisibility(byeBtn,driver).click();
		Verify.verify(getText(headerTxt).contains("Пономарёва Маргарита"));
		elementFluentWaitVisibility(accountLink,driver).click();
		Assert.assertTrue(getText(orderConteiner).contains(order));
	}

	private void verifyOrderingBefoSend()
	{
		Verify.verify(getText(orderBillingTxt).contains("г Томск, ул Нахимова, д 34, кв 53"));
		Verify.verify(getValueOfAttributeByName(guest.firstNameTxt,"value").contains("Маргарита"));
		Verify.verify(getValueOfAttributeByName(guest.lastNameTxt,"value").contains("Пономарёва"));
		Verify.verify(getValueOfAttributeByName(guest.phoneTxt,"value").contains("71111111111"));

	}
	public void orderingDefaultAddress()
	{
		selectProduct();
		verifyOrderingBefoSend();
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		validateMainData();

	}

	public void orderingNewAddress()
	{
		selectProduct();
		verifyOrderingBefoSend();
		elementFluentWaitVisibility(checkboxLabelBtn,driver).click();
		sleepWait();
		elementFluentWaitVisibility(addressesField,driver).sendKeys("Адрес доставки Томск, пр. Мира 20, оф.4");
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		validateMainData();
		elementFluentWaitVisibility(addressesLink,driver).click();
		AssertCollector.assertTrue(getText(addressesContaineer).contains("Адрес доставки Томск, пр. Мира 20, оф.4"));
	}
	public void orderingChangedAddress()
	{
		selectProduct();
		verifyOrderingBefoSend();
		elementFluentWaitVisibility(dropListAddresses,driver).click();
		Select dropdown= new Select(addressesList);
		dropdown.selectByIndex(4);
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		validateMainData();
	}

	public void orderingChangedStoreAddress()
	{
		selectProduct();
		verifyOrderingBefoSend();
		elementFluentWaitVisibility(dropListAddresses,driver).click();
		Select dropdown= new Select(addressesList);
		dropdown.selectByIndex(1);
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		textIsPresent(modelWindows,driver,"Выбранный вами адрес обслуживается другим");
		Verify.verify(getText(modelWindows).contains("Выбранный вами адрес обслуживается другим складом. " +
				"Цены и наличие товаров в заказе могут измениться. Переходим на другой склад?"));
		elementFluentWaitVisibility(cancelBtn,driver).click();
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		elementFluentWaitVisibility(closedBtn,driver).click();
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		textIsPresent(confirmBtn,driver,"Да");
		elementFluentWaitVisibility(confirmBtn,driver).click();
		sleepWait();
		elementFluentWaitClick(dropListAddresses,driver).click();
		dropdown.selectByIndex(1);
		elementFluentWaitVisibility(guest.createOrderButton,driver).click();
		validateMainData();
	}
//	public boolean dateDay() {
//		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		DateFormat time = new SimpleDateFormat("dd-MM-yyyy");
//		Date date = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.HOUR, 2);
//		Date dateNow = cal.getTime();
//		Object test =date.compareTo(dateNow);
//		System.out.println(dateNow);
//		if(dateNow> )
//
//		return  dateFormat.format(date.getTime());
//	}


}
