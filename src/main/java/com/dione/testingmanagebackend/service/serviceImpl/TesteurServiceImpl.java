package com.dione.testingmanagebackend.service.serviceImpl;

import com.dione.testingmanagebackend.entities.Testeur;

import com.dione.testingmanagebackend.repository.TesteurRepository;
import com.dione.testingmanagebackend.service.ITesteurService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class TesteurServiceImpl implements ITesteurService {

    private final TesteurRepository testeurRepository;

    public TesteurServiceImpl(TesteurRepository testeurRepository) {
        this.testeurRepository = testeurRepository;
    }

    @Override
    public Testeur getTesteur(Long idTesteur) throws ResourceNotFoundException {
        return testeurRepository.findById(idTesteur).orElseThrow(() -> new ResourceNotFoundException("testeur non trouvé"));
    }

    @Override
    public Testeur updateTesteur( Testeur testeur) throws ResourceNotFoundException {
        return testeurRepository.save(testeur);
    }

    @Override
    public Testeur addTesteur(Testeur testeur) {
        return testeurRepository.save(testeur);
    }

    @Override
    public void deleteTesteur(Long idTesteur) {
        testeurRepository.deleteById(idTesteur);}

    @Override
    public List<Testeur> getAllTesteur() {
        return testeurRepository.findAll();
    }
}
