package appium.step_definitions;

import appium.driver.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {
    @Before
    public void setUp() {
        //Driver.getWebDriver("chrome_web");
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
