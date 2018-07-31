package com.android.appiumtest.steps;


import com.android.appiumtest.pages.Base;
import com.android.appiumtest.utils.AppiumServer;
import com.android.appiumtest.utils.DriverManager;
import com.github.lalyos.jfiglet.FigletFont;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;


public class BaseSteps {
    private AppiumDriver driver = DriverManager.getDriver();
    private static AppiumServer server;
    private String port = System.getProperty("port", "");
    private String udid = System.getProperty("udid" , "");
    private String platform = System.getProperty("platform", "");
    private String deviceName = System.getProperty("deviceName", "");
    private String appiumServiceUrl;
    private String finalFilePath = "/Users/gzy1fz/Documents/Programming/courgette-jvm-selenium-master/build/" + deviceName +"/courgette-report";


    @Before
    public void before(Scenario scenario) throws Exception {

        server = new AppiumServer();
        appiumServiceUrl = server.startAppiumServer();
        String asciiArt1 = FigletFont.convertOneLine(scenario.getName());
        System.out.println(asciiArt1);
        DriverManager driverManager = new DriverManager();
        driverManager.initDriver("", "", "", ", ",appiumServiceUrl);

    }


    @Given("^I press the Home Button$")
    public void iPressTheHomeButton() throws Throwable {
        Base base = new Base();
        base.pressHomebuttonAndroid();
    }

    @After
    public void after(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            scenario.write("Scenario failed so capturing a screenshot");
            driver = DriverManager.getDriver();
            driver.context("NATIVE_APP");
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            scenario.embed(screenshot.getScreenshotAs(OutputType.BYTES), "image/png");
        }
        if (driver != null) {
            driver.quit();
        }
        server.destroyAppiumNode();
    }

}