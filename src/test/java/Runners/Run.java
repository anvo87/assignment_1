package Runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       //features = "src/test/java/Features/Register_account.feature",
       // features = "src/test/java/Features/Signup_Freemiumaccount.feature",
        features = "src/test/resources/Features",
        glue = {"StepDefinition"},
        tags = "@test6",
        plugin = {
                "pretty",
        },
        dryRun = false
)

public class Run extends AbstractTestNGCucumberParallelTests{

}
