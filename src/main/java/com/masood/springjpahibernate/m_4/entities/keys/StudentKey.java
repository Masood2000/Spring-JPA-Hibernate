package com.masood.springjpahibernate.m_4.entities.keys;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class StudentKey implements Serializable {

    private int num;
    private String code;

}
