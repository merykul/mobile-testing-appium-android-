package pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GalleryPage extends BasePO{

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Photos\"]")
    private WebElement photos;

    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public PhotosPage clickPhotos() {
        photos.click();
        return new PhotosPage(driver);
    }
}
