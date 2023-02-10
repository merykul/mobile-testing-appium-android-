package androidTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestRunner {
    public AndroidDriver driver;

    @BeforeMethod
    public void configureAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Samsung");
        options.setCapability("udid", "adb-R58R62JC02R-SndPFB._adb-tls-connect._tcp");
        options.setCapability("platformName", "Android");
        options.setCapability("platformVersion", "12");
        options.setApp("C://Users//User//IdeaProjects//appium_android//src//test//java//resourses//ApiDemos-debug.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, options);
    }

    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }
}
