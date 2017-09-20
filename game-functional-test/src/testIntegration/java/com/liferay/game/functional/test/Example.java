/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.game.functional.test;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.liferay.game.functional.test.util.FunctionalTestUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.arquillian.CukeSpace;
import java.io.File;
import java.net.URL;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * @author Cristina González
 */
@CucumberOptions(
	features = "features/start.feature",
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter", "pretty"}
)
@RunAsClient
@RunWith(CukeSpace.class)
public class Example {

	@BeforeClass
	public static void setUpClass() {
		FunctionalTestUtil.createReport();
	}

	@Given("^I am in the main page")
	public void given() {
		browser.get(_url.toExternalForm());

		Assert.assertEquals("Welcome - Liferay DXP", browser.getTitle());
	}

	@When("^I click")
	public void when() {
		System.out.println("WHEN");
	}

	@Then("^I see")
	public void then() {
		System.out.println("SEE");
	}

	@After
	public void tearDown(Scenario scenario) throws Throwable {
		FunctionalTestUtil.checkJavascriptErrors(browser);

		FunctionalTestUtil.takeScreenshot(scenario, browser);
	}

	@Drone
	public static WebDriver browser;

	@ArquillianResource
	private URL _url;
}
