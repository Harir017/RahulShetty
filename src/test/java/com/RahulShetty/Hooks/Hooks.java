package com.RahulShetty.Hooks;

import com.RahulShetty.Base.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {
	@Before
	public void setUp() {
		LaunchBrowser();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
