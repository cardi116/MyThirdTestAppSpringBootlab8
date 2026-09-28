package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cher.MySecondTestAppSpringBoot.dao.DisciplineDAO;
import ru.cher.MySecondTestAppSpringBoot.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineDAO disciplineDAO;

    @Autowired
    public DisciplineServiceImpl(DisciplineDAO disciplineDAO) {
        this.disciplineDAO = disciplineDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional(readOnly = true)
    public Discipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public boolean deleteDiscipline(int id) {
        Discipline d = disciplineDAO.getDiscipline(id);
        if (d != null) {
            disciplineDAO.deleteDiscipline(id);
            return true;
        }
        return false;
    }
}