package com.laba.solvd.enums;

public enum AgeGroup {
    INFANT(0, "INFANT"),
    TODDLER(1, "TODDLER"),
    CHILD(5, "CHILD"),
    TEEN(13, "TEEN"),
    ADULT(18, "ADULT"),
    SENIOR(65, "SENIOR");

    private final String group;
    private final int minAge;

    AgeGroup(int minAge, String group) {
        this.minAge = minAge;
        this.group = group;
    }

    public int getMinAge() {
        return minAge;
    }
    public String getGroup() {
        return group;
    }

    public static AgeGroup valueOf(int age) {
        if (age < TODDLER.minAge)
            return AgeGroup.INFANT;
        if (age < CHILD.minAge)
            return AgeGroup.TODDLER;
        if (age < TEEN.minAge)
            return AgeGroup.CHILD;
        if (age < ADULT.minAge)
            return AgeGroup.TEEN;
        if (age < SENIOR.minAge)
            return AgeGroup.ADULT;
        return AgeGroup.SENIOR;
    }
}