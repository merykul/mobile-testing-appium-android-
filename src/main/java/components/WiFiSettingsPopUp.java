package components;

import apps_pages.PreferenceDependencies;
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

    public WiFiSettingsPopUp(WebDriver driver) {
        super(driver);
    }

    public WiFiSettingsPopUp enterDataIntoInputField(String name) {
        enterField.sendKeys(name);
        return this;
    }

    public PreferenceDependencies clickOkButton() {
        okButton.click();
        return new PreferenceDependencies(driver);
    }

    public PreferenceDependencies clickCancelButton() {
        cancelButton.click();
        return new PreferenceDependencies(driver);
    }
}
