package com.laba.solvd.hospital;

import com.laba.solvd.category.*;
import com.laba.solvd.collection.GenericLinkedList;
import com.laba.solvd.enums.JobTitle;
import com.laba.solvd.exception.*;
import com.laba.solvd.hospital.patient.Patient;
import com.laba.solvd.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Hospital implements Information, PopulationCount, Transfer {
    public static final Logger logger = LogManager.getLogger(Hospital.class.getName());

    private Contact contact;
    private final GenericLinkedList<Department> departmentList = new GenericLinkedList<>();

    public Hospital() {
        logger.debug("Hospital object instantiated");
        logger.warn("Hospital was not given any information");
    }

    public Hospital(String name, String address, String phone) {
        logger.debug("Hospital object instantiated");
        contact = new Contact(name, address, phone);
        logger.info("Hospital object created");
    }

    public Contact getContact() {
        return contact;
    }

    public Department getDepartment(String deptName) {
        return departmentList.stream().filter(dept -> dept.getName().getLabel().equals(deptName)).findFirst().orElse(null);
    }

    public GenericLinkedList<Department> getDepartmentList() throws NoDepartmentsException {
        if (departmentList.size() == 0)
            throw new NoDepartmentsException("There are no departments set in this hospital.");
        return departmentList;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void addDepartment(Department dept) {
        departmentList.add(dept);
        logger.info(dept.getName() + " added");
    }

    public void removeDepartment(Department dept) {
        departmentList.remove(dept);
        logger.info(dept.getName() + " removed");
    }

    @Override
    public int totalResidents() {
        return Patient.patients + Staff.employees;
    }

    @Override
    public int numOfPatients() {
        return Patient.patients;
    }

    @Override
    public int numOfStaff() {
        return Staff.employees;
    }

    @Override
    public int numOfStaff(JobTitle title) {
        return departmentList.stream().mapToInt(dept -> dept.numOfStaff(title)).sum();
    }

    @Override
    public int numOfStaff(String title) {
        return departmentList.stream().mapToInt(dept -> dept.numOfStaff(title)).sum();
    }

    @Override
    public int numOfRooms() {
        return departmentList.stream().mapToInt(dept -> dept.getRoomList().size()).sum();
    }

    @Override
    public void moveStaff(Staff staff, Department dept) {
        departmentList.stream().forEach(dpt -> {
            if(dpt.getStaffList().contains(staff))
                dpt.removeStaff(staff);
        });
        this.getDepartment(dept.getName().getLabel()).addStaff(staff);
        logger.info("Staff " + staff.getContact().getName() + " moved to " + dept.getName());
    }

    @Override
    public void movePatient(Patient patient, Department dept) {
        departmentList.stream().forEach(dpt -> {
            if(dpt.getPatientList().contains(patient))
                dpt.removePatient(patient);
        });
        this.getDepartment(dept.getName().getLabel()).addPatient(patient);
        logger.info("Patient " + patient.getContact().getName() + " moved to " + dept.getName());
    }

    @Override
    public void getInfo() {
        contact.getInfo();
        System.out.println("[ DEPARTMENT LIST ]");
        departmentList.stream().forEach((department) -> System.out.println("\t➢ " + department.getName()));
        System.out.println();
    }

    @Override
    public String toString() {
        return "Hospital{" + "contact=" + contact + ", departmentList=" + departmentList + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(contact, hospital.contact) && Objects.equals(departmentList, hospital.departmentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact, departmentList);
    }
}
