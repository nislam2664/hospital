package com.laba.solvd.enums;

public enum Relation {
    MOTHER("MOTHER"),
    WIFE("WIFE"),
    GIRLFRIEND("GIRLFRIEND"),
    FATHER("FATHER"),
    HUSBAND("HUSBAND"),
    BOYFRIEND("BOYFRIEND"),
    PARENT("PARENT"),
    SPOUSE("SPOUSE"),
    FIANCE("FIANCE"),
    SON("SON"),
    BROTHER("BROTHER"),
    DAUGHTER("DAUGHTER"),
    SISTER("SISTER"),
    GRANDMOTHER("GRANDMOTHER"),
    GRANDFATHER("GRANDFATHER"),
    AUNT("AUNT"),
    UNCLE("UNCLE"),
    LEGAL_GUARDIAN("LEGAL GUARDIAN");

    private String label;

    Relation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
