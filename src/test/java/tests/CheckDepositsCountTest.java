package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckDepositsCountTest {

    @Test
    @DisplayName("Check archive deposits count")
    void checkDepositsCountTest() {

        // Открыть страницу "Вклады"
        open("https://alfabank.ru/make-money/");
        $("h1").shouldHave(text("Накопительные продукты"));

        // Перейти на подстраницу "Депозиты"
        $$("[href='/make-money/deposits/']").find(visible).click();
        $("h1").shouldHave(text("Вклады"));

        // Перейти по линку на "Архивные депозиты"
        $(byText("Архивные счета и депозиты")).scrollTo().click();
        $("[data-widget-name='Heading']").shouldHave(text("Архивные счета и депозиты"));

        // Перейти на вкладку "Депозиты"
        $$(byText("Депозиты")).find(visible).click();

        //Убедиться, что представлено ровно пять архивных депозитов
        $("[data-test-id='filter']").$$("[data-widget-name='CatalogCard']").shouldHaveSize(5);
    }
};
