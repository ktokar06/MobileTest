package org.example.tests;

import io.appium.java_client.android.AndroidDriver;
import org.example.utils.ParameterProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Listeners;

import java.net.URL;

@Listeners(org.example.listeners.TestListener.class)
public abstract class BaseTest {
    protected AndroidDriver driver;
    protected String appPackage;
    protected String appActivity;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", ParameterProvider.get("platformName"));
        caps.setCapability("appium:platformVersion", ParameterProvider.get("platformVersion"));
        caps.setCapability("appium:deviceName", ParameterProvider.get("deviceName"));
        caps.setCapability("appium:automationName", ParameterProvider.get("automationName"));
        caps.setCapability("appium:noReset", Boolean.parseBoolean(ParameterProvider.get("noReset")));
        caps.setCapability("appium:appPackage", appPackage);
        caps.setCapability("appium:appActivity", appActivity);

        driver = new AndroidDriver(new URL(ParameterProvider.get("appiumUrl")), caps);
        WebDriverRunner.setWebDriver(driver);
        driver.activateApp(appPackage);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}