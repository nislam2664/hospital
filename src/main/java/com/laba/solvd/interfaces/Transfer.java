package com.laba.solvd.interfaces;

import com.laba.solvd.category.Staff;
import com.laba.solvd.hospital.Department;
import com.laba.solvd.hospital.patient.Patient;

public interface Transfer {
    public void moveStaff(Staff staff, Department dept);
    public void movePatient(Patient patient, Department dept);
}
