package androidTests;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTestRunner {

    @Test
    public void wifiSettingsName() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        String alert = driver.findElement(AppiumBy.accessibilityId("android:id/alertTitle")).getText();
        Assert.assertEquals(alert, "WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("MeryWiFi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }
}
