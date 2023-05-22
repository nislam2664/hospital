package com.laba.solvd.interfaces;

import com.laba.solvd.hospital.patient.*;

public interface RoomService {
    public void addPatient(Patient patient);
    public Patient removePatient();
    public void removePatient(Patient patient);
    public void peekPatients();
    public int size();
    public void clear();
}
