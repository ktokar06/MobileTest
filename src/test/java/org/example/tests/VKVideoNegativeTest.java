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
@Feature("Video Play - Negative")
public class VKVideoNegativeTest extends BaseTest {

    {
        this.appPackage = ParameterProvider.get("vkVideoAppPackage");
        this.appActivity = ParameterProvider.get("vkVideoAppActivity");
    }

    @Test(description = "Проверка, что видео не воспроизводится без пропуска логина")
    @Severity(SeverityLevel.NORMAL)
    @Description("""
                1. Открыть приложение VK Video
                2. Дождаться появления экрана логина
                3. НЕ нажимать кнопку пропуска 'Skip'
                4. Проверить, что список видео недоступен
                """)
    public void testVideoNotPlayingWithoutLogin() {
        VKVideoPage vkPage = new VKVideoPage(driver);

        Assert.assertFalse(vkPage.isFirstVideoVisible(), "Видео не должно быть доступно без логина");
    }
}