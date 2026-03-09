package org.example.pages;

import io.appium.java_client.android.AndroidDriver;

/**
 * Базовый абстрактный класс для всех Page Object классов.
 */
public abstract class BasePage {
    protected AndroidDriver driver;

    /**
     * Конструктор базовой страницы.
     *
     * @param driver экземпляр AndroidDriver для управления устройством
     */
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }
}