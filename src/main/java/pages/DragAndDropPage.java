package pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePO{

    @FindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement dragResult;

    @FindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement dragDrop1;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDragResult() {
        return dragResult;
    }

    public WebElement getDragDrop1() {
        return dragDrop1;
    }
}
