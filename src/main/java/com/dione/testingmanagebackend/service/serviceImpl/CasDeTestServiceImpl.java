package com.dione.testingmanagebackend.service.serviceImpl;

import com.dione.testingmanagebackend.entities.CasDeTest;
import com.dione.testingmanagebackend.repository.CasDeTestRepository;
import com.dione.testingmanagebackend.service.ICasDeTestService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasDeTestServiceImpl implements ICasDeTestService {

    private final CasDeTestRepository casDeTestRepository;

    public CasDeTestServiceImpl(CasDeTestRepository casDeTestRepository){
        this.casDeTestRepository=casDeTestRepository;
    }
    @Override
    public CasDeTest getCasDeTest(Long refCasTest) throws ResourceNotFoundException {
        return casDeTestRepository.findById(refCasTest).orElseThrow(() -> new ResourceNotFoundException("cas de test non trouvé"));
    }

    @Override
    public CasDeTest updateCasDeTest(CasDeTest casTest) throws ResourceNotFoundException {
        return casDeTestRepository.save(casTest);
    }

    @Override
    public CasDeTest addCasDeTest(CasDeTest casTest) {
        return casDeTestRepository.save(casTest);
    }

    @Override
    public void deleteCasDeTest(Long refCasTest) {
        casDeTestRepository.deleteById(refCasTest);
    }

    @Override
    public List<CasDeTest> getAllCasDeTest() {
        return casDeTestRepository.findAll();
    }

    @Override
    public Object getCasVisionTest(Long id) {
        return casDeTestRepository.CasVisionTest(id);
    }
}
