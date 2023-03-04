package pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GalleryPage extends BasePO{

    @FindBy(id = "00000000-0000-0037-ffff-ffff00000038")
    private WebElement photos;

    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public PhotosPage clickPhotos() {
        photos.click();
        return new PhotosPage(driver);
    }
}
