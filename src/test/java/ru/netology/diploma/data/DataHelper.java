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
    private static final Faker FAKER =
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

    private static LocalDate getDate() {
        return LocalDate.now()
                .plusDays(RANDOM.nextInt(366));
    }

    private static CardInfo.ValidThru getValidThru(LocalDate date) {
        return new CardInfo.ValidThru(
                MONTH_FORMATTER.format(date),
                YEAR_FORMATTER.format(date)
        );
    }

    public static CardInfo getCardInfo(
            String number,
            LocalDate date
    ) {
        Name name = FAKER.name();

        return new CardInfo(
                number,
                getValidThru(date),
                name.firstName() + ' ' + name.lastName(),
                FAKER.number()
                        .digits(3)
        );
    }

    public static CardInfo getCardInfo(String number) {
        return getCardInfo(
                number,
                getDate()
        );
    }
}
