import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        publish = true,
        plugin = "pretty",
        tags = "not @todo"
)
public class RunCucumberTest {
}
