package test_package;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/feature_folder"},
plugin = {"json:target/cucumber.json"},
glue = "step_package",tags = {"@Air"})


public class test_class extends AbstractTestNGCucumberTests{

}
