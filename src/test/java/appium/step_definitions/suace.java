package appium.step_definitions;

import java.net.MalformedURLException;

import appium.Utils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

import org.junit.Assert;
import appium.driver.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.Basic;

public class suace {

    private AndroidDriver driver;
    Basic basic = new Basic();

    public suace() throws MalformedURLException {
        this.driver = Driver.getAndroidDriver("android");
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       System.out.println("login page");
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) throws InterruptedException {
        basic.login(username, password);
        Thread.sleep(2000);
    }

    @Then("the user should see the products page")
    public void the_user_should_see_the_products_page() {
        System.out.println("products");
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedMessage) {
       String actualMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sorry, this user has been locked out.']")).getText();
       Assert.assertEquals(expectedMessage, actualMessage);
       System.out.println("end of test");
    }

    @Given("the user has logged in successfully")
    public void the_user_has_logged_in_successfully() throws InterruptedException {
       basic.login("standard_user", "secret_sauce");
       Thread.sleep(2000);
    }

    @When("the user selects the product {string}")
    public void the_user_selects_the_product(String prodName) throws InterruptedException {
      driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text='" + prodName + "']")).click();
      Thread.sleep(2000);
    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() throws InterruptedException {
       basic.addProductToCart();
    }

    @Then("the cart badge should display {string}")
    public void the_cart_badge_should_display(String expectedCount) throws InterruptedException {
       String actualCount = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]")).getText();
       Assert.assertEquals(expectedCount, actualCount);
       Thread.sleep(2000);
    }

    @When("the user removes the product from the cart")
    public void the_user_removes_the_product_from_the_cart() throws InterruptedException {
       basic.removeFromCart();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() throws InterruptedException {
        // Note: This method needs to be implemented properly
        String cartNum = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).getText();
        Thread.sleep(2000);
        Assert.assertEquals("", cartNum);
        System.out.println("cart: "+cartNum);
    }


@Given("the user has items in the cart")
public void the_user_has_items_in_the_cart() throws InterruptedException {
   String prodName="Sauce Labs Backpack";
   driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text='" + prodName + "']")).click();
   Thread.sleep(2000);
   basic.addProductToCart();

}
@When("the user proceeds to checkout")
public void the_user_proceeds_to_checkout() throws InterruptedException {
   driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
   Thread.sleep(2000);
    Point start = new Point(104, 837);
    Point end = new Point(8, 835);
    Utils.swipe(driver, start, end);
    Thread.sleep(2000);
   driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")).click();
   Thread.sleep(2000);


}

    @When("completes the purchase with:")
    public void completesPurchaseWith(Map<String, String> purchaseDetails) throws InterruptedException {
        String firstName = purchaseDetails.get("First Name");
        String lastName = purchaseDetails.get("Last Name");
        String zipCode = purchaseDetails.get("Zip Code");

        driver.findElement(AppiumBy.accessibilityId("test-First Name")).sendKeys(firstName);
        driver.findElement(AppiumBy.accessibilityId("test-Last Name")).sendKeys(lastName);
        driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code")).sendKeys(zipCode);

        // Tap the continue button


        // Perform a swipe on the element with the specified text

    }
    // suace.java
    @Then("the user should see the order confirmation page")
    public void the_user_should_see_the_order_confirmation_page() throws InterruptedException {
        Thread.sleep(2000);
        WebElement continueButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUE\"]"));
        Utils.tapElement(driver, continueButton);
        Thread.sleep(2000);

    }
}