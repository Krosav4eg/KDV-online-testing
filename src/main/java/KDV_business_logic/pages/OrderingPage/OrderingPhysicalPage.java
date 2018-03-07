package KDV_business_logic.pages.OrderingPage;

import Core.basePage.BasePage;
import Core.utils.Constants;
import KDV_business_logic.pages.BasketPages.BasketPage;
import KDV_business_logic.pages.OrderingPage.OrderGuest.OrderingGuestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import Core.utils.AssertCollector;

import java.util.Calendar;
import java.util.List;

import static Core.utils.Constants.*;
import static Core.utils.WaitingUtility.*;

public class OrderingPhysicalPage extends BasePage {

    public OrderingPhysicalPage(WebDriver driver) {
        super(driver);
    }

    OrderingGuestPage guest = new OrderingGuestPage(driver);
    BasketPage basketPage = new BasketPage(driver);
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
    public WebElement checkboxLabelBtn;

    @FindBy(id = "billing:street_new")
    private WebElement addressesField;

    @FindBy(id = "billing:floor")
    private WebElement floorField;

    @FindBy(id = "checkout-delivery-date")
    private WebElement dateTxt;

    @FindBy(id = "billing:porch")
    private WebElement porchField;
    //
    @FindBy(css = "div.profile-nav__content > a:nth-child(3)")
    private WebElement addressesLink;

    @FindBy(css = ".profile__addresses")
    public WebElement addressesContaineer;

    @FindBy(css = ".select2-container")
    public WebElement dropListAddresses;

    @FindBy(css = "div.checkout-layout__inner h1")
    public WebElement headerOrderTxt;

    @FindBy(id = "loc-changed")
    public WebElement modelWindows;

    @FindBy(css = "button.j_confirm_confirm")
    private WebElement confirmBtn;

    @FindBy(css = "button.j_confirm_cancel")
    private WebElement cancelBtn;

    @FindBy(css = "#loc-changed .modal__close")
    private WebElement closedBtn;

    @FindBy(css = "#billing-address-select>option")///checkout-delivery-time
    private List<WebElement> addressesList;

    @FindBy(id = "billing-address-select")///checkout-delivery-time
    private WebElement addressList;

    /**
     * Authorization and select product
     */
    private void selectProduct() {
        getUrl(AUTORIZATION_PAGE_URL);
        fillInputField(emailInputField, PONOMAREVA_EMAIL);//"test_m.ponomareva@magdv.com");
        fillInputFieldAndPressEnterButton(passwordField, PONOMAREVA_PASSWORD); //"ztq0d9e6");
        if (!getText(basketSummaryTxt).contains("тов.")) {
            basketPage.addProductToBasket();
        } else {
            elementFluentWaitVisibility(selectMiniCart).click();
            elementFluentWaitVisibility(selectBasket).click();
            elementFluentWaitVisibility(orderBtn).click();
        }
    }

    /**
     * Validate Data after ordering
     */
    private void validateMainData() {
        textIsPresent(orderContainer, "Ваш заказ принят");
        String order = getText(orderTxt);
        AssertCollector.verifyCondition(getText(orderContainer).contains("Ваш заказ принят"));
        AssertCollector.verifyCondition(getText(orderContainer).contains("Спасибо за покупку!"));
        AssertCollector.verifyCondition(getText(orderContainer).contains("Номер вашего заказа"));
        AssertCollector.verifyCondition(getText(orderContainer).contains("Вы получите письмо на ваш адрес электронной почты"));
        AssertCollector.verifyCondition(getText(orderContainer).contains("Продолжить покупать"));
        elementFluentWaitVisibility(byeBtn).click();
        AssertCollector.verifyCondition(getText(headerTxt).contains("Пономарёва Маргарита"));
        elementFluentWaitVisibility(accountLink).click();
        Assert.assertTrue(getText(orderConteiner).contains(order));
    }

    private void verifyOrderingBeforeSend() {
        AssertCollector.verifyCondition(getText(orderBillingTxt).contains("г Томск, ул Нахимова, д 34, кв 53"));
        AssertCollector.verifyCondition(getValueOfAttributeByName(guest.firstNameTxt, "value").contains("Маргарита"));
        AssertCollector.verifyCondition(getValueOfAttributeByName(guest.lastNameTxt, "value").contains("Пономарёва"));
        AssertCollector.verifyCondition(getValueOfAttributeByName(guest.phoneTxt, "value").contains("71111111111"));
    }

    private static boolean dateDay(String time) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 4);
        int hourNow = cal.get(Calendar.HOUR);
        int dateNow = cal.get(Calendar.DATE);
        boolean result;
        if (hourNow >= 8) {
            result = time.contains(Integer.toString(dateNow + 1));
        } else {
            result = time.contains(Integer.toString(dateNow));
        }
        System.out.println(dateNow + 7);
        return result;
    }

    public void orderingDefaultAddress() {
        selectProduct();
        verifyOrderingBeforeSend();
        dateDay(getValueOfAttributeByName(dateTxt, "value"));
        elementFluentWaitVisibility(guest.createOrderButton).click();
        validateMainData();
    }

    public void orderingNewAddress() {
        selectProduct();
        verifyOrderingBeforeSend();
        elementFluentWaitVisibility(checkboxLabelBtn).click();
        sleepWait();
        elementFluentWaitVisibility(addressesField).sendKeys("Адрес доставки Томск, пр. Мира 20, оф.4");
        moveToElementJS(driver,addressesField);
        elementFluentWaitVisibility(guest.createOrderButton).click();
        validateMainData();
        elementFluentWaitVisibility(addressesLink).click();
        AssertCollector.assertTrue(getText(addressesContaineer).contains("Адрес доставки Томск, пр. Мира 20, оф.4"));
    }

    public void orderingChangedAddress() {
        selectProduct();
        verifyOrderingBeforeSend();
        elementFluentWaitVisibility(dropListAddresses).click();
        clickOnIndexFromElementList(addressesList, 4);
        elementFluentWaitVisibility(guest.createOrderButton).click();
        validateMainData();
    }

    public void orderingChangedStoreAddress() {
        selectProduct();
        verifyOrderingBeforeSend();
        elementFluentWaitVisibility(dropListAddresses).click();
//        Select dropdown = new Select(addressList);
//        addressList.dropdown.selectByIndex(4);
        Select dropdown = new Select(addressList);
        dropdown.selectByIndex(1);
        elementFluentWaitVisibility(guest.createOrderButton).click();
        textIsPresent(modelWindows, "Выбранный вами адрес обслуживается другим");
        AssertCollector.verifyCondition(getText(modelWindows).contains("Выбранный вами адрес обслуживается другим складом. " +
                "Цены и наличие товаров в заказе могут измениться. Переходим на другой склад?"));
        elementFluentWaitVisibility(cancelBtn).click();
        elementFluentWaitVisibility(guest.createOrderButton).click();
        elementFluentWaitVisibility(closedBtn).click();
        elementFluentWaitVisibility(guest.createOrderButton).click();
        textIsPresent(confirmBtn, "Да");
        elementFluentWaitVisibility(confirmBtn).click();
//        //TODO
//        elementFluentWaitClick(dropListAddresses).click();
//        dropdown.selectByIndex(1);
//        elementFluentWaitVisibility(guest.createOrderButton).click();
//        validateMainData();
    }
}
