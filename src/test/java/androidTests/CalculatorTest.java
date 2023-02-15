package androidTests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement seven = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));
        WebElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement zero = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00"));
        WebElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        seven.click();
        plus.click();
        zero.click();
        equals.click();
        WebElement result = driver.findElement(By.className("android.view.ViewGroup"));
        String res = result.getText();
        String expectedResult = "7";
        Assert.assertEquals(res, expectedResult);
    }
}

