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
    @Getter
    private final SelenideElement numberSpan =
            findSpan("Номер карты");
    private final SelenideElement numberField =
            findField(numberSpan);
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
    @Getter
    private final SelenideElement ownerSpan =
            findSpan("Владелец");
    private final SelenideElement ownerField =
            findField(ownerSpan);
    @Getter
    private final SelenideElement securityCodeSpan =
            findSpan("CVC/CVV");
    private final SelenideElement securityCodeField =
            findField(securityCodeSpan);
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

    public void validProceed() {
        proceedButton.click();
    }
}
