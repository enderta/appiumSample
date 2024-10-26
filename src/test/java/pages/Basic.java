package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.driver.Driver;

import java.net.MalformedURLException;
import java.time.Duration;

public class Basic {
    public Basic() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver("android"), Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(accessibility = "test-Username")
    public WebElement username;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement password;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;
    
    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }
}
