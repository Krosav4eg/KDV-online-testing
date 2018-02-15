package pages.BasketPages;

import Core.basePage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.OrderingPage.OrderingPhysicalPage;
import utils.AssertCollector;

import static utils.Constants.BASE_URL;
import static utils.WaitingUtility.*;


public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".j_cart_control_add")
    private WebElement productAddBtn;

    @FindBy(css = ".cart-control__btn.cart-control__btn_inc")
    private WebElement productPlusBtn;

    @FindBy(css = "[title='Кальмар подкопчённый (упаковка 1 кг)']")
    private WebElement tittleProductTxt;

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

    @FindBy(css = "h1.title")
    private WebElement searchHeaderTxt;

    private void searchElement() {
        moveToElementJS(driver, productContainer);
        elementFluentWaitVisibility(searchField).sendKeys("Кальмар подкопчённый");
        moveToElementJS(driver, searchBtn);
        elementFluentWaitVisibility(searchBtn).click();
    }

    public void selectOneProduct() {
        searchElement();
        moveToElementJS(driver, productAddBtn);
        scrollDown();
        textIsPresent(searchHeaderTxt, "Результаты поиска для «Кальмар подкопчённый»");
        moveToElementJS(driver, tittleProductTxt);
        try {
            if (elementIsVisible(productAddBtn)) {
                elementFluentWaitVisibility(productAddBtn).click();
                textIsPresent(new OrderingPhysicalPage(driver).basketSummaryTxt, "тов.");
                elementFluentWaitVisibility(selectMiniCart).click();
                elementFluentWaitVisibility(selectBasket).click();
            } else if (elementIsVisible(productPlusBtn)) {
                elementFluentWaitVisibility(selectMiniCart).click();
                elementFluentWaitVisibility(selectBasket).click();
            }
        } catch (NoSuchElementException ex) {
            ex.getMessage();
        }
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
        AssertCollector.assertTrue(elementIsDisplayed(imageCard));
        elementFluentWaitVisibility(imageCard).click();
        driver.navigate().back();
    }

    private void selectTwoProducts() {
        moveToElementJS(driver, productContainer);
        clickElementByJS(driver, firstProductBtn);
        clickElementByJS(driver, secondProductBtn);
        moveToElementJS(driver, selectMiniCart);
        elementIsClickable(selectMiniCart).click();
        moveToElementJS(driver, selectBasket);
        elementIsClickable(selectBasket).click();
    }

    public void verifyAddProductToBasket() {

        selectTwoProducts();
        Double summ = getPrice(firstPriceTxt) + getPrice(secondPriceTxt);
        AssertCollector.assertTrue(getPrice(summTxt) == summ);
        increaseProductCount();
        AssertCollector.assertTrue(getText(cardPayContainer).contains("Ну вот, уже лучше! Можно и заказ оформить."));
        elementFluentWaitVisibility(completeOrder).click();
        AssertCollector.assertTrue(getCurrentUrl().contains("onestepcheckout/"));
    }

    private double getPrice(WebElement element) {
        return parseStringToDouble(getText(element));
    }

    public void increaseProductCount() {
        while (getPrice(summTxt) < 300) {
            sleepWait();
            elementFluentWaitVisibility(incBtn).click();
        }
    }

    public void increaseLegalPersonProductCount() {
        try {
            while (getPrice(summTxt) < 2000) {
                sleepWait();
                elementFluentWaitVisibility(incBtn).click();
            }
        } catch (NoSuchElementException ex) {
            ex.getMessage();
        }
    }

    public void verifyDeleteProduct() {
        selectTwoProducts();
        elementFluentWaitVisibility(removePositionBtn).click();
        AssertCollector.assertTrue(getText(removeContainer).contains("Вы уверены, что хотите удалить товар из корзины?"));
        AssertCollector.assertTrue(getText(removeContainer).contains("Отмена"));
        elementFluentWaitVisibility(canceledBtn).click();
        elementFluentWaitVisibility(removePositionBtn).click();
        elementFluentWaitVisibility(closeBtn).click();
        elementFluentWaitVisibility(removePositionBtn).click();
        elementFluentWaitVisibility(confirmBtn).click();
        elementFluentWaitVisibility(removePositionBtn).click();
        elementFluentWaitVisibility(confirmBtn).click();
        AssertCollector.assertTrue(getText(basketContainer).contains("Ваша корзина пуста, вы можете перейти"));
        elementFluentWaitVisibility(mainPageLink).click();
        AssertCollector.assertTrue(getCurrentUrl().contains(BASE_URL));
    }

    public void verifyDeleteAllProduct() {
        selectTwoProducts();
        elementFluentWaitVisibility(removeAll).click();
        elementFluentWaitVisibility(canceledBtn).click();
        elementFluentWaitVisibility(removeAll).click();
        elementFluentWaitVisibility(closeAllBtn).click();
        elementFluentWaitVisibility(removeAll).click();
        elementFluentWaitVisibility(confirmBtn).click();
        AssertCollector.assertTrue(getText(basketContainer).contains("Ваша корзина пуста, вы можете перейти"));
        elementFluentWaitVisibility(mainPageLink).click();
        AssertCollector.assertTrue(getCurrentUrl().contains(BASE_URL));
    }

    public void verifyProductAbsent() {
        selectOneProduct();
        AssertCollector.assertTrue(getText(cardContainer).contains("95,20"));
        AssertCollector.assertTrue(getText(cardContainer).contains("Конфеты «Томские классические», 300 г"));
        elementFluentWaitVisibility(selectCityLink).click();
        elementFluentWaitVisibility(selectCityTylaLink).click();
        AssertCollector.assertTrue(getText(cardContainer).contains("Нет в наличии"));
        AssertCollector.assertTrue(getPrice(summTxt) == 0);
    }
}
