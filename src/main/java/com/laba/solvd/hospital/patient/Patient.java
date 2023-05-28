package com.laba.solvd.hospital.patient;

import com.laba.solvd.category.*;
import com.laba.solvd.enums.*;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public final class Patient extends Person implements Information, Runnable {
    private static final Logger logger = LogManager.getLogger(Patient.class.getName());

    private final int MAX_VISITORS = 2;
    private LocalDate dateOfAdmission;
    private LocalTime timeOfAdmission;
    private Bill bill = new Bill();
    private MedicalRecord medicalRecord = new MedicalRecord();
    private final ArrayList<Visitor> visitorList = new ArrayList<>();
    public static int patients;
    private volatile boolean seen = false;

    static {
        patients = 0;
    }

    public Patient(String fullName, LocalDate DOB, Gender gender) {
        super(fullName, DOB, gender);
        logger.debug("Patient object instantiated");
        this.dateOfAdmission = LocalDate.now();
        patients++;
        logger.info("Patient object created");
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public LocalTime getTimeOfAdmission() {
        return timeOfAdmission;
    }

    public Bill getBill() {
        return bill;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public ArrayList<Visitor> getVisitorList() {
        return visitorList;
    }

    public boolean getIfSeen() {
        return seen;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (dateOfAdmission == null)
                throw new NullDataException();
            if (dateOfAdmission.isAfter(LocalDate.now()))
                throw new InvalidDateException();
            this.dateOfAdmission = dateOfAdmission;
            logger.info("Date of admission was set");
        } catch (NullDataException e) {
            logger.warn("Date of admission was not provided");
            System.out.println("Admission date was not provided. Please provide the admission date.");
            while (true) {
                try {
                    System.out.print("Admission date in YYYY-MM-DD form : ");
                    String date = scanner.nextLine();
                    if (date == null || date.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isValidDate(date))
                        throw new IllegalArgumentException();
                    if (LocalDate.parse(date).isAfter(LocalDate.now()))
                        throw new InvalidDateException();
                    this.dateOfAdmission = LocalDate.parse(date);
                    logger.info("Date of admission was set");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Date of admission was not provided");
                    System.out.println("Admission date was not provided. Please provide the admission date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Incorrect date of admission was provided");
                    System.out.println("Incorrect date was provided. Please provide the admission date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Invalid date of admission was provided");
                    System.out.println("Admission date provided is after the current date. Please provide a valid admission date.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Incorrect date of admission was provided");
            System.out.println("Admission date was not given in correct form. Please provide a valid admission date.");
            while (true) {
                try {
                    System.out.print("Admission date in YYYY-MM-DD format : ");
                    String date = scanner.nextLine();
                    if (date == null || date.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isValidDate(date))
                        throw new IllegalArgumentException();
                    if (LocalDate.parse(date).isAfter(LocalDate.now()))
                        throw new InvalidDateException();
                    this.dateOfAdmission = LocalDate.parse(date);
                    logger.info("Date of admission was set");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Date of admission was not provided");
                    System.out.println("Admission date was not provided. Please provide the admission date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Incorrect date of admission was provided");
                    System.out.println("Incorrect date was provided. Please provide the admission date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Invalid date of admission was provided");
                    System.out.println("Admission date provided is after the current date. Please provide a valid admission date.");
                }
            }
        } catch (InvalidDateException e) {
            System.out.println("Admission date registered is after the current date. Please provide a valid admission date.");
            while (true) {
                try {
                    System.out.print("Admission date in YYYY-MM-DD format : ");
                    String date = scanner.nextLine();
                    if (date == null || date.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isValidDate(date))
                        throw new IllegalArgumentException();
                    if (LocalDate.parse(date).isAfter(LocalDate.now()))
                        throw new InvalidDateException();
                    this.dateOfAdmission = LocalDate.parse(date);
                    logger.info("Date of admission was set");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Date of admission was not provided");
                    System.out.println("Admission date was not provided. Please provide the admission date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Incorrect date of admission was provided");
                    System.out.println("Incorrect date was provided. Please provide the admission date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Invalid date of admission was provided");
                    System.out.println("Admission date provided is after the current date. Please provide a valid admission date.");
                }
            }
        }
    }

    public void setTimeOfAdmission(LocalTime time) {
        this.timeOfAdmission = time;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void setIfSeen(boolean seen) {
        this.seen = seen;
    }

    public void addVisitor(Visitor visitor) {
        try {
            if (visitorList.size() == MAX_VISITORS)
                throw new ExceedCapacityException();
            visitorList.add(visitor);
            logger.info("Visitor was admitted to see a patient");
            System.out.println("You may proceed, " + visitor.getFirstName());
        }
        catch (ExceedCapacityException e) {
            logger.info("Patient's visitor list is full");
            System.out.println("Sorry, the patient has the maximum number of visitors visiting at this time. Please come back later or try again tomorrow.");
        }
    }

    public void removeVisitor(Visitor visitor) {
        visitorList.remove(visitor);
        logger.info("Visitor removed");
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Patient ✦✦✦");
        System.out.println("Name :: " + firstName + " " + lastName);
        System.out.println("Age :: " + age);
        System.out.println("Date of Birth :: " + DOB.toString());
        System.out.println("Date Admitted :: " + dateOfAdmission.toString());
        System.out.println("Current Visitors :: ");
        visitorList.stream().forEach((visitor) -> System.out.println("\t➢ " + visitor.getFirstName() + " " + visitor.getLastName() + " --> " + visitor.getRelation()));
        System.out.println();
        bill.getInfo();
        medicalRecord.getInfo();
    }

    @Override
    public String toString() {
        return "Patient{" + "dateOfAdmission=" + dateOfAdmission + ", bill=" + bill + ", medicalRecord=" + medicalRecord + ", visitorList=" + visitorList + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(dateOfAdmission, patient.dateOfAdmission) && Objects.equals(bill, patient.bill) && Objects.equals(medicalRecord, patient.medicalRecord) && Objects.equals(visitorList, patient.visitorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfAdmission, bill, medicalRecord, visitorList);
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread started ::: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Thread ended ::: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

