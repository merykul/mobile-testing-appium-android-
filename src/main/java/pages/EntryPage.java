package pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryPage extends BasePO{
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    private WebElement views;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Preference\"]")
    private WebElement preferences;

    public EntryPage(WebDriver driver) {
        super(driver);
    }

    public ViewsPage clickViews() {
        views.click();
        return new ViewsPage(driver);
    }

    public PreferencesPage clickPreferences() {
        preferences.click();
        return new PreferencesPage(driver);
    }
}
