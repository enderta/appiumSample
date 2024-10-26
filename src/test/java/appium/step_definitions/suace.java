package appium.step_definitions;

import java.net.MalformedURLException;

import org.junit.Assert;
import appium.driver.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Basic;

public class suace {
   
    private AndroidDriver driver;
    Basic basic = new Basic();

    public suace() throws MalformedURLException, InterruptedException {
        this.driver = Driver.getAndroidDriver("android");
        Thread.sleep(2000);

    }
    @Given("the user is on the login page")
public void the_user_is_on_the_login_page() {
   System.out.println("login page");
}
@When("the user logs in with username {string} and password {string}")
public void the_user_logs_in_with_username_and_password(String string, String string2) throws InterruptedException {
    basic.login(string, string2);
    Thread.sleep(2000);
}
@Then("the user should see the products page")
public void the_user_should_see_the_products_page() {
    System.out.println("products");
}
@Then("the user should see an error message {string}")
public void the_user_should_see_an_error_message(String string) {
   String message= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sorry, this user has been locked out.']")).getText();
Assert.assertEquals(string, message);
System.out.println("end of test");

}

}
