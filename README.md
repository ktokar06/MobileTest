# Тестовое задание автоматизации мобильного устройства

**Стек:** Appium, Java 22, Selenide, Android Studio (Android 11 / api 30), Maven.

1. **Написать автотест на приложение VK Видео (com.vk.vkvideo).** Необходимо проверить, что видео (на ваш выбор) воспроизводится. Для завершения автотеста должны быть обработаны как положительные (видео воспроизводится), так и негативные (видео не воспроизводится) сценарии.

   Ссылка на приложение: https://play.google.com/store/apps/details?id=com.vk.vkvideo


2. **Написать автотест на мобильное приложение Алхимия: Головоломка (com.ilyin.alchemy).**

   Ссылка на приложение: https://play.google.com/store/apps/details?id=com.ilyin.alchemy

   **Шаги прохождения теста:**

   1 Нажать на кнопку "Играть" в главном меню.

   2 Нажать на добавление подсказок.

   3 Получить подсказку за просмотр рекламы.

   4 Тест завершается после проверки на то, что количество подсказок было увеличено и значение равно 4.

Каждый автотест должен успешно завершаться.

---

**Настройки Appium(config.properties):**

```properties
# Appium Settings
platformName=Android
platformVersion=11
deviceName=Android_11
automationName=UiAutomator2
appiumUrl=http://127.0.0.1:4723
noReset=true

# VK Video App
vkVideoAppPackage=com.vk.vkvideo
vkVideoAppActivity=com.vk.video.screens.main.MainActivity

# Alchemy App
alchemyAppPackage=com.ilyin.alchemy
alchemyAppActivity=com.ilyin.app_google_core.MainComposeActivity
```