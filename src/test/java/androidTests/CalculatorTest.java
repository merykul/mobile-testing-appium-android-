package androidTests;

import calculator.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    static AppiumDriver driver;

    @BeforeMethod
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung");
        capabilities.setCapability("udid", "adb-R58R62JC02R-SndPFB._adb-tls-connect._tcp");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);
    }

    @Test
    public static void addOperation() {
        String result = new MainPage(driver)
                .clickZero()
                .clickMultiple()
                .clickSeven()
                .clickEquals()
                .getResult();
        Assert.assertEquals(result, "0");
    }
}

