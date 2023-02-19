package com.dione.testingmanagebackend.service;

import com.dione.testingmanagebackend.entities.CasDeTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public interface ICasDeTestService {
    CasDeTest getCasDeTest(Long refCasTest) throws ResourceNotFoundException;
    CasDeTest updateCasDeTest (CasDeTest casTest) throws ResourceNotFoundException;
    CasDeTest addCasDeTest(CasDeTest casTest);
    void deleteCasDeTest(Long refCasTest);
    List<CasDeTest> getAllCasDeTest();
    Object getCasVisionTest(Long id);
}
