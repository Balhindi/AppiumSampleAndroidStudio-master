package com.android.appiumtest.suites;

import org.junit.Before;
import org.junit.runner.RunWith;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        showTestOutput = true,
        reportTargetDir = "build/My19",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "com.android.appiumtest.steps",
                tags = {"@test"},
                plugin = {"pretty",
                        "json:build/My19/cucumber-report/cucumber.json",
                        "html:build/My19/cucumber-report/cucumber.html"},
                strict = true
        ))

public class Android8InchTestSuite {
}
