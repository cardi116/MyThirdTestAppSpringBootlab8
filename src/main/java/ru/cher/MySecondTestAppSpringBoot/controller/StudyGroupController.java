package ru.cher.MySecondTestAppSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cher.MySecondTestAppSpringBoot.dao.StudyGroupRepository;
import ru.cher.MySecondTestAppSpringBoot.entity.StudyGroup;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class StudyGroupController {

    private final StudyGroupRepository repository;

    @Autowired
    public StudyGroupController(StudyGroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<StudyGroup> getAllGroups() {
        return repository.findAll();
    }

    @PostMapping
    public StudyGroup saveGroup(@RequestBody StudyGroup group) {
        return repository.save(group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}