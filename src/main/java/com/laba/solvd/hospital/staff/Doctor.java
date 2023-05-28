package com.laba.solvd.hospital.staff;

import com.laba.solvd.category.*;
import com.laba.solvd.enums.Gender;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.exception.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Doctor extends Staff implements Information, Runnable {
    private static final Logger logger = LogManager.getLogger(Doctor.class.getName());

    private float fee;
    private volatile boolean busy = true;

    public Doctor(String fullName, LocalDate DOB, Gender gender, LocalDate joinDate, float fee) {
        super(fullName, DOB, gender, JobTitle.DOCTOR, joinDate);
        logger.debug("Doctor object instantiated");
        setFee(fee);
        logger.info("Doctor object created");
    }

    public float getFee() {
        return fee;
    }

    public boolean getIfBusy() {
        return busy;
    }

    public void setFee(float fee)  {
        Scanner scanner = new Scanner(System.in);
        try{
            if (fee <= 0)
                throw new NegativeNumberException();
            this.fee = fee;
            logger.info("Fee was established");
        }
        catch (NegativeNumberException e) {
            logger.warn("Negative free provided");
            System.out.print("Doctor's fee cannot be negative.\nProvide a valid fee : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isNumeric(num))
                        throw new InputMismatchException();
                    if (Float.parseFloat(num) <= 0)
                        throw new NegativeNumberException();
                    this.fee = Float.parseFloat(num);
                    logger.info("Fee was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative free provided");
                    System.out.print("Doctor's fee cannot be negative.\nProvide a valid fee : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Invalid free provided");
                    System.out.print("Invalid fee.\nPlease enter a valid fee amount : ");
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Invalid free provided");
            System.out.print("Invalid fee.\nPlease enter a valid fee amount : ");
            while(true) {
                try {
                    String num = scanner.nextLine();
                    if (!StringManipulation.isInteger(num))
                        throw new InputMismatchException();
                    if (Integer.parseInt(num) <= 0)
                        throw new NegativeNumberException();
                    this.fee = Integer.parseInt(num);
                    logger.info("Fee was established");
                    break;
                } catch (NegativeNumberException ex) {
                    logger.warn("Negative free provided");
                    System.out.print("Doctor's fee cannot be negative.\nProvide a valid fee : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Invalid free provided");
                    System.out.print("Invalid fee.\nPlease enter a valid fee amount : ");
                }
            }
        }
    }

    public void setIfBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Doctor ✦✦✦");
        System.out.println("Name :: " + firstName + " " + lastName);
        System.out.println("Age :: " + age);
        System.out.println("Start Date :: " + joinDate.toString());
        System.out.println("Specialty Fee :: " + NumberFormat.getCurrencyInstance().format(fee));
        System.out.println();
    }

    @Override
    public String toString() {
        return super.toString() + "\n      Doctor{" + "fee=" + fee + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Float.compare(doctor.fee, fee) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fee);
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread started ::: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            busy = false;
            System.out.println("Thread ended ::: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
