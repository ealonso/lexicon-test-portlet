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

import java.net.URL;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Julio Camarero
 */
public class CommonSteps {

	public static void cantClickInButton(
		WebDriver browser, String buttonText, String elementType) {

		WebElement button = getButton(browser, buttonText, elementType);

		Assert.assertFalse(button.isEnabled());
	}

	public static void clickInBackLink(WebDriver browser) {
		if (_log.isDebugEnabled()) {
			_log.debug("Trying to click on  back link");
		}

		WebElement backLink = FunctionalTestLocatorsHelper.getClickableElement(
			browser, By.xpath("//a[@title='Back']"));

		backLink.click();
	}

	public static void clickInButton(
		WebDriver browser, String buttonText, String elementType) {

		if (_log.isDebugEnabled()) {
			_log.debug("Trying to click on  " + elementType + " " + buttonText);
		}

		WebElement button = getButton(browser, buttonText, elementType);

		button.click();
	}

	public static void deleteTouchpoint(
		WebDriver browser, URL appUrl, String name) {

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting touchpoint  " + name);
		}

		//navigateToPage(browser, appUrl, "touchpoints/list");

		WebElement row = FunctionalTestLocatorsHelper.getElement(
			browser, By.xpath("//p[contains(.,'" + name + "')]/ancestor::li"));

		Actions actions = new Actions(browser);

		actions.moveToElement(row).perform();

		WebElement deleteLink = row.findElement(
			By.xpath(".//a[@title='delete']"));

		JavascriptExecutor js = (JavascriptExecutor)browser;

		js.executeScript("arguments[0].click();", deleteLink);

		try {

			// We should wait for the success message instead once the
			// success message is available

			Thread.sleep(2000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public static WebElement fetchTouchpoint(
		WebDriver browser, String touchpointName) {

		return FunctionalTestLocatorsHelper.fetchElement(
			browser, By.xpath("//div[@class='dataset-display']"),
			By.xpath("//a[contains(., '" + touchpointName + "')]"));
	}

	public static void findTouchpointInList(
		WebDriver browser, String touchpointName) {

		if (_log.isDebugEnabled()) {
			_log.debug("Looking for touchpoint  " + touchpointName);
		}

		WebElement touchpoint = fetchTouchpoint(browser, touchpointName);

		Assert.assertNotNull(
			"Can't find touchpoint " + touchpointName +
				" in the list of touchpoints.",
			touchpoint);
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

	protected static WebElement getButton(
		WebDriver browser, String buttonText, String elementType) {

		String xPath;

		if (elementType.equals("link")) {
			xPath = "//a[contains(., '" + buttonText + "')]";
		}
		else {
			xPath = "//input[contains(@value, '" + buttonText + "')]";
		}

		return FunctionalTestLocatorsHelper.getElement(
			browser, By.xpath(xPath));
	}

	private static final Log _log = LogFactoryUtil.getLog(CommonSteps.class);

}