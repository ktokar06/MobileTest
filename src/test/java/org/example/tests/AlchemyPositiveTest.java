package org.example.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import org.example.pages.AlchemyPage;
import org.example.utils.ParameterProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Alchemy Game Tests")
@Feature("Hints Functionality")
public class AlchemyPositiveTest extends BaseTest {

    {
        this.appPackage = ParameterProvider.get("alchemyAppPackage");
        this.appActivity = ParameterProvider.get("alchemyAppActivity");
    }

    @Test(description = "Проверка получения 2 бесплатных подсказок через кнопку 'Claim'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
                1. Нажать кнопку 'Play' в главном меню
                2. Проверить, что количество подсказок равно 2
                3. Нажать на получение подсказок
                4. Получить подсказку
                5. Проверить, что количество подсказок стало равно 4
                """)
    public void testGetTwoFreeHintsViaClaim() {
        AlchemyPage alchemy = new AlchemyPage(driver);

        alchemy.tapPlayButton();

        Assert.assertEquals(alchemy.getHintCount(), 2, "Изначально подсказок должно быть 2");

        alchemy.clickFreeHints()
                .claimTwoHints()
                .closeNavigationMenu();

        Assert.assertEquals(alchemy.getHintCount(), 4, "После получения подсказок через Claim должно быть 4");
    }
}