package pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class CostumerAdapterPage extends BasePO{
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]")
    private WebElement peopleNames;

    @FindBy(id = "android:id/title")
    private WebElement sampleMenuPopUp;

    public CostumerAdapterPage(WebDriver driver) {
        super(driver);
    }

    public RemoteWebElement peopleNameButtonFind() {
        peopleNames.isEnabled();
        return new RemoteWebElement();
    }

}
