package com.RahulShetty.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",      
	    glue = {"com.RahulShetty.Stepdefs", "com.RahulShetty.Hooks"},  
	    plugin = {"pretty", "html:target/cucumber-report.html"},
	    monochrome = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}
