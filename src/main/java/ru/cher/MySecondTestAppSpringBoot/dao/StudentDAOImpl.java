package ru.cher.MySecondTestAppSpringBoot.dao;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.cher.MySecondTestAppSpringBoot.entity.Student;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final Logger log = LoggerFactory.getLogger(StudentDAOImpl.class);

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Getting all students from database");
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student saveStudent(Student student) {
        log.info("Saving student to database: {}", student);
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        log.info("Getting student with id: {}", id);
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        log.info("Deleting student with id: {}", id);
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}