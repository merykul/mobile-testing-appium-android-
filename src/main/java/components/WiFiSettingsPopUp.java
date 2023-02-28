package components;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.PreferenceDependenciesPage;
import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WiFiSettingsPopUp extends BasePO{

    @FindBy(id = "android:id/edit")
    private WebElement enterField;

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

    @FindBy(id = "android:id/button2")
    private WebElement cancelButton;

    @FindBy()
    private WebElement popUpTitle;

    public WiFiSettingsPopUp(WebDriver driver) {
        super(driver);
    }

    public WiFiSettingsPopUp enterDataIntoInputField(String name) {
        enterField.sendKeys(name);
        return this;
    }

    public PreferenceDependenciesPage clickOkButton() {
        okButton.click();
        return new PreferenceDependenciesPage(driver);
    }

    public PreferenceDependenciesPage clickCancelButton() {
        cancelButton.click();
        return new PreferenceDependenciesPage(driver);
    }

    public String getPopUpTitle() {
        return popUpTitle.getText();
    }
}
