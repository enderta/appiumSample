package appium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html"
        },
        features = "/home/ender/IdeaProjects/appiuTest/resources",
        glue = "appium/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
