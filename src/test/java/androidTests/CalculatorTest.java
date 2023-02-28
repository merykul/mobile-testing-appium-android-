package androidTests;

import calculator.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTestRunnerForCalculator;

public class CalculatorTest extends BaseTestRunnerForCalculator{

    @Test
    public void multipleOperation() {
        String result = new MainPage(driver)
                .clickZero()
                .clickMultiple()
                .clickSeven()
                .clickEquals()
                .getResult();
        Assert.assertEquals(result, "0");
    }
}

