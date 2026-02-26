package com.RahulShetty.Runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
	    features = "src/test/resources/features",      
	   
	    glue = {"com.RahulShetty.Stepdefs", "com.RahulShetty.Hooks"},
	    snippets = SnippetType.CAMELCASE,
	    plugin = {"pretty", "html:target/cucumber-report.html",
	    		 "rerun:target/failed_scenarios.txt"},
	    tags = "@Automation",
	    monochrome = true 
	)
	@Listeners(com.RahulShetty.Listeners.TestListener.class)
	public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}
	}
