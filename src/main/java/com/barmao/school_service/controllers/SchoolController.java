package com.barmao.school_service.controllers;

import com.barmao.school_service.entities.School;
import com.barmao.school_service.service.SchoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {

    private final SchoolService schoolService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SchoolController(SchoolService schoolService,ObjectMapper objectMapper){
        this.schoolService = schoolService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public School addSchool(@RequestBody School school){
        log.info("Adding new school: {}", school.getName());
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> fetchSchools(){
        log.info("Fetching all schools");
        return schoolService.fetchSchools();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> fetchSchoolById(@PathVariable int id) {
        log.info("Fetching school with id: {}", id);
        School school = schoolService.fetchSchoolById(id);

        if(school == null){
            log.warn("School with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("School not found");
        }

        try{
            String jsonString = objectMapper.writeValueAsString(school);
            return ResponseEntity.status(HttpStatus.OK).body(jsonString);
        } catch (Exception e){
            log.warn("Error converting school to JSON", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting school to JSON");
        }
    }
}
