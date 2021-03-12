package com.learn.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AssertjTest {

    @Test
    public void assertCustomclass(){
        HashMap<String,String> exp = new HashMap<>();
        exp.put("1","GOOGLE");
        exp.put("2","MS");
        Employee employee1 = new Employee("First",1,"one",exp);
        Employee employee2 = new Employee("Second", 2, "one",exp);
//Comparison on customclass
        Assertions.assertThat(employee1).as("COMPARISON FAILED").isEqualToComparingFieldByField(employee2);

    }
}
