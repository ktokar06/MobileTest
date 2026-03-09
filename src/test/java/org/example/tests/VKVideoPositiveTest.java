package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.pages.VKVideoPage;
import org.example.utils.ParameterProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("VK Video Tests")
@Feature("Video Play")
public class VKVideoPositiveTest extends BaseTest {

    {
        this.appPackage = ParameterProvider.get("vkVideoAppPackage");
        this.appActivity = ParameterProvider.get("vkVideoAppActivity");
    }

    @Test(description = "Проверка воспроизведения видео")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
                1. Открыть приложение VK Video
                2. Пропустить экран логина
                3. Открыть первое видео
                4. Проверить, что видео воспроизводится
                """)
    public void testVideoPlay() {
        VKVideoPage vkPage = new VKVideoPage(driver);

        vkPage.skipLoginIfPresent()
                .openFirstVideo();

        Assert.assertTrue(vkPage.isVideoPlaying(), "Видео не воспроизводится");
    }
}