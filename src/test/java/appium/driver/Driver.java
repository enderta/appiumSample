package appium.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AndroidDriver androidDriver;
    private static WebDriver webDriver;
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();
    private static final String APPIUM_URL = "http://127.0.0.1:4723";
    private static Driver instance;

    private Driver() {}

    public static Driver getInstance() {
        if (instance == null) {
            synchronized (Driver.class) {
                if (instance == null) {
                    instance = new Driver();
                }
            }
        }
        return instance;
    }

    private static void initializeAndroidDriver() throws MalformedURLException {
        URL url = new URL(APPIUM_URL);
        androidDriver = new AndroidDriver(url, capabilities);
    }

    public static AndroidDriver getAndroidDriver(String driverName) throws MalformedURLException {
        if (androidDriver == null) {
            setCapabilities(driverName);
            initializeAndroidDriver();
        }
        return androidDriver;
    }

    private static void setCapabilities(String driverName) {
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "R58M43YW9NE");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 60000);
        capabilities.setCapability("adbExecTimeout", 60000);
        capabilities.setCapability("autoGrantPermissions", true);

        if (driverName.equals("android")) {
            capabilities.setCapability("app", "/home/cyf/IdeaProjects/appiumSample/sauceLab.apk");
            capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        } else if (driverName.equals("chrome")) {
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("chromedriverExecutable", "/home/cyf/IdeaProjects/appiumSample/chromedriver");
        }
    }

    public static WebDriver getWebDriver(String driverName) {
        if (webDriver == null) {
            synchronized (Driver.class) {
                if (webDriver == null) {
                    switch (driverName) {
                        case "chrome_web":
                            webDriver = new ChromeDriver();
                            break;
                        case "firefox_web":
                            webDriver = new FirefoxDriver();
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid driver name: " + driverName);
                    }
                    webDriver.manage().window().maximize();
                }
            }
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        } else if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
    }
}