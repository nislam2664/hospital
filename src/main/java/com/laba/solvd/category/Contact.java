package com.laba.solvd.category;

import com.laba.solvd.Main;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public final class Contact implements Information {
    private static final Logger logger = LogManager.getLogger(Contact.class.getName());

    private String name;
    private String address;
    private String phone;

    public Contact() {
        logger.debug("Contact object instantiated");
        logger.warn("Contact was not given any information");
    }

    public Contact(String name, String address, String phone) {
        logger.debug("Contact object instantiated");
        setName(name);
        setAddress(address);
        setPhone(phone);
        logger.info("Contact object created");
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (name == null || name.isBlank())
                throw new FullNameNotGivenException();
            if (!StringManipulation.isAlphabetic(name))
                throw new IllegalArgumentException();
            this.name = StringManipulation.capitalize(name);
            logger.info("Name provided successfully");
        } catch (FullNameNotGivenException e) {
            logger.warn("Name was not provided");
            System.out.println("A name was not provided, please provide the full name.");
            while(true) {
                try {
                    System.out.print("Name : ");
                    this.name = scanner.nextLine();
                    if (this.name == null || this.name.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(this.name))
                        throw new IllegalArgumentException();
                    this.name = StringManipulation.capitalize(this.name);
                    logger.info("Name provided successfully");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.error("Name was not provided");
                    System.out.println("A name has not been provided, please provide the full name.");
                } catch (IllegalArgumentException ex) {
                    logger.error("Name contains invalid characters");
                    System.out.println("A name must include alphabets only, please provide a proper full name.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Name contains invalid characters");
            System.out.println("A name must include alphabets only, please provide a proper full name.");
            while(true) {
                try {
                    System.out.print("Name : ");
                    this.name = scanner.nextLine();
                    if (this.name == null || this.name.isBlank())
                        throw new FullNameNotGivenException();
                    if (!StringManipulation.isAlphabetic(this.name))
                        throw new IllegalArgumentException();
                    this.name = StringManipulation.capitalize(this.name);
                    logger.info("Name successfully provided");
                    break;
                } catch (FullNameNotGivenException ex) {
                    logger.error("Name was not provided");
                    System.out.println("A name has not been provided, please provide a full name.");;
                } catch (IllegalArgumentException ex) {
                    logger.error("Name contains invalid characters");
                    System.out.println("A name must include alphabets only, please provide a proper full name.");
                }
            }
            logger.info("Name was changed");
        }
    }

    public void setAddress(String address) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(address == null || address.isBlank())
                throw new NullDataException();
            this.address = address;
        } catch (NullDataException e) {
            logger.warn("Address was not provided");
            System.out.println("An address was not provided, please provide a valid address below.");
            while(true) {
                try {
                    System.out.print("Address : ");
                    this.address = scanner.nextLine();
                    if (this.address == null || this.address.isBlank())
                        throw new NullDataException();
                    logger.info("Address successfully provided");
                    break;
                } catch (NullDataException ex) {
                    logger.error("Empty address given");
                    System.out.println("An address has not been provided, please provide an address below.");;
                }
            }
            logger.info("Address was changed");
        }
    }

    public void setPhone(String phone) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(phone == null || phone.isBlank())
                throw new NullDataException();
            if (!StringManipulation.isNumeric(phone))
                throw new IllegalArgumentException();
            this.phone = phone;
        } catch (NullDataException e) {
            logger.warn("Phone number was not provided");
            System.out.println("An phone number was not provided, please provide a valid phone number below.");
            while(true) {
                try {
                    System.out.print("Phone # : ");
                    this.phone = scanner.nextLine();
                    if (this.phone == null || this.phone.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isNumeric(this.phone))
                        throw new IllegalArgumentException();
                    logger.info("Phone number successfully provided");
                    break;
                } catch (NullDataException ex) {
                    logger.error("Phone number was not provided");
                    System.out.println("An phone number has not been provided, please provide an phone number.");
                }  catch (IllegalArgumentException ex) {
                    logger.error("Phone number included invalid characters");
                    System.out.println("Phone number must contain only numbers and dashes, please provide a proper phone number.");
                }
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Phone number included invalid characters");
            System.out.println("Phone number must contain only numbers and dashes, please provide a proper phone number.");
            while(true) {
                try {
                    System.out.print("Phone # : ");
                    this.phone = scanner.nextLine();
                    if (this.phone == null || this.phone.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isNumeric(this.phone))
                        throw new IllegalArgumentException();
                    logger.info("Phone number successfully provided");
                    break;
                } catch (NullDataException ex) {
                    logger.error("Phone number was not provided");
                    System.out.println("An phone number has not been provided, please provide an phone number.");
                } catch (IllegalArgumentException ex) {
                    logger.error("Phone number included invalid characters");
                    System.out.println("Phone number must contain only numbers and dashes, please provide a proper phone number.");
                }
            }
            logger.info("Phone number was changed");
        }
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ " + name + " ✦✦✦");
        System.out.println("--------------------------------");
        System.out.println("Address :: " + address);
        System.out.println("Phone # :: " + phone);
    }

    @Override
    public String toString() {
        return "Contact{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(address, contact.address) && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phone);
    }
}


