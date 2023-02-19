package com.dione.testingmanagebackend.service;

import com.dione.testingmanagebackend.entities.Testeur;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public interface ITesteurService {
    Testeur getTesteur(Long idTesteur) throws ResourceNotFoundException;
    Testeur updateTesteur( Testeur testeur) throws ResourceNotFoundException;
    Testeur addTesteur(Testeur testeur);
    void deleteTesteur(Long id);
    List<Testeur> getAllTesteur();
}
