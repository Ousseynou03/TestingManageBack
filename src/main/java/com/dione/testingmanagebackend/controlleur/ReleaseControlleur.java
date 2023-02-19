package com.dione.testingmanagebackend.controlleur;

import com.dione.testingmanagebackend.entities.Releas;
import com.dione.testingmanagebackend.service.serviceImpl.ReleasServiceImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/releaseManager")
public class ReleaseControlleur {

    private final ReleasServiceImpl releasService;

    private Releas releas = new Releas();

    public ReleaseControlleur(ReleasServiceImpl releasService) {
        this.releasService = releasService;
    }

    @GetMapping
    public ResponseEntity<List<Releas>> getAllRelease(){
        List<Releas> releas = releasService.getAllReleas();
        return ResponseEntity.ok().body(releas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Releas> getTesteur(@PathVariable(value="id") Long refRelease) throws ResourceNotFoundException {
        releas = releasService.getReleas(refRelease);
        return ResponseEntity.ok().body(releas);
    }

    @PostMapping
    public ResponseEntity<Releas> addRelease(@RequestBody Releas release){
        return ResponseEntity.ok().body(releasService.addReleas(release));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Releas> updateRelease(@PathVariable (value = "id", required = false) Long refRelease, @RequestBody Releas releaseRequest ) throws ResourceNotFoundException {
        releaseRequest.setRefRelease(refRelease);
        return ResponseEntity.ok().body(releasService.updateReleas(releaseRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteRelease(@PathVariable(value="id") Long refRelease){
        releasService.deleteReleas(refRelease);
        return "ok";
    }
}
