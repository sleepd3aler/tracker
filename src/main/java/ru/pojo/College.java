package ru.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Новицкий Александр Анатольевич");
        student.setStudyGroup("35");
        LocalDate admissionDate = LocalDate.of(2007, 9, 1);
        student.setAdmissionDate(admissionDate);
        System.out.println("ФИО Студента: " + student.getName() + "\n" +
                "Группа: " + student.getStudyGroup() + "\n" + "Дата поступления: " + student.getAdmissionDate());
    }
}
