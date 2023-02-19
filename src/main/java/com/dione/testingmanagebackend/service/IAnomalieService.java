package com.dione.testingmanagebackend.service;

import com.dione.testingmanagebackend.entities.Anomalie;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public interface IAnomalieService {
    Anomalie getAnomalie(Long refAnomalie) throws ResourceNotFoundException;
    Anomalie updateAnomalie( Anomalie anomalie) throws ResourceNotFoundException;
    Anomalie addAnomalie(Anomalie anomalie);
    void deleteAnomalie(Long refAnomalie);
    List<Anomalie> getAllAnomalie();
}
