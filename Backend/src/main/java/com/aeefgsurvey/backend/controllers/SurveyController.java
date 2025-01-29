package com.aeefgsurvey.backend.controllers;

import com.aeefgsurvey.backend.entities.Survey;
import com.aeefgsurvey.backend.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, headers, HttpStatus.OK);
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

    @PostMapping("/batch")
    public List<Survey> createSurveys(@RequestBody List<Survey> surveys) {
        return surveys.stream()
                .map(surveyService::createSurvey)
                .toList();
    }

}
