package com.android.appiumtest.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverManager {
    private static AppiumDriver driver;
    private static boolean fullReset = false;
    private static boolean noReset = false;


    public void initDriver(String port, String platform, String deviceName, String udid, String appiumServiceUrl) throws Exception {
     /*   String platformName = platform.split("-")[0];
        String platformVersion = platform.split("-")[1];
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(fullReset)
        {
            capabilities.setCapability(MobileCapabilityType.FULL_RESET,true);
        }
        if(noReset)
        {
            capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        }*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Automation");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        int rport = Integer.valueOf("8753");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, rport);
        capabilities.setCapability(MobileCapabilityType.APP, "SomeAPk/apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "");
        driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    public static AppiumDriver getDriver()
    {
        return driver;
    }



}
