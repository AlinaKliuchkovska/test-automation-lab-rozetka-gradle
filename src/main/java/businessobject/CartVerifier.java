package businessobject;

import rozetkapages.CartPopup;
import utils.DriverManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartVerifier {
    private final CartPopup cartPopup = new CartPopup(DriverManager.getDriver());

    public void verifyThatNumberOfItemsInCartIs(int expectedNumberOfItemsInCart){
        assertEquals(expectedNumberOfItemsInCart, cartPopup.getNumberOfProductsInCart());
    }

    public void verifyThatTotalSumInCartLessThan(int maxSum){
        assertTrue(cartPopup.getTotalSum() < maxSum);
    }
}