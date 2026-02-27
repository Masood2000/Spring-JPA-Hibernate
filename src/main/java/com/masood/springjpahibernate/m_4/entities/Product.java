package com.masood.springjpahibernate.m_4.entities;


import com.masood.springjpahibernate.m_4.entities.keys.ProductKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "HPRODUCT")
@Getter
@Setter
@IdClass(ProductKey.class)
public class Product {

    @Id
    private String code;

    @Id
    private long num;

    private String color;

    @Override
    public String toString() {

        return "Product{" +
                "code='" + code + '\'' +
                ", number=" + num +
                ", color='" + color + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return num == product.num && Objects.equals(code, product.code) && Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, num, color);
    }
}
