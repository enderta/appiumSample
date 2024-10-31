import appium.Utils;
import appium.driver.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.Point;
import java.net.MalformedURLException;

public class ScrollTests {
    @Test
    public void testScroll() throws MalformedURLException, InterruptedException {
        AndroidDriver driver =   Driver.getAndroidDriver("android");
        Thread.sleep(2000);
        Utils.scrollToEnd(driver);
        Utils.scrollToTop(driver);
        Utils.scrollToElement(driver, "secret_sauce");
        Utils.tapElement(driver, driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"standard_user\")")));
        Thread.sleep(2000);
        Utils.scrollToElement(driver, "Username");
        Thread.sleep(2000);
        Utils.tapElement(driver, driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")")));
        Thread.sleep(2000);
        Utils.scrollToElement(driver,"$15.99");
        Point start = new Point(0, 585);
        Point end = new Point (571, 574);
        Utils.swipe(driver, start, end);
        WebElement logout = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGOUT\"]"));
        Utils.tapElement(driver, logout);
String loginText = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")")).getText();
        Assertions.assertEquals("LOGIN", loginText);
        driver.quit();

    }
}
