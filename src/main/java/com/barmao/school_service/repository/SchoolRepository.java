package com.barmao.school_service.repository;

import com.barmao.school_service.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {
}
