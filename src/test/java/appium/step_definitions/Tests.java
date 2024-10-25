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
   Driver.getAndroidDriver("chrome").findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
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
    public void the_user_clicks_on_button(String string) throws MalformedURLException {
       Driver.getAndroidDriver("chrome").findElement(By.xpath("//a[@href='/login']")).click();
       
    }
    @Then("{string} should be visible")
    public void should_be_visible(String string) throws MalformedURLException {
        Driver.getAndroidDriver("chrome").findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
    }

    @When("enters invalid email and password")
public void enters_invalid_email_and_password() throws MalformedURLException {
    Driver.getAndroidDriver("chrome").findElement(By.xpath("//input[@name='email']")).sendKeys("invalid@example.com");
    Driver.getAndroidDriver("chrome").findElement(By.xpath("//input[@name='password']")).sendKeys("invalidpassword");
}
@When("clicks on {string} button")
public void clicks_on_button(String string) throws MalformedURLException {
    Driver.getAndroidDriver("chrome").findElement(By.xpath("//button[@type='submit']")).click();
}
@Then("{string} error message should be displayed")
public void error_message_should_be_displayed(String string) throws MalformedURLException {
    Driver.getAndroidDriver("chrome").findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
    Assert.assertEquals("Your email or password is incorrect!", 
    Driver.getAndroidDriver("chrome").findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText());
    System.out.println("end of test");
}





}
