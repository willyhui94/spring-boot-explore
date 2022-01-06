package com.willyhui.dataJPA.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Employee.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Employee> employees;
}
