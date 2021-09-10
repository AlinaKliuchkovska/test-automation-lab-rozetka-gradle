package businessobject;

import model.RozetkaFilter;
import rozetkapages.HomePage;
import rozetkapages.ProductGroupPage;
import rozetkapages.ProductPage;
import utils.DriverManager;

public class CartBO {
    private final HomePage homePage = new HomePage(DriverManager.getDriver());
    private final ProductPage productPage = new ProductPage(DriverManager.getDriver());
    private final ProductGroupPage productGroupPage = new ProductGroupPage(DriverManager.getDriver());

    public void addToCart(RozetkaFilter rozetkaFilter) {
        homePage.enterKeyWordToSearchInput(rozetkaFilter.getGroup());
        productGroupPage.enterBrandToBrandSearchInput(rozetkaFilter.getBrandName())
                .checkBrandCheckbox(rozetkaFilter.getBrandName()).checkReadyToShipCheckbox()
                .selectSortingType(rozetkaFilter.getSortingType()).clickOnFirstProduct();
        productPage.clickOnAddToCartButton();
    }
}