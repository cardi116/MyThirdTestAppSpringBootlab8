package ru.cher.MySecondTestAppSpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.cher.MySecondTestAppSpringBoot.entity.Discipline;

import java.util.List;

@Repository
public class DisciplineDAOImpl implements DisciplineDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDisciplines() {
        return entityManager.createQuery("from Discipline", Discipline.class).getResultList();
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return entityManager.merge(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public void deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from Discipline where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}