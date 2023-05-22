package com.laba.solvd.hospital.room;

import com.laba.solvd.category.*;
import com.laba.solvd.exception.ExceedCapacityException;
import com.laba.solvd.hospital.patient.*;
import com.laba.solvd.interfaces.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class EmergencyRoom extends Room implements Information, RoomService {
    private final PriorityQueue<Patient> emergencyQueue  = new PriorityQueue<>((p1, p2) -> Integer.compare((p1.getTimeOfAdmission()).compareTo(p2.getTimeOfAdmission()), 0));

    public EmergencyRoom(int floorNumber, int maxCapacity) {
        super(floorNumber, 1, maxCapacity);
    }

    public PriorityQueue<Patient> getEmergencyQueue() {
        return emergencyQueue;
    }

    @Override
    public void addPatient(Patient patient) {
        try {
            if (emergencyQueue.size() == this.getMaxCapacity())
                throw new ExceedCapacityException();
            patient.setTimeOfAdmission(LocalTime.now());
            emergencyQueue.add(patient);
            System.out.println("Patient has been added to the emergency room queue");
        }
        catch (ExceedCapacityException e) {
            System.out.println("The queue for this emergency room is currently full.");
        }
    }

    @Override
    public Patient removePatient() {
        return emergencyQueue.remove();
    }

    @Override
    public void removePatient(Patient patient) {
        emergencyQueue.stream().forEach(pat -> {
            if(pat.equals(patient))
                emergencyQueue.remove(patient);
        });
    }

    @Override
    public void peekPatients() {
        AtomicInteger idx = new AtomicInteger(0);
        emergencyQueue.stream().forEach(patient -> {
            idx.addAndGet(1);
            System.out.println("[ " + idx + " ] " + patient.getTimeOfAdmission() + "\t\t" + patient.getFirstName() + " " + patient.getLastName());
        });
    }

    @Override
    public int size() {
        return emergencyQueue.size();
    }

    @Override
    public void clear() {
        emergencyQueue.clear();
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Emergency Room ✦✦✦");
        System.out.println("Floor :: " + this.getFloorNumber());
        System.out.println("Maximum Capacity :: " + getMaxCapacity());
        System.out.println("Current Capacity :: " + emergencyQueue.size());
        System.out.println("[ PATIENT QUEUE ]");
        this.peekPatients();
        System.out.println();
    }

    @Override
    public String toString() {
        return "EmergencyRoom{" +
                "emergencyQueue=" + emergencyQueue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmergencyRoom that = (EmergencyRoom) o;
        return Objects.equals(emergencyQueue, that.emergencyQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emergencyQueue);
    }
}
