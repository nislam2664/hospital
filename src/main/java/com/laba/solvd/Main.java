package com.laba.solvd;

import com.laba.solvd.category.Room;
import com.laba.solvd.category.Staff;
import com.laba.solvd.enums.*;
import com.laba.solvd.hospital.*;
import com.laba.solvd.hospital.patient.*;
import com.laba.solvd.hospital.room.*;
import com.laba.solvd.hospital.staff.*;
import com.laba.solvd.tools.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.print.Doc;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // LOGGER PRACTICE
        logger.info("Hospital simulation started");
        logger.error("Error occurred!");
        logger.fatal("Fatal code! Fatal code!");
        logger.debug("Currently debugging...");
        logger.warn("This is a warning.");
        System.out.println();

        // REFLECTION
        Reflection.reflection();

        // FILE AND STRING UTILS PRACTICE
       /* FileReader.fileReader();

        // HOSPITAL SIMULATION
        Hospital hospital = new Hospital("Green Hill Hospital", "106-05 Pennsylvania Ave., Franklin Square, NY 11010","347-445-3124");

        Department dept = new Department(DeptName.RADIOLOGY, 12345678);
        hospital.addDepartment(dept);
        Department dept2 = new Department(DeptName.NEUROLOGY, 87654321);
        hospital.addDepartment(dept2);
        hospital.getInfo();

        EmergencyRoom emergencyRoom = new EmergencyRoom(9,  9);
        dept.addRoom(emergencyRoom);
        emergencyRoom.getInfo();

        Bill bill = new Bill(123, 99, "private");
        bill.getInfo();

        Doctor d1 = new Doctor("Amish Patel", LocalDate.parse("1990-06-13"), Gender.MALE, LocalDate.now(), 45);
        d1.getInfo();
        Doctor d2 = new Doctor("Anya Forger", LocalDate.parse("1990-06-13"), Gender.FEMALE, LocalDate.now(), 60);
        d2.getInfo();
        Doctor d3 = new Doctor("Verosika Mayday", LocalDate.parse("1990-06-13"), Gender.FEMALE, LocalDate.now(), 99);
        d3.getInfo();

        Nurse n1 = new Nurse("Hannah Montana", LocalDate.parse("1990-06-13"), Gender.FEMALE, LocalDate.now());
        n1.addPatient(new Patient("Miranda Govenchi", LocalDate.parse("2019-02-23"), Gender.FEMALE));
        n1.getInfo();
        System.out.println(n1.getDOB());
        Nurse n2 = new Nurse("Pippi Longstocking", LocalDate.parse("1990-06-13"), Gender.FEMALE, LocalDate.now());
        n2.addPatient(new Patient("Toby MacGuire", LocalDate.parse("1990-06-13"), Gender.MALE));
        n2.getInfo();

        Interpreter i1 = new Interpreter("John Doe", LocalDate.parse("1990-06-13"), Gender.MALE, LocalDate.now());
        i1.addLanguage("Spanish");
        i1.addLanguage("Cantonese");
        i1.addLanguage("German");
        i1.getInfo();

        Patient p1 = new Patient("Georgia Miller", LocalDate.parse("1995-08-19"), Gender.FEMALE);
        p1.setBill(new Bill(9876, 1883.29382F, "United Healthcare"));
        p1.setMedicalRecord(new MedicalRecord(69, 143, "120/80", 98.6));
        Patient p2 = new Patient("Percy Jackson", LocalDate.parse("2020-11-22"), Gender.MALE);
        p1.setBill(new Bill(1623, 5988.402F, "Medicaid"));
        p1.setMedicalRecord(new MedicalRecord(71, 172, "120/80", 98.6));

        Visitor v1 = new Visitor("Ginny Miller", LocalDate.parse("1990-06-13"), Relation.DAUGHTER);
        v1.getInfo();
        Visitor v2 = new Visitor("Austin Miller", LocalDate.parse("1990-06-13"), Relation.SON);
        Visitor v3 = new Visitor("Paul Hollace", LocalDate.parse("1990-06-13") , Relation.BOYFRIEND);
        p1.addVisitor(v1);
        p1.addVisitor(v2);
        p1.addVisitor(v3);

        p1.setTimeOfAdmission(LocalTime.now());
        emergencyRoom.addPatient(p1);
        p2.setTimeOfAdmission(LocalTime.now());
        emergencyRoom.addPatient(p2);
        emergencyRoom.getInfo();

        p1.getInfo();

        dept.addStaff(d1);
        dept.addStaff(d2);
        dept.addStaff(d3);
        dept.addStaff(n1);
        dept.addStaff(n2);
        dept.addStaff(i1);
        dept.addPatient(p1);
        dept.addPatient(p2);
        dept.getInfo();

        System.out.println("Dept 1 total population :: " + dept.totalResidents());
        System.out.println("Dept 1 # of Doctors :: " + dept.numOfStaff("Doctor"));
        System.out.println("Dept 2 total population :: " + dept2.totalResidents());
        System.out.println("Hospital total population :: " + hospital.totalResidents());

        dept.getInfo();
        emergencyRoom.peekPatients();
        System.out.println();

        // LAMBDA FUNCTIONS
        System.out.println("FEMALE STAFF: ");
        Supplier<Gender> getGender = () -> Gender.FEMALE;
        Consumer<Staff> printStaff = staff -> System.out.println("\t" + staff.getContact().getName());
        dept.filterStaff(getGender.get()).stream().forEach(printStaff);
        System.out.println();

        Predicate<Staff> getDoctor = doc -> doc.getTitle().equals(JobTitle.DOCTOR);
        BiConsumer<String, Float> printDocFee = (doc, fee) -> System.out.println(doc + " -> " + NumberFormat.getCurrencyInstance().format(fee));
        System.out.println("✦✦✦ BEFORE 50% DISCOUNT ✦✦✦");
        dept.getStaffList().stream().filter(getDoctor).map(Doctor.class::cast).forEach(doc -> printDocFee.accept(doc.getContact().getName(), doc.getFee()));
        System.out.println();

        Function<Float, Float> halfOff = a -> (float) (a / 2.0);
        System.out.println("✦✦✦ AFTER 50% DISCOUNT ✦✦✦");
        dept.getStaffList().stream().filter(getDoctor).map(Doctor.class::cast).forEach(doc -> doc.setFee(halfOff.apply(doc.getFee())));
        dept.getStaffList().stream().filter(getDoctor).map(Doctor.class::cast).forEach(doc -> printDocFee.accept(doc.getContact().getName(), doc.getFee()));
        System.out.println();

        dept.groupStaffByTitle().keySet().stream().forEach(jobTitle -> {
            System.out.println(jobTitle + ": ");
            dept.groupStaffByTitle().get(jobTitle).stream().forEach(printStaff);
        });
        System.out.println();

        Consumer<Patient> printPatient = patient -> System.out.println("\t" + patient.getContact().getName() + "\t" + patient.getAge());
        dept.groupPatientByAgeGroup().keySet().stream().forEach(ageGroup -> {
            System.out.println(ageGroup + ": ");
            dept.groupPatientByAgeGroup().get(ageGroup).stream().forEach(printPatient);
        });*/
    }
}
