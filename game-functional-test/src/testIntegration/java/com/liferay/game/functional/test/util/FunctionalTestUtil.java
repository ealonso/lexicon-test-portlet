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
package com.liferay.game.functional.test.util;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.Scenario;

import java.io.File;

import java.util.List;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Cristina González
 */
public class FunctionalTestUtil {

	public static void checkJavascriptErrors(WebDriver webDriver) {
		final List<JavaScriptError> javaScriptErrors =
			JavaScriptError.readErrors(webDriver);

		Assert.assertTrue(
			printErrorMessage(javaScriptErrors), javaScriptErrors.isEmpty());
	}

	public static void createReport() {
		File reportFile = new File("build/reports/tests/cucumber/index.html");

		ExtentCucumberFormatter.initiateExtentCucumberFormatter(
			reportFile, false);
	}

	public static void takeScreenshot(Scenario scenario, WebDriver webDriver) {
		if (scenario.isFailed()) {
			final TakesScreenshot takesScreenshot = (TakesScreenshot)webDriver;

			final byte[] screenshot = takesScreenshot.getScreenshotAs(
				OutputType.BYTES);

			scenario.embed(screenshot, "image/png");
		}
	}

	protected static String printErrorMessage(
		List<JavaScriptError> javaScriptErrors) {

		StringBuilder sb = new StringBuilder(2 + 3 * javaScriptErrors.size());

		sb.append(javaScriptErrors.size());
		sb.append(" Javascript Errors detected: \n");

		for (JavaScriptError javaScriptError : javaScriptErrors) {
			sb.append(" * ");
			sb.append(javaScriptError.toString());
			sb.append("\n");
		}

		return sb.toString();
	}

}