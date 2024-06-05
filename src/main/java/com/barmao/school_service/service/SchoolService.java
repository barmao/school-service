package com.barmao.school_service.service;

import com.barmao.school_service.models.School;
import com.barmao.school_service.repository.SchoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    public School addSchool(School school){
        log.info("Adding new school: {}", school.getName());
        return schoolRepository.save(school);
    }

    public List<School> fetchSchools(){
        log.info("Fetching all schools");
        return schoolRepository.findAll();
    }

    public School fetchSchoolById(int id){
        log.info("Fetching school with id: {}", id);
        return schoolRepository.findById(id).orElse(null);
    }
}
