package ru.netology.diploma.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$$;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class ButtonHelper {
    static SelenideElement findButton(String text) {
        return $$("button.button span.button__text")
                .find(Condition.ownText(text))
                .parent()
                .parent();
    }
}
