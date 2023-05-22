package com.laba.solvd.enums;

public enum Relation {
    MOTHER, WIFE, GIRLFRIEND,
    FATHER, HUSBAND, BOYFRIEND,
    PARENT, SPOUSE, FIANCE,
    SON, BROTHER,
    DAUGHTER, SISTER,
    GRANDMOTHER, GRANDFATHER,
    AUNT, UNCLE, LEGAL_GUARDIAN;

    private String label;

    static {
        MOTHER.label = "Mother";
        WIFE.label = "Wife";
        GIRLFRIEND.label = "Girlfriend";
        FATHER.label = "Father";
        HUSBAND.label = "Husband";
        BOYFRIEND.label = "Boyfriend";
        PARENT.label = "Parent";
        SPOUSE.label = "Spouse";
        FIANCE.label = "Fiance";
        SON.label = "Son";
        BROTHER.label = "Brother";
        DAUGHTER.label = "Daughter";
        SISTER.label = "Sister";
        GRANDMOTHER.label = "Grandmother";
        GRANDFATHER.label = "Grandfather";
        AUNT.label = "Aunt";
        UNCLE.label = "Uncle";
        LEGAL_GUARDIAN.label = "Legal Guardian";
    }

    public String getLabel() {
        return label;
    }
}
