package com.dione.testingmanagebackend.controlleur;

import com.dione.testingmanagebackend.entities.Anomalie;
import com.dione.testingmanagebackend.service.serviceImpl.AnomalieServiceImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/anomalieManager")
public class AnomalieControlleur {

    private final AnomalieServiceImpl anomalieService;

    private Anomalie anomalie = new Anomalie();

    public AnomalieControlleur(AnomalieServiceImpl anomalieService) {
        this.anomalieService = anomalieService;
    }

    @GetMapping
    public ResponseEntity<List<Anomalie>> getAllAnomalie(){
        List<Anomalie> anomalies = anomalieService.getAllAnomalie();
        return ResponseEntity.ok().body(anomalies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anomalie> getAnomalie(@PathVariable(value="id") Long refAnomalie) throws ResourceNotFoundException {
        anomalie = anomalieService.getAnomalie(refAnomalie);
        return ResponseEntity.ok().body(anomalie);
    }

    @PostMapping
    public ResponseEntity<Anomalie> addAnomalie(@RequestBody Anomalie anomalie){
        return ResponseEntity.ok().body(anomalieService.addAnomalie(anomalie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anomalie> updateAnoamalie(@PathVariable (value = "id", required = false) Long refAnomalie, @RequestBody Anomalie anomalieRequest ) throws ResourceNotFoundException {
        anomalieRequest.setRefAnomalie(refAnomalie);
        return ResponseEntity.ok().body(anomalieService.updateAnomalie(anomalieRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteAnomalie(@PathVariable(value="id") Long refAnomalie){
        anomalieService.deleteAnomalie(refAnomalie);
        return "ok";
    }
}
