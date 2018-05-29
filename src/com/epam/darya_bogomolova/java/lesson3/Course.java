package com.epam.darya_bogomolova.java.lesson3;

import java.time.LocalDateTime;


public class Course {
    String name;
    int duration;
    LocalDateTime startDate;

    public Course(String name, int duration, LocalDateTime startDate) {
        this.name = name;
        this.duration = duration;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                '}';
    }

    public LocalDateTime getDateOfEndCourse () {
        LocalDateTime endDate = startDate;
        endDate.plusDays(duration/8);
        endDate.plusHours(duration%8);
        return endDate;
    }
}
