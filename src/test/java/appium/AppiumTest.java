package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import appium.driver.Driver;

public class AppiumTest {
    public static void main(String[] args) throws Exception {
      AndroidDriver driver =   Driver.getAndroidDriver("android");
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        Thread.sleep(2000);
        System.out.println("Login successful");
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        Thread.sleep(2000);
        // Your test code here

        Driver.quitDriver();
    }
}