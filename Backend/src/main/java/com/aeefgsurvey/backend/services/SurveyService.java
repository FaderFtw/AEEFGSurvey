package com.aeefgsurvey.backend.services;


import com.aeefgsurvey.backend.entities.Survey;
import com.aeefgsurvey.backend.repositories.SurveyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Transactional
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }


    @Transactional
    public Survey getSurveyById(String id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found"));
    }

    @Transactional
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Transactional
    public void deleteAllSurveys() {
        surveyRepository.deleteAll();
    }

}