package com.laba.solvd.category;

import com.laba.solvd.enums.Gender;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.exception.InvalidDateException;
import com.laba.solvd.exception.NullDataException;
import com.laba.solvd.interfaces.Information;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public abstract class Staff extends Person implements Information {
    private static final Logger logger = LogManager.getLogger(Staff.class.getName());

    protected JobTitle title;
    protected LocalDate joinDate;
    public static int employees;

    static {
        employees = 0;
    }

    public Staff() {
    }

    public Staff(String fullName, LocalDate DOB, Gender gender, JobTitle title, LocalDate joinDate) {
        super(fullName, DOB, gender);
        setTitle(title);
        setJoinDate(joinDate);
        employees++;
    }

    public final JobTitle getTitle() {
        return title;
    }

    public final LocalDate getJoinDate() {
        return joinDate;
    }

    public final int getEmployees() {
        return employees;
    }

    public final void setTitle(JobTitle title) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(title == null)
                throw new NullDataException();
            this.title = title;
            logger.info("Job title set successfully");
        } catch (NullDataException e) {
            logger.warn("Job title was not established");
            System.out.println("Job title was not established. Please provide a job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
            while (true) {
                System.out.print("Job title : ");
                String label = scanner.nextLine();
                try {
                    if(label == null || label.isBlank())
                        throw new NullDataException();
                    this.title = JobTitle.valueOf(label.toUpperCase());
                    logger.info("Job title set successfully");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Job title was not established");
                    System.out.println("Job title was not established. Please provide a job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Invalid job title");
                    System.out.println("No such job title exists. Please provide a valid job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid job title");
            System.out.println("No such job title exists. Please provide a valid job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
            while (true) {
                System.out.print("Job title : ");
                String label = scanner.nextLine();
                try {
                    if(label == null || label.isBlank())
                        throw new NullDataException();
                    this.title = JobTitle.valueOf(label.toUpperCase());
                    logger.info("Job title set successfully");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Job title was not established");
                    System.out.println("Job title was not established. Please provide a job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Invalid job title");
                    System.out.println("No such job title exists. Please provide a valid job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
                }
            }
        }
    }

    public final void setJoinDate(LocalDate joinDate) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (joinDate == null)
                throw new NullDataException();
            if (joinDate.isAfter(LocalDate.now()))
                throw new InvalidDateException();
            this.joinDate = joinDate;
            logger.info("Join date set successfully");
        } catch (NullDataException e) {
            logger.warn("Join date was not established");
            System.out.println("Join date was not provided. Please provide the join date.");
            while (true) {
                try {
                    System.out.print("Join date in YYYY-MM-DD form : ");
                    String date = scanner.nextLine();
                    if (date == null || date.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isValidDate(date))
                        throw new IllegalArgumentException();
                    if (LocalDate.parse(date).isAfter(LocalDate.now()))
                        throw new InvalidDateException();
                    this.joinDate = LocalDate.parse(date);
                    logger.info("Join date set successfully");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Join date was not established");
                    System.out.println("Join date was not provided. Please provide the join date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Join date included invalid characters or incorrect form");
                    System.out.println("Incorrect date was provided. Please provide the join date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Join date provided was after current date");
                    System.out.println("Join date provided is after the current date. Please provide a valid join date.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Join date included invalid characters or incorrect form");
            System.out.println("Join date was not given in correct form. Please provide a valid join date.");
            while (true) {
                try {
                    System.out.print("Join date in YYYY-MM-DD format : ");
                    String date = scanner.nextLine();
                    if (date == null || date.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isValidDate(date))
                        throw new IllegalArgumentException();
                    if (LocalDate.parse(date).isAfter(LocalDate.now()))
                        throw new InvalidDateException();
                    this.DOB = LocalDate.parse(date);
                    logger.info("Join date set successfully");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Join date was not established");
                    System.out.println("Join date was not provided. Please provide the join date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Join date included invalid characters or incorrect form");
                    System.out.println("Incorrect date was provided. Please provide the join date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Join date provided was after current date");
                    System.out.println("Join date provided is after the current date. Please provide a valid join date.");
                }
            }
        } catch (InvalidDateException e) {
            logger.warn("Join date provided was after current date");
            System.out.println("Join date registered is after the current date. Please provide a valid join date.");
            while (true) {
                try {
                    System.out.print("Join date in YYYY-MM-DD format : ");
                    String date = scanner.nextLine();
                    if (date == null || date.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isValidDate(date))
                        throw new IllegalArgumentException();
                    if (LocalDate.parse(date).isAfter(LocalDate.now()))
                        throw new InvalidDateException();
                    this.joinDate = LocalDate.parse(date);
                    logger.info("Join date set successfully");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Join date was not established");
                    System.out.println("Join date was not provided. Please provide the join date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Join date included invalid characters or incorrect form");
                    System.out.println("Incorrect date was provided. Please provide the join date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Join date provided was after current date");
                    System.out.println("Join date provided is after the current date. Please provide a valid join date.");
                }
            }
        }
    }

    @Override
    public void getInfo() {
        System.out.println("Name :: " + firstName + " " + lastName);
        System.out.println("Title :: " + title);
        System.out.println("Age :: " + age);
        System.out.println("Start Date :: " + joinDate.toString());
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Staff{" + "title='" + title + '\'' + ", joinDate=" + joinDate + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(title, staff.title) && Objects.equals(joinDate, staff.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, joinDate);
    }
}
