package com.android.appiumtest.pages;


import com.android.appiumtest.utils.DriverManager;
import com.hotwire.imageassert.Image;
import com.hotwire.imageassert.ImageAssert;
import com.hotwire.imageassert.listener.PrintStreamResultListener;
import com.hotwire.imageassert.listener.ThrowExceptionResultListener;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.android.appiumtest.pageuis.Info3BaseElements;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Base {

    private AppiumDriver driver = DriverManager.getDriver();


    public void pressHomebuttonAndroid() {
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
    }




}