package ru.netology.diploma.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$$;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class FieldHelper {
    static SelenideElement findSpan(String text) {
        return $$("span.input span.input__top")
                .find(Condition.ownText(text))
                .parent()
                .parent();
    }

    static SelenideElement findField(SelenideElement span) {
        return span.find("input.input__control");
    }

    static SelenideElement findField(String text) {
        return findField(findSpan(text));
    }
}
