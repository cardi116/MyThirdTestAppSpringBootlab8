package ru.cher.MySecondTestAppSpringBoot.dao;

import ru.cher.MySecondTestAppSpringBoot.entity.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}