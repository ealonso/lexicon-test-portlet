/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.game.functional.test;

import com.liferay.game.functional.test.util.FunctionalTestUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.runtime.arquillian.CukeSpace;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

/**
 * @author Julio Camarero
 */
@CucumberOptions(
	features = "features/character_creation.feature",
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
)
@RunAsClient
@RunWith(CukeSpace.class)
public class CharacterCreationFeatureTest {

	@Drone
	public static WebDriver browser;

	@BeforeClass
	public static void setUpClass() {
		FunctionalTestUtil.createReport();
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@When("^I add a new character called (.+)$")
	public void addCharacter(String characterName) {
	}

	@But("^I add a new character without a name$")
	public void addCharacterWithoutName() {
		addCharacter("");
	}

	@Then("^I can't save the character")
	public void cantSaveCharacter() {
	}

	@And("^I don't see (.+) in the list of characters$")
	public void dontFind(String characterName) {
	}

	@Then("^I see (.+) in the list of characters$")
	public void findCharacter(String characterName) {
	}

	@Given("^I am in the list of characters$")
	public void navigateToListOfCharacters() {
		browser.get(_url.toExternalForm());
	}

	@After
	public void tearDown(Scenario scenario) {
		FunctionalTestUtil.checkJavascriptErrors(browser);

		FunctionalTestUtil.takeScreenshot(scenario, browser);
	}

	@ArquillianResource
	private static URL _url;

}