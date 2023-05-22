package com.laba.solvd.hospital.room;

import com.laba.solvd.category.*;
import com.laba.solvd.exception.ExceedCapacityException;
import com.laba.solvd.hospital.patient.*;
import com.laba.solvd.interfaces.*;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class WaitingRoom extends Room implements Information, RoomService {
    private PriorityQueue<Patient> waitingQueue;

    public WaitingRoom(int floorNumber, int maxCapacity) {
        super(floorNumber, 0, maxCapacity);
        this.waitingQueue = new PriorityQueue<>((p1, p2) -> Integer.compare((p1.getTimeOfAdmission()).compareTo(p2.getTimeOfAdmission()), 0));
    }

    public PriorityQueue<Patient> getWaitingQueue() {
        return waitingQueue;
    }

    @Override
    public void addPatient(Patient patient) {
        try {
            if (waitingQueue.size() == this.getMaxCapacity())
                throw new ExceedCapacityException();
            patient.setTimeOfAdmission(LocalTime.now());
            waitingQueue.add(patient);
            System.out.println("Patient has been admitted to the waiting room.");
        }
        catch (ExceedCapacityException e) {
            System.out.println("The waiting room is currently full.");
        }
    }

    @Override
    public Patient removePatient() {
        return waitingQueue.remove();
    }

    @Override
    public void removePatient(Patient patient) {
        waitingQueue.remove(patient);
    }

    @Override
    public void peekPatients() {
        AtomicInteger idx = new AtomicInteger(0);
        waitingQueue.stream().forEach(patient -> {
            idx.addAndGet(1);
            System.out.println("[ " + idx + " ] " + patient.getTimeOfAdmission() + "\t\t" + patient.getFirstName() + " " + patient.getLastName());
        });
    }

    @Override
    public int size() {
        return waitingQueue.size();
    }

    @Override
    public void clear() {
        waitingQueue.clear();
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ Waiting Room ✦✦✦");
        System.out.println("Maximum Capacity :: " + getMaxCapacity());
        System.out.println("[ PATIENT QUEUE ]");
        this.peekPatients();
        System.out.println();
    }

    @Override
    public String toString() {
        return "WaitingRoom{" +
                "waitingQueue=" + waitingQueue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaitingRoom that = (WaitingRoom) o;
        return Objects.equals(waitingQueue, that.waitingQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(waitingQueue);
    }
}