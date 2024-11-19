package org.example;

import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE_KM("5km"),
    TEN_KM("10km");

    private final String code;

    Distance(String code) {
        this.code = code;
    }

    public static Distance of(String code){
        return Stream.of(values())
                .filter(d -> Objects.equals(d.code, code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown distance: " + code));
    }
}
