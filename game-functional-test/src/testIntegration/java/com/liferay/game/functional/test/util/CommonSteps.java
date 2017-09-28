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

package com.liferay.game.functional.test.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.util.Validator;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Julio Camarero
 */
public class CommonSteps {

	public static void addCharacter(WebDriver browser, String characterName) {
		if (_log.isDebugEnabled()) {
			_log.debug("Adding Character  " + characterName);
		}

		FunctionalTestLocatorsHelper.clickElement(
			browser, By.xpath("//a[@data-original-title='Add new Character']"));

		introduceValueInInput(
			browser, "_com_liferay_game_web_portlet_GamePortlet_name",
			characterName);

		String imageName = characterName.replaceAll("\\s", "");

		imageName = imageName.toLowerCase();

		String imageURL = "/o/game-web/images/got/" + imageName + ".png";

		introduceValueInInput(
			browser, "_com_liferay_game_web_portlet_GamePortlet_url", imageURL);

		FunctionalTestLocatorsHelper.clickElement(
			browser, By.xpath("//button[@type='submit']"));

		if (Validator.isNotNull(characterName)) {
			FunctionalTestLocatorsHelper.waitForElementToBeVisible(
				browser,
				By.xpath(
					"//*[contains(., 'Your request completed successfully.')]"));
		}
	}

	public static void addCharacterIfItDoesNotExist(
		WebDriver browser, String characterName) {

		WebElement character = fetchCharacter(browser, characterName);

		if (character == null) {
			addCharacter(browser, characterName);
		}
	}

	public static void deleteCharacter(
		WebDriver browser, String characterName) {

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting Character  " + characterName);
		}

		clickOnCharacterAction(browser, characterName, "Delete");

		browser.switchTo().alert().accept();

		FunctionalTestLocatorsHelper.waitForElementToBeVisible(
			browser,
			By.xpath(
				"//*[contains(., 'Your request completed successfully.')]"));
	}

	public static WebElement fetchCharacter(
		WebDriver browser, String characterName) {

		return FunctionalTestLocatorsHelper.fetchElement(
			browser,
			By.xpath(
				"//*[@id=" +
					"'_com_liferay_game_web_portlet_GamePortlet_characters']"),
			By.xpath("//li[contains(., '" + characterName + "')]"));
	}

	public static void findCharacter(WebDriver browser, String charactrName) {
		if (_log.isDebugEnabled()) {
			_log.debug("Looking for Character  " + charactrName);
		}

		WebElement touchpoint = fetchCharacter(browser, charactrName);

		Assert.assertNotNull(
			"Can't find character " + charactrName +
				" in the list of characters.",
			touchpoint);
	}

	public static WebElement getCharacterCard(
		WebDriver browser, String characterName) {

		return FunctionalTestLocatorsHelper.getElement(
			browser,
			By.xpath(
				"//*[contains(@class,'card-row')][contains(.,'" +
					characterName + "')]"));
	}

	public static void introduceValueInInput(
		WebDriver browser, String inputName, String value) {

		if (_log.isDebugEnabled()) {
			_log.debug("Typing " + value);
		}

		WebElement input = FunctionalTestLocatorsHelper.getClickableElement(
			browser, By.name(inputName));

		input.sendKeys(value);
	}

	public static void reviveCharacter(
		WebDriver browser, String characterName) {

		if (_log.isDebugEnabled()) {
			_log.debug("Reviving Character  " + characterName);
		}

		clickOnCharacterAction(browser, characterName, "Revive");

		FunctionalTestLocatorsHelper.waitForElementToBeVisible(
			browser,
			By.xpath(
				"//*[contains(., 'Your request completed successfully.')]"));
	}

	public static void slayCharacter(WebDriver browser, String characterName) {
		if (_log.isDebugEnabled()) {
			_log.debug("Slaying Character  " + characterName);
		}

		clickOnCharacterAction(browser, characterName, "Kill");

		FunctionalTestLocatorsHelper.waitForElementToBeClickable(
			browser,
			By.xpath(
				"//*[contains(., 'Your request completed successfully.')]"));
	}

	protected static void clickOnCharacterAction(
		WebDriver browser, String characterName, String action) {

		WebElement card = getCharacterCard(browser, characterName);

		WebElement actionsLink = card.findElement(
			By.className("dropdown-toggle"));

		actionsLink.click();

		String menuId = actionsLink.getAttribute("id");

		WebElement actionsMenu =
			FunctionalTestLocatorsHelper.getClickableElement(
				browser, By.xpath("//*[@aria-labelledby='" + menuId + "']"));

		WebElement actionLink = actionsMenu.findElement(
			By.xpath("//a[contains(.,'" + action + "')]"));

		actionLink.click();
	}

	private static final Log _log = LogFactoryUtil.getLog(CommonSteps.class);

}