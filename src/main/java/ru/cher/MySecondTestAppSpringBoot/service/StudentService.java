package ru.cher.MySecondTestAppSpringBoot.service;

import ru.cher.MySecondTestAppSpringBoot.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    boolean deleteStudent(int id);
}