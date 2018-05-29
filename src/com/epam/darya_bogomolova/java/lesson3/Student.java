package com.epam.darya_bogomolova.java.lesson3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

public class Student {
    String name;
    String surname;
    List<Course> program;
    String programName;

    public Student(String name, String surname, List<Course> program, String programName) {
        this.name = name;
        this.surname = surname;
        this.program = program;
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", program=" + program +
                ", programName='" + programName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getProgram() {
        return program;
    }

    public void setProgram(List<Course> program) {
        this.program = program;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public LocalDateTime getEndProgramDate() {
        LocalDateTime endDate = program.get(0).getDateOfEndCourse();
        for (int i = 1; i < program.size(); i++) {
            if (program.get(i).getDateOfEndCourse().compareTo(endDate) > 0) {
                endDate = program.get(i).getDateOfEndCourse();
            }
        }
        return endDate;
    }

    public String isFinishedProgram(LocalDateTime startProgramDate) {
        LocalDateTime curDate = LocalDateTime.now();
        int days = durationOfProgram()/8;
        int hours = durationOfProgram()%8;
        LocalDateTime endDate = startProgramDate.plusDays(days).plusHours(hours);

        if (curDate.compareTo(endDate) < 0) {
            return ("Study is not complete, until the end of " + ChronoUnit.DAYS.between(curDate, endDate) + " days and " +
                    (ChronoUnit.HOURS.between(curDate, endDate) % 24) + " hours");
        } else {

            return ("Study is complete, " + ChronoUnit.DAYS.between(endDate, curDate) + " days and " + (ChronoUnit.HOURS.between(endDate, curDate) % 24) + " hours ago");
        }
    }


    public int durationOfProgram() {
        int duration = 0;
        for (Course course : program) {
            duration += course.duration;
        }
        return duration;
    }


    public LocalDateTime getStartProgramDate() {
        LocalDateTime startDate = program.get(0).getDateOfEndCourse();
        for (int i = 1; i < program.size(); i++) {
            if (program.get(i).getDateOfEndCourse().compareTo(startDate) < 0) {
                startDate = program.get(i).getDateOfEndCourse();
            }
        }
        return startDate;
    }

}
