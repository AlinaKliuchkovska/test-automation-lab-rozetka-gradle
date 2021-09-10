package rozetkatests;

import businessobject.CartBO;
import businessobject.CartVerifier;
import model.RozetkaFilter;
import model.RozetkaFilters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.XMLToObject;

public class AddToCartTests extends BaseTest {
    private static final int EXPECTED_NUMBER_OF_ITEMS_IN_CART = 1;
    private static final int MAX_SUM = 500000;

    @DataProvider(name = "filter")
    public Object[][] filter() {
        RozetkaFilters rozetkaFilters = XMLToObject.readXMLToObject();
        RozetkaFilter[][] rozetkaFilterArray = new RozetkaFilter[rozetkaFilters.getRozetkaFilters().size()][1];
        for (int i = 0; i < rozetkaFilters.getRozetkaFilters().size(); i++) {
            rozetkaFilterArray[i][0] = rozetkaFilters.getRozetkaFilters().get(i);
        }
        return rozetkaFilterArray;
    }

    @Test(dataProvider = "filter")
    public void checkThatAddingToCartWorksCorrect(RozetkaFilter rozetkaFilter) {
        CartBO cartBO = new CartBO();
        CartVerifier cartVerifier = new CartVerifier();
        cartBO.addToCart(rozetkaFilter);
        cartVerifier.verifyThatNumberOfItemsInCartIs(EXPECTED_NUMBER_OF_ITEMS_IN_CART);
        cartVerifier.verifyThatTotalSumInCartLessThan(MAX_SUM);
    }
}