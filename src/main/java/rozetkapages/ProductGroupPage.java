package rozetkapages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import rozetkapages.element.CheckBox;
import rozetkapages.element.CustomSelect;
import rozetkapages.element.Product;
import rozetkapages.element.TextInput;

import java.util.NoSuchElementException;

import static org.openqa.selenium.Keys.ENTER;


public class ProductGroupPage extends BasePage {
    public ProductGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[contains(@class, 'ng-star-inserted')]")
    private CustomSelect sortingTypeSelect;

    @FindBy(xpath = "//a[contains(@href,'gotovo-k-otpravke')]/ancestor::li")
    private CheckBox readyToShipCheckbox;

    @FindBy(xpath = "//button[@class='button button_type_link sidebar-alphabet__toggle']//preceding::input[@class='sidebar-search__input ng-untouched ng-pristine ng-valid']")
    private TextInput brandSearchInput;

    @FindBy(css = ".goods-tile__heading")
    private Product firstProduct;

    public ProductGroupPage enterBrandToBrandSearchInput(String brandName) {
        waitForVisibilityOfElement(brandSearchInput);
        brandSearchInput.sendKeys(brandName, ENTER);
        return this;
    }

    public ProductGroupPage selectSortingType(String sortingType) {
        waitForElementToBeClickable(sortingTypeSelect);
        sortingTypeSelect.selectByVisibleText(sortingType);
        return this;
    }

    public ProductGroupPage clickOnFirstProduct() {
        waitForElementToBeClickable(firstProduct);
        firstProduct.click();
        return this;
    }

    public ProductGroupPage checkReadyToShipCheckbox() {
        try {
            waitForElementToBeClickable(readyToShipCheckbox);
            readyToShipCheckbox.setChecked(true);
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Checkbox is not enabled");
        }
        return this;
    }

    public ProductGroupPage checkBrandCheckbox(String brandName){
        waitForElementToBeClickable(driver.findElement(By.xpath(String.format("//input[@id='%s']//parent::a", brandName))));
        driver.findElement(By.xpath(String.format("//input[@id='%s']//parent::a", brandName))).click();
        return this;
    }
}