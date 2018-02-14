package pages.CategoryPage;

import Core.apiMethods.GlobalAPI;
import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertCollector;

import static utils.Constants.BASE_URL;
import static utils.WaitingUtility.elementFluentWaitVisibility;
import static utils.WaitingUtility.elementIsDisplayed;

public class CardPage extends BasePage {
    public CardPage(WebDriver driver) {
        super(driver);
    }

    //========================CARD PAGE=============================================
    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(css = ".product")
    private WebElement productContainer;

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

    @FindBy(css = ".product-item__inner")
    private WebElement productCardContainer;

    @FindBy(css = ".product-chars")
    private WebElement productCardDescriptionContainer;

    @FindBy(css = ".composition-spoiler__show")
    private WebElement showAll;

    @FindBy(css = ".cart-control__btn_inc")
    private WebElement cartControlIncBtn;

    @FindBy(css = ".cart-control__btn_dec")
    private WebElement cartControlDecBtn;

    @FindBy(css = ".benefit_price")
    private WebElement benefitPrice;

    @FindBy(css = ".benefit_delivery")
    private WebElement benefitDelivery;

    @FindBy(css = ".benefit_payment")
    private WebElement benefitPayment;



    public void searchAndSelect() {
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL + "/konfety.html");
        elementFluentWaitVisibility(selectCategorySearchBtn, driver).click();
        CallJS("jQuery(\"#inputs-search-table div.search-category-dropdown__list div:contains('Конфеты')\").click()", driver);
        elementFluentWaitVisibility(searchField, driver).sendKeys("Томские классические");
        elementFluentWaitVisibility(searchBtn, driver).click();
        moveMouseTo(driver, aboutLink);
    }

    public void verifyFieldsCardMainPage() {
        searchAndSelect();
        AssertCollector.assertTrue(getText(categoryContainer).contains("Конфеты «Томские классические», 300 г"));
        AssertCollector.assertTrue(getText(categoryContainer).contains("95,20"));
        AssertCollector.assertTrue(getText(categoryContainer).contains("\u20BD"));
        AssertCollector.assertTrue(elementIsDisplayed(categoryAddBtn,driver), "element is visible");
    }

    public void addProductFromCardMainPage() {
        searchAndSelect();
        clickElementByJS(driver, categoryAddBtn);
        driver.navigate().refresh();
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("1"));
        elementFluentWaitVisibility(categoryDecBtn, driver).click();
        driver.navigate().refresh();
        AssertCollector.assertTrue(elementIsDisplayed(categoryAddBtn,driver));
    }

    public void addProductNotValidFromCardMainPage() {
        searchAndSelect();
        moveMouseTo(driver, aboutLink);
        elementFluentWaitVisibility(categoryAddBtn, driver).click();
        sleepWait();
        driver.navigate().refresh();
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("1"));
        addTxtToInput("-5");
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("51"));
        addTxtToInput("99999");
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("9999"));
        addTxtToInput("@!$^*&$#@*()");
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("9999"));
        elementFluentWaitVisibility(categoryInputTxt, driver).clear();
    }

    private void addTxtToInput(String txt) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOf(categoryAddBtn)).click();
        } catch (Exception ex) {
            System.out.println("Add button not available");
        }
        elementFluentWaitVisibility(categoryInputTxt, driver).click();
        elementFluentWaitVisibility(categoryInputTxt, driver).sendKeys(txt);
        moveMouseToAndClick(driver, mainTxt, 0, 0);
        sleepWait();
        driver.navigate().refresh();
    }

    public void validCardProductVerify() {
        searchAndSelect();
        elementFluentWaitVisibility(productCardContainer, driver).click();
        AssertCollector.assertTrue(getText(productContainer).contains("Конфеты «Томские классические», 300 г"));
        AssertCollector.assertTrue(getText(productContainer).contains("Конфеты «Томские классические» – суфле в шоколаде – визитная карточка Томска, где история сладкого бренда началась 50 лет назад."));
        AssertCollector.assertTrue(getText(productContainer).contains("95,20"));
        AssertCollector.assertTrue(getText(productContainer).contains("\u20BD"));
        AssertCollector.assertTrue(elementIsDisplayed(categoryAddBtn,driver), "element is visible");
        elementFluentWaitVisibility(categoryAddBtn, driver).click();
        sleepWait();
        AssertCollector.assertTrue(elementIsDisplayed(cartControlIncBtn,driver), "element is visible");
        AssertCollector.assertTrue(elementIsDisplayed(cartControlDecBtn,driver), "element is visible");
        elementFluentWaitVisibility(cartControlDecBtn, driver).click();
        sleepWait();
        AssertCollector.assertTrue(elementIsDisplayed(categoryAddBtn,driver), "element is visible");
    }

    public void validCardProductVerifyDescription() {
        searchAndSelect();
        elementFluentWaitVisibility(productCardContainer, driver).click();
        moveMouseTo(driver, productCardDescriptionContainer);
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Описание"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Страна производства:"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Россия"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Условия хранения:"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Хранить при температуре (18±3) С и относительной влажности воздуха не более 75%."));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Срок хранения:"), "");
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("СТО 73745375-001-2013"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Артикул:"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("КЗ603"));
    }

    public void validCardProductVerifyComposition() {
        searchAndSelect();
        elementFluentWaitVisibility(productCardContainer, driver).click();
        moveMouseTo(driver, productCardDescriptionContainer);
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Состав продукта:"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Белки"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Жиры"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Углеводы"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("Калории"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("2,5 г"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("22 г"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("59 г"));
        AssertCollector.assertTrue(getText(productCardDescriptionContainer).contains("495 ккал"));
        AssertCollector.assertTrue(elementIsDisplayed(showAll,driver), "element is present");
        elementFluentWaitVisibility(showAll, driver).click();
    }

    public void verifyNotValidProductCard() {
        searchAndSelect();
        elementFluentWaitVisibility(productCardContainer, driver).click();
        addTxtToInput("-5");
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("51"),
                "text not present");
        addTxtToInput("99999");
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("9999"));
        addTxtToInput("@!$^*&$#@*()");
        AssertCollector.assertTrue(getValueOfAttributeByName(categoryInputTxt, "value").contains("9999"));
    }

    public void validCardProductVerifyAdvantagesShop() {
        searchAndSelect();
        elementFluentWaitVisibility(productCardContainer, driver).click();
        AssertCollector.assertTrue(getText(benefitDelivery).contains("Ваши покупки из интернет-магазина KDV мы доставим бесплатно. Доставка в день заказа, в удобное для вас время, до двери квартиры/офиса."));
        elementFluentWaitVisibility(benefitDelivery, driver).click();
        AssertCollector.assertTrue(getCurrentUrl().contains("delivery"));
        driver.navigate().back();
        AssertCollector.assertTrue(getText(benefitPayment).contains("Интернет-магазин KDV работает без предоплаты. Оплата производится курьеру наличным и безналичным способом по факту доставки Вашего заказа."));
        elementFluentWaitVisibility(benefitPayment, driver).click();
        AssertCollector.assertTrue(getCurrentUrl().contains("payment-orders"));
        driver.navigate().back();
        AssertCollector.assertTrue(getText(benefitPrice).contains("KDV - мощное производство, распределительные центры и автопарк, что позволяет KDV держать демократичные цены на продукцию. В интернет-магазине KDV – еще дешевле."));
        elementFluentWaitVisibility(benefitPrice, driver).click();
        AssertCollector.assertTrue(getCurrentUrl().contains("about"));
        driver.navigate().back();
    }
}
