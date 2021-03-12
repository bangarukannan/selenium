package com.learn.tests;

import lombok.Data;

import java.util.HashMap;

@Data
public class Employee {

    private String name;
    private int age;
    private String id;
    private HashMap<String,String> experience;

    public Employee(String name, int ageNo, String idNo, HashMap<String, String> experience){
        this.name = name;
        this.age = ageNo;
        this.id = idNo;
        this.experience = experience;
    }


}
