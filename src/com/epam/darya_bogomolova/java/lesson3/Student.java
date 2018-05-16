package com.epam.darya_bogomolova.java.lesson3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Student {
    private String firstName;
    private String lastName;
    private StudyProgram program;

    public Student(String firstName, String lastName, StudyProgram program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public StudyProgram getProgram() {
        return program;
    }

    public String getProgramTimeLeft() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime programLeft = program.getStartDate().plusDays(program.getProgramDuration() / 8);
        if (ChronoUnit.DAYS.between(now, programLeft) > 0) {
            return "Program left throw " + ChronoUnit.DAYS.between(now, programLeft) + " days " +
                    (ChronoUnit.HOURS.between(now, programLeft) % 24) + " hours!";
        }

        return "Program left " + ChronoUnit.DAYS.between(programLeft, now) + " days " +
                ChronoUnit.HOURS.between(programLeft, now) % 24 + " hours ago!";
    }
}
