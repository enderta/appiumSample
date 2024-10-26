package appium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html"
        },
        features = "resources/features",
        glue = "appium/step_definitions",
        dryRun = false,
        tags = "@apk"
)
public class CukesRunner {
}
