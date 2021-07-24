package com.spring.aop.learning.controller;

import com.spring.aop.learning.dao.CurdRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelationshipController {

    private CurdRepository curdRepository;

    public RelationshipController(CurdRepository curdRepository) {
        this.curdRepository = curdRepository;
    }

    @PostMapping(value = "/relationships", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveRelationships(@RequestBody List<Relationship> relationships) {
        System.out.println(relationships);
        curdRepository.save(relationships);
        return "new ResponseEntity<>.ok()";
    }

    @PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody List<Item> items){
        curdRepository.findAll(List.of("id"));
        System.out.println(items);
        return "new ResponseEntity<Items>.ok(items)";
    }

}
