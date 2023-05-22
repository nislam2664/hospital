package com.laba.solvd.enums;

import java.util.Objects;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    NON_BINARY("NON-BINARY"),
    UNDEFINED("UNDEFINED");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
