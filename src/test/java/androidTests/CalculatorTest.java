package androidTests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTestRunner;

import java.net.MalformedURLException;

public class CalculatorTest extends BaseTestRunner {
    static AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        startApp();
    }

    @Test
    public static void addOperation() {
        WebElement seven = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));
        WebElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement zero = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00"));
        WebElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));

         seven.click();;
         plus.click();
         zero.click();
         equals.click();

       WebElement result = driver.findElement(By.className("android.view.ViewGroup"));
       String res = result.getText();
       String expectedResult = "7";
       Assert.assertEquals(res, expectedResult);
    }
}

