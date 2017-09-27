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

import com.liferay.game.functional.test.util.CommonSteps;
import com.liferay.game.functional.test.util.FunctionalTestLocatorsHelper;
import com.liferay.game.functional.test.util.FunctionalTestUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.runtime.arquillian.CukeSpace;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Julio Camarero
 */
@CucumberOptions(
	features = "features/character_slay.feature",
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
)
@RunAsClient
@RunWith(CukeSpace.class)
public class CharacterSlayFeatureTest {

	@Drone
	public static WebDriver browser;

	@BeforeClass
	public static void setUpClass() {
		FunctionalTestUtil.createReport();
	}

	@Then("^I can't slay (.+)$")
	public void cantSlayCharacter(String characterName) {
	}

	@Given("^I slay (.+)$")
	public void slayCharacter(String characterName) {
		CommonSteps.slayCharacter(browser, characterName);
	}

	@After
	public void tearDown(Scenario scenario) {
		FunctionalTestUtil.checkJavascriptErrors(browser);

		FunctionalTestUtil.takeScreenshot(scenario, browser);
	}

	@Given("^I try to slay (.+)$")
	public void tryToSlayCharacter(String characterName) {
		try {
			CommonSteps.slayCharacter(browser, characterName);

			Assert.fail("I shouldn't be able to slay this character.");
		}
		catch (ElementNotVisibleException enve) {
		}
	}

	@And("^(.+) is ALIVE")
	public void verifyAliveCharacter(String characterName) {
		String cardLocator = "//*[contains(@class,'card-row')][contains(.,'" +
			characterName + "')]";
		String stickerLocator =
			"//*[contains(@class,'sticker')][contains(.,'DEAD')]";

		WebElement deadSticker = FunctionalTestLocatorsHelper.fetchElement(
			browser, By.xpath(cardLocator), By.xpath(stickerLocator));

		if (deadSticker != null) {
			CommonSteps.reviveCharacter(browser, characterName);
		}
	}

	@Then("^(.+) is DEAD")
	public void verifyDeadCharacter(String characterName) {
		WebElement character = CommonSteps.getCharacterCard(
			browser, characterName);

		character.findElement(
			By.xpath("//*[contains(@class,'sticker')][contains(.,'DEAD')]"));
	}

	@Given("^a character called (.+) exists$")
	public void verifyExistsCharacter(String characterName) {
		navigateToListOfCharacters();

		CommonSteps.addCharacterIfItDoesNotExist(browser, characterName);
	}

	protected void navigateToListOfCharacters() {
		browser.get(_url.toExternalForm());
	}

	@ArquillianResource
	private static URL _url;

}