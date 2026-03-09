package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для главной страницы игры Alchemy.
 */
public class AlchemyPage extends BasePage {
    private static final int DEFAULT_TIMEOUT = 10;

    public SelenideElement playButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Play']"));
    public SelenideElement hintCountText = $(AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Hints (')]"));
    public SelenideElement freeHintsButton = $(AppiumBy.androidUIAutomator("new UiSelector().description(\"Free hints\")"));
    public SelenideElement claimButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Claim!']"));
    public SelenideElement closeMenuButton = $(AppiumBy.androidUIAutomator("new UiSelector().description(\"Close navigation menu\")"));

    /**
     * Конструктор страницы AlchemyPage.
     *
     * @param driver экземпляр AndroidDriver для управления устройством
     */
    public AlchemyPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Нажимает на кнопку 'Play' в главном меню.
     * Ожидает появления кнопки в течение таймаута перед кликом.
     *
     * @return текущий экземпляр AlchemyPage для цепочки вызовов
     */
    @Step("Нажать на кнопку 'Play' в главном меню")
    public AlchemyPage tapPlayButton() {
        playButton.shouldBe(visible, Duration.ofSeconds(DEFAULT_TIMEOUT)).click();
        return this;
    }

    /**
     * Получает текущее количество доступных подсказок.
     *
     * @return количество подсказок в виде целого числа
     */
    @Step("Получить текущее количество подсказок")
    public int getHintCount() {
        String hintsFullText = hintCountText.shouldBe(visible, Duration.ofSeconds(DEFAULT_TIMEOUT)).getText();
        String numberStr = hintsFullText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberStr);
    }

    /**
     * Нажимает на кнопку '' для открытия меню получения бесплатных подсказок.
     *
     * @return текущий экземпляр AlchemyPage для цепочки вызовов
     */
    @Step("Нажать на кнопку 'Free hints' для открытия меню подсказок")
    public AlchemyPage clickFreeHints() {
        freeHintsButton.shouldBe(visible, Duration.ofSeconds(DEFAULT_TIMEOUT)).click();
        return this;
    }

    /**
     * Нажимает на кнопку 'Claim' для получения двух бесплатных подсказок.
     *
     * @return текущий экземпляр AlchemyPage для цепочки вызовов
     */
    @Step("Нажать на кнопку 'Claim'")
    public AlchemyPage claimTwoHints() {
        claimButton.shouldBe(visible, Duration.ofSeconds(DEFAULT_TIMEOUT)).click();
        return this;
    }

    /**
     * Закрывает меню навигации после получения подсказок.
     *
     * @return текущий экземпляр AlchemyPage для цепочки вызовов
     */
    @Step("Закрыть меню навигации")
    public AlchemyPage closeNavigationMenu() {
        closeMenuButton.shouldBe(visible, Duration.ofSeconds(DEFAULT_TIMEOUT)).click();
        return this;
    }
}