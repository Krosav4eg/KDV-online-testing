package KDV_business_logic.pages.CategoryPage;

import Core.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Core.utils.AssertCollector;

import static Core.utils.Constants.ABOUT_PAGE_URL;
import static Core.utils.Constants.BASE_URL;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    //========================Category PAGE=============================================
    @FindBy(css = "[alt='Конфеты']")
    private WebElement candyLink;

    @FindBy(css = ".breadcrumbs")
    private WebElement breadcrumbsTxt;

    @FindBy(css = "h1.title")
    private WebElement headerTxt;

    @FindBy(css = " [title='Список']")
    private WebElement listBtn;

    @FindBy(css = "[title='Сетка']")
    private WebElement gridBtn;

    @FindBy(css = "div.columns-layout__aside > div > div:nth-child(1) a")
    private WebElement existBtn;

    @FindBy(css = ".filter__group_active")
    private WebElement activeFilter;

    @FindBy(css = "[title='Удалить позицию']")
    private WebElement deletePositionBtn;

    @FindBy(css = ".filter__group_active a.link")
    private WebElement deletePositionLink;

    @FindBy(css = ".columns-layout__aside")
    private WebElement leftSideNavigateTxt;

    @FindBy(css = ".toolbar-sort a.toolbar-select__direction")
    private WebElement sortBtn;

    @FindBy(css = ".toolbar-select__list a:nth-child(3)")
    private WebElement sortPriceLink;

    @FindBy(css = ".toolbar-select__list a:nth-child(2)")
    private WebElement sortDefaultLink;

    @FindBy(css = "div.yt-products-container.clearfix > div > div:nth-child(1)")
    private WebElement categoryElementTxt;

    @FindBy(css = ".toolbar-select__value")
    private WebElement dropDownMenu;

    @FindBy(css = "div.yt-products-container.clearfix > div > div:nth-child(1) .product-total-price")
    private WebElement priceTxt;

    @FindBy(css = ".header-bottom-left__btn-catalog-wrapper")
    private WebElement catalogMainList;

    @FindBy(css = ".header-bottom-left__btn-catalog-wrapper [alt='Конфеты']")
    private WebElement candyCategoryMainLink;

    @FindBy(css = "#select-search-wrapper div")
    private WebElement selectCategorySearchBtn;

    @FindBy(css = "#search_mini_form button")
    private WebElement searchBtn;

    private void selectCategorySideBar() {
        driver.navigate().to(BASE_URL);
        driver.navigate().refresh();
        clickElementByJS(driver, candyLink);
    }

    public void selectFromCategoryDropDown() {
        driver.navigate().refresh();
        elementFluentWaitVisibility(selectCategorySearchBtn).click();
        CallJS("jQuery(\"#inputs-search-table div.search-category-dropdown__list div:contains('Конфеты')\").click()");
        elementFluentWaitVisibility(searchBtn).click();
        AssertCollector.assertTrue(headerTxt.getText().contains("Конфеты"), "required header  is present");
        driver.navigate().to(ABOUT_PAGE_URL);
        elementFluentWaitVisibility(catalogMainList).click();
        elementFluentWaitVisibility(candyCategoryMainLink).click();
        AssertCollector.assertTrue(headerTxt.getText().contains("Конфеты"), "required header  is present");
    }

    public void breadCrumbs() {
        selectCategorySideBar();
        AssertCollector.assertTrue(breadcrumbsTxt.getText().contains("Конфеты"),
                "required bread Crumbs  is present");
    }

    public void commodityGridList() {
        selectCategorySideBar();
        elementFluentWaitVisibility(listBtn).click();
        AssertCollector.assertTrue(listBtn.getAttribute("class").contains("list-mode__item_active"),
                "required list  is active");
        elementFluentWaitVisibility(gridBtn).click();
        AssertCollector.assertTrue(gridBtn.getAttribute("class").contains("list-mode__item_active"),
                "required grid  is active");
    }

    //TODO bug absence signatures "Статус" "В наличии"
    public void checkBox() {
        selectCategorySideBar();
        elementFluentWaitVisibility(existBtn).click();
        AssertCollector.assertTrue(getText(activeFilter).
                contains("Выбранные параметры"), "text 'Выбранные параметры' is present");
        AssertCollector.assertTrue(getText(activeFilter).contains("Статус"), "text 'Статус' is present");
        AssertCollector.assertTrue(getText(activeFilter).contains("в наличии"), "text 'В наличии' is present");
        AssertCollector.assertTrue(elementIsVisible(deletePositionBtn), "checkbox delete is present");
        AssertCollector.assertTrue(elementIsVisible(existBtn), "checkbox is present");
        AssertCollector.assertTrue(getText(leftSideNavigateTxt).
                contains("Выбранные параметры"), "all condition deleted");
        elementFluentWaitVisibility(deletePositionBtn).click();
        elementFluentWaitVisibility(existBtn).click();
        elementFluentWaitVisibility(deletePositionLink).click();
        AssertCollector.assertTrue(!getText(leftSideNavigateTxt).contains("Выбранные параметры"),
                "all condition deleted");
    }

    public void sortFilterDefault() {
        selectCategorySideBar();
        moveMouseTo(driver, dropDownMenu);
        elementFluentWaitVisibility(sortDefaultLink).click();
        moveMouseTo(driver, dropDownMenu);
        elementFluentWaitVisibility(sortDefaultLink).click();
        String firstElement = getText(categoryElementTxt);
        elementFluentWaitVisibility(sortBtn).click();
        AssertCollector.assertTrue(!firstElement.contains(getText(categoryElementTxt)), "price filter is active");
    }

    public void sortFilterPrice() {
        selectCategorySideBar();
        moveMouseTo(driver, dropDownMenu);
        Double firstValue = Double.valueOf(getText(priceTxt).replaceAll("[^0-9]", ""));
        elementFluentWaitVisibility(sortPriceLink).click();
        elementFluentWaitVisibility(sortBtn).click();
        Double lastValue = Double.valueOf(getText(priceTxt).replaceAll("[^0-9]", ""));
        AssertCollector.assertTrue(lastValue > firstValue, "Asc filter is active");
        firstValue = Double.valueOf(getText(priceTxt).replaceAll("[^0-9]", ""));
        moveMouseTo(driver, dropDownMenu);
        elementFluentWaitVisibility(sortPriceLink).click();
        lastValue = Double.valueOf(getText(priceTxt).replaceAll("[^0-9]", ""));
        AssertCollector.assertTrue(lastValue < firstValue, "Asc filter is active");
    }
}
