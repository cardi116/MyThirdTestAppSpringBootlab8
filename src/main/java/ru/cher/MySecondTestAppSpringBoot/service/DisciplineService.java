package ru.cher.MySecondTestAppSpringBoot.service;

import ru.cher.MySecondTestAppSpringBoot.entity.Discipline;
import java.util.List;

public interface DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    boolean deleteDiscipline(int id);
}