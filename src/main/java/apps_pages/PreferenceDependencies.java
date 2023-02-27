package apps_pages;

import base.BasePO;
import components.WiFiSettingsPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferenceDependencies extends BasePO{

    @FindBy(id = "android:id/checkbox")
    private WebElement wiFiCheckbox;

    @FindBy(id = "00000000-0000-003c-ffff-ffff00000048")
    private WebElement wiFiSettings;

    public PreferenceDependencies(WebDriver driver) {
        super(driver);
    }

    public PreferenceDependencies clickWiFiCheckbox() {
        wiFiCheckbox.click();
        return this;
    }

    public WiFiSettingsPopUp clickWiFiSettings() {
        wiFiSettings.click();
        return new WiFiSettingsPopUp(driver);
    }
}
