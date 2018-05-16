package com.epam.darya_bogomolova.java.lesson3;

import java.time.LocalDateTime;
import java.util.List;

public class StudyProgram {
    private LocalDateTime startDate;
    private List<Course> courses;

    public StudyProgram(LocalDateTime startDate, List<Course> courses) {
        this.startDate = startDate;
        this.courses = courses;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getProgramDuration() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getDuration().intValue();
        }

        return sum;
    }
}
