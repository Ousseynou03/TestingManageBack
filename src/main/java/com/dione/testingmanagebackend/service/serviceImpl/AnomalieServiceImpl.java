package com.dione.testingmanagebackend.service.serviceImpl;

import com.dione.testingmanagebackend.entities.Anomalie;
import com.dione.testingmanagebackend.repository.AnomalieRepository;
import com.dione.testingmanagebackend.service.IAnomalieService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalieServiceImpl implements IAnomalieService {

    private final AnomalieRepository anomalieRepository;

    public AnomalieServiceImpl(AnomalieRepository anomalieRepository){
        this.anomalieRepository=anomalieRepository;
    }
    @Override
    public Anomalie getAnomalie(Long refAnomalie) throws ResourceNotFoundException {
        return anomalieRepository.findById(refAnomalie).orElseThrow(() -> new ResourceNotFoundException("anomalie non trouvé"));

    }

    @Override
    public Anomalie updateAnomalie(Anomalie anomalie) throws ResourceNotFoundException {
        return anomalieRepository.save(anomalie);
    }

    @Override
    public Anomalie addAnomalie(Anomalie anomalie) {
        return anomalieRepository.save(anomalie);
    }

    @Override
    public void deleteAnomalie(Long refAnomalie) {
        anomalieRepository.deleteById(refAnomalie);
    }

    @Override
    public List<Anomalie> getAllAnomalie() {
        return anomalieRepository.findAll();
    }
}
