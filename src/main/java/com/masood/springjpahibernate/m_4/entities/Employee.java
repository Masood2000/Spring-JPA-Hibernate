package com.masood.springjpahibernate.m_4.entities;


import com.masood.springjpahibernate.m_4.entities.generators.UUIDGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity()
@Table(name = "HEMPLOYEE")
@Getter
@Setter
public class Employee {

    @Id
    @GenericGenerator(name="UUIDGenerator",type = UUIDGenerator.class)
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(length = 1024)
    private String id;

    private String name;

    private String address;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
