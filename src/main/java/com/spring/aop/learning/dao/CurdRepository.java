package com.spring.aop.learning.dao;

import com.spring.aop.learning.controller.Relationship;

import java.util.List;

public interface CurdRepository {
    String save(List<Relationship> relationships);

    String findAll(List<String> ids);
}
