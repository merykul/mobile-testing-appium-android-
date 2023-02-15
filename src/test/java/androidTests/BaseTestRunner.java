package androidTests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPressGesture(RemoteWebElement element) {
        driver.executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", (element).getId(), "duration", 2000));
    }

    public void scrollTillTheEnd() {
        boolean canScrollMore;
        do {
            canScrollMore = (boolean) ((JavascriptExecutor) driver)
                    .executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "down",
                            "percent", 3.0
                    ));
        } while (canScrollMore);
    }

    public void swipeAction(RemoteWebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", element.getId(),
                "direction", direction,
                "percent", 0.75 ));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
