package com.epam.darya_bogomolova.java.lesson3;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Course course1 = new Course("Java Dev", 45, LocalDateTime.of(2018, 5, 15, 17, 0));
        Course course2 = new Course("UI", 38, LocalDateTime.of(2018, 5, 30, 11, 0));
        Course course3 = new Course("J2EE Dev ", 40, LocalDateTime.of(2018, 5, 18, 12, 0));
        Course course4 = new Course("DevOps", 30, LocalDateTime.of(2018, 6, 5, 17, 0));
        Course course5 = new Course("DB Analis", 34, LocalDateTime.of(2018, 5, 25, 13, 0));

        List<Course> program1 = new ArrayList<>();
        program1.add(course1);
        program1.add(course2);
        program1.add(course3);

        Student student1 = new Student("Ivan", "Sergeev", program1, "Java");

        List<Course> program2 = new ArrayList<>();
        program2.add(course4);
        program2.add(course5);

        Student student2 = new Student("Petr", "Alekseev", program2, "AnaliticProgram");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);


        int step = in.nextInt();
        if (step == 0) {
            for (Student student: students) {
                LocalDateTime startDate = student.getStartProgramDate();
                System.out.print(student.getName() + " " + student.getSurname() + " (" + student.getProgramName() + ") " + student.isFinishedProgram(startDate));
                System.out.println();
            }

        }
        else {
            for (Student student: students) {
                int days = student.durationOfProgram()/8;
                int hours = student.durationOfProgram()%8;
                LocalDateTime startProgramDate = student.getStartProgramDate();
                LocalDateTime endProgramDate = startProgramDate.plusDays(days).plusHours(hours);
                if (endProgramDate.getHour() >= 18) {
                    endProgramDate = endProgramDate.plusHours(16);
                }
                System.out.print(student.getName() + " " + student.getSurname() + " (" + student.getProgramName() + ") " + student.durationOfProgram() + " " +
                startProgramDate + " " + endProgramDate + " " + student.isFinishedProgram(startProgramDate));
                System.out.println();
            }
        }


    }
}
