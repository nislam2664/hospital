package com.laba.solvd.interfaces;

import com.laba.solvd.enums.JobTitle;

public interface PopulationCount {
    public int totalResidents();
    public int numOfPatients();
    public int numOfStaff();
    public int numOfStaff(JobTitle title);
    public int numOfStaff(String title);
    public int numOfRooms();
}
