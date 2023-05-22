package com.laba.solvd.hospital.staff;

import com.laba.solvd.category.*;
import com.laba.solvd.enums.Gender;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.exception.*;
import com.laba.solvd.hospital.patient.*;
import com.laba.solvd.interfaces.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Nurse extends Staff implements Information {
    private final int MAX_PATIENTS = 10;
    private final ArrayList<Patient> patientList = new ArrayList<>();

    public Nurse(String fullName, LocalDate DOB, Gender gender, LocalDate joinDate) {
        super(fullName, DOB, gender, JobTitle.NURSE, joinDate);
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void addPatient(Patient patient) {
        try {
            if (patientList.size() == MAX_PATIENTS)
                throw new ExceedCapacityException();
            patientList.add(patient);
            System.out.println("A new patient has been assigned under Nurse " + getLastName() + "'s care.");
        }
        catch (ExceedCapacityException e) {
            System.out.println("Nurse " + getLastName() + " has currently maximum number of patients under their care.");
        }
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Nurse ✦✦✦");
        System.out.println("Name :: " + firstName + " " + lastName);
        System.out.println("Age :: " + age);
        System.out.println("Start Date :: " + joinDate.toString());
        System.out.println("Patients :: ");
        patientList.stream().forEach(patient -> System.out.println("\t▪ " + patient.getFirstName() + " " + patient.getLastName()));
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + "\n      Nurse{" + "MAX_CAPACITY=" + MAX_PATIENTS + ", patientList=" + patientList + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nurse nurse = (Nurse) o;
        return Objects.equals(patientList, nurse.patientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MAX_PATIENTS, patientList);
    }
}
