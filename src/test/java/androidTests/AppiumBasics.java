package androidTests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTestRunner {

    @Test
    public void appiumTest() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

    }
}
