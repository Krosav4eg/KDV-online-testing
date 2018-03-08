package KDV_business_logic.pages.OrderingPage;


import Core.basePage.BasePage;
import Core.utils.AssertCollector;
import Core.utils.WaitingUtility;
import KDV_business_logic.pages.BasketPages.BasketPage;
import KDV_business_logic.pages.MainPage.MainPageSelector;
import KDV_business_logic.pages.OrderingPage.OrderGuest.OrderingGuestPage;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Core.utils.Constants.BASE_URL;

public class OrderingLegalPage extends BasePage {
    public OrderingLegalPage(WebDriver driver) {
        super(driver);
    }
    BasketPage basketPage= new BasketPage(driver);
    MainPageSelector mainPageSelector= new MainPageSelector(driver);
    @FindBy(css = "[id='billing:firstname']")
    public WebElement firstNameTxt;


    @FindBy (id = "billing-address-select")
    public WebElement addresList;

    @FindBy(css = ".button.button_mobile-wide.j_button_make_order")
    public WebElement createOrderButton;

    @FindBy(css = "[id='billing:lastname']")
    public WebElement lastNameTxt;

    @FindBy(css = ".select2-selection__rendered#select2-billing-address-select-container")
    public WebElement deliveryAddress;

    @FindBy(xpath = "//span[@aria-expanded='true']")
    public WebElement addressDropDownArea;

    @FindBy(xpath = "//select/option[text()='Кемерово, 50 лет Октября, 16']")
    public WebElement secondAddressDropDownList;

    @FindBy(xpath = "//select/option[text()='Томск, Иркутский тракт 114/1']")
    public WebElement thirdAddressDropDownList;

    @FindBy(xpath = "//span[@class=\"text\"]")
    public WebElement transportDescription;

    @FindBy(css = ".button.button_mobile-wide.j_button_metrics_goals")
    public WebElement continueShoppingButton;

    @FindBy(css = ".text a.link")
    public WebElement orderLink;

    @FindBy(css = "[id='billing:telephone']")
    public WebElement phoneTxt;

    @FindBy(css = ".profile-orders__col.profile-orders__col_id.hidden-xs.hidden-xxs")
    public List<WebElement> orderNumberInList;

    @FindBy(id = "onepage-review")
    public WebElement orderContainer;

    public void createOrderForLegalPerson() {
        basketPage.addProductToBasket();
    }

    public String getElementTextFromList(List<WebElement> element, int elementIndex) {
        return element.get(elementIndex).getText();
    }

    public JSONObject data() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Геннадий");
        data.put("lastName", "Фадеев");
        data.put("phone", "+71111111111");
        return data;
    }

    public JSONObject dataSecond() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Илья");
        data.put("lastName", "Панфилов");
        data.put("phone", "+71111111111");
        return data;
    }

    public JSONObject dataFirst() {
        JSONObject data = new JSONObject();
        data.put("firstName", "Софья");
        data.put("lastName", "Стрелкова");
        data.put("phone", "+72222222222");
        return data;
    }
    public void deliveryAddressBlock(JSONObject data) {
        elementFluentWaitVisibility(new OrderingGuestPage(driver).firstNameTxt).clear();
        elementFluentWaitVisibility(new OrderingGuestPage(driver).firstNameTxt).sendKeys(data.getString("firstName"));
        elementFluentWaitVisibility(new OrderingGuestPage(driver).lastNameTxt).clear();
        elementFluentWaitVisibility(new OrderingGuestPage(driver).lastNameTxt).sendKeys(data.getString("lastName"));
        elementFluentWaitVisibility(new OrderingGuestPage(driver).phoneTxt).clear();
        elementFluentWaitVisibility(new OrderingGuestPage(driver).phoneTxt).sendKeys(data.getString("phone"));
    }
    public void verifyCreateOrder(JSONObject data)
    {
        AssertCollector.assertEqualsJ(mainPageSelector.myAccountLink.getText(), "ООО Юрмет",
                "Company name is correct");
        textPresent("Адреса доставки (Торговые точки)");
        AssertCollector.assertTrue(deliveryAddress.getText().contains("Томск, Иркутский тракт 114/1"),
                "Address is correct");
        elementIsClickable(deliveryAddress).click();
        AssertCollector.assertTrue(addressDropDownArea.isDisplayed(),
                "Address dropdown list is appear");

        if(data.getString("firstName").equals("Софья")){
            selectOptionList(addresList,1);
           // elementIsClickable(secondAddressDropDownList).click();
        }
        if (data.getString("firstName").equals("Геннадий"))
        {
            selectOptionList(addresList,0);
            //elementIsClickable(thirdAddressDropDownList).click();
        }
        moveMouseToAndClick(driver,orderContainer,0,0);
        sleepWait();
        String currentName = getValueOfAttributeByName(firstNameTxt, "value");
        AssertCollector.assertEqualsJ(currentName, data.getString("firstName"),
                "First name is correct");
        AssertCollector.assertEqualsJ(getValueOfAttributeByName(lastNameTxt, "value"),
                data.getString("lastName"), "Last name is correct");
        AssertCollector.assertEqualsJ(getValueOfAttributeByName(phoneTxt, "value"),
                data.getString("phone"), "Phones correct");
        AssertCollector.assertTrue(transportDescription.getText().
                contains("Доставка грузовым транспортом: 0,00"), "Correct value");
        moveToElementJS(driver,orderContainer);
        elementIsClickable(createOrderButton).click();
        textPresent("Обработка, пожалуйста, подождите. Не нажимайте на обновление или кнопку" +
                " назад иначе этот заказ не будет оформлен.");
        textPresent("Ваш заказ принят.");
        textPresent("Спасибо за покупку!");
        textPresent("Вы получите письмо на ваш адрес электронной почты (email) с подробной " +
                "информацией о заказе и ссылкой на страницу, на которой можно проверить текущий статус заказа.\n" +
                "\n" +
                "Будем благодарны, если при оплате наличными Вы подготовите сумму без сдачи.");
        WaitingUtility.elementFluentWaitVisibility(orderLink);
        String orderNumberActual = orderLink.getText();
        elementIsClickable(continueShoppingButton).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(),
                BASE_URL + "/", "Urls are equals");
        elementIsClickable(new MainPageSelector(driver).myAccountLink).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(),
                BASE_URL + "/customer/account", "Urls are equals");
        getUrl(BASE_URL + "/sales/order/history/");
        AssertCollector.assertEqualsJ(orderNumberActual,
                getElementTextFromList(orderNumberInList, 0).substring(2, 12)
                , "Number orders are equals");
    }

}
