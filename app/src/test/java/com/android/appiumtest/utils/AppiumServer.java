package com.android.appiumtest.utils;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

    private AppiumDriverLocalService appiumService;
    private String appiumServiceUrl;


    public String startAppiumServer(){
        System.out.println(
                "**************************************************************************\n");
        System.out.println("Starting Appium Server on Localhost......");
        System.out.println(
                "**************************************************************************\n");

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .usingAnyFreePort();

        appiumService = builder.build();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);

        return appiumServiceUrl;

    }

    /**
     * Destroy running Appium server
     */
    public void destroyAppiumNode(){
        appiumService.stop();
        if(appiumService.isRunning())
        {
            appiumService.stop();
        }
    }
}