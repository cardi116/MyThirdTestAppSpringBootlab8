package ru.cher.MySecondTestAppSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cher.MySecondTestAppSpringBoot.dto.ApiResponse;
import ru.cher.MySecondTestAppSpringBoot.entity.Student;
import ru.cher.MySecondTestAppSpringBoot.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(ApiResponse.ok("Студенты успешно получены", students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return ResponseEntity.ok(ApiResponse.ok("Студент найден", student));
        }
        return ResponseEntity.status(404).body(ApiResponse.error("Студент с id=" + id + " не найден"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> saveStudent(@RequestBody Student student) {
        Student saved = studentService.saveStudent(student);
        return ResponseEntity.ok(ApiResponse.ok("Студент успешно сохранен", saved));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Student>> updateStudent(@RequestBody Student student) {
        Student updated = studentService.saveStudent(student);
        return ResponseEntity.ok(ApiResponse.ok("Данные студента успешно обновлены", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable("id") int id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok(ApiResponse.ok("Студент успешно удален", null));
        }
        return ResponseEntity.status(404).body(ApiResponse.error("Студент с id=" + id + " не найден"));
    }
}