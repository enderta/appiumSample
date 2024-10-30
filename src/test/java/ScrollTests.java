import appium.Utils;
import appium.driver.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class ScrollTests {
    @Test
    public void testScroll() throws MalformedURLException, InterruptedException {
        AndroidDriver driver =   Driver.getAndroidDriver("android");
        Thread.sleep(2000);
        Utils.scrollToElement(driver, "secret_sauce");
        Utils.tapElement(driver, driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"standard_user\")")));
        Thread.sleep(2000);
        Utils.scrollToElement(driver, "Username");
        Thread.sleep(2000);
        Utils.tapElement(driver, driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")")));
        Thread.sleep(2000);
        Utils.scrollToElement(driver,"$15.99");


    }
}
