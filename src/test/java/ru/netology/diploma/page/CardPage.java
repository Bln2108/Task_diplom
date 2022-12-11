package ru.netology.diploma.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ru.netology.diploma.data.CardInfo;

import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.diploma.page.ButtonHelper.findButton;
import static ru.netology.diploma.page.FieldHelper.findField;
import static ru.netology.diploma.page.FieldHelper.findSpan;

public class CardPage {
    private final SelenideElement numberField =
            findField("Номер карты");
    @Getter
    private final SelenideElement monthSpan =
            findSpan("Месяц");
    private final SelenideElement monthField =
            findField(monthSpan);
    @Getter
    private final SelenideElement yearSpan =
            findSpan("Год");
    private final SelenideElement yearField =
            findField(yearSpan);
    private final SelenideElement ownerField =
            findField("Владелец");
    private final SelenideElement securityCodeField =
            findField("CVC/CVV");
    private final SelenideElement proceedButton =
            findButton("Продолжить");

    public CardPage(String text) {
        $$("h3")
                .find(Condition.ownText(text))
                .shouldBe(Condition.visible);
    }

    public void validProceed(CardInfo cardInfo) {
        numberField.sendKeys(cardInfo.getNumber());
        monthField.sendKeys(cardInfo.getValidThru()
                .getMonth());
        yearField.sendKeys(cardInfo.getValidThru()
                .getYear());
        ownerField.sendKeys(cardInfo.getOwner());
        securityCodeField.sendKeys(cardInfo.getSecurityCode());
        proceedButton.click();
    }
}
