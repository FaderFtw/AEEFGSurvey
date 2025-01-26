package com.aeefgsurvey.backend.repositories;

import com.aeefgsurvey.backend.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, String> {
}