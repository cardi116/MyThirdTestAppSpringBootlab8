package ru.cher.MySecondTestAppSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cher.MySecondTestAppSpringBoot.dto.ApiResponse;
import ru.cher.MySecondTestAppSpringBoot.entity.Discipline;
import ru.cher.MySecondTestAppSpringBoot.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Discipline>>> getAllDisciplines() {
        return ResponseEntity.ok(ApiResponse.ok("Дисциплины успешно получены", disciplineService.getAllDisciplines()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Discipline>> getDiscipline(@PathVariable("id") int id) {
        Discipline d = disciplineService.getDiscipline(id);
        if (d != null) {
            return ResponseEntity.ok(ApiResponse.ok("Дисциплина найдена", d));
        }
        return ResponseEntity.status(404).body(ApiResponse.error("Дисциплина с id=" + id + " не найдена"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Discipline>> saveDiscipline(@RequestBody Discipline discipline) {
        Discipline saved = disciplineService.saveDiscipline(discipline);
        return ResponseEntity.ok(ApiResponse.ok("Дисциплина успешно сохранена", saved));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Discipline>> updateDiscipline(@RequestBody Discipline discipline) {
        Discipline updated = disciplineService.saveDiscipline(discipline);
        return ResponseEntity.ok(ApiResponse.ok("Дисциплина успешно обновлена", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteDiscipline(@PathVariable("id") int id) {
        boolean deleted = disciplineService.deleteDiscipline(id);
        if (deleted) {
            return ResponseEntity.ok(ApiResponse.ok("Дисциплина успешно удалена", null));
        }
        return ResponseEntity.status(404).body(ApiResponse.error("Дисциплина с id=" + id + " не найдена"));
    }
}