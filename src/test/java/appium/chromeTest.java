package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import appium.driver.Driver;
public class chromeTest {
    
    public AndroidDriver driver;

  
    @Test
    public void runTest() throws Exception {
        AndroidDriver driver =  Driver.getAndroidDriver("chrome");
        driver.get("https://amazon.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        //search iphone
        ////android.view.View[@content-desc="Clear search keywords"]
       
    }

    @After
    public void tearDown() throws Exception {
       Driver.quitDriver();
    }
}
