package androidTests;

import org.openqa.selenium.DeviceRotation;
import pages.EntryPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTestRunner {
    @Test
    public void wifiSettingsName() {
        driver.setClipboardText("MeryWiFi");
        new EntryPage(driver)
                .clickPreferences()
                .clickPreferenceDependencies()
                .clickWiFiCheckbox()
                .clickWiFiSettings()
                .enterDataIntoInputField(driver.getClipboardText())
                .clickOkButton();
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    @Test
    public void longPressGesture() {
        RemoteWebElement peopleNamesButton = new EntryPage(driver)
                .clickViews()
                .clickEnableLists()
                .clickCustomerAdapter()
                .peopleNameButtonFind();

        longPressGesture(peopleNamesButton);
        String actualResult = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(actualResult, "Sample menu");
    }

    @Test
    public void scrollTest() {
        new EntryPage(driver)
                .clickViews();
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }

    @Test
    public void swipeTest() {
        new EntryPage(driver)
                .clickViews()
                .clickGallery();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        RemoteWebElement widgetImage = (RemoteWebElement) driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(widgetImage.getAttribute("focusable"), "true");
        swipeAction(widgetImage, "left");
        Assert.assertEquals(widgetImage.getAttribute("focusable"), "false");
    }

    @Test
    public void DragDropTest() throws InterruptedException {
        new EntryPage(driver).clickViews().clickDragAndDropPage();
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
