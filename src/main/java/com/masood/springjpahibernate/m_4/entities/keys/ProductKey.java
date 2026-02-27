package com.masood.springjpahibernate.m_4.entities.keys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class ProductKey implements Serializable {


    private String code;
    private long num;

}
