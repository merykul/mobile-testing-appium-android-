package androidTests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTestRunner {

    @Test
    public void wifiSettingsName() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        String alert = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alert, "WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("MeryWiFi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Test
    public void longPressGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        RemoteWebElement peopleNamesButton = (RemoteWebElement) driver
                .findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressGesture(peopleNamesButton);
        String actualResult = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(actualResult, "Sample menu");
    }

    @Test
    public void scrollTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }

    @Test
    public void swipeTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        RemoteWebElement widgetImage = (RemoteWebElement) driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(widgetImage.getAttribute("focusable"), "true");
        swipeAction(widgetImage, "left");
        Assert.assertEquals(widgetImage.getAttribute("focusable"), "false");
    }

    @Test
    public void DragDropTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 448,
                "endY", 398
        ));
        WebElement droppedConfirm = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertEquals(droppedConfirm.getText(), "Dropped!");
    }
}
