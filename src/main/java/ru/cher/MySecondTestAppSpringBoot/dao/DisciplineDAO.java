package ru.cher.MySecondTestAppSpringBoot.dao;

import ru.cher.MySecondTestAppSpringBoot.entity.Discipline;
import java.util.List;

public interface DisciplineDAO {
    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    void deleteDiscipline(int id);
}