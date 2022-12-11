package ru.netology.diploma.data;

import lombok.Value;

@Value
public class CardInfo {

    String number;
    ValidThru validThru;
    String owner;
    String securityCode;

    @Value
    public static class ValidThru {
        String month;
        String year;
    }
}
