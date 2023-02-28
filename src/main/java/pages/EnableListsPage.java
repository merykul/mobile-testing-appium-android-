package pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnableListsPage extends BasePO{
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")
    private WebElement customerAdapter;

    public EnableListsPage(WebDriver driver) {
        super(driver);
    }

    public CostumerAdapterPage clickCustomerAdapter() {
        customerAdapter.click();
        return new CostumerAdapterPage(driver);
    }
}
