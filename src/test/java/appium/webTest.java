package appium;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;


import appium.driver.Driver;


public class webTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       
     WebDriver driver =  Driver.getWebDriver("chrome_web");
     driver.get("https://amazon.com");
     Thread.sleep(5000);
     System.out.println(driver.getTitle());
     Driver.quitDriver();
    }
}
