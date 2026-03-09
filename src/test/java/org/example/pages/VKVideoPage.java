package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для страницы VK Video.
 */
public class VKVideoPage extends BasePage {
    private static final int DEFAULT_TIMEOUT = 10;

    private final SelenideElement firstVideoItem = $(By.xpath("//android.widget.GridView[@resource-id='com.vk.vkvideo:id/recycler']/android.widget.FrameLayout[1]"));
    private final SelenideElement skipLoginButton = $(By.xpath("//android.widget.Button[@resource-id='com.vk.vkvideo:id/fast_login_tertiary_btn' and @text='Skip']"));
    private final SelenideElement playerContainer = $(By.id("com.vk.vkvideo:id/playerContainer"));

    /**
     * Конструктор класса VKVideoPage.
     *
     * @param driver экземпляр AndroidDriver для управления устройством
     */
    public VKVideoPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Пропускает экран логина, если он отображается на странице.
     *
     * @return текущий экземпляр VKVideoPage
     */
    @Step("Пропустить экран логина, если он виден")
    public VKVideoPage skipLoginIfPresent() {
        if (skipLoginButton.is(Condition.visible, Duration.ofSeconds(DEFAULT_TIMEOUT))) {
            skipLoginButton.click();
        }
        return this;
    }

    /**
     * Открывает первое видео из списка.
     *
     * @return текущий экземпляр VKVideoPage
     */
    @Step("Открыть первое видео")
    public VKVideoPage openFirstVideo() {
        firstVideoItem.shouldBe(Condition.visible, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .click();

        playerContainer.shouldBe(Condition.visible, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return this;
    }

    /**
     * Проверяет, воспроизводится ли видео в данный момент.
     *
     * @return true если плеер виден (видео воспроизводится), иначе false
     */
    @Step("Проверяем, что видео воспроизводится")
    public boolean isVideoPlaying() {
        return playerContainer.is(Condition.visible, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    /**
     * Проверяет, доступно ли первое видео для просмотра.
     *
     * @return true если первый элемент видео виден, иначе false
     */
    @Step("Проверяем, доступно ли первое видео")
    public boolean isFirstVideoVisible() {
        return firstVideoItem.is(Condition.visible);
    }
}