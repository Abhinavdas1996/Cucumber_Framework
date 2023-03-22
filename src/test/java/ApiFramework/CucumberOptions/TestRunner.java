package ApiFramework.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ApiFramework/NewFeatures",
        plugin = {"pretty","json:target/jsonReports/cucumber-report.json"},
        glue = {"ApiFramework/FeatureStepDefinitions"},
        tags = "@AddPlace or @DeletePlace"
)
public class TestRunner {
}
