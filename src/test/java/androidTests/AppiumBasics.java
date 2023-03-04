package androidTests;

import org.openqa.selenium.DeviceRotation;
import pages.DragAndDropPage;
import pages.EntryPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement peopleNamesButton = new EntryPage(driver)
                .clickViews()
                .clickEnableLists()
                .clickCustomerAdapter()
                .getPeopleNameButton();

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
        swipeAction(photosPage.getFirstPhotoWidget(), "left");
        String focusableAfter = photosPage.isFocusableFirst();
        Assert.assertEquals(focusableAfter, "false");
    }

    @Test
    public void DragDropTest() {
        DragAndDropPage dragAndDropPage = new EntryPage(driver)
                .clickViews()
                .clickDragAndDropPage();
        dragAction(dragAndDropPage.getDragDrop1() , 448, 398);
        Assert.assertEquals(dragAndDropPage.getDragResult().getText(), "Dropped!");
    }
}
