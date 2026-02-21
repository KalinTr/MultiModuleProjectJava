package org.example;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

// --- OLD CODE (kept for reference) ---
// import io.cucumber.junit.Cucumber;
// import io.cucumber.junit.CucumberOptions;
// import org.junit.runner.RunWith;
//
// @RunWith(Cucumber.class)
// @CucumberOptions(
//         features = "classpath:resources",
//         glue = {"stepDefinition", "hooks", "org.example"},
//         plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"}
// )
// --- END OLD CODE ---

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("resources")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinition, hooks, org.example")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/cucumber.html")
public class RunCucumberTest {
}