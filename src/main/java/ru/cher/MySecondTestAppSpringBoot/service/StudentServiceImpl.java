package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cher.MySecondTestAppSpringBoot.dao.StudentDAO;
import ru.cher.MySecondTestAppSpringBoot.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
        Student student = studentDAO.getStudent(id);
        if (student != null) {
            studentDAO.deleteStudent(id);
            return true;
        }
        return false;
    }
}