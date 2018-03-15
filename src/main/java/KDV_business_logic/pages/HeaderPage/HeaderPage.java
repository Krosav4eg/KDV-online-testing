package KDV_business_logic.pages.HeaderPage;

import Core.basePage.BasePage;
import Core.logger.MagDvLogger;
import Core.utils.AssertCollector;
import Core.utils.TestReporter;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Core.utils.Constants.BASE_URL;
import static org.testng.Assert.fail;

public class HeaderPage extends BasePage {
    private static final Logger LOGGER = MagDvLogger.getMagDvLogger().getLogger();

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Вход']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@title='Регистрация']")
    private WebElement registrationButton;

    @FindBy(xpath = "//a[@title=\"Выйти\"]")
    private WebElement exitButton;

    @FindBy(xpath = "//div[text()='Кемерово']")
    private WebElement selectCityKemerovo;

    @FindBy(className = "geo__title_default")
    private WebElement geoWindowModal;

    @FindBy(xpath = "(//a[@title='КДВ'])[1]")
    private WebElement companyLogo;

    @FindBy(css = ".quicklink__item.quicklink__item_geo.j_geo_control.j_geo_control_modal")
    private WebElement baseCityLink;

    @FindBy(className = "quicklink__item_geo")
    private WebElement cityLink;

    @FindBy(xpath = "(//*[@class='modal__box']//div[@data-location])[1]")
    private WebElement firstCityLink;

    @FindBy(css = ".select2-selection.select2-selection--single")
    private WebElement citySearchField;

    @FindBy(css = ".select2-results__options")
    private WebElement citySearchDropdown;

    @FindBy(css = ".mini-cart-summary__qty.mini-cart-summary__qty_empty")
    private WebElement myCart;

    @FindBy(xpath = "(.//*[@class='product-item__title-link'])[1]")
    private WebElement productTitleToBasket;

    @FindBy(xpath = "(.//*[@class='product-total-price'])[1]")
    private WebElement productPriceToBasket;

    @FindBy(className = "social")
    private WebElement socialContainer;

    @FindBy(css = ".product-item__summary-cart")
    private List<WebElement> hitSalesBasketButtons;

    @FindBy(css = ".cart-control__active")
    private WebElement productAddedButton;

    @FindBy(xpath = ".//*[@class='mini-cart-product__name mini-cart-product__name_link']")
    private WebElement productTitleInBasket;

    @FindBy(xpath = ".//*[@class='mini-cart-product__price']")
    private WebElement productPriceInBasket;

    @FindBy(css = ".mini-cart__dropdown.j_mini-cart__dropdown")
    private WebElement mainBasketToExpandButton;

    @FindBy(css = ".mini-cart__inner.mini-cart_clickable.j_mini-cart_clickable")
    private WebElement subBasketToExpandButton;

    @FindBy(css = ".mini-cart-summary__qty")
    private WebElement quantityOfProductsInBasket;

    @FindBy(xpath = "//div[@class=\"event-menu\"]//*[@href='tel:8 800 250 5555']")
    private WebElement telLink;

    @FindBy(css = ".button-scroll-top")
    private WebElement upButton;

    @FindBy(xpath = "(.//span[@class='btn-catalog__label with-closed-expander'])[1]")
    private WebElement catalogExpand;

    @FindBy(css = ".header-bottom-left__catalog")
    private WebElement categoryList;

    @FindBy(xpath = ".//*[@id='select-search-wrapper']/div")
    private WebElement categoryDropdown;

    @FindBy(css = ".search-category__selected.j_search_category_selected")
    private WebElement categoriesHeader;

    @FindBy(xpath = ".//*[@id='inputs-search-table']//div[4]")
    private WebElement categoryFromList;

    @FindBy(xpath = ".//*[@id='inputs-search-table']//div[9]")
    private WebElement anotherCategoryFromList;

    @FindBy(css = ".search-button__btn")
    private WebElement searchButton;

    @FindBy(css = ".mini-cart__dropdown.j_mini-cart__dropdown")
    private WebElement fullBasketDropdown;

    @FindBy(css = ".header-bottom-left__logo_small.text-left")
    private WebElement smallLogo;

    @FindBy(css = ".filter__value")
    private WebElement filterValue;

    @FindBy(css = ".top-link-myaccount")
    private WebElement myAccountLink;

    @FindBy(xpath = "//div[@id='input-search-wrapper']/*[@id='search']")
    private WebElement searchProductField;

    @FindBy(id = "footer")
    private WebElement footer;

    @FindBy(css = ".geo-confirm__city")
    private WebElement geoConfirmModalWindow;

    @FindBy(xpath = "//button[text()='Да']")
    private WebElement acceptGeoConfirm;

    @FindBy(xpath = "//div/p[1]")
    private WebElement resultsProductSearch;

    public void changeCity() {
        elementIsClickable(baseCityLink).click();
        elementIsClickable(firstCityLink).click();
        AssertCollector.assertEquals(getText(baseCityLink), " LINK IS EQUAL ", getText(baseCityLink));
    }

    public void changeCityToOther() {
        textIsPresent(baseCityLink, "Астрахань");
        elementIsClickable(cityLink).click();
        LOGGER.log(Level.INFO, "Check changing city to other");
        TestReporter.step("Check changing city to other");
        String otherCity = "Кемерово";
        textIsPresent(geoWindowModal, "Или выберите из списка");
        elementIsClickable(selectCityKemerovo).click();
        textIsPresent(baseCityLink, "Кемерово");
        AssertCollector.assertEquals(baseCityLink.getAttribute("title"), " LINK IS EQUAL ", otherCity);
    }

    public void checkCompanyLogo() {
        String urlActual = driver.getCurrentUrl();
        elementIsClickable(companyLogo).click();
        String urlExpected = driver.getCurrentUrl();
        AssertCollector.assertEquals(urlActual, " URL IS EQUAL ", urlExpected);
    }

    public void changeCityToCurrent() {
        LOGGER.log(Level.INFO, "Check changing city to current");
        TestReporter.step("Check changing city to current");
        textIsPresent(baseCityLink, "Кемерово");
        elementIsClickable(cityLink).click();
        textIsPresent(geoWindowModal, "Или выберите из списка");
        String currentCity = getText(baseCityLink);
        moveMouseTo(driver, baseCityLink);
        textIsPresent(geoWindowModal, "Или выберите из списка");
        Actions actions = new Actions(driver);
        actions.moveToElement(citySearchField);
        actions.click();
        actions.sendKeys(currentCity);
        actions.build().perform();
        elementIsClickable(citySearchDropdown).click();
        AssertCollector.assertEquals(currentCity, " City link is equal ", getText(baseCityLink));
    }

    public void openingRegistrationLink() {
        String linkTextAttribute = getValueOfAttributeByName(registrationButton, "href");
        elementFluentWaitVisibility(registrationButton).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of registration ",
                linkTextAttribute);
    }

    public void openingEnterLink() {
        String linkTextAttribute = getValueOfAttributeByName(enterButton, "href");
        elementFluentWaitVisibility(enterButton).click();
        getCurrentUrl();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of enter ",
                linkTextAttribute);
    }

    public void verifyingAnswerYourQuestionsTelNumber() {
        getUrl(BASE_URL);
        textPresent("Служба поддержки");
        String expTelLink = "tel:8 800 250 5555";
        String actTelLink = getValueOfAttributeByName(telLink, "href");
        AssertCollector.assertEquals(actTelLink, " Current telephone is equal to ",
                expTelLink);
    }

    public void verifyMyCardIsEmpty() {
        LOGGER.log(Level.INFO, "Verifying clicking my basket");
        TestReporter.step("Verifying clicking my basket");
        elementIsClickable(myCart).click();
        AssertCollector.assertTrue(elementIsVisible(myCart));
        AssertCollector.assertTrue(myCart.getText().equals("Корзина пока пуста"));
    }

    public void verifyMyBasketWithProduct() {
        getUrl(BASE_URL);
        String actTitle = getValueOfAttributeByName(productTitleToBasket, "title");
        String actPrice = getText(productPriceToBasket);
        moveToElementJS(driver, socialContainer);
        clickOnIndexFromElementList(hitSalesBasketButtons, 0);
        elementIsClickable(productAddedButton);
        if (elementIsVisible(productAddedButton)) {
            LOGGER.log(Level.INFO, "Button hitSalesBasketButtons is displayed");
            TestReporter.step("Button hitSalesBasketButtons is displayed");
            AssertCollector.assertTrue(elementIsVisible(productAddedButton));
        } else {
            LOGGER.log(Level.WARNING, "Button hitSalesBasketButtons isn't displayed");
            TestReporter.step("Button hitSalesBasketButtons isn't displayed");
            fail();
        }
        elementFluentWaitVisibility(upButton).click();
        hoverAndClick(driver, mainBasketToExpandButton, subBasketToExpandButton);
        String expTitle = getValueOfAttributeByName(productTitleInBasket, "title");
        String expPrice = getText(productPriceInBasket);
        AssertCollector.assertEquals(actTitle, " Title in Singleton page equals title in" +
                " basket page ", expTitle);
        AssertCollector.assertEqualsJ(actPrice, expPrice, " Price in Singleton page equals price in" +
                " basket page ");
    }

    public void openingCatalogAfterLeftMainPage() {
        elementFluentWaitVisibility(registrationButton).click();
        elementFluentWaitVisibility(catalogExpand).click();
        AssertCollector.assertTrue(elementIsVisible(categoryList));
    }

    public void verifyPhysicalAuthCredential() {
        String linkTextValue = getValueOfAttributeByName(myAccountLink, "href");
        elementFluentWaitVisibility(myAccountLink).click();
        AssertCollector.assertEquals(getCurrentUrl(), " Current url is equal link of ",
                linkTextValue);
    }

    public void verifySearchButton() {
        String actualTitle = "Поиск";
        String expectedTitle = searchButton.getAttribute("title");
        AssertCollector.assertEquals(actualTitle, " Current title is equal to title of ", expectedTitle);
        String enterButtonValue = getValueOfAttributeByName(searchProductField, "placeholder");
        AssertCollector.assertEqualsJ(enterButtonValue, "Введите название товара",
                "Placeholder values are equals");
    }

    public void cabinetLink() {
        getUrl(BASE_URL);
        AssertCollector.assertEqualsJ(getCurrentUrl(), BASE_URL + "/", "Urls are equals");
        AssertCollector.assertEqualsJ(myAccountLink.getText(),
                "ООО Аванс", "Organization name is correct");
        elementIsClickable(myAccountLink).click();
        AssertCollector.assertEqualsJ(getCurrentUrl(), BASE_URL + "/customer/account", "Is Clickable");
        elementIsClickable(exitButton);
    }

    public void verifyStickingHeaderDuringScrolling() {
        scrollToNecessaryElement(footer);
        AssertCollector.assertTrue(elementIsVisible(smallLogo));
        AssertCollector.assertTrue(elementIsVisible(searchProductField));
        AssertCollector.assertTrue(elementIsVisible(categoryDropdown));
        AssertCollector.assertTrue(elementIsVisible(searchButton));
        AssertCollector.assertTrue(myCart.getText().equals("Корзина пока пуста"));
        clickOnIndexFromElementList(hitSalesBasketButtons, 14);
        elementIsClickable(quantityOfProductsInBasket).click();
        AssertCollector.assertTrue(elementIsVisible(fullBasketDropdown));
    }

    public void verifyToolTypeText() {
        moveMouseTo(driver, companyLogo);
        String companyLogoValue = getValueOfAttributeByName(companyLogo, "title");
        AssertCollector.assertEquals("КДВ", " tooltip text is equal of ",
                companyLogoValue);
        moveMouseTo(driver, baseCityLink);
        String baseCityLinkValue = getValueOfAttributeByName(baseCityLink, "title");
        AssertCollector.assertEquals(getText(baseCityLink), " tooltip text is equal of ",
                baseCityLinkValue);
        moveMouseTo(driver, registrationButton);
        String registrationButtonValue = getValueOfAttributeByName(registrationButton, "title");
        AssertCollector.assertEquals(getText(registrationButton), " tooltip text is equal of ",
                registrationButtonValue);
        moveMouseTo(driver, enterButton);
        String enterButtonValue = getValueOfAttributeByName(enterButton, "title");
        AssertCollector.assertEquals(getText(enterButton), " tooltip text is equal of ",
                enterButtonValue);
    }

    public void placeholderCheckingInSearchField() {
        getUrl(BASE_URL);
        String actPlaceholder = "Введите название товара";
        String expPlaceholder = searchProductField.getAttribute("placeholder");
        AssertCollector.assertEquals(actPlaceholder, " Current placeholder is equal to placeholder of ",
                expPlaceholder);
        moveMouseTo(driver, searchProductField);
        elementIsClickable(searchProductField).click();
        fillInputField(searchProductField, "вафли");
        String textFromPlaceholder = searchProductField.getAttribute("value");
        AssertCollector.assertEquals(textFromPlaceholder, " Current  text from placeholder is equal to ",
                textFromPlaceholder);
    }

    public void verificationOfCategoriesDropdownInSearchField() {
        elementIsClickable(categoriesHeader).click();
        String expCategoryFromList = getText(categoryFromList);
        elementIsClickable(categoryFromList).click();
        String actCategoryFromList = getText(categoriesHeader);
        AssertCollector.assertEquals(actCategoryFromList, " Current name of category is equal to ",
                expCategoryFromList);
    }

    public void verifyLatinTextInProductInputField() {
        fillInputFieldAndPressEnterButton(searchProductField, "biscuit");
        textPresent("По вашему запросу «biscuit» ничего не найдено.");
        verifySpecialSymbolsInProductInputField();
        verifyNumbersInProductInputField();
        verifyLongStringsWithNumbersInProductInputField();
    }


    private void verifySpecialSymbolsInProductInputField() {
        String expSymbols = "~`!@#$%^dfddgdfg&*()_+?:'dfvdfg{}[];";
        fillInputFieldAndPressEnterButton(searchProductField, expSymbols);
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(expSymbols));
    }

    private void verifyNumbersInProductInputField() {
        String expNumbers = "564654";
        fillInputFieldAndPressEnterButton(searchProductField, expNumbers);
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(expNumbers));
    }

    private void verifyLongStringsWithNumbersInProductInputField() {
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(255));
        String textFromInputField = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(256));
        String textFromInputField1 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField1));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(257));
        String textFromInputField2 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField2));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(1000));
        String textFromInputField3 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField3));
        backPage();
        fillInputFieldAndPressEnterButton(searchProductField, RandomStringUtils.randomNumeric(1024));
        String textFromInputField4 = searchProductField.getAttribute("value");
        AssertCollector.assertTrue(resultsProductSearch.getText().contains(textFromInputField4));
    }

    public void verifySearchQueryWithInputTextWithCategory() {
        fillInputField(searchProductField, "суфле");
        try {
            if (elementIsVisible(geoConfirmModalWindow)) {
                elementIsClickable(acceptGeoConfirm).click();
            }
        } catch (NoSuchElementException ex) {
            ex.getMessage();
        }
        elementIsClickable(categoriesHeader).click();
        String expResult = anotherCategoryFromList.getText();
        elementIsClickable(anotherCategoryFromList).click();
        elementIsClickable(searchButton).click();
        String actResult = filterValue.getText();
        String title = driver.getTitle();
        AssertCollector.assertTrue(title.contains("суфле"));
        AssertCollector.assertEquals(actResult, " Names of categories are equal ", expResult);
    }
}
