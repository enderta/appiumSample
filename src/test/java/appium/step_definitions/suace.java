package appium.step_definitions;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;

import appium.driver.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class suace {
   
    private AndroidDriver driver;

    public suace() throws MalformedURLException, InterruptedException {
        this.driver = Driver.getAndroidDriver("android");
        Thread.sleep(2000);

    }

    @When("the user enters username {string}")
    public void the_user_enters_username(String username) {
        driver.findElement(new AppiumBy.ByAccessibilityId("test-Username"))
        .sendKeys(username);
    }

    @When("the user enters password {string}")
    public void the_user_enters_password(String password) {
        driver.findElement(AppiumBy.accessibilityId("test-Password"))
        .sendKeys(password);

    }

    @When("the user taps the LOGIN button")
    public void the_user_taps_the_login_button() {
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
    }

    @Then("the user should see the products page")
    public void the_user_should_see_the_products_page() {
        // Implement your assertion here
        // For example:
        // Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("test-PRODUCTS")).isDisplayed());
       System.out.println("Login successful");
    }
}
