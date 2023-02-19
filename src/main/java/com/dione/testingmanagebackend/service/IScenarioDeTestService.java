package com.dione.testingmanagebackend.service;

import com.dione.testingmanagebackend.entities.ScenarioDeTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public interface IScenarioDeTestService {
    ScenarioDeTest getScenario(Long refScenario) throws ResourceNotFoundException;
    ScenarioDeTest updateScenario(ScenarioDeTest scenarioTest) throws ResourceNotFoundException;
    ScenarioDeTest addScenario(ScenarioDeTest scenarioTest);
    void deleteScenario(Long refScenario);
    List<ScenarioDeTest> getAllScenario();
    List<ScenarioDeTest> getAllScenarioCasDeTest(Long id);
}
