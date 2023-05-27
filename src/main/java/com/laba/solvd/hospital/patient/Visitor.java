package com.laba.solvd.hospital.patient;

import com.laba.solvd.category.*;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.enums.Relation;
import com.laba.solvd.exception.NullDataException;
import com.laba.solvd.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public final class Visitor extends Person implements Information {
    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    private Relation relation;

    public Visitor(String fullName, LocalDate DOB, Relation relation) {
        super(fullName, DOB, null);
        logger.debug("Visitor object instantiated");
        this.relation = relation;
        logger.info("Visitor object created");
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(relation == null)
                throw new NullDataException();
            this.relation = relation;
            logger.info("Relation to patient has been established");
        } catch (NullDataException e) {
            logger.warn("Relation was not given");
            System.out.println("Relation was not established. Please provide a relation.\n{MOTHER, WIFE, GIRLFRIEND, FATHER, HUSBAND, BOYFRIEND, PARENT, SPOUSE, FIANCE, SON, BROTHER, DAUGHTER, SISTER, GRANDMOTHER, GRANDFATHER, AUNT, UNCLE, LEGAL GUARDIAN}.");
            while (true) {
                System.out.print("Relation : ");
                String label = scanner.nextLine();
                try {
                    if (label == null || label.isBlank())
                        throw new NullDataException();
                    this.relation = Relation.valueOf(label.toUpperCase());
                    logger.info("Relation to patient has been established");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Relation was not given");
                    System.out.println("Relation was not established. Please provide a relation.\n{MOTHER, WIFE, GIRLFRIEND, FATHER, HUSBAND, BOYFRIEND, PARENT, SPOUSE, FIANCE, SON, BROTHER, DAUGHTER, SISTER, GRANDMOTHER, GRANDFATHER, AUNT, UNCLE, LEGAL GUARDIAN}.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Invalid relation was given");
                    System.out.println("No such relation exists. Please provide a valid relation.\n{MOTHER, WIFE, GIRLFRIEND, FATHER, HUSBAND, BOYFRIEND, PARENT, SPOUSE, FIANCE, SON, BROTHER, DAUGHTER, SISTER, GRANDMOTHER, GRANDFATHER, AUNT, UNCLE, LEGAL GUARDIAN}.");
                }
            }
        }  catch (IllegalArgumentException e) {
            logger.warn("Invalid relation was given");
            System.out.println("No such relation exists. Please provide a valid relation.\n{MOTHER, WIFE, GIRLFRIEND, FATHER, HUSBAND, BOYFRIEND, PARENT, SPOUSE, FIANCE, SON, BROTHER, DAUGHTER, SISTER, GRANDMOTHER, GRANDFATHER, AUNT, UNCLE, LEGAL GUARDIAN}.");
            while (true) {
                System.out.print("Relation : ");
                String label = scanner.nextLine();
                try {
                    if (label == null || label.isBlank())
                        throw new NullDataException();
                    this.relation = Relation.valueOf(label.toUpperCase());
                    logger.info("Relation to patient has been established");
                    break;
                } catch (NullDataException ex) {
                    logger.warn("Relation was not given");
                    System.out.println("Relation was not established. Please provide a relation.\n{MOTHER, WIFE, GIRLFRIEND, FATHER, HUSBAND, BOYFRIEND, PARENT, SPOUSE, FIANCE, SON, BROTHER, DAUGHTER, SISTER, GRANDMOTHER, GRANDFATHER, AUNT, UNCLE, LEGAL GUARDIAN}.");
                } catch (IllegalArgumentException ex) {
                    logger.warn("Invalid relation was given");
                    System.out.println("No such relation exists. Please provide a valid relation.\n{MOTHER, WIFE, GIRLFRIEND, FATHER, HUSBAND, BOYFRIEND, PARENT, SPOUSE, FIANCE, SON, BROTHER, DAUGHTER, SISTER, GRANDMOTHER, GRANDFATHER, AUNT, UNCLE, LEGAL GUARDIAN}.");
                }
            }
        }
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Visitor ✦✦✦");
        System.out.println("Name :: " + firstName + " " + lastName);
        System.out.println("Age :: " + age);
        System.out.println("Relationship to Patient :: " + relation + "\n");
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Visitor{relation='" + relation + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(relation, visitor.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), relation);
    }
}