package ru.netology.diploma.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataHelper {
    private static final Random RANDOM =
            new Random();
    private static final DateTimeFormatter MONTH_FORMATTER =
            DateTimeFormatter.ofPattern("MM");
    public static final DateTimeFormatter YEAR_FORMATTER =
            DateTimeFormatter.ofPattern("yy");
    private static final Faker FAKER_EN =
            new Faker(
                    new Locale("en"),
                    RANDOM
            );
    private static final Faker FAKER_RU =
            new Faker(
                    new Locale("ru"),
                    RANDOM
            );

    public static String getApprovedCardNumber() {
        return "4444444444444441";
    }

    public static String getDeclinedCardNumber() {
        return "4444444444444442";
    }

    public static String getOtherCardNumber() {
        return "4444444444444443";
    }

    public static LocalDate getDate() {
        return LocalDate.now()
                .plusDays(RANDOM.nextInt(366));
    }

    private static ValidThru getValidThru(LocalDate date) {
        return new ValidThru(
                MONTH_FORMATTER.format(date),
                YEAR_FORMATTER.format(date)
        );
    }

    public static ValidThru getBadValidThru(LocalDate date) {
        return new ValidThru(
                Integer.toString(RANDOM.nextInt(87) + 13),
                YEAR_FORMATTER.format(date)
        );
    }

    private static String getOwner(Name name) {
        return name.firstName() + ' ' + name.lastName();
    }

    public static String getOwnerInLat() {
        return getOwner(FAKER_EN.name());
    }

    public static String getOwnerInCyr() {
        return getOwner(FAKER_RU.name());
    }

    public static CardInfo getCardInfo(
            String number,
            ValidThru validThru,
            String owner
    ) {
        return new CardInfo(
                number,
                validThru,
                owner,
                FAKER_EN.number()
                        .digits(3)
        );
    }

    public static CardInfo getCardInfo(
            String number,
            LocalDate date,
            String owner
    ) {
        return getCardInfo(
                number,
                getValidThru(date),
                owner
        );
    }

    public static CardInfo getCardInfo(
            String number,
            LocalDate date
    ) {
        return getCardInfo(
                number,
                date,
                getOwnerInLat()
        );
    }

    public static CardInfo getCardInfo(String number) {
        return getCardInfo(
                number,
                getDate(),
                getOwnerInLat()
        );
    }
}
