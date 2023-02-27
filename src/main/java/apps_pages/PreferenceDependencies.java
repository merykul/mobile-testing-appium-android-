package apps_pages;

import base.BasePO;
import components.WiFiSettingsPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferenceDependencies extends BasePO{

    @FindBy(id = "android:id/checkbox")
    private WebElement wiFiCheckbox;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
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
