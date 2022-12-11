package ru.netology.diploma.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.diploma.data.DataHelper;
import ru.netology.diploma.page.CardPage;
import ru.netology.diploma.page.LandingPage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;

import static com.codeborne.selenide.Selenide.open;

class ShopTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void shouldBuy() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validBuy();
        cardPage.validProceed(DataHelper.getCardInfo(
                DataHelper.getApprovedCardNumber()));
        landingPage.getOkNotification()
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldNotBuyInvalidYear() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validBuy();
        cardPage.validProceed(DataHelper.getCardInfo(
                DataHelper.getApprovedCardNumber(),
                LocalDate.now()
                        .minusYears(1)
        ));
        cardPage.getMonthSpan()
                .shouldNotHave(Condition.cssClass("input_invalid"));
        cardPage.getYearSpan()
                .shouldHave(Condition.cssClass("input_invalid"));
        landingPage.getOkNotification()
                .shouldNotBe(Condition.visible);
    }

    @Test
    void shouldNotBuyInvalidMonth() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validBuy();
        LocalDate date = LocalDate.now();
        if (date.getMonth() == Month.JANUARY) {
            cardPage.validProceed(DataHelper.getCardInfo(
                    DataHelper.getApprovedCardNumber(),
                    date.minusYears(1)
            ));
            cardPage.getMonthSpan()
                    .shouldNotHave(Condition.cssClass("input_invalid"));
            cardPage.getYearSpan()
                    .shouldHave(Condition.cssClass("input_invalid"));
        } else {
            cardPage.validProceed(DataHelper.getCardInfo(
                    DataHelper.getApprovedCardNumber(),
                    date.minusMonths(1)
            ));
            cardPage.getMonthSpan()
                    .shouldHave(Condition.cssClass("input_invalid"));
            cardPage.getYearSpan()
                    .shouldNotHave(Condition.cssClass("input_invalid"));
        }
        landingPage.getOkNotification()
                .shouldNotBe(Condition.visible);
    }

    @Test
    void shouldNotBuyDeclined() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validBuy();
        cardPage.validProceed(DataHelper.getCardInfo(
                DataHelper.getDeclinedCardNumber()));
        landingPage.getErrorNotification()
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldCredit() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validCredit();
        cardPage.validProceed(DataHelper.getCardInfo(
                DataHelper.getApprovedCardNumber()));
        landingPage.getOkNotification()
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldNotCreditInvalidYear() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validCredit();
        cardPage.validProceed(DataHelper.getCardInfo(
                DataHelper.getApprovedCardNumber(),
                LocalDate.now()
                        .minusYears(1)
        ));
        cardPage.getMonthSpan()
                .shouldNotHave(Condition.cssClass("input_invalid"));
        cardPage.getYearSpan()
                .shouldHave(Condition.cssClass("input_invalid"));
        landingPage.getOkNotification()
                .shouldNotBe(Condition.visible);
    }

    @Test
    void shouldNotCreditInvalidMonth() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validCredit();
        LocalDate date = LocalDate.now();
        if (date.getMonth() == Month.JANUARY) {
            cardPage.validProceed(DataHelper.getCardInfo(
                    DataHelper.getApprovedCardNumber(),
                    date.minusYears(1)
            ));
            cardPage.getMonthSpan()
                    .shouldNotHave(Condition.cssClass("input_invalid"));
            cardPage.getYearSpan()
                    .shouldHave(Condition.cssClass("input_invalid"));
        } else {
            cardPage.validProceed(DataHelper.getCardInfo(
                    DataHelper.getApprovedCardNumber(),
                    date.minusMonths(1)
            ));
            cardPage.getMonthSpan()
                    .shouldHave(Condition.cssClass("input_invalid"));
            cardPage.getYearSpan()
                    .shouldNotHave(Condition.cssClass("input_invalid"));
        }
        landingPage.getOkNotification()
                .shouldNotBe(Condition.visible);
    }

    @Test
    void shouldNotCreditDeclined() {
        open("http://localhost:8080");
        LandingPage landingPage = new LandingPage();
        CardPage cardPage = landingPage.validCredit();
        cardPage.validProceed(DataHelper.getCardInfo(
                DataHelper.getDeclinedCardNumber()));
        landingPage.getErrorNotification()
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}
