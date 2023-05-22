package com.laba.solvd.hospital.staff;

import com.laba.solvd.category.*;
import com.laba.solvd.enums.Gender;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.exception.FullNameNotGivenException;
import com.laba.solvd.interfaces.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Interpreter extends Staff implements Information {
    private final ArrayList<String> languages = new ArrayList<String>();

    public Interpreter(String fullName, LocalDate DOB, Gender gender, LocalDate joinDate) {
        super(fullName, DOB, gender, JobTitle.INTERPRETER, joinDate);
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Interpreter ✦✦✦");
        System.out.println("Name :: " + firstName + " " + lastName);
        System.out.println("Age :: " + age);
        System.out.println("Start Date :: " + joinDate.toString());
        System.out.println("Languages :: ");
        languages.stream().forEach(language -> System.out.println("\t• " + language));
        System.out.println();
    }

    public String toString() {
        return super.toString() + "\n      Interpreter{languages=" + languages + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Interpreter that = (Interpreter) o;
        return Objects.equals(languages, that.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), languages);
    }
}
