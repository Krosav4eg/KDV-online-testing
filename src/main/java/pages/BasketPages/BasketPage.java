package pages.BasketPages;

import basePage.BasePage;
import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AssertCollector;

import java.util.Set;

import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.elementIsClickable;
import static utils.WaitingUtility.waitForPageLoad;


public class BasketPage extends BasePage {
	public BasketPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".j_cart_control_add")
	private WebElement productAddBtn;

	@FindBy(css = ".product-item")
	private WebElement productContainer;

	@FindBy(css = "div.j_mini_cart_summary")
	private WebElement selectMiniCart;


	@FindBy(css = "[title='Просмотр корзины ']")
	private WebElement selectBasket;

	@FindBy(id = "cart-form")
	private WebElement cardContainer;

	@FindBy(css = ".cart__aside")
	private WebElement cardPayContainer;

	@FindBy(css = ".cart-list img")
	private WebElement imageCard;

	@FindBy(id = "search")
	private WebElement searchField;

	@FindBy(css = "[title='Поиск']")
	private WebElement searchBtn;

	@FindBy(css = "#magdv_tablisting > div > div:nth-child(1) a.j_cart_control_add")
	private WebElement firstProductBtn;
	@FindBy(css = "#magdv_tablisting > div > div:nth-child(2) a.j_cart_control_add")
	private WebElement secondProductBtn;

	@FindBy(css = "#cart-form > div.cart-list > div.cart-list__items > div:nth-child(2) > div.cart-item__col_price  div.cart-item__text_price> span")
	private WebElement secondPriceTxt;

	@FindBy(css = "#cart-form > div.cart-list > div.cart-list__items > div:nth-child(1) > div.cart-item__col_price  div.cart-item__text_price> span")
	private WebElement firstPriceTxt;

	@FindBy(css = "#cart-form>div.cart-list__total> div > span.j_cart_total_cost > span")
	private WebElement summTxt;

	@FindBy(css = "div.cart-list__items>div:nth-child(1)>div.cart-item__col_cart  div.cart-control__active>div.j_cart_control_inc")
	private WebElement incBtn;

	@FindBy(css = ".cart__checkout-button")
	private WebElement completeOrder;

	@FindBy(css = "div.cart-list__items > div:nth-child(1) > div.cart-item__col_remove> div > a")
	private WebElement removePositionBtn;

	@FindBy(id = "remove-product-from-cart-confirm")
	private WebElement removeContainer;

	@FindBy(css = "button.j_confirm_cancel")
	private WebElement canceledBtn;

	@FindBy(css = "button.j_confirm_confirm")
	private WebElement confirmBtn;

	@FindBy(css = "#remove-product-from-cart-confirm .modal__close")
	private WebElement closeBtn;

	@FindBy(css = "#remove-all-from-cart-confirm .modal__close")
	private WebElement closeAllBtn;


	@FindBy(xpath = "//a[text()='Очистить все']")
	private WebElement removeAll;

	@FindBy(css = ".text")
	private WebElement basketContainer;

	@FindBy(css = "a.link")
	private WebElement mainPageLink;

	@FindBy(css = "li.first")
	private WebElement selectCityLink;

	@FindBy(xpath = "//div[text()='Тула']")
	private WebElement selectCityTylaLink;


	private void searchElement() {
		moveToElementJS(driver, productContainer);
		elementFluentWaitVisibility(searchField, driver).sendKeys("томские класические");
		moveToElementJS(driver, searchBtn);
		elementFluentWaitVisibility(searchBtn, driver).click();

	}

	private void selectOneProduct()
	{
		searchElement();
		moveToElementJS(driver,productAddBtn);
		elementFluentWaitVisibility(productAddBtn, driver).click();
		elementFluentWaitVisibility(selectMiniCart, driver).click();
		elementFluentWaitVisibility(selectBasket, driver).click();
	}
	public void verifyBasket() {
		selectOneProduct();
		AssertCollector.assertTrue(getText(cardContainer).contains("95,20"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Конфеты «Томские классические», 300 г"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Корзина"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Название товара"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Количество"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Удаление"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Сумма"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Итого к оплате:"));
		AssertCollector.assertTrue(getText(cardPayContainer).contains("Итого к оплате:"));
		AssertCollector.assertTrue(getText(cardPayContainer).contains("Минимальная сумма заказа 300,00"));
		AssertCollector.assertTrue(imageCard.isDisplayed());
		elementFluentWaitVisibility(imageCard, driver).click();
		driver.navigate().back();
	}

	private void selectTwoProducts() {
		moveToElementJS(driver, productContainer);
		clickElementByJS(driver, firstProductBtn);
		clickElementByJS(driver, secondProductBtn);
		moveToElementJS(driver, selectMiniCart);
		elementIsClickable(selectMiniCart, driver).click();
		moveToElementJS(driver, selectBasket);
		elementIsClickable(selectBasket, driver).click();

	}

	public void verifyAddProductToBasket() {

		selectTwoProducts();
		Double summ = getPrice(firstPriceTxt) + getPrice(secondPriceTxt);
		AssertCollector.assertTrue(getPrice(summTxt) == summ);
		increaseProductCount();
		AssertCollector.assertTrue(getText(cardPayContainer).contains("Ну вот, уже лучше! Можно и заказ оформить."));
		elementFluentWaitVisibility(completeOrder, driver).click();
		AssertCollector.assertTrue(getCurrentUrl().contains("onestepcheckout/"));
	}

	private double getPrice(WebElement element) {
		return parseStringToDouble(getText(element));
	}

	private void increaseProductCount() {
		while (getPrice(summTxt) < 300) {
			sleepWait();
			elementFluentWaitVisibility(incBtn, driver).click();
		}
	}

	public void verifyDeleteProduct() {
		selectTwoProducts();
		elementFluentWaitVisibility(removePositionBtn, driver).click();
		AssertCollector.assertTrue(getText(removeContainer).contains("Вы уверены, что хотите удалить товар из корзины?"));
		AssertCollector.assertTrue(getText(removeContainer).contains("Отмена"));
		elementFluentWaitVisibility(canceledBtn, driver).click();
		elementFluentWaitVisibility(removePositionBtn, driver).click();
		elementFluentWaitVisibility(closeBtn, driver).click();
		elementFluentWaitVisibility(removePositionBtn, driver).click();
		elementFluentWaitVisibility(confirmBtn, driver).click();
		elementFluentWaitVisibility(removePositionBtn, driver).click();
		elementFluentWaitVisibility(confirmBtn, driver).click();
		AssertCollector.assertTrue(getText(basketContainer).contains("Ваша корзина пуста, вы можете перейти"));
		elementFluentWaitVisibility(mainPageLink, driver).click();
		AssertCollector.assertTrue(getCurrentUrl().contains("http://tomsk.demo.dev.magonline.ru/"));
	}

	public void verifyDeleteAllProduct() {
		selectTwoProducts();
		elementFluentWaitVisibility(removeAll,driver).click();
		elementFluentWaitVisibility(canceledBtn, driver).click();
		elementFluentWaitVisibility(removeAll,driver).click();
		elementFluentWaitVisibility(closeAllBtn, driver).click();
		elementFluentWaitVisibility(removeAll,driver).click();
		elementFluentWaitVisibility(confirmBtn, driver).click();
		AssertCollector.assertTrue(getText(basketContainer).contains("Ваша корзина пуста, вы можете перейти"));
		elementFluentWaitVisibility(mainPageLink, driver).click();
		AssertCollector.assertTrue(getCurrentUrl().contains("http://tomsk.demo.dev.magonline.ru/"));
	}

	public void verifyProductAbsent()
	{
		selectOneProduct();
		AssertCollector.assertTrue(getText(cardContainer).contains("95,20"));
		AssertCollector.assertTrue(getText(cardContainer).contains("Конфеты «Томские классические», 300 г"));
		elementFluentWaitVisibility(selectCityLink,driver).click();
		elementFluentWaitVisibility(selectCityTylaLink,driver).click();
		AssertCollector.assertTrue(getText(cardContainer).contains("Нет в наличии"));
		System.out.println(getPrice(summTxt));
		AssertCollector.assertTrue(getPrice(summTxt)==0);

	}
}