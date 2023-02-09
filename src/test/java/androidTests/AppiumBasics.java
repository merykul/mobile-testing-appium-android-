package androidTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics{

    @Test
    public void appiumTest() throws MalformedURLException {
//         Automated start of Appium server [not working, running onto "The local appium server has not been started" error]
//        AppiumDriverLocalService service = new AppiumServiceBuilder()
//                .withAppiumJS(new File("C://Users//User//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
//                .build();
//        service.start();

        // Capabilities for Samsung Galaxy A22 and App
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Samsung");
        options.setCapability("udid", "adb-R58R62JC02R-SndPFB._adb-tls-connect._tcp");
        options.setCapability("platformName", "Android");
        options.setCapability("platformVersion", "12");
        options.setApp("C://Users//User//IdeaProjects//appium_android//src//test//java//resourses//ApiDemos-debug.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, options);
        driver.quit();
    }
}
