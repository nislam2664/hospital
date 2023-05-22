package com.laba.solvd.category;

import com.laba.solvd.enums.AgeGroup;
import com.laba.solvd.enums.Gender;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tools.StringManipulation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Scanner;

public abstract class Person implements Information {
    protected String firstName;
    protected String lastName;
    protected LocalDate DOB;
    protected Gender gender;
    protected int age;
    protected AgeGroup group;
    protected Contact contact;

    public Person() {

    }

    public Person(String fullName, LocalDate DOB, Gender gender) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (fullName == null || fullName.split(" ").length == 1)
                throw new FullNameNotGivenException();
            if (!StringManipulation.isAlphabetic(fullName))
                throw new IllegalArgumentException();
            firstName = StringManipulation.capitalize(fullName.split(" ")[0]);
            lastName = StringManipulation.capitalize(fullName.split(" ")[1]);
        } catch (FullNameNotGivenException e) {
            System.out.println("Full name has not been registered. Please provide the required names.");
            while (true) {
                try {
                    System.out.print("First name : ");
                    firstName = scanner.nextLine();
                    System.out.print("Last name : ");
                    lastName = scanner.nextLine();
                    if (firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(firstName) || !StringManipulation.isAlphabetic(lastName))
                        throw new IllegalArgumentException();
                    firstName = StringManipulation.capitalize(firstName);
                    lastName = StringManipulation.capitalize(lastName);
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("Full name was not provided. Please provide the required names.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Full name must include alphabets only, please provide a proper full name.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Full name must include alphabets only, please provide a proper full name.");
            while(true) {
                try {
                    System.out.print("First name : ");
                    firstName = scanner.nextLine();
                    System.out.print("Last name : ");
                    lastName = scanner.nextLine();
                    if (firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(firstName) || !StringManipulation.isAlphabetic(lastName))
                        throw new IllegalArgumentException();
                    firstName = StringManipulation.capitalize(firstName);
                    lastName = StringManipulation.capitalize(lastName);
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("Full name was not provided. Please provide the required names.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Full name must include alphabets only, please provide a proper full name.");
                }
            }
        }

        setDOB(DOB);
        this.gender = Objects.requireNonNullElse(gender, Gender.UNDEFINED);
        this.contact = new Contact(firstName + " " + lastName, "N/A", "0");
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final LocalDate getDOB() {
        return DOB;
    }

    public final Gender getGender() {
        return gender;
    }

    public final int getAge() {
        return age;
    }

    public AgeGroup getGroup() {
        return group;
    }

    public final Contact getContact() {
        return contact;
    }

    public final void setFirstName(String firstName) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(firstName == null || firstName.isBlank())
                throw new FullNameNotGivenException();
            if (!StringManipulation.isAlphabetic(firstName))
                throw new IllegalArgumentException();
            this.firstName = StringManipulation.capitalize(firstName);
            this.contact = new Contact(this.firstName + " " + lastName, this.contact.getAddress(), this.contact.getPhone());
        } catch (FullNameNotGivenException e) {
            scanner = new Scanner(System.in);
            System.out.println("First name was not provided. Please provide the first name.");
            while(true) {
                try {
                    System.out.print("First name : ");
                    this.firstName = scanner.nextLine();
                    if (this.firstName == null || this.firstName.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(this.firstName))
                        throw new IllegalArgumentException();
                    this.firstName = StringManipulation.capitalize(this.firstName);
                    this.contact = new Contact(this.firstName + " " + lastName, this.contact.getAddress(), this.contact.getPhone());
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("First name has not been provided. Please provide the first name.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("First name must include alphabets only, please provide a proper first name.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("First name must include alphabets only, please provide a proper first name.");
            while(true) {
                try {
                    System.out.print("First name : ");
                    this.firstName = scanner.nextLine();
                    if (this.firstName == null || this.firstName.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(this.firstName))
                        throw new IllegalArgumentException();
                    this.firstName = StringManipulation.capitalize(this.firstName);
                    this.contact = new Contact(this.firstName + " " + lastName, this.contact.getAddress(), this.contact.getPhone());
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("First name was not provided. Please provide the first name.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("First name must include alphabets only, please provide a proper first name.");
                }
            }
        }
    }

    public final void setLastName(String lastName) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(lastName == null || lastName.isBlank())
                throw new FullNameNotGivenException();
            if (!StringManipulation.isAlphabetic(lastName))
                throw new IllegalArgumentException();
            this.lastName = StringManipulation.capitalize(lastName);
            this.contact = new Contact(firstName + " " + this.lastName, this.contact.getAddress(), this.contact.getPhone());
        } catch (FullNameNotGivenException e) {
            scanner = new Scanner(System.in);
            System.out.println("Last name was not provided. Please provide the last name.");
            while(true) {
                try {
                    System.out.print("Last name : ");
                    this.lastName = scanner.nextLine();
                    if (this.lastName == null || this.lastName.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(this.lastName))
                        throw new IllegalArgumentException();
                    this.lastName = StringManipulation.capitalize(this.lastName);
                    this.contact = new Contact(firstName + " " + this.lastName, this.contact.getAddress(), this.contact.getPhone());
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("Last name has not been provided. Please provide the last name.");;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Last name must include alphabets only, please provide a proper last name.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Last name must include alphabets only, please provide a proper last name.");
            while(true) {
                try {
                    System.out.print("Last name : ");
                    this.lastName = scanner.nextLine();
                    if (this.lastName == null || this.lastName.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(this.lastName))
                        throw new IllegalArgumentException();
                    this.lastName = StringManipulation.capitalize(this.lastName);
                    this.contact = new Contact(firstName + " " + this.lastName, this.contact.getAddress(), this.contact.getPhone());
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("Last name was not provided. Please provide the last name.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Last name must include alphabets only, please provide a proper last name.");
                }
            }
        }
    }

    public final void setDOB(LocalDate DOB) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (DOB == null)
                throw new NullDataException();
            if (DOB.isAfter(LocalDate.now()))
                throw new InvalidDateException();
            this.DOB = DOB;
        } catch (NullDataException e) {
            System.out.println("Birth date was not provided. Please provide the birth date.");
            while (true) {
                try {
                    System.out.print("Birth date in YYYY-MM-DD form : ");
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
                    System.out.println("Birth date was not provided. Please provide the birth date.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect date was provided. Please provide the birth date in the correct form.");
                } catch (InvalidDateException ex) {
                    System.out.println("Birth date provided is after the current date. Please provide a valid birth date.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Birth date was not given in correct form. Please provide a valid birth date.");
            while (true) {
                try {
                    System.out.print("Birth date in YYYY-MM-DD format : ");
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
                    System.out.println("Birth date was not provided. Please provide the birth date.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect date was provided. Please provide the birth date in the correct form.");
                } catch (InvalidDateException ex) {
                    System.out.println("Birth date provided is after the current date. Please provide a valid birth date.");
                }
            }
        } catch (InvalidDateException e) {
            System.out.println("Birth date registered is after the current date. Please provide a valid birth date.");
            while (true) {
                try {
                    System.out.print("Birth date in YYYY-MM-DD format : ");
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
                    System.out.println("Birth date was not provided. Please provide the birth date.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect date was provided. Please provide the birth date in the correct form.");
                } catch (InvalidDateException ex) {
                    System.out.println("Birth date provided is after the current date. Please provide a valid birth date.");
                }
            }
        }
        age = Period.between(this.DOB, LocalDate.now()).getYears();
        group = AgeGroup.valueOf(age);
    }

    public final void setGender(Gender gender) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(gender == null)
                throw new NullDataException();
            this.gender = gender;
        } catch (NullDataException e) {
            System.out.println("Gender was not established. Please provide a gender.\n{MALE, FEMALE, NON-BINARY}.");
            while (true) {
                System.out.print("Gender : ");
                String label = scanner.nextLine();
                try {
                    System.out.println("gender is : " + Gender.valueOf(label.toUpperCase()));
                    this.gender = Gender.valueOf(label.toUpperCase());
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println("No such gender exists. Please provide a valid gender.\n{MALE, FEMALE, NON-BINARY}.");
                }
            }
        }
    }

    public final void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Person ✦✦✦");
        System.out.println("First Name :: " + firstName);
        System.out.println("Last Name :: " + lastName);
        System.out.println("Date of Birth :: " + DOB.toString());
        System.out.println("Age :: " + age);
        System.out.println("Gender :: " + gender.toString());
        System.out.println("Address :: " + contact.getAddress());
        System.out.println("Phone # :: " + contact.getPhone());
    }

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", DOB=" + DOB + ", gender=" + gender + ", age=" + age + ", contact=" + contact + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Person other = (Person) obj;
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return (this.getFirstName().equals(other.getFirstName())) && (this.getLastName().equals(other.getLastName())) && (this.getDOB().isEqual(other.getDOB())) && (this.getGender().equals(other.getGender()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, DOB, gender, age, contact);
    }
}

