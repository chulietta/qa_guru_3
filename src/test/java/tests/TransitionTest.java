package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TransitionTest {

    @Test
    @DisplayName("Transition Test")
    void transitionTest() {

        // Открыть главную страницу
        open("https://alfabank.ru/");

        // Перейти на подстраницу "Вклады"
        $(".f1Cda9K").sibling(0).lastChild().preceding(3).click();
        $("h1").shouldHave(text("Накопительные продукты"));

        // Перейти на подстраницу "Страхование вкладов"
        $("[data-test-id='tabs-list-tabTitle-0']").sibling(0).click();
        $("[data-test-id='accordion-header-0']").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));
    }
};
