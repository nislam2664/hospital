package com.laba.solvd.category;

import com.laba.solvd.Main;
import com.laba.solvd.enums.AgeGroup;
import com.laba.solvd.enums.Gender;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Scanner;

public abstract class Person implements Information {
    private static final Logger logger = LogManager.getLogger(Person.class.getName());

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
            logger.info("Full name established successfully");
        } catch (FullNameNotGivenException e) {
            logger.warn("Full name was not provided");
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
                    logger.info("Full name successfully provided");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.warn("Full name was not provided");
                    System.out.println("Full name was not provided. Please provide the required names.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Full name contains invalid characters");
                    System.out.println("Full name must include alphabets only, please provide a proper full name.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Full name contains invalid characters");
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
                    logger.info("Full name successfully provided");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.warn("Full name was not provided");
                    System.out.println("Full name was not provided. Please provide the required names.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Full name contains invalid characters");
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
            logger.info("First name successfully set");
        } catch (FullNameNotGivenException e) {
            scanner = new Scanner(System.in);
            logger.warn("First name was not provided");
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
                    logger.info("First name successfully set");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.warn("First name was not provided");
                    System.out.println("First name has not been provided. Please provide the first name.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("First name included invalid characters");
                    System.out.println("First name must include alphabets only, please provide a proper first name.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("First name included invalid characters");
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
                    logger.info("First name successfully set");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.warn("First name was not provided");
                    System.out.println("First name was not provided. Please provide the first name.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("First name included invalid characters");
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
            logger.info("Last name successfully set");
        } catch (FullNameNotGivenException e) {
            scanner = new Scanner(System.in);
            logger.warn("Last name was not provided");
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
                    logger.info("Last name successfully set");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.warn("Last name was not provided");
                    System.out.println("Last name has not been provided. Please provide the last name.");;
                } catch (IllegalArgumentException ex) {
                    logger.warn("Last name included invalid characters");
                    System.out.println("Last name must include alphabets only, please provide a proper last name.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Last name included invalid characters");
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
                    logger.info("Last name successfully set");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.warn("Last name was not provided");
                    System.out.println("Last name was not provided. Please provide the last name.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Last name included invalid characters");
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
            logger.info("Birth date was provided");
        } catch (NullDataException e) {
            logger.warn("Birth date was not provided");
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
                    logger.info("Birth date was provided");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Birth date was not provided");
                    System.out.println("Birth date was not provided. Please provide the birth date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Birth date included invalid characters or incorrect form");
                    System.out.println("Incorrect date was provided. Please provide the birth date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Birth date provided was after current date");
                    System.out.println("Birth date provided is after the current date. Please provide a valid birth date.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Birth date included invalid characters or incorrect form");
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
                    logger.info("Birth date was provided");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Birth date was not provided");
                    System.out.println("Birth date was not provided. Please provide the birth date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Birth date included invalid characters or incorrect form");
                    System.out.println("Incorrect date was provided. Please provide the birth date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Birth date provided was after current date");
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
                    logger.info("Birth date was provided");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Birth date was not provided");
                    System.out.println("Birth date was not provided. Please provide the birth date.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Birth date included invalid characters or incorrect form");
                    System.out.println("Incorrect date was provided. Please provide the birth date in the correct form.");
                } catch (InvalidDateException ex) {
                    logger.warn("Birth date provided was after current date");
                    System.out.println("Birth date provided is after the current date. Please provide a valid birth date.");
                }
            }
        }
        age = Period.between(this.DOB, LocalDate.now()).getYears();
        group = AgeGroup.valueOf(age);
        logger.info("Proper age and age group established");
    }

    public final void setGender(Gender gender) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(gender == null)
                throw new NullDataException();
            this.gender = gender;
            logger.info("Gender was established");
        } catch (NullDataException e) {
            logger.warn("Gender was not established");
            System.out.println("Gender was not established. Please provide a gender.\n{MALE, FEMALE, NON-BINARY}.");
            while (true) {
                System.out.print("Gender : ");
                String label = scanner.nextLine();
                try {
                    if(label == null || label.isBlank())
                        throw new NullDataException();
                    this.gender = Gender.valueOf(label.toUpperCase());
                    logger.info("Gender successfully set");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Gender was not established");
                    System.out.println("Gender was not established. Please provide a gender.\n{MALE, FEMALE, NON-BINARY}.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Given gender does not exist");
                    System.out.println("No such gender exists. Please provide a valid gender.\n{MALE, FEMALE, NON-BINARY}.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Given gender does not exist");
            System.out.println("No such gender exists. Please provide a valid gender.\n{MALE, FEMALE, NON-BINARY}.");
            while (true) {
                System.out.print("Gender : ");
                String label = scanner.nextLine();
                try {
                    if(label == null || label.isBlank())
                        throw new NullDataException();
                    System.out.println("gender is : " + Gender.valueOf(label.toUpperCase()));
                    this.gender = Gender.valueOf(label.toUpperCase());
                    logger.info("Gender successfully set");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Gender was not established");
                    System.out.println("Gender was not established. Please provide a gender.\n{MALE, FEMALE, NON-BINARY}.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Given gender does not exist");
                    System.out.println("No such gender exists. Please provide a valid gender.\n{MALE, FEMALE, NON-BINARY}.");
                }
            }
        }
    }

    public final void setContact(Contact contact) {
        this.contact = contact;
        logger.info("Contact successfully set");
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

