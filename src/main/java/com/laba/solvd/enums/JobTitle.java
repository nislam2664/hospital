package com.laba.solvd.enums;

public enum JobTitle {
    DOCTOR("DOCTOR"),
    NURSE("NURSE"),
    INTERN("INTERN"),
    INTERPRETER("INTERPRETER"),
    RECEPTIONIST("RECEPTIONIST"),
    SOCIAL_WORKER("SOCIAL WORKER"),
    SURGEON("SURGEON");

    public final String label;

    JobTitle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
