package com.spring.aop.learning.dao;

import com.spring.aop.learning.controller.Relationship;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InMemoryRepository implements CurdRepository{

    @Override
    @Transaction
    public String save(List<Relationship> relationships) {
        System.out.println("saved successfully");
        return "Save";
    }

    @Override
    @Transaction
    public String findAll(List<String> ids) {
        System.out.println("Fetch objects");
        //return "findAll";
        throw new IllegalArgumentException("Failed");
    }


}
