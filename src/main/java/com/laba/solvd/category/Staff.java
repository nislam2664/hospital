package com.laba.solvd.category;

import com.laba.solvd.enums.Gender;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.exception.InvalidDateException;
import com.laba.solvd.exception.NullDataException;
import com.laba.solvd.interfaces.Information;
import com.laba.solvd.tools.StringManipulation;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public abstract class Staff extends Person implements Information {
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
        } catch (NullDataException e) {
            System.out.println("Job title was not established. Please provide a job title.\n{DOCTOR, NURSE, INTERN, INTERPRETER, RECEPTIONIST, SOCIAL WORKER, SURGEON}.");
            while (true) {
                System.out.print("Job title : ");
                String label = scanner.nextLine();
                try {
                    this.title = JobTitle.valueOf(label.toUpperCase());
                    break;
                } catch (IllegalArgumentException ex) {
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
        } catch (NullDataException e) {
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
                    break;
                } catch (NullDataException ex) {
                    System.out.println("Join date was not provided. Please provide the join date.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect date was provided. Please provide the join date in the correct form.");
                } catch (InvalidDateException ex) {
                    System.out.println("Join date provided is after the current date. Please provide a valid join date.");
                }
            }
        } catch (IllegalArgumentException e) {
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
                    break;
                } catch (NullDataException ex) {
                    System.out.println("Join date was not provided. Please provide the join date.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect date was provided. Please provide the join date in the correct form.");
                } catch (InvalidDateException ex) {
                    System.out.println("Join date provided is after the current date. Please provide a valid join date.");
                }
            }
        } catch (InvalidDateException e) {
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
                    break;
                } catch (NullDataException ex) {
                    System.out.println("Join date was not provided. Please provide the join date.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect date was provided. Please provide the join date in the correct form.");
                } catch (InvalidDateException ex) {
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
