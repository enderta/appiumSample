package appium.step_definitions;

import java.net.MalformedURLException;
import appium.driver.Driver;
import io.cucumber.java.Before;
import io.cucumber.messages.types.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;


public class Hooks {
   
  

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }

   
}
