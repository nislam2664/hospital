package com.laba.solvd.hospital.patient;

import com.laba.solvd.tool.StringManipulation;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Bill implements Information, Transaction {
    private int id;
    private float balance;
    private String insurance;

    public Bill() {

    }

    public Bill(int id, float balance, String insurance) {
        setId(id);
        setBalance(balance);
        setInsurance(insurance);
    }

    public int getId() {
        return id;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setId(int id) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (id <= 0)
                throw new NegativeNumberException();
            this.id = id;
        }
        catch (NegativeNumberException e) {
            System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.id = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid ID number input.\nPlease enter a valid ID : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid ID number input.\nPlease enter a valid ID : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.id = Integer.parseInt(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid ID number input.\nPlease enter a valid ID : ");
                }
            }
        }
    }

    public void setBalance(float balance) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (balance <= 0)
                throw new NegativeNumberException();
            this.balance = balance;
        }
        catch (NegativeNumberException e) {
            System.out.print("Balance due cannot be negative.\nPlease enter a valid amount : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    this.balance = Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("Balance due cannot be negative.\nPlease enter a valid amount : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid balance input.\nPlease enter a valid balance : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid balance input.\nPlease enter a valid balance : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    this.balance = Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid balance input.\nPlease enter a valid balance : ");
                }
            }
        }
    }

    public void setInsurance(String insurance) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(insurance == null || insurance.isBlank())
                throw new NullDataException();
            if (!StringManipulation.isAlphabetic(insurance))
                throw new IllegalArgumentException();
            this.insurance = StringManipulation.capitalize(insurance);
        } catch (NullDataException e) {
            System.out.println("Our records show an insurance has not been registered.");
            System.out.println("Please provide the insurance name or if the user has none, enter \"Private\".");
            while(true) {
                try {
                    System.out.print("Insurance name : ");
                    this.insurance = scanner.nextLine();
                    if (this.insurance == null || this.insurance.isBlank())
                        throw new NullDataException();
                    if (!StringManipulation.isAlphabetic(this.insurance))
                        throw new IllegalArgumentException();
                    this.insurance = StringManipulation.capitalize(this.insurance);
                    break;
                } catch (NullDataException ex) {
                    System.out.println("Insurance name was not provided. Please provide the required name.");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Insurance name must contain alphabets only. Please provide a proper name.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid balance input.\nPlease enter a valid balance : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    this.balance = Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid balance input.\nPlease enter a valid balance : ");
                }
            }
        }
    }

    @Override
    public void deposit(float payment) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (payment <= 0)
                throw new NegativeNumberException();
            balance += payment;
        }
        catch (NegativeNumberException e) {
            System.out.print("You cannot deposit a negative amount.\nPlease enter a valid amount : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    balance += Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("You cannot deposit a negative amount.\nPlease enter a valid amount : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid deposit.\nPlease enter a valid amount : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid balance input.\nPlease enter a valid balance : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    balance += Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("You cannot deposit a negative amount.\nPlease enter a valid amount : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid deposit.\nPlease enter a valid amount : ");
                }
            }
        }
    }

    @Override
    public void withdraw(float payment) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (payment <= 0 || payment > balance)
                throw new NegativeNumberException();
            balance += payment;
        }
        catch (NegativeNumberException e) {
            System.out.print("You cannot withdraw this amount.\nPlease enter a valid amount (balance => " + balance + ") : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0 || Float.parseFloat(num) > balance)
                        throw new NegativeNumberException();
                    balance += Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("You cannot withdraw this amount.\nPlease enter a valid amount (balance => " + balance + ") : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid withdrawal.\nPlease enter a valid amount (balance => " + balance + ") : ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid withdrawal.\nPlease enter a valid amount (balance => " + balance + ") : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    balance += Float.parseFloat(num);
                    break;
                } catch (NegativeNumberException ex) {
                    System.out.print("You cannot withdraw this amount.\nPlease enter a valid amount (balance => " + balance + ") : ");
                } catch (InputMismatchException ex) {
                    System.out.print("Invalid withdrawal.\nPlease enter a valid amount (balance => " + balance + ") : ");
                }
            }
        }
    }

    @Override
    public float getBalance() {
        return balance;
    }

    @Override
    public void getInfo() {
        System.out.println(">>> Bill #" + id + " <<<");
        System.out.println("----------------------");
        System.out.println("Insurance : " + insurance);
        System.out.println("Amount Due : " + NumberFormat.getCurrencyInstance().format(balance) + "\n");
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", balance=" + balance + ", insurance='" + insurance + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id && Float.compare(bill.balance, balance) == 0 && Objects.equals(insurance, bill.insurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, insurance);
    }
}
