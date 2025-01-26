package com.aeefgsurvey.backend.services;


import com.aeefgsurvey.backend.entities.Survey;
import com.aeefgsurvey.backend.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurveyById(String id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found"));
    }

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

}