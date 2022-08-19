package Runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       //features = "src/test/java/Features/Register_account.feature",
       // features = "src/test/java/Features/Signup_Freemiumaccount.feature",
        features = "src/test/java/Features",
        glue = {"stepDefinition"},
        tags = "@test1",
        plugin = {
                "pretty",
        },
        dryRun = false
)

public class Run extends AbstractTestNGCucumberParallelTests{

}
