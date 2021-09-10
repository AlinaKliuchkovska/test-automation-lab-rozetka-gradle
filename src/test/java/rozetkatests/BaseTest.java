package rozetkatests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

public abstract class BaseTest {
    @BeforeClass(alwaysRun=true)

    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver();
        DriverManager.getURL();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeBrowser();
    }
}