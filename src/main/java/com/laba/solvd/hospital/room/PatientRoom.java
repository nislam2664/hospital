package com.laba.solvd.hospital.room;

import com.laba.solvd.category.*;
import com.laba.solvd.collection.*;
import com.laba.solvd.exception.ExceedCapacityException;
import com.laba.solvd.hospital.patient.*;
import com.laba.solvd.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class PatientRoom extends Room implements Information, RoomService {
    private static final Logger logger = LogManager.getLogger(PatientRoom.class.getName());

    private final GenericLinkedList<Patient> patientBeds = new GenericLinkedList<Patient>();

    public PatientRoom(int floorNumber, int roomNumber, int maxCapacity) {
        super(floorNumber, roomNumber, maxCapacity);
        logger.debug("Patient room object instantiated");
        logger.info("Patient room object created");
    }

    public GenericLinkedList<Patient> getPatientBeds() {
        return patientBeds;
    }

    @Override
    public void addPatient(Patient patient) {
        try {
            if (patientBeds.size() == this.getMaxCapacity())
                throw new ExceedCapacityException();
            patientBeds.add(patient);
            logger.info("Patient added to patient room");
            System.out.println("Patient has been admitted into this room");
        }
        catch (ExceedCapacityException e) {
            logger.warn("Patient room is full");
            System.out.println("This room is currently full.");
        }
    }

    @Override
    public Patient removePatient() {
        return null;
    }

    @Override
    public void removePatient(Patient patient) {
        patientBeds.remove(patient);
    }

    @Override
    public void peekPatients() {
        if(patientBeds.size() == 0)
            System.out.print("UNOCCUPIED");
        else
            patientBeds.getInfo();
    }

    @Override
    public int size() {
        return patientBeds.size();
    }

    @Override
    public void clear() {
        patientBeds.clear();
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Patient Room ✦✦✦");
        System.out.println("Floor :: " + this.getFloorNumber());
        System.out.println("Room :: " + this.getRoomNumber());
        System.out.println("Maximum Capacity :: " + this.getMaxCapacity() + "\n");
        System.out.println(" [ PATIENTS IN ROOM ]");
        this.peekPatients();
        System.out.println();
    }

    @Override
    public String toString() {
        return "PatientRoom{" +
                "patientBeds=" + patientBeds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientRoom that = (PatientRoom) o;
        return Objects.equals(patientBeds, that.patientBeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientBeds);
    }
}