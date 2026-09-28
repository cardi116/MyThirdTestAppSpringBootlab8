package ru.cher.MySecondTestAppSpringBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DISCIPLINES")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // <-- Обязательно Integer, а не int

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "semester")
    private Integer semester;

    public Discipline() {
    }

    public Discipline(Integer id, String name, Integer hours, Integer semester) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.semester = semester;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}