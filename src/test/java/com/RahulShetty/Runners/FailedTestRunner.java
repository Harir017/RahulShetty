package com.RahulShetty.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "@target/failed_scenarios.txt",
    glue = {"com.RahulShetty.Stepdefs", "com.RahulShetty.Hooks"},
    plugin = {"pretty", "html:target/failed-report.html"},
    monochrome = true
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
}
