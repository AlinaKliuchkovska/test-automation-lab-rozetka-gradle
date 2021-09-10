package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private static final PropertiesReader propertiesReader = new PropertiesReader();

    public static void setDriver() {
        chromedriver().setup();
        driverPool.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        driverPool.get().manage().window().maximize();
        return driverPool.get();
    }

    public static void getURL() {
        getDriver().get(propertiesReader.getURL());
    }

    public static void closeBrowser() {
        driverPool.get().close();
        driverPool.remove();
    }
}