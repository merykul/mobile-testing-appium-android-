package apps_pages;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewsPage extends BasePO{

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
    private WebElement enableLists;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Drag and Drop\"]")
    private WebElement dragAndDrop;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Gallery\"]")
    private WebElement gallery;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"WebView\"]")
    private WebElement webView;

    public ViewsPage(WebDriver driver) {
        super(driver);
    }

    public EnableListsPage clickEnableLists() {
        enableLists.click();
        return new EnableListsPage(driver);
    }

    public DragAndDropPage clickDragAndDropPage() {
        dragAndDrop.click();
        return new DragAndDropPage(driver);
    }

    public GalleryPage clickGallery() {
        gallery.click();
        return new GalleryPage(driver);
    }

    public WebViewPage clickWebView() {
        webView.click();
        return new WebViewPage(driver);
    }
}
