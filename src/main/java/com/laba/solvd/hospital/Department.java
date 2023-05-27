package com.laba.solvd.hospital;

import com.laba.solvd.category.*;
import com.laba.solvd.enums.*;
import com.laba.solvd.exception.*;
import com.laba.solvd.hospital.patient.*;
import com.laba.solvd.interfaces.*;
import com.laba.solvd.tool.StringManipulation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Department implements Information, PopulationCount, Transfer {
    private static final Logger logger = LogManager.getLogger(Department.class.getName());

    private DeptName name;
    private int id;
    private final ArrayList<Staff> staffList = new ArrayList<>();
    private final ArrayList<Patient> patientList = new ArrayList<>();
    private final ArrayList<Room> roomList = new ArrayList<>();

    public Department() {
        logger.debug("Department object instantiated");
        logger.warn("Department was not given any information");
    }

    public Department(DeptName name, int id) {
        logger.debug("Department object instantiated");
        setName(name);
        setId(id);
        logger.info("Department object created");
    }

    public DeptName getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setName(DeptName name) {
        Scanner scanner = new Scanner(System.in);
        try {
            if(name == null)
                throw new NullDataException();
            this.name = name;
            logger.info("Name provided successfully");
        } catch (NullDataException e) {
            logger.warn("Name was not established");
            System.out.println("Department name was not established. Please provide a valid department name.\n{ANESTHESIOLOGY, CARDIOLOGY, DENTISTRY, DERMATOLOGY, ENDOCRINOLOGY, FAMILY MEDICINE, GASTROENTEROLOGY, INFECTIOUS DISEASE, NEUROLOGY, NEUROSURGERY, OPHTHALMOLOGY, ORTHOPAEDICS, PRIMARY CARE, PSYCHOLOGY, RADIOLOGY, RHEUMATOLOGY, UROLOGY}.");
            while (true) {
                System.out.print("Department name : ");
                String label = scanner.nextLine();
                try {
                    this.name = DeptName.valueOf(label.toUpperCase());
                    logger.info("Name provided successfully");
                    break;
                } catch (IllegalArgumentException ex) {
                    logger.warn("Invalid department name");
                    System.out.println("Department name given does not exist. Please provide a valid department name.\n{ANESTHESIOLOGY, CARDIOLOGY, DENTISTRY, DERMATOLOGY, ENDOCRINOLOGY, FAMILY MEDICINE, GASTROENTEROLOGY, INFECTIOUS DISEASE, NEUROLOGY, NEUROSURGERY, OPHTHALMOLOGY, ORTHOPAEDICS, PRIMARY CARE, PSYCHOLOGY, RADIOLOGY, RHEUMATOLOGY, UROLOGY}.");
                }
            }
        }
    }

    public void setId(int id) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (id <= 0)
                throw new NegativeNumberException();
            this.id = id;
            logger.info("ID provided successfully");
        }
        catch (NegativeNumberException e) {
            logger.warn("Negative ID provided");
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
                    logger.warn("Negative ID provided");
                    System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Invalid ID provided");
                    System.out.print("Invalid ID number input.\nPlease enter a valid ID : ");
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Invalid ID provided");
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
                    logger.warn("Negative ID provided");
                    System.out.print("ID cannot be negative.\nPlease enter a valid ID : ");
                } catch (InputMismatchException ex) {
                    logger.warn("Invalid ID provided");
                    System.out.print("Invalid ID number input.\nPlease enter a valid ID : ");
                }
            }
        }
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public void removePatient(Patient patient) {
        patientList.remove(patient);
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    // FILTER & GROUP STREAMS (STAFF)
    public List<Staff> filterStaff(JobTitle title) {
        return staffList.stream().sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())).filter(staff -> staff.getTitle().equals(title)).collect(Collectors.toList());
    }

    public List<Staff> filterStaff(Gender gender) {
        return staffList.stream().sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())).filter(staff -> staff.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Map<JobTitle, List<Staff>> groupStaffByTitle() {
        return staffList.stream().collect(Collectors.groupingBy(Staff::getTitle));
    }

    public Map<Gender, List<Staff>> groupStaffByGender() {
        return staffList.stream().collect(Collectors.groupingBy(Staff::getGender));
    }

    // FILTER & GROUP STREAMS (PATIENT)
    public List<Patient> filterPatient(AgeGroup ageGroup) {
        return patientList.stream().filter(patient -> patient.getGroup().equals(ageGroup)).collect(Collectors.toList());
    }

    public List<Patient> filterPatient(Gender gender) {
        return patientList.stream().filter(patient -> patient.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Map<AgeGroup, List<Patient>> groupPatientByAgeGroup() {
        return patientList.stream().collect(Collectors.groupingBy(Patient::getGroup));
    }

    public Map<Gender, List<Patient>> groupPatientByGender() {
        return patientList.stream().collect(Collectors.groupingBy(Patient::getGender));
    }

    // FILTER & GROUP STREAMS (ROOM)
    public List<Room> filterRoomByFloor(int floorNum) {
        return roomList.stream().filter(room -> room.getFloorNumber() == floorNum).collect(Collectors.toList());
    }

    public Map<Integer, List<Room>> groupPatientByFloor(int floorNum) {
        return roomList.stream().collect(Collectors.groupingBy(Room::getFloorNumber));
    }

    @Override
    public int totalResidents() {
        return numOfPatients() + numOfStaff();
    }

    @Override
    public int numOfPatients() {
        return patientList.size();
    }

    @Override
    public int numOfStaff() {
        return staffList.size();
    }

    @Override
    public int numOfStaff(JobTitle title) {
        return (int)(staffList.stream().filter(staff -> staff.getTitle().equals(title)).count());
    }

    @Override
    public int numOfStaff(String title) {
        return (int)(staffList.stream().filter(staff -> staff.getTitle().getLabel().equals(title.toUpperCase())).count());
    }

    @Override
    public int numOfRooms() {
        return roomList.size();
    }

    @Override
    public void moveStaff(Staff staff, Department dept) {
        if(this.getStaffList().contains(staff))
            this.removeStaff(staff);
        dept.addStaff(staff);
        logger.info("Staff " + staff.getContact().getName() + " moved to " + dept.getName());
    }

    @Override
    public void movePatient(Patient patient, Department dept) {
        if(this.getPatientList().contains(patient))
            this.removePatient(patient);
        dept.addPatient(patient);
        logger.info("Patient " + patient.getContact().getName() + " moved to " + dept.getName());
    }

    @Override
    public void getInfo() {
        System.out.println("✦✦✦ " + name.getLabel() + " DEPARTMENT ✦✦✦");
        System.out.println("--------------------------------");
        System.out.println("[ STAFF LIST ]");
        staffList.stream().forEach(staff -> System.out.println("\t▪ " + staff.getLastName() + ", " + staff.getFirstName()));
        System.out.println("[ PATIENT LIST ]");
        patientList.stream().forEach(patient -> System.out.println("\t▪ " + patient.getLastName() + ", " + patient.getFirstName()));
        System.out.println();
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + ", id=" + id + ", staffList=" + staffList + ", patientList =" + patientList + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(staffList, that.staffList) && Objects.equals(patientList, that.patientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, staffList, patientList);
    }
}
