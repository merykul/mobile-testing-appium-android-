package apps_pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferencesPage extends BasePO{

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    private WebElement preferenceDependencies;

    public PreferencesPage(WebDriver driver) {
        super(driver);
    }

    public PreferenceDependencies clickPreferenceDependencies() {
        preferenceDependencies.click();
        return new PreferenceDependencies(driver);
    }
}
