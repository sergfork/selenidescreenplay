package cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
//        tags = {"@cucumber"},
        features = "src/test/resources/features"
)
public class GoogleTest {
}
