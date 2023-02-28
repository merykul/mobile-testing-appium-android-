package calculator;

import base.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePO{

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")
    private WebElement one;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")
    private WebElement two;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")
    private WebElement three;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_04")
    private WebElement four;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")
    private WebElement five;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")
    private WebElement six;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")
    private WebElement seven;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")
    private WebElement zero;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")
    private WebElement multiple;

    @FindBy(id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")
    private WebElement equals;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"0 Calculation result\"]")
    private WebElement result;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickZero() {
        zero.click();
        return this;
    }

    public MainPage clickSeven() {
        seven.click();
        return this;
    }

    public MainPage clickEquals() {
        equals.click();
        return this;
    }

    public MainPage clickMultiple() {
        multiple.click();
        return this;
    }

    public String getResult() {
        return result.getText();
    }
}
