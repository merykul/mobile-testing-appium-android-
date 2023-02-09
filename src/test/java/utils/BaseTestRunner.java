package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestRunner {
    protected AppiumDriver driver;

    @BeforeSuite
    public void startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung");
        capabilities.setCapability("udid", "adb-R58R62JC02R-SndPFB._adb-tls-connect._tcp");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");

        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);

        System.out.println("Application started");
    }
}
