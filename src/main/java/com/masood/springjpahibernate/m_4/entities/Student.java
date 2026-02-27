package com.masood.springjpahibernate.m_4.entities;


import com.masood.springjpahibernate.m_4.entities.keys.StudentKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "HSTUDENT")
@Getter
@Setter
public class Student {

    @EmbeddedId
    private StudentKey id;

    private String name;


}
