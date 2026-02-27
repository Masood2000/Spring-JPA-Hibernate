package com.masood.springjpahibernate.m_4.entities;


import com.masood.springjpahibernate.m_4.entities.generators.UUIDGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
