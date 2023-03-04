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
import pages.PhotosPage;
import utils.BaseTestRunner;

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
                .clickViews()
                .scrollIntoView("WebView");
    }

    @Test
    public void swipeTest() {
        PhotosPage photosPage = new EntryPage(driver)
                .clickViews()
                .clickGallery()
                .clickPhotos();
        String focusableFirst = photosPage.isFocusableFirst();
        Assert.assertEquals(focusableFirst, "true");
        swipeAction((RemoteWebElement) photosPage.getFirstPhotoWidget(), "left");
        Assert.assertEquals(focusableFirst, "false");
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
