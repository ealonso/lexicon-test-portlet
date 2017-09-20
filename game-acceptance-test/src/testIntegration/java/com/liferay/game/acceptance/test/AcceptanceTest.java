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

package com.liferay.game.acceptance.test;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateReporter;

import cucumber.api.CucumberOptions;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.ReportParser;
import net.masterthought.cucumber.json.Feature;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Julio Camarero
 * @author Ruben Pulido
 */
@CucumberOptions(features = {
	"classpath:features/health_controller.feature",
	"classpath:features/info_controller.feature",
	"classpath:features/metrics.feature",
	"classpath:features/data_sources/add_data_source.feature",
	"classpath:features/data_sources/delete_data_source.feature",
	"classpath:features/data_sources/get_data_source.feature",
	"classpath:features/data_sources/update_data_source.feature"
})
@Ignore
public class AcceptanceTest {

	public static final String REPORTS_LOCATION =
		"build/reports/tests/testIntegration/cucumber/";

	@Test
	public void testAllControllers() throws IOException {
		CucumberRunner.parallel(getClass(), 5, REPORTS_LOCATION);

		String[] featureNames = {
			"contacts_mapping_rule_controller",
			"contacts_provider_entry_controller", "contacts_entry_controller",
			"contacts_mapping_suggestion_controller",
			"contacts_group_controller", "contacts_generation_controller",
			"contacts_tear_down"
		};

		for (String featureName : featureNames) {
			File file = new File(
				"src/testIntegration/resources/features/" + featureName +
					".feature");

			String reportPath = REPORTS_LOCATION + featureName + ".xml";

			CucumberRunner runner = new CucumberRunner(file);

			KarateReporter reporter = new KarateReporter(
				file.getPath(), reportPath);

			runner.run(reporter);

			reporter.done();
		}

		boolean allTestsPassed = _generateReport();

		Assert.assertEquals(true, allTestsPassed);
	}

	private static boolean _generateReport() throws IOException {
		File reportsLocation = new File(REPORTS_LOCATION);

		File[] files = reportsLocation.listFiles(
			(dir, name) -> name.toLowerCase().endsWith(".json"));

		if (files == null) {
			return false;
		}

		List<String> jsonPaths = new ArrayList<>(files.length);

		for (File file : files) {
			jsonPaths.add(file.getAbsolutePath());
		}

		Configuration config = new Configuration(
			new File(REPORTS_LOCATION), "osb-pulpo-engine-contacts-test");

		String buildNumber = System.getenv("TRAVIS_BUILD_ID");

		if (buildNumber == null) {
			buildNumber = "1";
		}

		config.setBuildNumber(buildNumber);

		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);

		reportBuilder.generateReports();

		_renameFeatureOverviewToIndexHtml();

		ReportParser reportParser = new ReportParser(config);

		List<Feature> features = reportParser.parseJsonResults(jsonPaths);

		System.out.println("");
		System.out.println("#################################################");
		System.out.println("Summary of Test Results: ");
		System.out.println("#################################################");

		for (Feature feature : features) {
			System.out.println(
				String.format(
					"Feature: %s. Status: %s. Number of failures: %s",
					feature.getRawName(), feature.getStatus(),
					feature.getNumberOfFailures()));
		}

		return reportBuilder.hasBuildPassed();
	}

	private static void _renameFeatureOverviewToIndexHtml() {
		String featureOverviewHtmlPath =
			REPORTS_LOCATION + "feature-overview.html";

		File featureOverviewHtml = new File(featureOverviewHtmlPath);

		String indexHtmlPath = REPORTS_LOCATION + "index.html";

		File indexHtml = new File(indexHtmlPath);

		if (indexHtml.exists()) {
			indexHtml.deleteOnExit();
		}

		boolean success = featureOverviewHtml.renameTo(indexHtml);

		if (!success) {
			throw new RuntimeException(
				String.format(
					"Could not rename %s to %s", featureOverviewHtml,
					indexHtmlPath));
		}
	}

}