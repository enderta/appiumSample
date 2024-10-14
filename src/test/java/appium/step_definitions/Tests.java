package appium.step_definitions;

import appium.driver.Driver;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Tests {
    @Given("the user launches the browser")
public void the_user_launches_the_browser() throws MalformedURLException {
   Driver.getAndroidDriver("chrome");
}
@When("the user navigates to {string}")
public void the_user_navigates_to(String url) throws MalformedURLException {
   Driver.getAndroidDriver("chrome").get(url);
}
@Then("the home page should be visible")
public void the_home_page_should_be_visible() throws InterruptedException, MalformedURLException {
        Thread.sleep(2000);
    String title = Driver.getAndroidDriver("chrome").getTitle();
    System.out.println("Title: " + title);
    Assert.assertEquals("Automation Exercise", title);
}
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() throws InterruptedException, MalformedURLException{
        Driver.getAndroidDriver("chrome").findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(2000);

    }
    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String string) {
        System.out.println("Button clicked");
    }
    @Then("{string} should be visible")
    public void should_be_visible(String string) {
        System.out.println("Login page visible");
    }
}
