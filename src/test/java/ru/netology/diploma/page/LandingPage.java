package ru.netology.diploma.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static ru.netology.diploma.page.ButtonHelper.findButton;

public class LandingPage {
    private final SelenideElement buyButton =
            findButton("Купить");
    private final SelenideElement creditButton =
            findButton("Купить в кредит");
    @Getter
    private final SelenideElement okNotification =
            $("div.notification_status_ok");
    @Getter
    private final SelenideElement errorNotification =
            $("div.notification_status_error");

    public LandingPage() {
        $("h2").shouldHave(Condition.ownText("Путешествие дня"));
    }

    public CardPage validBuy() {
        buyButton.click();

        return new CardPage("Оплата по карте");
    }

    public CardPage validCredit() {
        creditButton.click();

        return new CardPage("Кредит по данным карты");
    }
}
