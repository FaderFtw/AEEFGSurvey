package com.aeefgsurvey.backend.controllers;

import com.aeefgsurvey.backend.entities.Survey;
import com.aeefgsurvey.backend.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable String id) {
        return surveyService.getSurveyById(id);
    }

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        System.out.println(survey);
        return surveyService.createSurvey(survey);
    }

}
