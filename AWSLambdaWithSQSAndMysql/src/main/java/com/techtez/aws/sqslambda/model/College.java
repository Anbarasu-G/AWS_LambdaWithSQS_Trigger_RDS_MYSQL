package com.techtez.aws.sqslambda.model;

import java.util.List;

public class College {
  
	private String collegeName;
    private List<String> availableCourses;
    private String place;

   
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<String> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(List<String> availableCourses) {
        this.availableCourses = availableCourses;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
