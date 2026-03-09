package org.example.listeners;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[TEST START] " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[TEST PASSED] " + result.getName());
        takeScreenshot("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[TEST FAILED] " + result.getName());
        takeScreenshot("FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[TEST SKIPPED] " + result.getName());
        takeScreenshot("SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[TEST SUITE START] " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[TEST SUITE FINISHED] " + context.getName());
    }

    @Attachment(value = "Screenshot - {status}", type = "image/png")
    private byte[] takeScreenshot(String status) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver == null) {
            System.err.println("WebDriver is null, cannot take screenshot.");
            return new byte[0];
        }
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return new byte[0];
        }
    }
}