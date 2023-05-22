package com.laba.solvd.hospital;

import com.laba.solvd.category.*;
import com.laba.solvd.collection.GenericLinkedList;
import com.laba.solvd.exception.*;
import com.laba.solvd.hospital.patient.Patient;
import com.laba.solvd.interfaces.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Hospital implements Information, PopulationCount, Transfer {
    private Contact contact;
    private final GenericLinkedList<Department> departmentList = new GenericLinkedList<>();

    public Hospital() {

    }

    public Hospital(String name, String address, String phone) {
        contact = new Contact(name, address, phone);
    }

    public Contact getContact() {
        return contact;
    }

    public Department getDepartment(String deptName) {
        for (Department dept : departmentList)
            if (dept.getName().getLabel().equals(deptName))
                return dept;
        return null;
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
    }

    public void removeDepartment(Department dept) {
        departmentList.remove(dept);
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
    public int numOfStaff(String title) {
        AtomicInteger staffMembers = new AtomicInteger();
        departmentList.stream().forEach(dept -> {
            dept.getStaffList().stream().forEach(staff -> {
                if (staff.getTitle().getLabel().equals(title))
                    staffMembers.getAndIncrement();
            });
        });
        return staffMembers.get();
    }

    @Override
    public int numOfRooms() {
        AtomicInteger rooms = new AtomicInteger();
        departmentList.stream().forEach(dept -> rooms.addAndGet(dept.getRoomList().size()));
        return rooms.get();
    }

    @Override
    public void moveStaff(Staff staff, Department dept) {
        departmentList.stream().forEach(dpt -> {
            if(dpt.getStaffList().contains(staff))
                dpt.removeStaff(staff);
        });
        this.getDepartment(dept.getName().getLabel()).addStaff(staff);
    }

    @Override
    public void movePatient(Patient patient, Department dept) {
        departmentList.stream().forEach(dpt -> {
            if(dpt.getPatientList().contains(patient))
                dpt.removePatient(patient);
        });
        this.getDepartment(dept.getName().getLabel()).addPatient(patient);
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
