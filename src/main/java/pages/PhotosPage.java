package pages;

import base.BasePO;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class PhotosPage extends BasePO{

    @FindBy(xpath = "//android.widget.ImageView[@index='0']")
    private WebElement firstPhotoWidget;

    @FindBy(id = "00000000-0000-0038-ffff-ffff00000047")
    private WebElement secondPhotoWidget;

    public PhotosPage(WebDriver driver) {
        super(driver);
    }

    public void swipeAction(RemoteWebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", element.getId(),
                "direction", direction,
                "percent", 0.75 ));
    }

    public WebElement getFirstPhotoWidget() {
        return firstPhotoWidget;
    }

    public String isFocusableFirst() {
        sleep(2);
        return firstPhotoWidget.getAttribute("focusable");
    }
}
