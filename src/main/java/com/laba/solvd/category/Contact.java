package com.laba.solvd.category;

import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tool.StringManipulation;

import java.util.Objects;
import java.util.Scanner;

public final class Contact implements Information {
    private String name;
    private String address;
    private String phone;

    public Contact() {

    }

    public Contact(String name, String address, String phone) {
        setName(name);
        setAddress(address);
        setPhone(phone);
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
        } catch (FullNameNotGivenException e) {
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
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("A name has not been provided, please provide the full name.");;
                } catch (IllegalArgumentException ex) {
                    System.out.println("A name must include alphabets only, please provide a proper full name.");
                }
            }
        } catch (IllegalArgumentException e) {
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
                    break;
                } catch (FullNameNotGivenException ex) {
                    System.out.println("A name has not been provided, please provide a full name.");;
                } catch (IllegalArgumentException ex) {
                    System.out.println("A name must include alphabets only, please provide a proper full name.");
                }
            }
        }
    }

    public void setAddress(String address) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(address == null || address.isBlank())
                throw new NullDataException();
            this.address = address;
        } catch (NullDataException e) {
            System.out.println("An address was not provided, please provide a valid address below.");
            while(true) {
                try {
                    System.out.print("Address : ");
                    this.address = scanner.nextLine();
                    if (this.address == null || this.address.isBlank())
                        throw new NullDataException();
                    break;
                } catch (NullDataException ex) {
                    System.out.println("An address has not been provided, please provide an address below.");;
                }
            }
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
            System.out.println("An phone number was not provided, please provide a valid phone number below.");
            while(true) {
                try {
                    System.out.print("Phone # : ");
                    this.phone = scanner.nextLine();
                    if (this.phone == null || this.phone.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isNumeric(this.phone))
                        throw new IllegalArgumentException();
                    break;
                } catch (NullDataException ex) {
                    System.out.println("An phone number has not been provided, please provide an phone number.");
                }  catch (IllegalArgumentException ex) {
                    System.out.println("Phone number must contain only numbers and dashes, please provide a proper phone number.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Phone number must contain only numbers and dashes, please provide a proper phone number.");
            while(true) {
                try {
                    System.out.print("Phone # : ");
                    this.phone = scanner.nextLine();
                    if (this.phone == null || this.phone.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isNumeric(this.phone))
                        throw new IllegalArgumentException();
                    break;
                } catch (NullDataException ex) {
                    System.out.println("An phone number has not been provided, please provide an phone number.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Phone number must contain only numbers and dashes, please provide a proper phone number.");
                }
            }
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


