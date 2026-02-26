package com.masood.springjpahibernate.m_1.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "HPRODUCT")
@Getter
@Setter
public class Product {

    @Id()
    private Long id;

    private String name;

}

