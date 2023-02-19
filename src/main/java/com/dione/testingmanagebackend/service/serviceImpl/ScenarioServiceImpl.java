package com.dione.testingmanagebackend.service.serviceImpl;

import com.dione.testingmanagebackend.entities.ScenarioDeTest;
import com.dione.testingmanagebackend.repository.ScenarioRepository;
import com.dione.testingmanagebackend.service.IScenarioDeTestService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioServiceImpl implements IScenarioDeTestService {

    private final ScenarioRepository scenarioRepository;

    public ScenarioServiceImpl(ScenarioRepository scenarioRepository){
        this.scenarioRepository = scenarioRepository;
    }

    @Override
    public ScenarioDeTest getScenario(Long refScenario) throws ResourceNotFoundException {
        return scenarioRepository.findById(refScenario).orElseThrow(() -> new ResourceNotFoundException("scenario non trouvé"));
    }

    @Override
    public ScenarioDeTest updateScenario(ScenarioDeTest scenarioTest) throws ResourceNotFoundException {
        return scenarioRepository.save(scenarioTest);
    }

    @Override
    public ScenarioDeTest addScenario(ScenarioDeTest scenarioTest) {
        return scenarioRepository.save(scenarioTest);
    }

    @Override
    public void deleteScenario(Long refScenario) {
        scenarioRepository.deleteById(refScenario);
    }

    @Override
    public List<ScenarioDeTest> getAllScenario() {
        return scenarioRepository.findAll();
    }

    @Override
    public List<ScenarioDeTest> getAllScenarioCasDeTest(Long id) {
        return scenarioRepository.AllScenarioTest(id);
    }
}
